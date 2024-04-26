package com.sopt.seminar.exception;

import com.sopt.seminar.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
