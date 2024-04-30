package sopt.cloneCoding.carrot.service.dto.response;

import sopt.cloneCoding.carrot.domain.Product;

public record ProductCreateResponseDto (
        Long productId,
        Long memberId
) {
    public static ProductCreateResponseDto of(Product product) {
        return new ProductCreateResponseDto(product.getId(), product.getMember().getId());
    }
}
