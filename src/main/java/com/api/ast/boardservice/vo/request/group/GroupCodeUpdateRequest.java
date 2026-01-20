package com.api.ast.boardservice.vo.request.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupCodeUpdateRequest {
    private String groupCode;
    private String groupName;
    private String description;
    private String useYn;
}
