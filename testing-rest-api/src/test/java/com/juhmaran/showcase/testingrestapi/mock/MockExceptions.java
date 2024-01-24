package com.juhmaran.showcase.testingrestapi.mock;

public class MockExceptions {

    public static final String RESPONSE_BODY_400_LIST_PEOPLE = """
            {
                "code": 400,
                "status": "BAD_REQUEST.LIST_PEOPLE",
                "message": "Invalid filter or pagination parameters."
            }
            """;

    public static final String RESPONSE_BODY_400_INVALID_FILTER = """
            {
                "code": 400,
                "status": "BAD_REQUEST.INVALID_FILTER",
                "message": "Invalid filter value."
            }
            """;

    public static final String RESPONSE_BODY_400_COMBINE_FILTERS = """
            {
                "code": 400,
                "status": "BAD_REQUEST.COMBINE_FILTERS",
                "message": "Conflicting filter criteria."
            }
            """;

    public static final String RESPONSE_BODY_400_BAD_REQUEST = """
            {
                "code": 400,
                "status": "BAD_REQUEST",
                "message": "The request sent was invalid. Check the sent parameters and try again."
            }
            """;

    public static final String RESPONSE_BODY_401_REQUIRED_AUTHENTICATION = """
            {
                "code": 401,
                "status": "AUTHENTICATION",
                "message": "Required authentication is missing."
            }
            """;

    public static final String RESPONSE_BODY_401_UNAUTHORIZED = """
            {
                "code": 401,
                "status": "UNAUTHORIZED",
                "message": "The user does not have permission to access the requested resource. Provide the correct authentication credentials."
            }
            """;

    public static final String RESPONSE_BODY_403_FORBIDDEN = """
            {
                "code": 403,
                "status": "FORBIDDEN",
                "message": "The user has permission to access the resource, but is not authorized to perform the requested operation."
            }
            """;

    public static final String RESPONSE_BODY_404_PERSON_NOT_FOUND = """
            {
                "code": 404,
                "status": "PERSON_NOT_FOUND",
                "message": "Person not found."
            }
            """;

    public static final String RESPONSE_BODY_404_EMAIL_ALREADY_REGISTERED = """
            {
                "code": 404,
                "status": "NOT_FOUND.EMAIL_ALREADY_REGISTERED",
                "message": "Email already registered."
            }
            """;

    public static final String RESPONSE_BODY_404_PAGE_NOT_FOUND = """
            {
                "code": 404,
                "status": "PAGE_NOT_FOUND",
                "message": "Page not found."
            }
            """;

    public static final String RESPONSE_BODY_404_NOT_FOUND = """
            {
                "code": 404,
                "status": "NOT_FOUND",
                "message": "The requested resource does not exist. Check the URL and try again."
            }
            """;

    public static final String RESPONSE_BODY_500_INTERNAL_SERVER_ERROR = """
            {
                "code": 500,
                "status": "INTERNAL_SERVER_ERROR",
                "message": "An unexpected error occurred on the server. Try again later."
            }
            """;

}
