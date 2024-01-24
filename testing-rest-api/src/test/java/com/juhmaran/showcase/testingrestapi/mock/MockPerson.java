package com.juhmaran.showcase.testingrestapi.mock;

public class MockPerson {

    public static final String FIRST_NAME_1 = "John";
    public static final String LAST_NAME_1 = "Doe";
    public static final String EMAIL_1 = "john.doe@example.com";
    public static final String ADDRESS_1 = "123 Main St, Anytown, CA";
    public static final String GENDER_1 = "Male";

    public static final String FIRST_NAME_2 = "Jane";
    public static final String LAST_NAME_2 = "Smith";
    public static final String EMAIL_2 = "jane.smith@example.com";
    public static final String ADDRESS_2 = "456 Elm St, Anytown, CA";
    public static final String GENDER_2 = "Female";

    public static final Long NON_EXISTING_ID = 99L;

    public static final String PERSON_LIST_RESPONSE = """
            [
              {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john.doe@example.com",
                "address": "123 Main St, Anytown, CA",
                "gender": "Male"
              },
              {
                "firstName": "Jane",
                "lastName": "Smith",
                "email": "jane.smith@example.com",
                "address": "456 Elm St, Anytown, CA",
                "gender": "Female"
              }
            ]
            """;

    public static final String PERSON_LIST_WITH_ID_RESPONSE = """
            [
              {
                "id": 1L,
                "firstName": "John",
                "lastName": "Doe",
                "email": "john.doe@example.com",
                "address": "123 Main St, Anytown, CA",
                "gender": "Male"
              },
              {
                "id": 2L,
                "firstName": "Jane",
                "lastName": "Smith",
                "email": "jane.smith@example.com",
                "address": "456 Elm St, Anytown, CA",
                "gender": "Female"
              }
            ]
            """;

    public static final String PERSON_RESPONSE = """
            {
              "firstName": "John",
              "lastName": "Doe",
              "email": "john.doe@example.com",
              "address": "123 Main St, Anytown, CA",
              "gender": "Male"
            }
            """;

}
