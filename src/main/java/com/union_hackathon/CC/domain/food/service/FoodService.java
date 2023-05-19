package com.union_hackathon.CC.domain.food.service;

import com.union_hackathon.CC.domain.food.domain.Food;
import com.union_hackathon.CC.domain.food.domain.repository.FoodRepository;
import com.union_hackathon.CC.domain.food.exception.FoodNotFoundException;
import com.union_hackathon.CC.domain.food.presentation.dto.request.FoodAnswerRequestDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerAndExplainDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerResponseDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodHintDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodQuestionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Scope("prototype")
@Transactional(readOnly = true)
@Slf4j
public class FoodService {

    private final FoodRepository foodRepository;

    //문제, 사진, 객관식 문제
    public List<FoodQuestionDto> getFoodQuestion() {
        List<Food> foodList = foodRepository.findAll();
        return foodList.stream().map(food -> new FoodQuestionDto(food)).collect(Collectors.toList());
    }

    //힌트 주기
    public FoodHintDto getFoodHint(Long foodId) {
        Food food = findFood(foodId);
        return new FoodHintDto(food);
    }


    //정답이 맞는지 확인
    public FoodAnswerResponseDto checkCorrectAnswer(Long foodId, FoodAnswerRequestDto foodAnswerRequestDto) {
        Food food = findFood(foodId);
        Boolean isCorrected;
        if (food.getAnswer().equals(foodAnswerRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new FoodAnswerResponseDto(isCorrected);
    }

    //정답과 해설 보내주기
    public FoodAnswerAndExplainDto getFoodAnswerAndExplain(Long foodId) {
        Food food = findFood(foodId);
        return new FoodAnswerAndExplainDto(food);
    }

    private Food findFood(Long foodId) {
        return foodRepository
                .findById(foodId)
                .orElseThrow(()-> FoodNotFoundException.EXCEPTION);
    }

    //리스트에서 랜덤으로 뽑기
    private Food getRandomFood(List<Food> foodList) {
        Collections.shuffle(foodList);
        Food food = foodList.get(0);
        log.info(food.getId().toString());
        foodList.remove(food);
        return food;
    }

}
