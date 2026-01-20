package com.api.ast.boardservice.dto;

import com.api.ast.boardservice.dto.code.CommonCodeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeGroupDetailDto {
    private Long groupCodeId;
    private String groupCode;
    private String groupName;
    private String useYn;
    private List<CommonCodeDto> codes;
}
