package com.sopt.demo.exception;

import com.sopt.demo.common.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;
    public BusinessException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
