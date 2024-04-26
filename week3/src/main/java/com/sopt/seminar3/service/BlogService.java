package com.sopt.seminar3.service;

import com.sopt.seminar3.service.dto.BlogCreateRequest;
import com.sopt.seminar3.service.dto.BlogUpdateRequest;
import com.sopt.seminar3.common.dto.ErrorMessage;
import com.sopt.seminar3.domain.Blog;
import com.sopt.seminar3.domain.Member;
import com.sopt.seminar3.exception.NotFoundException;
import com.sopt.seminar3.respository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }

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
