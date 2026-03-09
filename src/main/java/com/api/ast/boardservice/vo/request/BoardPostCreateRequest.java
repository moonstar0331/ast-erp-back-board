package com.api.ast.boardservice.vo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostCreateRequest {
    private Long boardId;
    private Long writerId;
    private String writerUuid;
    private String title;
    private String content;
    private String postStatusCode;
}
