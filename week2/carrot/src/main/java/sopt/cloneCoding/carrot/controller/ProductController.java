package sopt.cloneCoding.carrot.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.cloneCoding.carrot.common.ApiResponse;
import sopt.cloneCoding.carrot.service.ProductCommandService;
import sopt.cloneCoding.carrot.service.dto.request.MemberCreateRequestDto;
import sopt.cloneCoding.carrot.service.dto.request.ProductCreateRequestDto;
import sopt.cloneCoding.carrot.service.dto.response.MemberCreateResponseDto;
import sopt.cloneCoding.carrot.service.dto.response.ProductCreateResponseDto;

import static sopt.cloneCoding.carrot.common.SuccessType.MEMBER_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductCommandService productCommandService;

    @PostMapping("/{memberId}/product")
    public ApiResponse<ProductCreateResponseDto> createProduct(@PathVariable("memberId") Long memberId, @Valid @RequestBody ProductCreateRequestDto productCreateDto){
        return ApiResponse.success(MEMBER_CREATE_SUCCESS, productCommandService.createProduct(memberId, productCreateDto));
    }
}
