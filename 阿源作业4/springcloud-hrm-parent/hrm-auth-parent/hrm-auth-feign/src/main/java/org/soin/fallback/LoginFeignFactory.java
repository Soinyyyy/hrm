package org.soin.fallback;

import feign.hystrix.FallbackFactory;
import org.soin.feign.LoginFeignClient;
import org.soin.dto.LoginMealTo;
import org.soin.dto.LoginTo;
import org.soin.util.AjaxResult;
import org.springframework.stereotype.Component;

@Component
//必须交给Spring容器去管理
public class LoginFeignFactory implements FallbackFactory<LoginFeignClient> {
    @Override
    public LoginFeignClient create(Throwable throwable) {
        return new LoginFeignClient() {
            @Override
            public AjaxResult save(LoginTo to) {
                throwable.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("服务降级了");
            }

            @Override
            public AjaxResult saveLoginMeal(LoginMealTo to) {
                throwable.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("服务降级了");
            }
        };
    }
}
