package com.ntt.elearning.controller;

import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.UrlResponse;
import com.ntt.elearning.service.UrlService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/url")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class UrlController {
    UrlService urlService;

    @PostMapping
    public ApiResponse<UrlResponse> uploadCourseImage(@RequestParam("image") MultipartFile file, @PathVariable String courseId){
        return ApiResponse.<UrlResponse>builder()
               .result(urlService.uploadCourseImage(file, courseId))
               .build();
    }
}
