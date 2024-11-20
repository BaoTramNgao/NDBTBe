package com.ntt.elearning.service;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ntt.elearning.Constant.KeyWordConstant;
import com.ntt.elearning.dto.response.UrlResponse;
import com.ntt.elearning.entity.UrlFile;
import com.ntt.elearning.repository.CourseRepository;
import com.ntt.elearning.repository.UrlRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UrlService {
    CloudinaryService cloudinaryService;
    UrlRepository urlRepository;
    CourseRepository courseRepository;

    public UrlResponse uploadCourseImage(MultipartFile file,String courseId) {
        try {

            Map uploadResult = cloudinaryService.upload(file, "course_folder");
            String url = uploadResult.get("url").toString();
            UrlFile urlFile = UrlFile.builder()
                    .id(courseId + "_url")
                    .name("course_image_url")
                    .url(url)
                    .build();
            urlRepository.save(urlFile);

            UrlResponse urlResponse = UrlResponse.builder()
                    .id(urlFile.getId())
                    .name(urlFile.getName())
                    .url(urlFile.getUrl())
                    .build();
            return urlResponse;
        } catch (RuntimeException e) {
            // Handle exceptions appropriately, e.g., log the error, throw a custom exception
            throw new RuntimeException("Image upload failed: " + e.getMessage());
        }
    }

    public UrlResponse uploadLessonVideo(MultipartFile file) {
        try {
            String lessonID = KeyWordConstant.COURSE_ID_KEYWORD + courseRepository.count() + 1;
            Map uploadResult = cloudinaryService.upload(file, "course_folder");
            String url = uploadResult.get("url").toString();
            UrlFile urlFile = UrlFile.builder()
                    .id(lessonID + "_url")
                    .name("course_image_url")
                    .url(url)
                    .build();
            urlRepository.save(urlFile);

            UrlResponse urlResponse = UrlResponse.builder()
                    .id(urlFile.getId())
                    .name(urlFile.getName())
                    .url(urlFile.getUrl())
                    .build();
            return urlResponse;
        } catch (RuntimeException e) {
            // Handle exceptions appropriately, e.g., log the error, throw a custom exception
            throw new RuntimeException("Image upload failed: " + e.getMessage());
        }
    }
}
