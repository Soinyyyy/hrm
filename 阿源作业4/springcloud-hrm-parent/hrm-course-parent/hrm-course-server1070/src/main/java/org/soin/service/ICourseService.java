package org.soin.service;

import org.soin.domain.Course;
import com.baomidou.mybatisplus.service.IService;
import org.soin.dto.CourseDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soin
 * @since 2021-08-19
 */
public interface ICourseService extends IService<Course> {

    void save(CourseDto courseDto);

    /**
     * 课程发布接口
     * @param id
     */
    void onLineCourse(Long id);
}
