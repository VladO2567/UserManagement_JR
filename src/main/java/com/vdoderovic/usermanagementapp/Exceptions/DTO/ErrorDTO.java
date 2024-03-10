package com.vdoderovic.usermanagementapp.Exceptions.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String field;
    private Object value;
    private String message;
}