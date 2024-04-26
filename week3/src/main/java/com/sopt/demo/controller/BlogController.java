package com.sopt.demo.controller;


import com.sopt.demo.service.dto.BlogCreateRequest;
import com.sopt.demo.service.dto.BlogUpdateRequest;
import com.sopt.demo.common.dto.SuccessMessage;
import com.sopt.demo.common.dto.SuccessStatusResponse;
import com.sopt.demo.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader(name = "memberId") Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        blogService.create(memberId, blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogUpdateRequest blogTitleUpdateRequest
    ){
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}
