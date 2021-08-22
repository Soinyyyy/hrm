package org.soin.service.impl;

import org.soin.document.CourseDocument;
import org.soin.domain.Course;
import org.soin.domain.CourseDetail;
import org.soin.domain.CourseMarket;
import org.soin.domain.CourseType;
import org.soin.feign.CourseFeignClient;
import org.soin.mapper.CourseDetailMapper;
import org.soin.mapper.CourseMapper;
import org.soin.mapper.CourseMarketMapper;
import org.soin.mapper.CourseTypeMapper;
import org.soin.service.ICourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.soin.dto.CourseDto;
import org.soin.util.AjaxResult;
import org.soin.util.AssertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-19
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseDetailMapper courseDetailMapper;
    @Autowired
    private CourseMarketMapper courseMarketMapper;
    @Autowired
    private CourseTypeMapper courseTypeMapper;
    @Autowired
    private CourseFeignClient courseFeignClient;
    @Override
    @Transactional
    //事务实现要么都成功要么都失败
    public void save(CourseDto courseDto) {
        //从前端传过来的对象里获取真实对象
        Course course = courseDto.getCourse();
        CourseDetail courseDetail = courseDto.getCourseDetail();
        CourseMarket courseMarket = courseDto.getCourseMarket();
        //修改课程状态
        course.setStatus(1);
        //手动赋值Course课程的信息
        course.setUserId(42L);
        course.setUserName("架构师阿源");
        course.setTenantId(27L);
        course.setTenantName("捞猪Spa");
        super.insert(course);
        /**
         * 设置课程的id
         */
        //获取当前的courseid并赋值
        courseDetail.setId(course.getId());
        //添加当前详情信息
        courseDetailMapper.insert(courseDetail);
        //设置课程类型的ID
        courseMarket.setId(course.getId());
        //调用保存方法来保存courseMarket
        courseMarketMapper.insert(courseMarket);
        //当课程保存完成总课程也需要加1以下代码实现步骤
        //根据Type查询到CourseType的对象
        CourseType courseType = courseTypeMapper.selectById(course.getCourseTypeId());
        //获取到总条数并且加1
        courseType.setTotalCount(courseType.getTotalCount()+1);
        //调用修改方法修改数据库的总值
        courseTypeMapper.updateById(courseType);
    }


    /**
     * 课程发布实现
     * 根据id获取课程
     * 修改课程的状态来上驾下架
     * 在保存
     * 然后再调用ES的接口保存数据到ES的索引库
     */

    @Override
    public void onLineCourse(Long id) {
        //根据id获取course对象
        Course course = super.selectById(id);
        //根据id获取market对象
        CourseMarket market = courseMarketMapper.selectById(id);
        //修改上线时间
        course.setOnlineTime(new Date());
        //修改状态
        course.setStatus(1);
        //调用修改方法来修改上线时间与状态
        courseMapper.updateById(course);
        //调用ES来保存索引数据
        //微服务之间调用用feign来实现
        CourseDocument courseDocument = new CourseDocument();
        BeanUtils.copyProperties(market,courseDocument);
        BeanUtils.copyProperties(course,courseDocument);
        //courseDocument.(market.getPrice().doubleValue());
        //courseDocument.(market.getPriceOld().doubleValue());
        //调用保存接口
        AjaxResult result = courseFeignClient.sava(courseDocument);
        AssertUtils.isFalse(result.isSuccess(),"Es保存数据失败");
    }
}
