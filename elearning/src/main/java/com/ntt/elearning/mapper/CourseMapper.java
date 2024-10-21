package com.ntt.elearning.mapper;

import com.ntt.elearning.dto.request.CourseCreationRequest;
import org.mapstruct.Mapper;

import com.ntt.elearning.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CourseCreationRequest request);
}
