package com.api.ast.boardservice.service.impl;

import com.api.ast.boardservice.dto.BoardDto;
import com.api.ast.boardservice.dto.BoardPostDto;
import com.api.ast.boardservice.exception.BoardServiceException;
import com.api.ast.boardservice.exception.ErrorCode;
import com.api.ast.boardservice.mapper.BoardMapper;
import com.api.ast.boardservice.openfeign.NotificationServiceClient;
import com.api.ast.boardservice.service.BoardService;
import com.api.ast.boardservice.vo.NotificationEvent;
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
    private final NotificationServiceClient notificationServiceClient;

    @Override
    @Transactional
    public void insertBoardOne(BoardDto dto) {
        try {
            boardMapper.insertBoardOne(dto);
        } catch (Exception e) {
            throw new BoardServiceException(ErrorCode.BOARD_MASTER_CREATE_ERROR);
        }
    }

    @Override
    public List<BoardDto> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public BoardDto selectBoardOne(Long boardId) {
        return boardMapper.selectBoardOne(boardId);
    }

    @Override
    public BoardDto selectBoardByMenuId(Long menuId) {
        return boardMapper.selectBoardByMenuId(menuId);
    }

    @Override
    @Transactional
    public BoardDto updateBoardOne(BoardDto dto) {
        int updatedCount = boardMapper.updateBoardOne(dto);

        if (updatedCount == 0) {
            throw new BoardServiceException(ErrorCode.BOARD_MASTER_UPDATE_ERROR);
        }

        return this.selectBoardOne(dto.getBoardId());
    }

    @Override
    @Transactional
    public void deleteBoardOne(Long boardId) {
        boardMapper.deleteBoardOne(boardId);
    }

    @Override
    @Transactional
    public void insertPostOne(BoardPostDto dto) {
        try {
            boardMapper.insertPostOne(dto);
            
            // 게시글 생성 성공 시 전체 알림 전송 (작성자 제외)
            NotificationEvent event = NotificationEvent.builder()
                    .type("NEW_POST")
                    .title("새로운 게시글이 등록되었습니다.")
                    .content(dto.getTitle())
                    .linkUrl("/board/post/" + dto.getPostId())
                    .build();
            
            try {
                notificationServiceClient.broadcastNotification(event, dto.getWriterUuid());
            } catch (Exception e) {
                log.error("Failed to send broadcast notification: {}", e.getMessage());
                // 알림 실패가 게시글 생성을 롤백시키지 않도록 예외 처리
            }
            
        } catch (BoardServiceException e) {
            throw e;
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
