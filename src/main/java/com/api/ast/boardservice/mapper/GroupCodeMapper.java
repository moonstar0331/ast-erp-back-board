package com.api.ast.boardservice.mapper;

import com.api.ast.boardservice.dto.group.GroupCodeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupCodeMapper {

    int insertOne(@Param("groupCode") GroupCodeDto groupCode);

    GroupCodeDto selectOne(@Param("groupCodeId") Long groupCodeId);

    List<GroupCodeDto> selectAll();

    int updateOne(@Param("groupCode") GroupCodeDto groupCode);

    int updateAll(@Param("groupCodeList") List<GroupCodeDto> groupCodeList);

}
