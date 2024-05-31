package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorMessage;
import com.sopt.seminar.domain.Blog;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.external.S3Service;
import com.sopt.seminar.respository.BlogRepository;
import com.sopt.seminar.service.dto.BlogCreateRequest;
import com.sopt.seminar.service.dto.BlogUpdateRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    private final S3Service s3Service;
    private static final String BLOG_S3_UPLOAD_FOLER = "blog/";

    @Transactional
    public String create(Long memberId, BlogCreateRequest createRequest) {
        //member찾기
        Member member = memberService.findById(memberId);
        try {
            Blog blog = blogRepository.save(Blog.create(member, createRequest.title(), createRequest.description(),
                    s3Service.uploadImage(BLOG_S3_UPLOAD_FOLER, createRequest.image())));
            return blog.getId().toString();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

//    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
//        Member member = memberService.findById(memberId);
//        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
//        return blog.getId().toString();
//    }

    //@Transactional
    public void updateTitle(Long blogId, BlogUpdateRequest TitleUpdateRequest) {
        Blog blog = findBlogById(blogId);
        blog.updateTitle(TitleUpdateRequest.title());
        blogRepository.save(blog);  //save안에 Transactional이 붙어있어서 사용해준거임
    }

    private Blog findBlogById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));
    }
}
