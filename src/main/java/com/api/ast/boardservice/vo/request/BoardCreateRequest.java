package com.api.ast.boardservice.vo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCreateRequest {
    private String boardTypeCode;
    private String boardName;
    private String useCommentYn;
    private String useYn;
    private Long menuId;
}
