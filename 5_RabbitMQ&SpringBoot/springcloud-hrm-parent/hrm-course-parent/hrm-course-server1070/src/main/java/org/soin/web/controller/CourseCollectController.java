package org.soin.web.controller;

import org.soin.query.CourseCollectQuery;
import org.soin.service.ICourseCollectService;
import org.soin.domain.CourseCollect;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseCollect")
public class CourseCollectController {
    @Autowired
    public ICourseCollectService courseCollectService;

    /**
    * 保存和修改公用的
    * @param courseCollect  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseCollect courseCollect){
            if(courseCollect.getId()!=null){
                courseCollectService.updateById(courseCollect);
            }else{
                courseCollectService.insert(courseCollect);
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
            courseCollectService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CourseCollect get(@PathVariable("id")Long id)
    {
        return courseCollectService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<CourseCollect> list(){

        return courseCollectService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<CourseCollect> json(@RequestBody CourseCollectQuery query)
    {
        Page<CourseCollect> page = new Page<CourseCollect>(query.getPage(),query.getRows());
        page = courseCollectService.selectPage(page);
        return new PageList<CourseCollect>(page.getTotal(),page.getRecords());
    }
}
