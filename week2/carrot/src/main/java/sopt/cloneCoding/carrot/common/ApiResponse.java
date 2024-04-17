package sopt.cloneCoding.carrot.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private final int status;
    private final String message;
    private T data;

    public static <T> ApiResponse<T> success(SuccessType successType, T data) {
        return new ApiResponse<T>(successType.getStatusCode(), successType.getMessage(), data);
    }

    public static <T> ApiResponse<T> success(SuccessType successType) {
        return new ApiResponse<T>(successType.getStatusCode(), successType.getMessage());
    }
}
