package com.api.ast.boardservice.dto.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeDto {
    private Long codeId;
    private Long groupCodeId;
    private Long parentId;
    private Long groupCode;
    private String codeValue;
    private String codeName;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deletedYn;
}
