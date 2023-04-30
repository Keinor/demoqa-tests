package com.nastyabelova.tests.tests.tests;

import com.nastyabelova.tests.tests.base.TestBase;
import com.nastyabelova.tests.tests.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.nastyabelova.tests.tests.helpers.TestDataHelper.*;

/**
 * Проверка заполнения формы регистрации студента
 */
public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test()
    public void fillRegistrationFormTests() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGender("2")
                .typePhoneNumber(phone)
                .typeSubjects()
                .typeHobbies("2")
                .typeHobbies("3")
                .typeUploadPicture(PICTURE)
                .typeAddress(address)
                .typeState(STATE)
                .typeCity(CITY)
                .calender.setDate(DAY, MONTH, YEAR);

        registrationPage.submitFormRegistration()
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", FEMALE_GENDER)
                .checkResultsValue("Mobile", phone)
                .checkResultsValue("Date of Birth", DAY + " " + MONTH + "," + YEAR)
                .checkResultsValue("Subjects", SUBJECTS_INPUT)
                .checkResultsValue("Hobbies", HOBBIE_READING + ", " + HOBBIE_MUSIC)
                .checkResultsValue("Picture", PICTURE)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", STATE + " " + CITY);
    }
}

