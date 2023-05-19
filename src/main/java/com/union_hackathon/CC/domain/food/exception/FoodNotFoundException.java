package com.union_hackathon.CC.domain.food.exception;

import com.union_hackathon.CC.global.error.exception.CCException;
import com.union_hackathon.CC.global.error.exception.ErrorCode;

public class FoodNotFoundException extends CCException {

    public static final CCException EXCEPTION = new FoodNotFoundException();

    public FoodNotFoundException() {
        super(ErrorCode.FOOD_NOT_FOUND);
    }
}
