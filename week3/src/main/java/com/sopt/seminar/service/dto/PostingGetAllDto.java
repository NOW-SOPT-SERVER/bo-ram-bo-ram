package com.sopt.seminar.service.dto;

import com.sopt.seminar.domain.Posting;

public record PostingGetAllDto (
        String title,
        String content
){
    public static PostingGetAllDto of(
            Posting posting
    ){
        return new PostingGetAllDto(posting.getTitle(), posting.getContent());
    }
}
