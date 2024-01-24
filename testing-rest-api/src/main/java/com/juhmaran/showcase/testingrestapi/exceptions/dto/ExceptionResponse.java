package com.juhmaran.showcase.testingrestapi.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private Integer code;
    private String status;
    private String message;

}
