package com.sopt.seminar.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostingCreateRequest (
        @Size(max=20,message = "블로그 제목이 너무 깁니다.")
        @NotBlank String title,

        @Size(max=500,message = "블로그 내용이 너무 깁니다.")
        @NotBlank String content
) {
}
