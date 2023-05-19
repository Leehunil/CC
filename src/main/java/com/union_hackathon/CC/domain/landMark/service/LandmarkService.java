package com.union_hackathon.CC.domain.landMark.service;

import com.union_hackathon.CC.domain.food.domain.Food;
import com.union_hackathon.CC.domain.food.exception.FoodNotFoundException;
import com.union_hackathon.CC.domain.food.presentation.dto.request.FoodAnswerRequestDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerResponseDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodQuestionDto;
import com.union_hackathon.CC.domain.landMark.domain.Landmark;
import com.union_hackathon.CC.domain.landMark.domain.repository.LandmarkRepository;
import com.union_hackathon.CC.domain.landMark.presentation.dto.request.LandmarkRequestDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkAnswerAndExplainDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkAnswerResponseDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkHintDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;

    public List<LandmarkQuestionDto> getFoodQuestion() {
        List<Landmark> landmarkList = landmarkRepository.findAll();
        return landmarkList.stream().map(food -> new LandmarkQuestionDto(food)).collect(Collectors.toList());
    }

    //
    //정답이 맞는지 확인
    public LandmarkAnswerResponseDto checkCorrectAnswer(Long landmarkId, LandmarkRequestDto landmarkRequestDto) {
        Landmark landmark = findLandmark(landmarkId);
        Boolean isCorrected;
        if (landmark.getAnswer().equals(landmarkRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new LandmarkAnswerResponseDto(isCorrected);
    }


    //힌트 주기
    public LandmarkHintDto getLandmarkHint(Long randmarkId) {
        Landmark landmark = findLandmark(randmarkId);
        return new LandmarkHintDto(landmark);
    }

    //정답과 해설 보내주기
    public LandmarkAnswerAndExplainDto getLandmarkAnswerAndExplain(Long landmarkId) {
        Landmark landmark = findLandmark(landmarkId);
        return new LandmarkAnswerAndExplainDto(landmark);
    }

    private Landmark findLandmark(Long landmarkId) {
        return landmarkRepository
                .findById(landmarkId)
                .orElseThrow(()-> FoodNotFoundException.EXCEPTION);
    }
}
