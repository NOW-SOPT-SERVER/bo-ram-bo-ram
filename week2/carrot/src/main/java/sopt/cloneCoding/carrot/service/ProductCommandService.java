package sopt.cloneCoding.carrot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.cloneCoding.carrot.common.ErrorType;
import sopt.cloneCoding.carrot.domain.Member;
import sopt.cloneCoding.carrot.domain.Product;
import sopt.cloneCoding.carrot.domain.SaleStatus;
import sopt.cloneCoding.carrot.domain.common.NotFoundException;
import sopt.cloneCoding.carrot.repository.MemberRepository;
import sopt.cloneCoding.carrot.repository.ProductRepository;
import sopt.cloneCoding.carrot.service.dto.request.ProductCreateRequestDto;
import sopt.cloneCoding.carrot.service.dto.response.ProductCreateResponseDto;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCommandService {
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public ProductCreateResponseDto createProduct(Long memberId, ProductCreateRequestDto requestDto){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND_MEMBER.getHttpStatus(),ErrorType.NOT_FOUND_MEMBER.getMessage()));

        Product product = Product.builder()
                .member(member)
                .title(requestDto.title())
                .method(requestDto.method())
                .isSuggested(requestDto.isSuggested())
                .price(requestDto.price())
                .description(requestDto.description())
                .saleStatus(SaleStatus.SALE)    //판매중인 상태 default로 설정
                .build();

        product = productRepository.save(product);

        return ProductCreateResponseDto.of(product);
    }
}
