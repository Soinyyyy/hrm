package org.soin.dto;

import lombok.Data;
import org.soin.domain.Course;
import org.soin.domain.CourseDetail;
import org.soin.domain.CourseMarket;

/**
 * 前台对象保存封装
 */
@Data
public class CourseDto {
    private Course course;
    private CourseDetail courseDetail;
    private CourseMarket courseMarket;
}
