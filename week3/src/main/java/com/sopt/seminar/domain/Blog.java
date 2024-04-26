package com.sopt.seminar.domain;

import com.sopt.seminar.service.dto.BlogCreateRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    @Builder
    private Blog(final Member member, final String title, final String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(final Member member, final BlogCreateRequest blogCreateRequest) {
        return Blog.builder()
                .member(member)
                .title(blogCreateRequest.title())   //레코드는 @getter가 그냥 붙어있음
                .description(blogCreateRequest.description())
                .build();
    }

    public void updateTitle(
            String title
    ) {
        this.title = title;
    }

}