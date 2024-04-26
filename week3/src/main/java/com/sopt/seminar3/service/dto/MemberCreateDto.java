package com.sopt.seminar3.service.dto;

import com.sopt.seminar3.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
