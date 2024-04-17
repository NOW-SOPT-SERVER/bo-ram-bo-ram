package com.sopt.demo.controller;

import com.sopt.demo.service.MemberQueryService;
import com.sopt.demo.service.MemberCommandService;
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
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberCreateDto memberCreate) {
        return ResponseEntity.created(URI.create(memberCommandService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(@PathVariable Long memberId){
        return  ResponseEntity.ok(memberQueryService.findMemberById(memberId));
    }
    
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable Long memberId){
        memberCommandService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<MemberFindDto>> getAllMembers() {
        return ResponseEntity.ok(memberQueryService.findAllMembers());
    }
}
