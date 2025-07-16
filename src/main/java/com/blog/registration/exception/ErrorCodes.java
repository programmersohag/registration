package com.blog.registration.exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    A_0000(Strings.ASSESSES_NOT_FOUND), U_0000(Strings.USER_NOT_FOUND), P_0000(Strings.PLAN_NOT_FOUND), R_0000(Strings.REGION_NOT_FOUND), Q_0000(Strings.QUESTION_NOT_FOUND), PQ_0000(Strings.PUBLISHED_QUESTION_NOT_FOUND), T_0000(Strings.TASK_NOT_FOUND), DSOTR_0000(Strings.DSO_TR_NOT_FOUND), DH_0000(Strings.DH_NOT_FOUND), DA_0000(Strings.DAO_NOT_FOUND), DSO_0000(Strings.DSO_NOT_FOUND), IA_0010(Strings.INVALID_ACTION_CUSTOM_MESSAGE);
    private final String message;
    ErrorCodes(String message) {
        this.message = message;
    }

}
