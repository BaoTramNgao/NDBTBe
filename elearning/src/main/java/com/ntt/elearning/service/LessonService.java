package com.ntt.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.LessonCreationRequest;
import com.ntt.elearning.dto.response.LessonResponse;
import com.ntt.elearning.entity.Lesson;
import com.ntt.elearning.exception.AppException;
import com.ntt.elearning.exception.ErrorCode;
import com.ntt.elearning.mapper.CourseMapper;
import com.ntt.elearning.mapper.LessonMapper;
import com.ntt.elearning.repository.CourseRepository;
import com.ntt.elearning.repository.LessonRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class LessonService {
    CourseRepository courseRepository;
    CourseMapper courseMapper;
    LessonRepository lessonRepository;
    LessonMapper lessonMapper;
    CourseService courseService;

    public LessonResponse createLesson(LessonCreationRequest request, String courseId) {
        var course = courseRepository.findById(courseId);
        if (!course.isPresent()) {
            throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        }
        Lesson lesson = lessonMapper.toLesson(request);
        courseService.addLessonToCourse(courseId, lesson.getId());
        return lessonMapper.toLessonResponse(lessonRepository.save(lesson));
    }

    public List<Lesson> getAllLessonsByCourseId(String courseId) {
        var course = courseRepository.findById(courseId);
        if (!course.isPresent()) {
            throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        }
        return courseRepository.findCourseById(courseId).getLessonId().stream().toList();
    }
}
