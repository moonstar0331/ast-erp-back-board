package com.api.ast.boardservice.service;

import com.api.ast.boardservice.dto.BoardMasterDto;
import com.api.ast.boardservice.dto.BoardPostDto;

import java.util.List;

public interface BoardService {

    void insertMasterOne(BoardMasterDto dto);

    List<BoardMasterDto> selectMasterList();

    BoardMasterDto selectMasterOne(Long masterId);

    BoardMasterDto updateMasterOne(BoardMasterDto dto);

    void deleteMasterOne(Long masterId);

    void insertPostOne(BoardPostDto dto);

    List<BoardPostDto> selectPostList();

    BoardPostDto selectPostOne(Long postId);

    BoardPostDto updatePostOne(BoardPostDto dto);

    void deletePostOne(Long postId);

}
