package org.soin.web.controller;

import org.soin.query.CourseQuery;
import org.soin.service.ICourseService;
import org.soin.domain.Course;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.dto.CourseDto;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public ICourseService courseService;

    /**
    * 保存和修改公用的
    * @param courseDto  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseDto courseDto){
        courseService.save(courseDto);
            return AjaxResult.me();
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
            courseService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Course get(@PathVariable("id")Long id)
    {
        return courseService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Course> list(){

        return courseService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Course> json(@RequestBody CourseQuery query)
    {
        Page<Course> page = new Page<Course>(query.getPage(),query.getRows());
        page = courseService.selectPage(page);
        return new PageList<Course>(page.getTotal(),page.getRecords());
    }

    /**
     * 课程上线
     * @param id
     * @return
     */
    @RequestMapping(value="/onLineCourse/{id}",method= RequestMethod.POST)
    public AjaxResult onLineCourse(@PathVariable("id") Long id){
        courseService.onLineCourse(id);
        return AjaxResult.me();
    }
}
