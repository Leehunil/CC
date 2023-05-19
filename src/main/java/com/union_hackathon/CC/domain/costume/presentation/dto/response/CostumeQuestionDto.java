package com.union_hackathon.CC.domain.costume.presentation.dto.response;

import com.union_hackathon.CC.domain.costume.domain.Costume;
import com.union_hackathon.CC.domain.flag.domain.Flag;
import lombok.Getter;

@Getter
public class CostumeQuestionDto {

    private Long id;

    private String url;

    private String question;

    private String one;

    private String two;

    private String three;

    private String four;

    public CostumeQuestionDto(Costume costume) {
        this.id = costume.getId();
        this.url = costume.getUrl();
        this.question = costume.getQuestion();
        this.one = costume.getChoice().getOne();
        this.two = costume.getChoice().getTwo();
        this.three = costume.getChoice().getThree();
        this.four = costume.getChoice().getFour();
    }
}
