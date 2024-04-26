package com.sopt.seminar3.exception;

import com.sopt.seminar3.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
