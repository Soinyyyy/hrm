package org.soin.fallback;

import feign.hystrix.FallbackFactory;
import org.soin.document.CourseDocument;
import org.soin.feign.CourseFeignClient;
import org.soin.util.AjaxResult;
import org.springframework.stereotype.Component;

/**
 * Feign降级方案
 */
@Component
//交给Spring去管理
public class CourseFeignClientFactory implements FallbackFactory<CourseFeignClient> {
    @Override
    public CourseFeignClient create(Throwable throwable) {
        return new CourseFeignClient() {
            @Override
            public AjaxResult sava(CourseDocument courseDocument) {
                return AjaxResult.me().setSuccess(false).setMessage("Feign服务降级");
            }
        };
    }
}
