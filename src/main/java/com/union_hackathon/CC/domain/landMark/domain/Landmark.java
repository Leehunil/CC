package com.union_hackathon.CC.domain.landMark.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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


}
