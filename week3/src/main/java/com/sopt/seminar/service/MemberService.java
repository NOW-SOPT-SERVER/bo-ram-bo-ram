package com.sopt.seminar.service;

import com.sopt.seminar.config.auth.UserAuthentication;
import com.sopt.seminar.common.dto.ErrorMessage;
import com.sopt.seminar.config.jwt.JwtTokenProvider;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.respository.MemberRepository;
import com.sopt.seminar.service.dto.MemberCreateDto;
import com.sopt.seminar.service.dto.MemberFindDto;
import com.sopt.seminar.service.dto.UserJoinResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    //    @Transactional
//    public String createMember(
//            MemberCreateDto memberCreateDto
//    ) {
//        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
//        memberRepository.save(member);
//        return member.getId().toString();
//    }

    @Transactional
    public UserJoinResponse createMember(
            MemberCreateDto memberCreate
    ) {
        Member member = memberRepository.save(
                Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age())
        );
        Long memberId = member.getId();
        String accessToken = jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(memberId)
        );
        return UserJoinResponse.of(accessToken, memberId.toString());
    }

    public MemberFindDto findMemberById(Long memberId) {
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    @Transactional
    public void deleteMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
        memberRepository.delete(member);
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}