package sopt.cloneCoding.carrot.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum SuccessType {

    MEMBER_CREATE_SUCCESS(HttpStatus.CREATED, "멤버 생성 성공"),
    PRODUCT_CREATE_SUCCESS(HttpStatus.CREATED, "제품 생성 성공");

    private final HttpStatus httpStatus;
    private final String message;

    public int getStatusCode() {
        return this.httpStatus.value();
    }
}