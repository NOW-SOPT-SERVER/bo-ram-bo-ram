package sopt.cloneCoding.carrot.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import sopt.cloneCoding.carrot.domain.TransactionMethod;

public record ProductCreateRequestDto(
    @NotBlank String title,
    TransactionMethod method,
    Boolean isSuggested,
    int price,
    @NotBlank String description
) {}
