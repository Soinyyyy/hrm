package org.soin.web.controller;

import org.soin.document.CourseDocument;
import org.soin.repository.CourseElasticRepository;
import org.soin.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseEsController {
    @Autowired
    private CourseElasticRepository courseElasticRepository;

    @RequestMapping(value = "/es/course",method = RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseDocument courseDocument) {
        courseElasticRepository.save(courseDocument);
        return AjaxResult.me();
    }
}
