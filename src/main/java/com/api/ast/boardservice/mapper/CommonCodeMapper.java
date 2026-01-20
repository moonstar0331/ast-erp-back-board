package com.api.ast.boardservice.mapper;

import com.api.ast.boardservice.dto.code.CommonCodeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonCodeMapper {

    int insertOne(@Param("commonCode") CommonCodeDto commonCode);

    CommonCodeDto selectOne(@Param("codeId") Long codeId);

    List<CommonCodeDto> selectAll();

    List<CommonCodeDto> selectAllByParentCodeId(@Param("parentCodeId") Long parentCodeId);

    List<CommonCodeDto> selectAllByGroupCodeId(@Param("groupCodeId") Long groupCodeId);

    int updateOne(@Param("commonCode") CommonCodeDto commonCode);

    void deleteOne(@Param("commonCode") CommonCodeDto commonCode);
}
