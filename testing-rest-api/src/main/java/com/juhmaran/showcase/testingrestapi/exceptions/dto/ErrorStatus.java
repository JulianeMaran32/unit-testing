package com.juhmaran.showcase.testingrestapi.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatus {

    LIST_PEOPLE(
            400,
            "BAD_REQUEST.LIST_PEOPLE",
            "Invalid filter or pagination parameters."),
    INVALID_FILTER(
            400,
            "BAD_REQUEST.INVALID_FILTER",
            "Invalid filter value."),
    COMBINE_FILTERS(
            400,
            "BAD_REQUEST.COMBINE_FILTERS",
            "Conflicting filter criteria."),
    REQUIRED_AUTHENTICATION(
            401,
            "AUTHENTICATION",
            "Required authentication is missing."),
    PERSON_NOT_FOUND(
            404,
            "PERSON_NOT_FOUND",
            "Person not found."),
    EMAIL_ALREADY_REGISTERED(
            404,
            "NOT_FOUND.EMAIL_ALREADY_REGISTERED",
            "Email already registered."),
    PAGE_NOT_FOUND(
            404,
            "PAGE_NOT_FOUND",
            "Page not found."),
    BAD_REQUEST(
            400,
            "BAD_REQUEST",
            "The request sent was invalid. Check the sent parameters and try again."),
    UNAUTHORIZED(
            401,
            "UNAUTHORIZED",
            "The user does not have permission to access the requested resource. Provide the correct authentication credentials."),
    FORBIDDEN(
            403,
            "FORBIDDEN",
            "The user has permission to access the resource, but is not authorized to perform the requested operation."),
    NOT_FOUND(
            404,
            "NOT_FOUND",
            "The requested resource does not exist. Check the URL and try again."),
    INTERNAL_SERVER_ERROR(
            500,
            "INTERNAL_SERVER_ERROR",
            "An unexpected error occurred on the server. Try again later.");

    private final Integer code;
    private final String status;
    private final String message;

}
