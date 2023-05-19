package com.union_hackathon.CC.domain.costume.exception;

import com.union_hackathon.CC.domain.flag.exception.FlagNotFoundException;
import com.union_hackathon.CC.global.error.exception.CCException;
import com.union_hackathon.CC.global.error.exception.ErrorCode;

public class CostumeNotFoundException extends CCException {

    public static final CCException EXCEPTION = new CostumeNotFoundException();

    public CostumeNotFoundException() {
        super(ErrorCode.COSTUME_NOT_FOUND);
    }
}
