package com.union_hackathon.CC.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    FOOD_NOT_FOUND(404, "해당하는 음식 관련 문제가 없습니다."),
    INTERNAL_SERVER_ERROR(500,"서버 에러");

    private int status;
    private String reason;
}
