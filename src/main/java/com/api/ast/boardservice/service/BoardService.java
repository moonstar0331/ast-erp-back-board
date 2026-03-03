package com.api.ast.boardservice.service;

import com.api.ast.boardservice.dto.BoardDto;
import com.api.ast.boardservice.dto.BoardPostDto;

import java.util.List;

public interface BoardService {

    void insertBoardOne(BoardDto dto);

    List<BoardDto> selectBoardList();

    BoardDto selectBoardOne(Long boardId);

    BoardDto selectBoardByMenuId(Long menuId);

    BoardDto updateBoardOne(BoardDto dto);

    void deleteBoardOne(Long boardId);

    void insertPostOne(BoardPostDto dto);

    List<BoardPostDto> selectPostList();

    BoardPostDto selectPostOne(Long postId);

    BoardPostDto updatePostOne(BoardPostDto dto);

    void deletePostOne(Long postId);

}
