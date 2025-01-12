package com.codesoom.assignment.controllers;

import com.codesoom.assignment.dto.ErrorResponse;
import com.codesoom.assignment.errors.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 상품 컨트롤러에서 발생한 예외를 처리한다.
 */
@ControllerAdvice
public class ProductControllerAdvice {

    /**
     * 상품을 찾지 못하여 던져진 예외를 처리하여 에러응답 객체를 리턴한다.
     * @param productNotFoundException 상품을 찾지 못해 던져진 예외
     * @return 에러 응답 객체
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse productNotFoundExceptionHandler(ProductNotFoundException productNotFoundException) {
        return ErrorResponse.builder()
                .message(productNotFoundException.getMessage())
                .build();
    }
}
