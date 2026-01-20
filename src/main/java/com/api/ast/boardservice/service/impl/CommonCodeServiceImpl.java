package com.api.ast.boardservice.service.impl;

import com.api.ast.boardservice.dto.code.CommonCodeDto;
import com.api.ast.boardservice.exception.BoardServiceException;
import com.api.ast.boardservice.exception.ErrorCode;
import com.api.ast.boardservice.mapper.CommonCodeMapper;
import com.api.ast.boardservice.service.CommonCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeMapper commonCodeMapper;

    @Override
    @Transactional
    public void insertOne(CommonCodeDto dto) {
        try {
            commonCodeMapper.insertOne(dto);
        } catch (Exception e) {
            throw new BoardServiceException(ErrorCode.COMMON_CODE_CREATE_ERROR);
        }
    }

    @Override
    @Transactional
    public void insertMany(List<CommonCodeDto> dtoList) {
        for (CommonCodeDto dto : dtoList) {
            insertOne(dto);
        }
    }

    @Override
    public CommonCodeDto selectOne(Long codeId) {
        return commonCodeMapper.selectOne(codeId);
    }

    @Override
    public List<CommonCodeDto> selectAll() {
        return commonCodeMapper.selectAll();
    }

    @Override
    public List<CommonCodeDto> selectAllByParentCodeId(Long parentCodeId) {
        return commonCodeMapper.selectAllByParentCodeId(parentCodeId);
    }


    @Override
    public List<CommonCodeDto> selectAllByGroupCodeId(Long groupCodeId) {
        return commonCodeMapper.selectAllByGroupCodeId(groupCodeId);
    }

    @Override
    @Transactional
    public CommonCodeDto updateOne(CommonCodeDto dto) {

        int updatedCount = commonCodeMapper.updateOne(dto);

        if (updatedCount == 0) {
            throw new BoardServiceException(ErrorCode.COMMON_CODE_UPDATE_ERROR);
        }

        return commonCodeMapper.selectOne(dto.getCodeId());
    }

    @Override
    @Transactional
    public List<CommonCodeDto> updateMany(List<CommonCodeDto> dtoList) {
        for (CommonCodeDto dto : dtoList) {
            updateOne(dto);
        }
        return dtoList;
    }

    @Override
    @Transactional
    public void deleteOne(Long codeId) {
        CommonCodeDto dto = commonCodeMapper.selectOne(codeId);
        if (dto == null) {
            throw new BoardServiceException(ErrorCode.COMMON_CODE_DELETE_ERROR);
        }

        dto.setDeletedYn(true);
        commonCodeMapper.deleteOne(dto);
    }

    @Override
    @Transactional
    public void deleteMany(List<Long> codeIdList) {
        for (Long codeId : codeIdList) {
            deleteOne(codeId);
        }
    }

    @Override
    @Transactional
    public void deleteManyByGroupCodeId(Long groupCodeId) {
        List<CommonCodeDto> commonCodeList = selectAllByGroupCodeId(groupCodeId);

        deleteMany(commonCodeList
                .stream()
                .map(CommonCodeDto::getCodeId)
                .collect(Collectors.toList()));
    }
}
