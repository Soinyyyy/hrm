package org.soin.web.controller;

import org.soin.query.MealQuery;
import org.soin.service.IMealService;
import org.soin.domain.Meal;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.dto.LoginMealTo;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    public IMealService mealService;

    /**
    * 保存和修改公用的
    * @param loginMealTo  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody LoginMealTo loginMealTo){
        //調用方法添加購買服務信息
        mealService.insertMealTo(loginMealTo);
        return AjaxResult.me();
}

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            mealService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Meal get(@PathVariable("id")Long id)
    {
        return mealService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Meal> list(){

        return mealService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Meal> json(@RequestBody MealQuery query)
    {
        Page<Meal> page = new Page<Meal>(query.getPage(),query.getRows());
        page = mealService.selectPage(page);
        return new PageList<Meal>(page.getTotal(),page.getRecords());
    }
}
