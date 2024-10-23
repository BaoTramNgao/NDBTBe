package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.LessonCreationRequest;
import com.ntt.elearning.dto.response.LessonResponse;
import com.ntt.elearning.entity.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    Lesson toLesson(LessonCreationRequest request);

    LessonResponse toLessonResponse(Lesson lesson);
}
