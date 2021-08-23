package org.soin.web.controller;

import org.aspectj.weaver.loadtime.Aj;
import org.soin.query.CourseTypeQuery;
import org.soin.service.ICourseTypeService;
import org.soin.domain.CourseType;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseType")
public class CourseTypeController {
    @Autowired
    public ICourseTypeService courseTypeService;

    /**
    * 保存和修改公用的
    * @param courseType  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseType courseType){
            if(courseType.getId()!=null){
                courseTypeService.updateById(courseType);
            }else{
                courseTypeService.insert(courseType);
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
            courseTypeService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CourseType get(@PathVariable("id")Long id)
    {
        return courseTypeService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<CourseType> list(){

        return courseTypeService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<CourseType> json(@RequestBody CourseTypeQuery query)
    {
        Page<CourseType> page = new Page<CourseType>(query.getPage(),query.getRows());
        page = courseTypeService.selectPage(page);
        return new PageList<CourseType>(page.getTotal(),page.getRecords());
    }

    /**
     * 查询课程类型树形数据
     */
    //请求头
    @RequestMapping(value = "/treeData",method = RequestMethod.GET)
    public AjaxResult findTreeData(){
        List<CourseType> list = courseTypeService.findTreeData();
        return AjaxResult.me().setResultObj(list);
    }
}
