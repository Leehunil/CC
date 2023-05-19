package com.union_hackathon.CC.domain.landMark.service;

import com.union_hackathon.CC.domain.food.exception.FoodNotFoundException;
import com.union_hackathon.CC.domain.landMark.domain.Landmark;
import com.union_hackathon.CC.domain.landMark.domain.repository.LandmarkRepository;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkAnswerAndExplainDto;
import com.union_hackathon.CC.domain.landMark.presentation.dto.response.LandmarkHintDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;




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
