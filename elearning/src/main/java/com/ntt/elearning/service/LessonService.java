package com.ntt.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntt.elearning.Constant.KeyWordConstant;
import com.ntt.elearning.Constant.LessonType;
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
    CloudinaryService cloudinaryService;

    public LessonResponse createLesson(LessonCreationRequest request) {
        var course = courseRepository.findById(request.getCourseId());
        if (!course.isPresent()) {
            throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        }
        var courseNumber = courseRepository.count() + 1;
        String courseId = KeyWordConstant.COURSE_ID_KEYWORD + courseNumber;
        Lesson lesson = Lesson.builder()
                .id(courseId + "_" + KeyWordConstant.LESSON_ID_KEYWORD + request.getNumberOfLessons())
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .build();

        courseService.addLessonToCourse(request.getCourseId(), lesson.getId());
        return lessonMapper.toLessonResponse(lessonRepository.save(lesson));
    }

    public List<LessonResponse> getAllLessonsByCourseId(String courseId) {
        var course = courseRepository.findById(courseId);
        if (!course.isPresent()) {
            throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        }
        return courseRepository.findCourseById(courseId).getLessons().stream()
                .map(lessonMapper::toLessonResponse)
                .toList();
    }

    public LessonResponse getLessonById(String lessonId) {
        return lessonMapper.toLessonResponse(
                lessonRepository.findById(lessonId).orElseThrow(() -> new AppException(ErrorCode.LESSON_NOT_FOUND)));
    }

    public void deleteLesson(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    public void updateLesson(Lesson lesson, String lessonId) {
        var existingLesson =
                lessonRepository.findById(lessonId).orElseThrow(() -> new AppException(ErrorCode.LESSON_NOT_FOUND));
        lesson.setId(lessonId);
        lessonRepository.save(lesson);
    }

    public List<LessonResponse> getAllListeningLessons(String courseId) {
        var course = courseRepository.findById(courseId);
        if (!course.isPresent()) {
            throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        }
        return courseRepository.findCourseById(courseId).getLessons().stream()
                .filter(lesson -> lesson.getType().equals(LessonType.LISTENING))
                .map(lessonMapper::toLessonResponse)
                .toList();
    }

    public List<LessonResponse> getAllReadingLessons(String courseId) {
        var course = courseRepository.findById(courseId);
        if (course.isEmpty()) throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        return courseRepository.findById(courseId).get().getLessons().stream()
                .filter(lesson -> lesson.getType().equals(LessonType.READING))
                .map(lessonMapper::toLessonResponse)
                .toList();
    }
}
