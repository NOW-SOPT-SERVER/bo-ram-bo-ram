package sopt.cloneCoding.carrot.domain;

import jakarta.persistence.*;
import lombok.*;
import sopt.cloneCoding.carrot.domain.common.BaseEntity;
import sopt.cloneCoding.carrot.service.dto.request.ProductCreateRequestDto;

@Table(name = "products")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private TransactionMethod method;

    @Column(columnDefinition ="BOOLEAN DEFAULT false")
    private Boolean isSuggested;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    @Builder
    public Product(Member member, ProductCreateRequestDto product){
        this.member = member;
        this.title = product.title();
        this.method=product.method();
        this.isSuggested = product.isSuggested();
        this.price = product.price();
        this.description=product.description();
    }
}
