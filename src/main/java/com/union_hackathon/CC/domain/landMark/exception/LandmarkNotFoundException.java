package com.union_hackathon.CC.domain.landMark.exception;

import com.union_hackathon.CC.domain.food.exception.FoodNotFoundException;
import com.union_hackathon.CC.global.error.exception.CCException;
import com.union_hackathon.CC.global.error.exception.ErrorCode;

public class LandmarkNotFoundException extends CCException {

    public static final CCException EXCEPTION = new LandmarkNotFoundException();

    public LandmarkNotFoundException() {
        super(ErrorCode.FOOD_NOT_FOUND);
    }
}
