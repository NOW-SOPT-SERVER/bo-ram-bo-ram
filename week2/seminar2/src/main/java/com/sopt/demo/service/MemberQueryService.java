package com.sopt.demo.service;

import com.sopt.demo.domain.Member;
import com.sopt.demo.respository.MemberRepository;
import com.sopt.demo.service.dto.MemberFindDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberFindDto findMemberById(Long memberId) {
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    public List<MemberFindDto> findAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream().map(MemberFindDto::of)
                .collect(Collectors.toList());
    }
}