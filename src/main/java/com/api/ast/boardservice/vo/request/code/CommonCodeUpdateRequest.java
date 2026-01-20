package com.api.ast.boardservice.vo.request.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeUpdateRequest {
    private Long codeId;
    private Long parentCodeId;
    private String codeValue;
    private String codeName;
    private String useYn;
}
