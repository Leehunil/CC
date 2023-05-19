package com.union_hackathon.CC.domain.landMark.domain;

import com.union_hackathon.CC.domain.choice.domain.Choice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Landmark {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "landmark_id")
    private Long id;

    private String url;

    private String question;

    private String info;

    private String hint;

    private String answer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "choice_id")
    private Choice choice;


}
