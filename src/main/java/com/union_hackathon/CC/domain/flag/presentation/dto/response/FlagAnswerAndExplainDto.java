package com.union_hackathon.CC.domain.flag.presentation.dto.response;

import com.union_hackathon.CC.domain.flag.domain.Flag;
import com.union_hackathon.CC.domain.food.domain.Food;
import lombok.Getter;

@Getter
public class FlagAnswerAndExplainDto {

    private String answer;

    private String info;

    public FlagAnswerAndExplainDto(Flag flag) {
        this.answer = flag.getAnswer();
        this.info = flag.getInfo();
    }
}
