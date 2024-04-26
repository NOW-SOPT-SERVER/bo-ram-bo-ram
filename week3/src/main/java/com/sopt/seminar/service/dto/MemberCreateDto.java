package com.sopt.seminar.service.dto;

import com.sopt.seminar.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
