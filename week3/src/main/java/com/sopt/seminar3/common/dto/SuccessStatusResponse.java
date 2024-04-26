package com.sopt.seminar3.common.dto;

public record SuccessStatusResponse (
        int stastus,
        String message
){
    public static SuccessStatusResponse of(final SuccessMessage message){
        return new SuccessStatusResponse(message.getStatus(), message.getMessage());
    }
}
