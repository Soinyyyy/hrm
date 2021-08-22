package org.soin.web.controller;

import org.soin.query.CourseResourceQuery;
import org.soin.service.ICourseResourceService;
import org.soin.domain.CourseResource;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseResource")
public class CourseResourceController {
    @Autowired
    public ICourseResourceService courseResourceService;

    /**
    * 保存和修改公用的
    * @param courseResource  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseResource courseResource){
            if(courseResource.getId()!=null){
                courseResourceService.updateById(courseResource);
            }else{
                courseResourceService.insert(courseResource);
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
            courseResourceService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CourseResource get(@PathVariable("id")Long id)
    {
        return courseResourceService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<CourseResource> list(){

        return courseResourceService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<CourseResource> json(@RequestBody CourseResourceQuery query)
    {
        Page<CourseResource> page = new Page<CourseResource>(query.getPage(),query.getRows());
        page = courseResourceService.selectPage(page);
        return new PageList<CourseResource>(page.getTotal(),page.getRecords());
    }
}
