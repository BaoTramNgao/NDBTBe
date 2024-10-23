package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.CourseCreationRequest;
import com.ntt.elearning.dto.response.CourseResponse;
import com.ntt.elearning.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CourseCreationRequest request);

    CourseResponse toCourseResponse(Course course);
}
