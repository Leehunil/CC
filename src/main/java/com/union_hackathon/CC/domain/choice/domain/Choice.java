package com.union_hackathon.CC.domain.choice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Choice {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "choice_id")
    private Long id;

    private String one;

    private String two;

    private String three;

    private String four;

    @Builder
    public Choice(String one, String two, String three, String four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }




}
