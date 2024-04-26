package com.sopt.demo.common.dto;

public record SuccessStatusResponse (
        int stastus,
        String message
){
    public static SuccessStatusResponse of(final SuccessMessage message){
        return new SuccessStatusResponse(message.getStatus(), message.getMessage());
    }
}
