package com.sopt.seminar.service.dto;

import com.sopt.seminar.domain.Member;
import com.sopt.seminar.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {

    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
