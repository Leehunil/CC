package com.union_hackathon.CC.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CCException extends RuntimeException{

    private ErrorCode errorCode;
}
