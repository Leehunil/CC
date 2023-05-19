package com.union_hackathon.CC.domain.flag.presentation.dto.response;

import com.union_hackathon.CC.domain.flag.domain.Flag;
import com.union_hackathon.CC.domain.food.domain.Food;
import lombok.Getter;

@Getter
public class FlagQuestionDto {

    private Long id;

    private String url;

    private String question;

    private String one;

    private String two;

    private String three;

    private String four;

    public FlagQuestionDto(Flag flag) {
        this.id = flag.getId();
        this.url = flag.getUrl();
        this.question = flag.getQuestion();
        this.one = flag.getChoice().getOne();
        this.two = flag.getChoice().getTwo();
        this.three = flag.getChoice().getThree();
        this.four = flag.getChoice().getFour();
    }
}
