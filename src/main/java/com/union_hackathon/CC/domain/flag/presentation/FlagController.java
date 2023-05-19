package com.union_hackathon.CC.domain.flag.presentation;

import com.union_hackathon.CC.domain.flag.presentation.dto.request.FlagAnswerRequestDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerAndExplainDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerResponseDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagHintDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagQuestionDto;
import com.union_hackathon.CC.domain.flag.service.FlagService;
import com.union_hackathon.CC.domain.food.presentation.dto.request.FoodAnswerRequestDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerAndExplainDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerResponseDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodHintDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodQuestionDto;
import com.union_hackathon.CC.domain.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flag")
public class FlagController {

    private final FlagService flagService;

    @GetMapping("/question")
    public List<FlagQuestionDto> getFlagQuestion() {
        return flagService.getFlagQuestion();
    }

    @GetMapping("/hint/{flagId}")
    public FlagHintDto getFlagHint(@PathVariable Long flagId) {
        return flagService.getFlagHint(flagId);
    }

    @GetMapping("/check-answer/{flagId}")
    public FlagAnswerResponseDto checkFlagAnswer(@PathVariable Long flagId,
                                                 @RequestBody FlagAnswerRequestDto flagAnswerRequestDto) {
        return flagService.checkCorrectAnswer(flagId, flagAnswerRequestDto);
    }

    @GetMapping("/answer/{flagId}")
    public FlagAnswerAndExplainDto getFlagAnswerAndExplain(@PathVariable Long flagId) {
        return flagService.getFlagAnswerAndExplain(flagId);
    }
}
