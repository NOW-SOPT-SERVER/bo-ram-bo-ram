package com.sopt.seminar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    //404
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),

    //400
    POSTING_TITLE_LONG(HttpStatus.BAD_REQUEST.value(), "블로그 제목이 너무 깁니다."),
    POSTING_CONTENT_LONG(HttpStatus.BAD_REQUEST.value(), "블로그 내용이 너무 깁니다."),

    //401
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
    ;
    private final int status;
    private final String message;
}
