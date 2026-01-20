package com.api.ast.boardservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    GROUP_CODE_SELECT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Group Code Select Error"),
    GROUP_CODE_CREATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Group Code Create Error"),
    GROUP_CODE_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Group Code Update Error"),
    COMMON_CODE_CREATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Common Code Create Error"),
    COMMON_CODE_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Common Code Update Error"),
    COMMON_CODE_DELETE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Common Code Delete Error");

    private HttpStatus status;
    private String message;
}
