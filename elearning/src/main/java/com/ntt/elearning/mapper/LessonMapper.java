package com.ntt.elearning.mapper;


import com.ntt.elearning.dto.request.LessonCreationRequest;
import com.ntt.elearning.dto.response.LessonResponse;
import com.ntt.elearning.entity.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    Lesson toLesson(LessonCreationRequest request);
    LessonResponse toLessonResponse(Lesson lesson);
}
