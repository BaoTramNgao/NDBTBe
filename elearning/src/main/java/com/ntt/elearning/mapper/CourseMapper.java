package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.CourseRequest;
import com.ntt.elearning.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CourseRequest request);
}
