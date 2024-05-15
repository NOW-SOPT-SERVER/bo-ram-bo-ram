package com.sopt.seminar.common.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private final int code;
    private final String message;
    private T data;

    public static <T> ApiResponse<T> success(SuccessMessage successType, T data) {
        return new ApiResponse<T>(successType.getStatus(),successType.getMessage(), data);
    }
}
