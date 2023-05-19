package com.union_hackathon.CC.domain.food.presentation;

import com.union_hackathon.CC.domain.food.presentation.dto.request.FoodAnswerRequestDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerAndExplainDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerResponseDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodHintDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodQuestionDto;
import com.union_hackathon.CC.domain.food.service.FoodService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/question")
    public List<FoodQuestionDto> getFoodQuestion() {
        return foodService.getFoodQuestion();
    }

    @GetMapping("/hint/{foodId}")
    public FoodHintDto getFoodHint(@PathVariable Long foodId) {
        return foodService.getFoodHint(foodId);
    }

    @GetMapping("/check-answer/{foodId}")
    public FoodAnswerResponseDto checkFoodAnswer(@PathVariable Long foodId,
                                                 @RequestBody FoodAnswerRequestDto foodAnswerRequestDto) {
        return foodService.checkCorrectAnswer(foodId, foodAnswerRequestDto);
    }

    @GetMapping("/answer/{foodId}")
    public FoodAnswerAndExplainDto getFoodAnswerAndExplain(@PathVariable Long foodId) {
        return foodService.getFoodAnswerAndExplain(foodId);
    }


}
