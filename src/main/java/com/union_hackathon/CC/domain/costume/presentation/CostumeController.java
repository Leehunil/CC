package com.union_hackathon.CC.domain.costume.presentation;

import com.union_hackathon.CC.domain.costume.domain.Costume;
import com.union_hackathon.CC.domain.costume.presentation.dto.request.CostumeAnswerRequestDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeAnswerAndExplainDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeAnswerResponseDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeHintDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeQuestionDto;
import com.union_hackathon.CC.domain.costume.service.CostumeService;
import com.union_hackathon.CC.domain.flag.presentation.dto.request.FlagAnswerRequestDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerAndExplainDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerResponseDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagHintDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagQuestionDto;
import com.union_hackathon.CC.domain.flag.service.FlagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costume")
public class CostumeController {

    private final CostumeService costumeService;

    @GetMapping("/question")
    public List<CostumeQuestionDto> getCostumeQuestion() {
        return costumeService.getCostumeQuestion();
    }

    @GetMapping("/hint/{costumeId}")
    public CostumeHintDto getCostumeHint(@PathVariable Long costumeId) {
        return costumeService.getCostumeHint(costumeId);
    }

    @GetMapping("/check-answer/{costumeId}")
    public CostumeAnswerResponseDto checkCostumeAnswer(@PathVariable Long costumeId,
                                                    @RequestBody CostumeAnswerRequestDto costumeAnswerRequestDto) {
        return costumeService.checkCorrectAnswer(costumeId, costumeAnswerRequestDto);
    }

    @GetMapping("/answer/{costumeId}")
    public CostumeAnswerAndExplainDto getCostumeAnswerAndExplain(@PathVariable Long costumeId) {
        return costumeService.getCostumeAnswerAndExplain(costumeId);
    }
}
