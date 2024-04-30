package sopt.cloneCoding.carrot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.cloneCoding.carrot.common.ApiResponse;
import jakarta.validation.Valid;
import sopt.cloneCoding.carrot.service.MemberCommandService;
import sopt.cloneCoding.carrot.service.dto.request.MemberCreateRequestDto;
import sopt.cloneCoding.carrot.service.dto.response.MemberCreateResponseDto;

import static sopt.cloneCoding.carrot.common.SuccessType.MEMBER_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberCommandService memberCommandService;

    @PostMapping
    public ApiResponse<MemberCreateResponseDto> createMember(@Valid @RequestBody MemberCreateRequestDto memberCreateDto){
        return ApiResponse.success(MEMBER_CREATE_SUCCESS, memberCommandService.createMember(memberCreateDto));
    }
}
