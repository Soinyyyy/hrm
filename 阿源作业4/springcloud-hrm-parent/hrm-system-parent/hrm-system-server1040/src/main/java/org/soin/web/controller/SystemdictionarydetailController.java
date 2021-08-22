package org.soin.web.controller;

import org.soin.query.SystemdictionarydetailQuery;
import org.soin.service.ISystemdictionarydetailService;
import org.soin.domain.Systemdictionarydetail;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemdictionarydetail")
public class SystemdictionarydetailController {
    @Autowired
    public ISystemdictionarydetailService systemdictionarydetailService;

    /**
    * 保存和修改公用的
    * @param systemdictionarydetail  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Systemdictionarydetail systemdictionarydetail){
            if(systemdictionarydetail.getId()!=null){
                systemdictionarydetailService.updateById(systemdictionarydetail);
            }else{
                systemdictionarydetailService.insert(systemdictionarydetail);
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
            systemdictionarydetailService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Systemdictionarydetail get(@PathVariable("id")Long id)
    {
        return systemdictionarydetailService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Systemdictionarydetail> list(){

        return systemdictionarydetailService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Systemdictionarydetail> json(@RequestBody SystemdictionarydetailQuery query)
    {
        Page<Systemdictionarydetail> page = new Page<Systemdictionarydetail>(query.getPage(),query.getRows());
        page = systemdictionarydetailService.selectPage(page);
        return new PageList<Systemdictionarydetail>(page.getTotal(),page.getRecords());
    }
}
