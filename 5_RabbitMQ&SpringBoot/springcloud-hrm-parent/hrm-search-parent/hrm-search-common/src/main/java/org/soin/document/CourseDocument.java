package org.soin.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * ES索引库
 */
@Document(indexName = "hrm",type = "course")
@Data
public class CourseDocument {

    @Id
    private Long id;
    /**
     * 课程名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String name;
    /**
     * 适用人群
     */
    @Field(type = FieldType.Keyword)
    private String forUser;
    /**
     * 课程分类
     */
    @Field(type = FieldType.Long)
    private Long courseTypeId;

    @Field(type = FieldType.Keyword)
    private String gradeName;
    /**
     * 课程等级
     */
    @Field(type = FieldType.Long)
    private Long gradeId;
    /**
     * 教育机构
     */
    @Field(type = FieldType.Long)
    private Long tenantId;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String tenantName;

    /**
     * 课程的开课时间
     */
    @Field(type = FieldType.Date)
    private Date startTime;
    /**
     * 课程的节课时间
     */
    @Field(type = FieldType.Date)
    private Date endTime;
    /**
     * 封面
     */
    @Field(type = FieldType.Keyword)
    private String pic;

    @Field(type = FieldType.Integer)
    private Integer saleCount;
    @Field(type = FieldType.Integer)
    private Integer viewCount;
    /**
     * 评论数
     */
    @Field(type = FieldType.Integer)
    private Integer commentCount;

    /**
     * 收费规则：，收费1免费，2收费
     */
    @Field(type = FieldType.Integer)
    private Integer charge;
    /**
     * 营销截止时间
     */
    @Field(type = FieldType.Date)
    private Date expires;
    /**
     * 咨询qq
     */
    @Field(type = FieldType.Keyword)
    private String qq;
    /**
     * 价格
     */
    @Field(type = FieldType.Double)
    private Double price;
    /**
     * 原价
     */
    @Field(type = FieldType.Double)
    private Double priceOld;

}
