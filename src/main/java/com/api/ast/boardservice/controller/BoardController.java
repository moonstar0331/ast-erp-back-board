package com.api.ast.boardservice.controller;

import com.api.ast.boardservice.dto.BoardDto;
import com.api.ast.boardservice.dto.BoardPostDto;
import com.api.ast.boardservice.vo.request.BoardCreateRequest;
import com.api.ast.boardservice.vo.request.BoardPostCreateRequest;
import com.api.ast.boardservice.service.BoardService;
import com.api.ast.boardservice.vo.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    // board_master (게시판 설정) 생성
    @PostMapping("/")
    public ResponseEntity<Void> insertBoardOne(@RequestBody BoardCreateRequest request) {
        BoardDto dto = new ModelMapper().map(request, BoardDto.class);
        boardService.insertBoardOne(dto);
        return ResponseEntity
                .ok()
                .build();
    }

    // board_master (게시판 설정) 리스트 조회
    @GetMapping("/list")
    public ResponseEntity<List<BoardResponse>> selectBoardList() {
        List<BoardDto> result = boardService.selectBoardList();

        ModelMapper mapper = new ModelMapper();
        List<BoardResponse> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, BoardResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_master (게시판 설정) 단건 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponse> selectBoardOne(@RequestParam Long boardId) {
        BoardDto result = boardService.selectBoardOne(boardId);
        BoardResponse response = new ModelMapper().map(result, BoardResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_master (게시판 설정) 수정
    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponse> updateBoardOne(@RequestParam Long boardId, @RequestBody BoardCreateRequest request) {
        BoardDto dto = new ModelMapper().map(request, BoardDto.class);
        dto.setBoardId(boardId);
        BoardDto result = boardService.updateBoardOne(dto);
        BoardResponse response = new ModelMapper().map(result, BoardResponse.class);

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_master (게시판 설정) 삭제
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoardOne(@RequestParam Long boardId) {
        boardService.deleteBoardOne(boardId);
        return ResponseEntity.ok().build();
    }

    // board_post (게시글) 생성
    @PostMapping("/post")
    public ResponseEntity<Void> insertPostOne(@RequestBody BoardPostCreateRequest request) {
        BoardPostDto dto = new ModelMapper().map(request, BoardPostDto.class);
        boardService.insertPostOne(dto);
        return ResponseEntity
                .ok()
                .build();
    }

    // board_post (게시글) 리스트 조회
    @GetMapping("/post/list")
    public ResponseEntity<List<BoardPostDto>> selectPostList() {
        List<BoardPostDto> result = boardService.selectPostList();

        ModelMapper mapper = new ModelMapper();
        List<BoardPostDto> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, BoardPostDto.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_post (게시글) 단건 조회
    @GetMapping("/post/{postId}")
    public ResponseEntity<BoardPostDto> selectPostOne(@RequestParam Long postId) {
        BoardPostDto result = boardService.selectPostOne(postId);
        BoardPostDto response = new ModelMapper().map(result, BoardPostDto.class);

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_post (게시글) 수정
    @PutMapping("/post/{postId}")
    public ResponseEntity<BoardPostDto> updatePostOne(@RequestParam Long postId, @RequestBody BoardPostCreateRequest request) {
        BoardPostDto dto = new ModelMapper().map(request, BoardPostDto.class);
        dto.setPostId(postId);
        BoardPostDto result = boardService.updatePostOne(dto);
        BoardPostDto response = new ModelMapper().map(result, BoardPostDto.class);

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_post (게시글) 삭제
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<Void> deletePostOne(@RequestParam Long postId) {
        boardService.deletePostOne(postId);
        return ResponseEntity.ok().build();
    }
}
