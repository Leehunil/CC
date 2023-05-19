package com.union_hackathon.CC.domain.food.presentation.dto.response;

import com.union_hackathon.CC.domain.food.domain.Food;
import lombok.Getter;

@Getter
public class FoodAnswerAndExplainDto {

    private String answer;

    private String info;

    public FoodAnswerAndExplainDto(Food food) {
        this.answer = food.getAnswer();
        this.info = food.getInfo();
    }

}
