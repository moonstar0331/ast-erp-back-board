package com.api.ast.boardservice.controller;

import com.api.ast.boardservice.dto.BoardMasterDto;
import com.api.ast.boardservice.dto.BoardPostDto;
import com.api.ast.boardservice.vo.request.BoardMasterCreateRequest;
import com.api.ast.boardservice.vo.request.BoardPostCreateRequest;
import com.api.ast.boardservice.service.BoardService;
import com.api.ast.boardservice.vo.response.BoardMasterResponse;
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
    @PostMapping("/master")
    public ResponseEntity<Void> insertMasterOne(@RequestBody BoardMasterCreateRequest request) {
        BoardMasterDto dto = new ModelMapper().map(request, BoardMasterDto.class);
        boardService.insertMasterOne(dto);
        return ResponseEntity
                .ok()
                .build();
    }

    // board_master (게시판 설정) 리스트 조회
    @GetMapping("/master/list")
    public ResponseEntity<List<BoardMasterResponse>> selectMasterList() {
        List<BoardMasterDto> result = boardService.selectMasterList();

        ModelMapper mapper = new ModelMapper();
        List<BoardMasterResponse> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, BoardMasterResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_master (게시판 설정) 단건 조회
    @GetMapping("/master/{masterId}")
    public ResponseEntity<BoardMasterResponse> selectMasterOne(@RequestParam Long masterId) {
        BoardMasterDto result = boardService.selectMasterOne(masterId);
        BoardMasterResponse response = new ModelMapper().map(result, BoardMasterResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_master (게시판 설정) 수정
    @PutMapping("/master/{masterId}")
    public ResponseEntity<BoardMasterResponse> updateMasterOne(@RequestParam Long masterId, @RequestBody BoardMasterCreateRequest request) {
        BoardMasterDto dto = new ModelMapper().map(request, BoardMasterDto.class);
        dto.setBoardId(masterId);
        BoardMasterDto result = boardService.updateMasterOne(dto);
        BoardMasterResponse response = new ModelMapper().map(result, BoardMasterResponse.class);

        return ResponseEntity
                .ok()
                .body(response);
    }

    // board_master (게시판 설정) 삭제
    @DeleteMapping("/master/{masterId}")
    public ResponseEntity<Void> deleteMasterOne(@RequestParam Long masterId) {
        boardService.deleteMasterOne(masterId);
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
