package com.api.ast.boardservice.mapper;

import com.api.ast.boardservice.dto.BoardMasterDto;
import com.api.ast.boardservice.dto.BoardPostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void insertMasterOne(BoardMasterDto dto);

    List<BoardMasterDto> selectMasterList();

    BoardMasterDto selectMasterOne(Long masterId);

    int updateMasterOne(BoardMasterDto dto);

    void deleteMasterOne(Long masterId);

    void insertPostOne(BoardPostDto dto);

    List<BoardPostDto> selectPostList();

    BoardPostDto selectPostOne(Long postId);

    int updatePostOne(BoardPostDto dto);

    void deletePostOne(Long postId);
}
