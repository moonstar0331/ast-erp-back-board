package com.api.ast.boardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardMasterDto {
    private Long boardId;
    private String boardTypeCode;
    private String boardName;
    private String useCommentYn;
    private String useYn;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private boolean deletedYn;
    private Long menuId;
}
