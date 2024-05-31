package com.sopt.seminar.controller;


import com.sopt.seminar.config.auth.PrincipalHandler;
import com.sopt.seminar.service.BlogService;
import com.sopt.seminar.service.dto.BlogCreateRequest;
import com.sopt.seminar.service.dto.BlogUpdateRequest;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    private final PrincipalHandler principalHandler;

    @PostMapping("/blog")
    public ResponseEntity createBlog(
            @ModelAttribute BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.created(URI.create(blogService.create(
                principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
    }

//    @PostMapping("/blog")
//    public ResponseEntity createBlog(
//            BlogCreateRequest blogCreateRequest
//    ) {
//        return ResponseEntity.created(URI.create(blogService.create(
//                principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
//    }

//    @PostMapping("/blog")
//    public ResponseEntity<SuccessStatusResponse> createBlog(
//            @RequestHeader(name = "memberId") Long memberId,
//            @RequestBody BlogCreateRequest blogCreateRequest
//    ) { return ResponseEntity.status(HttpStatus.CREATED).header(
//                        "Location",
//                        blogService.create(memberId, blogCreateRequest))
//                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
//    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogUpdateRequest blogTitleUpdateRequest
    ){
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}
