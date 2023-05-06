package com.nastyabelova.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.nastyabelova.tests.helpers.TestDataHelper;
import com.nastyabelova.tests.pages.components.CalenderComponent;
import org.assertj.core.api.SoftAssertions;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class RegistrationPage {

    private final SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            addressArea = $("#currentAddress"),
            stateOption = $("#react-select-3-input"),
            cityOption = $("#react-select-4-input"),
            submitForm = $("#submit");
    public CalenderComponent calender = new CalenderComponent();
    ElementsCollection lines = $$(".table-responsive tbody tr");

    public void openPage() {
        open("/automation-practice-form");
        zoom(0.8);
        formTitle.shouldHave(text(TestDataHelper.FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeGender(String key) {
        $x("//label[@for='gender-radio-" + key + "']").click();
        return this;
    }

    public RegistrationPage typePhoneNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage typeSubjects() {
        subjectsInput.setValue(TestDataHelper.SUBJECTS_INPUT).pressEnter();
        return this;
    }

    public RegistrationPage typeHobbies(String key) {
        $x("//label[@for='hobbies-checkbox-" + key + "']").click();
        return this;
    }

    public RegistrationPage typeUploadPicture(String value) {
        uploadPicture.uploadFile(new File("src/test/resources/img/" + value));
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressArea.setValue(value);
        return this;
    }

    public RegistrationPage typeState(String value) {
        stateOption.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeCity(String value) {
        cityOption.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitFormRegistration() {
        submitForm.click();
        return this;
    }

    public void checkResultsData(Map<String, String> expectedData) {
        SoftAssertions softly = new SoftAssertions();
        lines.snapshot();
        for (SelenideElement line : lines) {
            String keytd = line.$("td").text(); //Student Name
            String expectedValue = expectedData.get(keytd);
            String actualValuetd = line.$("td", 1).text();

            softly.assertThat(actualValuetd)
                    .as(format("\nTable: %s contains %s, but expected %s", keytd, expectedValue, actualValuetd))
                    .isEqualTo(expectedValue);
        }
        softly.assertAll();
    }
}