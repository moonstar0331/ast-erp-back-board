package com.api.ast.boardservice.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupCodeDto {
    private Long groupCodeId;
    private String groupCode;
    private String groupName;
    private String description;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deletedYn;
}
