package com.union_hackathon.CC.domain.food.presentation.dto.response;

import com.union_hackathon.CC.domain.food.domain.Food;
import lombok.Getter;

@Getter
public class FoodHintDto {

    private String hint;

    public FoodHintDto(Food food) {
        this.hint = food.getHint();
    }
}
