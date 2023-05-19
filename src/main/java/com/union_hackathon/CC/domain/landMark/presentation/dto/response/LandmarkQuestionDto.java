package com.union_hackathon.CC.domain.landMark.presentation.dto.response;

import com.union_hackathon.CC.domain.landMark.domain.Landmark;
import lombok.Getter;

@Getter
public class LandmarkQuestionDto {

    private Long id;

    private String url;

    private String question;

    private String one;

    private String two;

    private String three;

    private String four;

    public LandmarkQuestionDto(Landmark landmark) {
        this.id = landmark.getId();
        this.url = landmark.getUrl();
        this.question = landmark.getQuestion();
        this.one = landmark.getChoice().getOne();
        this.two = landmark.getChoice().getTwo();
        this.three = landmark.getChoice().getThree();
        this.four = landmark.getChoice().getFour();
    }
}
