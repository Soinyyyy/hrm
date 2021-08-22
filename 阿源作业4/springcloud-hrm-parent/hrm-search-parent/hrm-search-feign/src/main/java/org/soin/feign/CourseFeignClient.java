package org.soin.feign;

import org.soin.document.CourseDocument;
import org.soin.fallback.CourseFeignClientFactory;
import org.soin.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "search-server", fallbackFactory = CourseFeignClientFactory.class)
public interface CourseFeignClient {
    /**
     * 调用的方法
     * @param courseDocument
     * @return
     */
    @RequestMapping(value = "/es/course",method = RequestMethod.POST)
    AjaxResult sava(@RequestBody CourseDocument courseDocument);
}
