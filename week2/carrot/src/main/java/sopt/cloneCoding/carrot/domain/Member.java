package sopt.cloneCoding.carrot.domain;

import jakarta.persistence.*;
import lombok.*;
import sopt.cloneCoding.carrot.domain.common.BaseEntity;

@Table(name = "members")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    public static Member createMember(String nickname){
        return builder().nickname(nickname).build();
    }

    @Builder
    private Member(String nickname){
        this.nickname=nickname;
    }

}
