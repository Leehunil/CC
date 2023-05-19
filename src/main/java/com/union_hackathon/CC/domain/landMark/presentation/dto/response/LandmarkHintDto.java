package com.union_hackathon.CC.domain.landMark.presentation.dto.response;

import com.union_hackathon.CC.domain.food.domain.Food;
import com.union_hackathon.CC.domain.landMark.domain.Landmark;
import lombok.Getter;

@Getter
public class LandmarkHintDto {

    private String hint;

    public LandmarkHintDto(Landmark landmark) {
        this.hint = landmark.getHint();
    }
}
