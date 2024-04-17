package sopt.cloneCoding.carrot.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.cloneCoding.carrot.domain.common.BaseEntity;

@Table(name = "products")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(name = "transaction_Method", nullable = false)
    private TransactionMethod method;

    private Boolean isSuggested;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;
}
