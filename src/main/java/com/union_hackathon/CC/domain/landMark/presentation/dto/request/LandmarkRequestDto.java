package com.union_hackathon.CC.domain.landMark.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LandmarkRequestDto {

    @NotEmpty
    private String answer;
}
