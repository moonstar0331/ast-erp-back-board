package com.api.ast.boardservice.vo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostResponse {
    private Long postId;
    private Long boardId;
    private Long writerId;
    private String title;
    private String content;
    private String postStatusCode;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private boolean deletedYn;
}
