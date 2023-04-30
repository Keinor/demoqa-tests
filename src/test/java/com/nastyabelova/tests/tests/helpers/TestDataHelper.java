package com.nastyabelova.tests.tests.helpers;

import com.github.javafaker.Faker;

public class TestDataHelper {

    public static final String FORM_TITLE = "Student Registration Form";
    public static final String SUBJECTS_INPUT = "Computer Science";
    public static final String DAY = "19";
    public static final String YEAR = "1998";
    public static final String MONTH = "September";
    public static final String PICTURE = "gory.jpg";
    public static final String STATE = "NCR";
    public static final String CITY = "Noida";
    public static final String FEMALE_GENDER = "Female";
    public static final String HOBBIE_READING = "Reading";
    public static final String HOBBIE_MUSIC = "Music";

    private static final Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String address = faker.address().city();
    public static String phone = faker.phoneNumber().subscriberNumber(10);
}
