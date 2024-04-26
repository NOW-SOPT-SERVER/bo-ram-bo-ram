package com.sopt.demo.exception;

import com.sopt.demo.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
