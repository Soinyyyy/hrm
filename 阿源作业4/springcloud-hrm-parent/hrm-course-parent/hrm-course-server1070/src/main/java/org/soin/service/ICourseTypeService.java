package org.soin.service;

import org.soin.domain.CourseType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author soin
 * @since 2021-08-19
 */
public interface ICourseTypeService extends IService<CourseType> {

    List<CourseType> findTreeData();
}
