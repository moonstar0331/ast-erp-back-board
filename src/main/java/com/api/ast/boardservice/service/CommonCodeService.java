package com.api.ast.boardservice.service;

import com.api.ast.boardservice.dto.code.CommonCodeDto;

import java.util.List;

public interface CommonCodeService {

    void insertOne(CommonCodeDto dto);

    void insertMany(List<CommonCodeDto> dtoList);

    CommonCodeDto selectOne(Long codeId);

    List<CommonCodeDto> selectAll();

    List<CommonCodeDto> selectAllByParentCodeId(Long parentCodeId);

    List<CommonCodeDto> selectAllByGroupCodeId(Long groupCodeId);

    CommonCodeDto updateOne(CommonCodeDto dto);

    List<CommonCodeDto> updateMany(List<CommonCodeDto> dtoList);

    void deleteOne(Long codeId);

    void deleteMany(List<Long> codeIdList);

    void deleteManyByGroupCodeId(Long groupCodeId);
}
