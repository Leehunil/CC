package com.union_hackathon.CC.domain.costume.presentation.dto.response;

import com.union_hackathon.CC.domain.costume.domain.Costume;
import com.union_hackathon.CC.domain.flag.domain.Flag;
import lombok.Getter;

@Getter
public class CostumeAnswerAndExplainDto {

    private String answer;

    private String info;

    public CostumeAnswerAndExplainDto(Costume costume) {
        this.answer = costume.getAnswer();
        this.info = costume.getInfo();
    }
}
