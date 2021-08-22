package org.soin.repository;

import org.soin.document.CourseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseElasticRepository extends ElasticsearchRepository<CourseDocument,Long> {
}
