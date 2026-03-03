package com.api.ast.boardservice.service.impl;

import com.api.ast.boardservice.dto.BoardMasterDto;
import com.api.ast.boardservice.dto.BoardPostDto;
import com.api.ast.boardservice.exception.BoardServiceException;
import com.api.ast.boardservice.exception.ErrorCode;
import com.api.ast.boardservice.mapper.BoardMapper;
import com.api.ast.boardservice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    @Transactional
    public void insertMasterOne(BoardMasterDto dto) {
        try {
            boardMapper.insertMasterOne(dto);
        } catch (Exception e) {
            throw new BoardServiceException(ErrorCode.BOARD_MASTER_CREATE_ERROR);
        }
    }

    @Override
    public List<BoardMasterDto> selectMasterList() {
        return boardMapper.selectMasterList();
    }

    @Override
    public BoardMasterDto selectMasterOne(Long masterId) {
        return boardMapper.selectMasterOne(masterId);
    }

    @Override
    @Transactional
    public BoardMasterDto updateMasterOne(BoardMasterDto dto) {
        int updatedCount = boardMapper.updateMasterOne(dto);

        if (updatedCount == 0) {
            throw new BoardServiceException(ErrorCode.BOARD_MASTER_UPDATE_ERROR);
        }

        return boardMapper.selectMasterOne(dto.getBoardId());
    }

    @Override
    @Transactional
    public void deleteMasterOne(Long masterId) {
        boardMapper.deleteMasterOne(masterId);
    }

    @Override
    @Transactional
    public void insertPostOne(BoardPostDto dto) {
        try {
            boardMapper.insertPostOne(dto);
        } catch (Exception e) {
            throw new BoardServiceException(ErrorCode.BOARD_POST_CREATE_ERROR);
        }
    }

    @Override
    public List<BoardPostDto> selectPostList() {
        return boardMapper.selectPostList();
    }

    @Override
    public BoardPostDto selectPostOne(Long postId) {
        return boardMapper.selectPostOne(postId);
    }

    @Override
    @Transactional
    public BoardPostDto updatePostOne(BoardPostDto dto) {
        int updatedCount = boardMapper.updatePostOne(dto);
        if (updatedCount == 0) {
            throw new BoardServiceException(ErrorCode.BOARD_POST_UPDATE_ERROR);
        }
        return boardMapper.selectPostOne(dto.getPostId());
    }

    @Override
    @Transactional
    public void deletePostOne(Long postId) {
        boardMapper.deletePostOne(postId);
    }
}
