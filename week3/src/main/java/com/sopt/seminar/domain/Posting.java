package com.sopt.seminar.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Posting extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    @Builder
    private Posting(final Blog blog, final String title, final String content) {
        this.blog = blog;
        this.title = title;
        this.content = content;
    }

    public static Posting createPosting(final Blog blog, final String title, final String content) {
        return Posting.builder()
                .blog(blog)
                .title(title)
                .content(content)
                .build();
    }

}
