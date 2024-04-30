package sopt.cloneCoding.carrot.service.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequestDto (
        @NotBlank String nickname
){}
