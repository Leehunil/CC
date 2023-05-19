package com.union_hackathon.CC.domain.flag.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FlagAnswerRequestDto {

    @NotEmpty
    private String answer;
}
