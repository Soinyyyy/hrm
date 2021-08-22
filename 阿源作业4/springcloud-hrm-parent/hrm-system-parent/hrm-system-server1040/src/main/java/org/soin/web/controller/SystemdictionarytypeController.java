package org.soin.web.controller;

import org.soin.domain.Systemdictionarydetail;
import org.soin.query.SystemdictionarytypeQuery;
import org.soin.service.ISystemdictionarytypeService;
import org.soin.domain.Systemdictionarytype;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemdictionarytype")
public class SystemdictionarytypeController {
    @Autowired
    public ISystemdictionarytypeService systemdictionarytypeService;

    /**
    * 保存和修改公用的
    * @param systemdictionarytype  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Systemdictionarytype systemdictionarytype){
            if(systemdictionarytype.getId()!=null){
                systemdictionarytypeService.updateById(systemdictionarytype);
            }else{
                systemdictionarytypeService.insert(systemdictionarytype);
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
            systemdictionarytypeService.deleteById(id);
            return AjaxResult.me();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Systemdictionarytype get(@PathVariable("id")Long id)
    {
        return systemdictionarytypeService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Systemdictionarytype> list(){

        return systemdictionarytypeService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Systemdictionarytype> json(@RequestBody SystemdictionarytypeQuery query)
    {
        Page<Systemdictionarytype> page = new Page<Systemdictionarytype>(query.getPage(),query.getRows());
        page = systemdictionarytypeService.selectPage(page);
        return new PageList<Systemdictionarytype>(page.getTotal(),page.getRecords());
    }

    /**
     * 数据字典查询
     * @param sn
     * @return
     */
    @RequestMapping(value = "/listBySn/{sn}",method = RequestMethod.GET)
    public AjaxResult listBySn(@PathVariable("sn")String sn)
    {
        List<Systemdictionarydetail> systemdictionarydetails =  systemdictionarytypeService.listBySn(sn);
        return AjaxResult.me().setResultObj(systemdictionarydetails);
    }
}
