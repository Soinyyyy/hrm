package org.soin.web.controller;

import org.soin.query.CourseViewQuery;
import org.soin.service.ICourseViewService;
import org.soin.domain.CourseView;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseView")
public class CourseViewController {
    @Autowired
    public ICourseViewService courseViewService;

    /**
    * 保存和修改公用的
    * @param courseView  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseView courseView){
            if(courseView.getId()!=null){
                courseViewService.updateById(courseView);
            }else{
                courseViewService.insert(courseView);
            }
            return AjaxResult.me();
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
            courseViewService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CourseView get(@PathVariable("id")Long id)
    {
        return courseViewService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<CourseView> list(){

        return courseViewService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<CourseView> json(@RequestBody CourseViewQuery query)
    {
        Page<CourseView> page = new Page<CourseView>(query.getPage(),query.getRows());
        page = courseViewService.selectPage(page);
        return new PageList<CourseView>(page.getTotal(),page.getRecords());
    }
}
