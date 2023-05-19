package com.union_hackathon.CC.domain.flag.exception;

import com.union_hackathon.CC.domain.food.exception.FoodNotFoundException;
import com.union_hackathon.CC.global.error.exception.CCException;
import com.union_hackathon.CC.global.error.exception.ErrorCode;

public class FlagNotFoundException extends CCException{

    public static final CCException EXCEPTION = new FlagNotFoundException();

    public FlagNotFoundException() {
        super(ErrorCode.FLAG_NOT_FOUND);
    }
}
