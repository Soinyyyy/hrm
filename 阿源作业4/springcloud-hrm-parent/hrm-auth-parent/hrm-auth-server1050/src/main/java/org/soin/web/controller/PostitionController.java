package org.soin.web.controller;

import org.soin.query.PostitionQuery;
import org.soin.service.IPostitionService;
import org.soin.domain.Postition;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postition")
public class PostitionController {
    @Autowired
    public IPostitionService postitionService;

    /**
    * 保存和修改公用的
    * @param postition  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Postition postition){
        try {
            if(postition.getId()!=null){
                postitionService.updateById(postition);
            }else{
                postitionService.insert(postition);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            postitionService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Postition get(@PathVariable("id")Long id)
    {
        return postitionService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Postition> list(){

        return postitionService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Postition> json(@RequestBody PostitionQuery query)
    {
        Page<Postition> page = new Page<Postition>(query.getPage(),query.getRows());
        page = postitionService.selectPage(page);
        return new PageList<Postition>(page.getTotal(),page.getRecords());
    }
}
