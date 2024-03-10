package com.vdoderovic.usermanagementapp.Exceptions;

import com.vdoderovic.usermanagementapp.Exceptions.DTO.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class GlobalResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {


        List<ErrorDTO> errorDTOList = new ArrayList<>();
        List<FieldError> fieldErrorList = ex.getFieldErrors();
        for(FieldError fieldError : fieldErrorList) {
            ErrorDTO errorDTO = new ErrorDTO(
                    fieldError.getField(),
                    fieldError.getRejectedValue(),
                    fieldError.getDefaultMessage()
            );
            errorDTOList.add(errorDTO);
        }
        Map<String, Object> errorResponse= new HashMap<>();
        errorResponse.put("message", "Validation failed");
        errorResponse.put("errors", errorDTOList);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}