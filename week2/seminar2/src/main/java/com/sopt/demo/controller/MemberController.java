package com.sopt.demo.controller;

import com.sopt.demo.service.MemberService;
import com.sopt.demo.service.dto.MemberCreateDto;
import com.sopt.demo.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
    @GetMapping("/all")
    public ResponseEntity<List<MemberFindDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }
}
