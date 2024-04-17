package sopt.cloneCoding.carrot.service.dto.response;

import sopt.cloneCoding.carrot.domain.Member;

public record MemberCreateResponseDto(
        Long memberId,
        String nickname
){
    public static MemberCreateResponseDto of(Member member){
        return new MemberCreateResponseDto(member.getId(),
                member.getNickname());
    }
}
