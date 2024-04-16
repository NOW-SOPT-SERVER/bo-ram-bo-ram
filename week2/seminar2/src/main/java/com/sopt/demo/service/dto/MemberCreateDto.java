package com.sopt.demo.service.dto;

import com.sopt.demo.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
