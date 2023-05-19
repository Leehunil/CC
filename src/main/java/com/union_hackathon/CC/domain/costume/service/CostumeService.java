package com.union_hackathon.CC.domain.costume.service;

import com.union_hackathon.CC.domain.costume.domain.Costume;
import com.union_hackathon.CC.domain.costume.domain.repository.CostumeRepository;
import com.union_hackathon.CC.domain.costume.exception.CostumeNotFoundException;
import com.union_hackathon.CC.domain.costume.presentation.dto.request.CostumeAnswerRequestDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeAnswerAndExplainDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeAnswerResponseDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeHintDto;
import com.union_hackathon.CC.domain.costume.presentation.dto.response.CostumeQuestionDto;
import com.union_hackathon.CC.domain.flag.domain.Flag;
import com.union_hackathon.CC.domain.flag.domain.repository.FlagRepository;
import com.union_hackathon.CC.domain.flag.exception.FlagNotFoundException;
import com.union_hackathon.CC.domain.flag.presentation.dto.request.FlagAnswerRequestDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerAndExplainDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagAnswerResponseDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagHintDto;
import com.union_hackathon.CC.domain.flag.presentation.dto.response.FlagQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CostumeService {

    private final CostumeRepository costumeRepository;

    //문제, 사진, 객관식 문제
    public List<CostumeQuestionDto> getCostumeQuestion() {
        List<Costume> costumeList = costumeRepository.findAll();
        return costumeList.stream().map(costume -> new CostumeQuestionDto(costume)).collect(Collectors.toList());
    }

    //힌트 주기
    public CostumeHintDto getCostumeHint(Long costumeId) {
        Costume costume = findCostume(costumeId);
        return new CostumeHintDto(costume);
    }


    //정답이 맞는지 확인
    public CostumeAnswerResponseDto checkCorrectAnswer(Long costumeID, CostumeAnswerRequestDto costumeAnswerRequestDto) {
        Costume costume = findCostume(costumeID);
        Boolean isCorrected;
        if (costume.getAnswer().equals(costumeAnswerRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new CostumeAnswerResponseDto(isCorrected);
    }

    //정답과 해설 보내주기
    public CostumeAnswerAndExplainDto getCostumeAnswerAndExplain(Long costumeId) {
        Costume costume = findCostume(costumeId);
        return new CostumeAnswerAndExplainDto(costume);
    }

    private Costume findCostume(Long costumeId) {
        return costumeRepository
                .findById(costumeId)
                .orElseThrow(()-> CostumeNotFoundException.EXCEPTION);
    }
}
