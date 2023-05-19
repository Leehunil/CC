package com.union_hackathon.CC.domain.costume.presentation.dto.response;

import com.union_hackathon.CC.domain.costume.domain.Costume;
import com.union_hackathon.CC.domain.flag.domain.Flag;
import lombok.Getter;

@Getter
public class CostumeHintDto {
    private String hint;

    public CostumeHintDto(Costume costume) {
        this.hint = costume.getHint();
    }
}
