package com.api.ast.boardservice.controller;

import com.api.ast.boardservice.dto.code.CommonCodeDto;
import com.api.ast.boardservice.service.CommonCodeService;
import com.api.ast.boardservice.vo.request.code.CommonCodeCreateRequest;
import com.api.ast.boardservice.vo.request.code.CommonCodeUpdateRequest;
import com.api.ast.boardservice.vo.response.code.CommonCodeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/code")
public class CommonCodeController {

    private final CommonCodeService commonCodeService;

    // 공통코드 단건 생성
    @PostMapping("/")
    public ResponseEntity<Void> insertOne(@RequestBody CommonCodeCreateRequest request) {
        CommonCodeDto dto = new ModelMapper().map(request, CommonCodeDto.class);
        commonCodeService.insertOne(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    // 공통코드 다건 생성
    @PostMapping("/list")
    public ResponseEntity<Void> insertMany(@RequestBody List<CommonCodeCreateRequest> request) {
        List<CommonCodeDto> dtoList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        request.forEach(r -> {
            CommonCodeDto dto = mapper.map(r, CommonCodeDto.class);
            dtoList.add(dto);
        });
        commonCodeService.insertMany(dtoList);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    // 공통코드 상세 조회 (공통코드 ID로)
    @GetMapping("/{codeId}")
    public ResponseEntity<CommonCodeResponse> selectOne(@PathVariable Long codeId) {
        CommonCodeDto result = commonCodeService.selectOne(codeId);
        CommonCodeResponse response = new ModelMapper().map(result, CommonCodeResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<CommonCodeResponse>> selectAll() {
        List<CommonCodeDto> result = commonCodeService.selectAll();

        ModelMapper mapper = new ModelMapper();
        List<CommonCodeResponse> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, CommonCodeResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 부모코드로 공통코드 전체 조회
    @GetMapping("/list/parent/{parentCodeId}")
    public ResponseEntity<List<CommonCodeResponse>> selectAllByParentCodeId(@PathVariable Long parentCodeId) {
        List<CommonCodeDto> result = commonCodeService.selectAllByParentCodeId(parentCodeId);
        ModelMapper mapper = new ModelMapper();

        List<CommonCodeResponse> response = new ArrayList<>();
        result.forEach(
                dto -> response.add(mapper.map(dto, CommonCodeResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }


    // 공통코드 리스트 조회 (그룹ID로, 공통코드만 조회)
    @GetMapping("/list/group/{groupCodeId}")
    public ResponseEntity<List<CommonCodeResponse>> selectAllByGroupCodeId(@PathVariable Long groupCodeId) {
        List<CommonCodeDto> result = commonCodeService.selectAllByGroupCodeId(groupCodeId);

        ModelMapper mapper = new ModelMapper();

        List<CommonCodeResponse> response = new ArrayList<>();
        result.forEach(dto ->
                response.add(mapper.map(dto, CommonCodeResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 단건 수정
    @PutMapping("/{codeId}")
    public ResponseEntity<CommonCodeResponse> updateOne(@RequestBody CommonCodeUpdateRequest request) {
        CommonCodeDto dto = new ModelMapper().map(request, CommonCodeDto.class);
        CommonCodeDto result = commonCodeService.updateOne(dto);
        CommonCodeResponse response = new ModelMapper().map(result, CommonCodeResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 다건 수정
    @PutMapping("")
    public ResponseEntity<List<CommonCodeResponse>> updateMany(@RequestBody List<CommonCodeUpdateRequest> request) {
        List<CommonCodeDto> dtoList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        request.forEach(r -> {
            CommonCodeDto dto = mapper.map(r, CommonCodeDto.class);
            dtoList.add(dto);
        });

        List<CommonCodeDto> result = commonCodeService.updateMany(dtoList);
        List<CommonCodeResponse> response = new ArrayList<>();

        result.forEach(r -> {
            response.add(mapper.map(r, CommonCodeResponse.class));
        });

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 단건 삭제
    @DeleteMapping("/{codeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long codeId) {
        commonCodeService.deleteOne(codeId);
        return ResponseEntity
                .ok()
                .build();
    }

    // 공통코드 다건 삭제
    @DeleteMapping("/list")
    public ResponseEntity<Void> deleteMany(@RequestBody List<Long> codeIdList) {
        commonCodeService.deleteMany(codeIdList);

        return ResponseEntity
                .ok()
                .build();
    }
}
