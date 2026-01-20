package com.api.ast.boardservice.controller;

import com.api.ast.boardservice.dto.CommonCodeGroupDetailDto;
import com.api.ast.boardservice.dto.group.GroupCodeDto;
import com.api.ast.boardservice.service.GroupCodeService;
import com.api.ast.boardservice.vo.request.group.GroupCodeCreateRequest;
import com.api.ast.boardservice.vo.request.group.GroupCodeUpdateRequest;
import com.api.ast.boardservice.vo.response.CommonCodeGroupDetailResponse;
import com.api.ast.boardservice.vo.response.group.GroupCodeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupCodeController {

    private final GroupCodeService groupCodeService;

    // 공통코드 그룹 생성 (단건만)
    @PostMapping("/")
    public ResponseEntity<Void> insertOne(@RequestBody GroupCodeCreateRequest request) {
        GroupCodeDto dto = new ModelMapper().map(request, GroupCodeDto.class);
        groupCodeService.insertOne(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    // 공통코드 그룹 상세 조회
    @GetMapping("/{groupCodeId}")
    public ResponseEntity<GroupCodeResponse> selectOne(@PathVariable Long groupCodeId) {
        GroupCodeDto result = groupCodeService.selectOne(groupCodeId);
        GroupCodeResponse response = new ModelMapper().map(result, GroupCodeResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 그룹 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<GroupCodeResponse>> selectAll() {
        List<GroupCodeDto> result = groupCodeService.selectAll();

        ModelMapper mapper = new ModelMapper();
        List<GroupCodeResponse> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, GroupCodeResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 그룹 단건 수정
    @PutMapping("/{groupCodeId}")
    public ResponseEntity<GroupCodeResponse> updateOne(@PathVariable Long groupCodeId,
                                                       @RequestBody GroupCodeUpdateRequest request) {
        GroupCodeDto dto = new ModelMapper().map(request, GroupCodeDto.class);
        dto.setGroupCodeId(groupCodeId);

        GroupCodeDto result = groupCodeService.updateOne(dto);
        GroupCodeResponse response = new ModelMapper().map(result, GroupCodeResponse.class);

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 그룹 다건 수정
    @PutMapping("/")
    public ResponseEntity<List<GroupCodeResponse>> updateAll(@RequestBody List<GroupCodeUpdateRequest> request) {
        List<GroupCodeDto> dtoList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        request.forEach(r -> {
            GroupCodeDto dto = mapper.map(r, GroupCodeDto.class);
            dtoList.add(dto);
        });

        List<GroupCodeDto> result = groupCodeService.updateAll(dtoList);
        List<GroupCodeResponse> response = new ArrayList<>();
        result.forEach(r -> {
            response.add(mapper.map(r, GroupCodeResponse.class));
        });

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 그룹 단건 삭제
    @DeleteMapping("/{groupCodeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long groupCodeId) {
        groupCodeService.deleteOne(groupCodeId);
        return ResponseEntity
                .ok()
                .build();
    }

    // 공통코드 그룹 다건 삭제
    @DeleteMapping("/list")
    public ResponseEntity<Void> deleteAll(@RequestBody List<Long> groupCodeIdList) {
        groupCodeIdList.forEach(groupCodeId -> {
            groupCodeService.deleteOne(groupCodeId);
        });
        return ResponseEntity
                .ok()
                .build();
    }


    // 공통코드 + 그룹 상세 조회 (그룹코드 ID 로)
    @GetMapping("/code/list/{groupCodeId}")
    public ResponseEntity<CommonCodeGroupDetailResponse> selectOneWithCodes(@PathVariable Long groupCodeId) {
        CommonCodeGroupDetailDto result = groupCodeService.selectOneWithCodes(groupCodeId);

        CommonCodeGroupDetailResponse response = new ModelMapper().map(result, CommonCodeGroupDetailResponse.class);

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 + 그룹 전체 조회
    @GetMapping("/code/list")
    public ResponseEntity<List<CommonCodeGroupDetailResponse>> selectAllWithCodes() {
        List<CommonCodeGroupDetailDto> result = groupCodeService.selectAllWithCodes();

        ModelMapper mapper = new ModelMapper();
        List<CommonCodeGroupDetailResponse> response = new ArrayList<>();

        result.forEach(dto -> {
            CommonCodeGroupDetailResponse groupDetailResponse = mapper.map(dto, CommonCodeGroupDetailResponse.class);
            response.add(groupDetailResponse);
        });

        return ResponseEntity
                .ok()
                .body(response);
    }
}
