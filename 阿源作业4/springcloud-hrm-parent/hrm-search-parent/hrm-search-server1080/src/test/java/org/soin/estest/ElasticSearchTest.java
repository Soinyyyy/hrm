package org.soin.estest;

import org.elasticsearch.common.recycler.Recycler;
import org.junit.runner.RunWith;
import org.soin.ElasticSearchApplication1080;
import org.soin.document.CourseDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 创建索引库测试是否成功
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticSearchApplication1080.class)
public class ElasticSearchTest {
    /**
     * 注入Es的模板
     */
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    public void testEs () throws Exception{
        //创建
        elasticsearchTemplate.createIndex(CourseDocument.class);
        elasticsearchTemplate.putMapping(CourseDocument.class);
    }
}
