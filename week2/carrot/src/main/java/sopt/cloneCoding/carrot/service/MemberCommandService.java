package sopt.cloneCoding.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.cloneCoding.carrot.domain.Member;
import sopt.cloneCoding.carrot.repository.MemberRepository;
import sopt.cloneCoding.carrot.service.dto.request.MemberCreateRequestDto;
import sopt.cloneCoding.carrot.service.dto.response.MemberCreateResponseDto;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandService {
    private final MemberRepository memberRepository;
    public MemberCreateResponseDto createMember(MemberCreateRequestDto memberCreateDto){
        Member member = Member.createMember(memberCreateDto.nickname());
        memberRepository.save(member);
        return MemberCreateResponseDto.of(member);
    }
}
