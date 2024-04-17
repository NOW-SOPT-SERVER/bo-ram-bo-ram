package sopt.cloneCoding.carrot.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ErrorType {
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND,"해당하는 멤버가 없습니다");

    private final HttpStatus httpStatus;
    private final String message;
}
