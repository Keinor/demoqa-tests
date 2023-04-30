package com.nastyabelova.tests.tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.nastyabelova.tests.tests.pages.components.CalenderComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.nastyabelova.tests.tests.helpers.TestDataHelper.FORM_TITLE;
import static com.nastyabelova.tests.tests.helpers.TestDataHelper.SUBJECTS_INPUT;

public class RegistrationPage {
    public CalenderComponent calender = new CalenderComponent();
    private final SelenideElement
            formTitle = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressArea = $("#currentAddress");
    private final SelenideElement stateOption = $("#react-select-3-input");
    private final SelenideElement cityOption = $("#react-select-4-input");
    private final SelenideElement submitForm = $("#submit");

    public void openPage() {
        open("/automation-practice-form");
        zoom(0.8);
        formTitle.shouldHave(text(FORM_TITLE));
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
        subjectsInput.setValue(SUBJECTS_INPUT).pressEnter();
        return this;
    }

    public RegistrationPage typeHobbies(String key) {
        $x("//label[@for='hobbies-checkbox-'" + key + "'']").click();
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

    public RegistrationPage checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent()
                .shouldHave(text(value));
        return this;
    }
}
