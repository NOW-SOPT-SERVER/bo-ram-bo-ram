package com.sopt.demo.common;
import lombok.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private final int code;
    private final String message;
    private T data;

    public static <T> ApiResponse<T> success(SuccessType successType, T data) {
        return new ApiResponse<T>(successType.getStatusCode(), successType.getMessage(), data);
    }
}