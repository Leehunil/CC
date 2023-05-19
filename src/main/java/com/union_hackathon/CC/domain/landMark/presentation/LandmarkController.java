package com.union_hackathon.CC.domain.landMark.presentation;

import com.union_hackathon.CC.domain.food.presentation.dto.request.FoodAnswerRequestDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerAndExplainDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerResponseDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodHintDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodQuestionDto;
import com.union_hackathon.CC.domain.food.service.FoodService;
import com.union_hackathon.CC.domain.landMark.presentation.dto.request.LandmarkRequestDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkAnswerAndExplainDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkAnswerResponseDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkHintDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkQuestionDto;
import com.union_hackathon.CC.domain.landMark.service.LandmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/landmark")
public class LandmarkController {

    private final LandmarkService landmarkService;

    @GetMapping("/question")
    public List<LandmarkQuestionDto> getLandmarkQuestion() {
        return landmarkService.getFoodQuestion();
    }

    @GetMapping("/hint/{landmarkId}")
    public LandmarkHintDto getLandmarkHint(@PathVariable Long landmarkId) {
        return landmarkService.getLandmarkHint(landmarkId);
    }

    @GetMapping("/check-answer/{landmarkId}")
    public LandmarkAnswerResponseDto checkLandmarkAnswer(@PathVariable Long landmarkId,
                                                         @RequestBody LandmarkRequestDto landmarkRequestDto) {
        return landmarkService.checkCorrectAnswer(landmarkId, landmarkRequestDto);
    }

    @GetMapping("/answer/{landmarkId}")
    public LandmarkAnswerAndExplainDto getLandmarkAnswerAndExplain(@PathVariable Long landmarkId) {
        return landmarkService.getLandmarkAnswerAndExplain(landmarkId);
    }


}
