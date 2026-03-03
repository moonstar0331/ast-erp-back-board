package com.api.ast.boardservice.mapper;

import com.api.ast.boardservice.dto.BoardDto;
import com.api.ast.boardservice.dto.BoardPostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void insertBoardOne(BoardDto dto);

    List<BoardDto> selectBoardList();

    BoardDto selectBoardOne(Long boardId);

    int updateBoardOne(BoardDto dto);

    void deleteBoardOne(Long boardId);

    void insertPostOne(BoardPostDto dto);

    List<BoardPostDto> selectPostList();

    List<BoardPostDto> selectPostListByBoardId(Long boardId);

    BoardPostDto selectPostOne(Long postId);

    int updatePostOne(BoardPostDto dto);

    void deletePostOne(Long postId);
}
