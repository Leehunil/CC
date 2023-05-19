package com.union_hackathon.CC.domain.food.domain;

import com.union_hackathon.CC.domain.choice.domain.Choice;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Food {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "food_id")
    private Long id;

    private String url;

    private String question;

    private String info;

    private String hint;

    private String answer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "choice_id")
    private Choice choice;

    @Builder
    public Food(String url, String question, String info, String hint, String answer, Choice choice) {
        this.url = url;
        this.question = question;
        this.info = info;
        this.hint = hint;
        this.answer = answer;
        this.choice = choice;
    }
}
