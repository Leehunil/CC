package com.union_hackathon.CC.domain.flag.service;

import com.union_hackathon.CC.domain.flag.domain.Flag;
import com.union_hackathon.CC.domain.flag.domain.repository.FlagRepository;
import com.union_hackathon.CC.domain.flag.exception.FlagNotFoundException;
import com.union_hackathon.CC.domain.flag.presentation.dto.request.FlagAnswerRequestDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerAndExplainDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerResponseDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagHintDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagQuestionDto;
import com.union_hackathon.CC.domain.food.domain.Food;
import com.union_hackathon.CC.domain.food.exception.FoodNotFoundException;
import com.union_hackathon.CC.domain.food.presentation.dto.request.FoodAnswerRequestDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerAndExplainDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodAnswerResponseDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodHintDto;
import com.union_hackathon.CC.domain.food.presentation.dto.response.FoodQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FlagService {

    private final FlagRepository flagRepository;

    //문제, 사진, 객관식 문제
    public List<FlagQuestionDto> getFlagQuestion() {
        List<Flag> flagList = flagRepository.findAll();
        return flagList.stream().map(flag -> new FlagQuestionDto(flag)).collect(Collectors.toList());
    }

    //힌트 주기
    public FlagHintDto getFlagHint(Long flagId) {
        Flag flag = findFlag(flagId);
        return new FlagHintDto(flag);
    }


    //정답이 맞는지 확인
    public FlagAnswerResponseDto checkCorrectAnswer(Long flagId, FlagAnswerRequestDto flagAnswerRequestDto) {
        Flag flag = findFlag(flagId);
        Boolean isCorrected;
        if (flag.getAnswer().equals(flagAnswerRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new FlagAnswerResponseDto(isCorrected);
    }

    //정답과 해설 보내주기
    public FlagAnswerAndExplainDto getFlagAnswerAndExplain(Long flagId) {
        Flag flag = findFlag(flagId);
        return new FlagAnswerAndExplainDto(flag);
    }

    private Flag findFlag(Long flagId) {
        return flagRepository
                .findById(flagId)
                .orElseThrow(()-> FlagNotFoundException.EXCEPTION);
    }
}
