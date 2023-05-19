package com.union_hackathon.CC.domain.food.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodAnswerRequestDto {

    @NotEmpty
    private String answer;
}
