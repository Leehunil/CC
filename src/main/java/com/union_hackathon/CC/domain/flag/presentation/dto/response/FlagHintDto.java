package com.union_hackathon.CC.domain.flag.presentation.dto.response;

import com.union_hackathon.CC.domain.flag.domain.Flag;
import com.union_hackathon.CC.domain.food.domain.Food;
import lombok.Getter;

@Getter
public class FlagHintDto {
    private String hint;

    public FlagHintDto(Flag flag) {
        this.hint = flag.getHint();
    }
}
