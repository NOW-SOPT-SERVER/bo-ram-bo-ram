package com.sopt.seminar.controller;

import com.sopt.seminar.service.MemberService;
import com.sopt.seminar.service.dto.MemberCreateDto;
import com.sopt.seminar.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;
    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberCreateDto memberCreate) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(@PathVariable Long memberId){
        return  ResponseEntity.ok(memberService.findMemberById(memberId));
    }
    
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

}
