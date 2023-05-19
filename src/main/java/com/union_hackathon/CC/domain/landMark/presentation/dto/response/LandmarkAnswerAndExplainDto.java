package com.union_hackathon.CC.domain.landMark.presentation.dto.response;

import com.union_hackathon.CC.domain.food.domain.Food;
import com.union_hackathon.CC.domain.landMark.domain.Landmark;
import lombok.Getter;

@Getter
public class LandmarkAnswerAndExplainDto {

    private String answer;

    private String info;

    public LandmarkAnswerAndExplainDto(Landmark landmark) {
        this.answer = landmark.getAnswer();
        this.info = landmark.getInfo();
    }
}
