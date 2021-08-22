package org.soin.feign;

import org.soin.fallback.LoginFeignFactory;
import org.soin.dto.LoginMealTo;
import org.soin.dto.LoginTo;
import org.soin.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient(value = "auth-server", fallbackFactory = LoginFeignFactory.class)
public interface LoginFeignClient {
    //解决微服务之间相互调用的跨域问题
    @RequestMapping(value = "/login/save",method = RequestMethod.POST)
    AjaxResult save(@RequestBody LoginTo to);

    @RequestMapping(value="/meal/saveLoginMeal",method= RequestMethod.POST)
    AjaxResult saveLoginMeal(@RequestBody LoginMealTo to);
}
