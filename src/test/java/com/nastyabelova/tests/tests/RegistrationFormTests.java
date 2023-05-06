package com.nastyabelova.tests.tests;

import com.nastyabelova.tests.helpers.TestDataHelper;
import com.nastyabelova.tests.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.nastyabelova.tests.helpers.TestDataHelper.expectedData;

/**
 * Проверка заполнения формы регистрации студента
 */
public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test()
    public void fillRegistrationFormTests() {
        registrationPage.openPage();
        registrationPage.typeFirstName(TestDataHelper.firstName)
                .typeLastName(TestDataHelper.lastName)
                .typeEmail(TestDataHelper.email)
                .typeGender("2")
                .typePhoneNumber(TestDataHelper.phone)
                .typeSubjects()
                .typeHobbies("2")
                .typeHobbies("3")
                .typeUploadPicture(TestDataHelper.PICTURE)
                .typeAddress(TestDataHelper.address)
                .typeState(TestDataHelper.STATE)
                .typeCity(TestDataHelper.CITY)
                .calender.setDate(TestDataHelper.DAY, TestDataHelper.MONTH, TestDataHelper.YEAR);

        registrationPage.submitFormRegistration();
        registrationPage.checkResultsData(expectedData);
    }
}

