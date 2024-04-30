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
        public Product(Member member, String title, TransactionMethod method,
                    Boolean isSuggested, int price, String description){
        this.member = member;
        this.title = title;
        this.method= method;
        this.isSuggested = isSuggested;
        this.price = price;
        this.description= description;
        this.saleStatus = SaleStatus.SALE;// 상태 판매중으로 default 설정
    }

    public static Product createProduct(
            Member member,
            ProductCreateRequestDto requestDto
    ){  return Product.builder()
            .member(member)
            .title(requestDto.title())
            .method(requestDto.method())
            .isSuggested(requestDto.isSuggested())
            .price(requestDto.price())
            .description(requestDto.description())
            .saleStatus(SaleStatus.SALE)
            .build();
    }
//
//    public static Product createProduct(
//            Member member,
//            String title,
//            TransactionMethod method,
//            Boolean isSuggested,
//            int price,
//            String description
//    ){  return Product.builder()
//            .member(member)
//            .title(title)
//            .method(method)
//            .isSuggested(isSuggested)
//            .price(price)
//            .description(description)
//            .build();
//    }
}
