package com.sopt.seminar.controller;

import com.sopt.seminar.common.dto.ApiResponse;
import com.sopt.seminar.common.dto.SuccessMessage;
import com.sopt.seminar.common.dto.SuccessStatusResponse;
import com.sopt.seminar.service.PostingService;
import com.sopt.seminar.service.dto.PostingCreateRequest;
import com.sopt.seminar.service.dto.PostingGetAllDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sopt.seminar.common.dto.SuccessMessage.GET_ALL_POSTINGS_SUCCESS;

@RestController
@RequestMapping("api/v1/posting")
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @PostMapping
    public ResponseEntity<SuccessStatusResponse> createPosting(
            @RequestHeader(name = "memberId")  Long memberId,
            @Valid @RequestBody PostingCreateRequest postingCreateRequest
    ){        return ResponseEntity.status(HttpStatus.CREATED)
            .header("postingId", postingService.createPosting(memberId, postingCreateRequest))
            .body(SuccessStatusResponse.of(SuccessMessage.POSTING_CREATE_SUCCESS));
    }

    @GetMapping("/all")
    public ApiResponse<List<PostingGetAllDto>> getAllPostings() {
        return ApiResponse.success(GET_ALL_POSTINGS_SUCCESS, postingService.getAllPostings());
    }

}
