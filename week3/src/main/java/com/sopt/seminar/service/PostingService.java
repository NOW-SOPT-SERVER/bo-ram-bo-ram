package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorMessage;
import com.sopt.seminar.domain.Blog;
import com.sopt.seminar.domain.Posting;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.respository.BlogRepository;
import com.sopt.seminar.respository.MemberRepository;
import com.sopt.seminar.respository.PostingRepository;
import com.sopt.seminar.service.dto.PostingCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;
    private final BlogRepository blogRepository;
    private final MemberRepository memberRepository;

    public String createPosting(Long memberId, PostingCreateRequest requestDto) {
        memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));

        Blog blog = blogRepository.findById(memberId).orElseThrow(
                ()->new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));

        Posting posting = postingRepository.save(Posting.createPosting(blog, requestDto.title(),requestDto.content()));
        postingRepository.save(posting);
        return posting.toString();
    }
}
