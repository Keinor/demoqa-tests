package com.nastyabelova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Проверка заполнения формы регистрации студента
 */
public class RegistrationFormTests {
    private final String firstName = "Masha";
    private final String lastName = "Ivanova";
    private final String userEmail = "mi@mail.ru";
    private final String userNumber = "1234567890";
    private final String subjectsInput = "Computer Science";
    private final String day = "19";
    private final String year = "1998";
    private final String month = "September";
    private final String picture = "gory.jpg";
    private final String address = "Moscow";
    private final String state = "NCR";
    private final String city = "Noida";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        zoom(0.8);
    }

    @Test
    public void fillRegistrationFormTests() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $x("//label[@for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $x("//label[@for='hobbies-checkbox-2']").click();
        $x("//label[@for='hobbies-checkbox-3']").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $x("//div[contains(@aria-label, \"September 19th, 1998\")]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + picture));
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        //Проверки полей после нажатия отправки формы
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text("Female"));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subjectsInput));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Reading" + ", " + "Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(address));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }
}

