package org.soin.service.impl;

import org.soin.constant.BaseConstant;
import org.soin.domain.CourseType;
import org.soin.mapper.CourseTypeMapper;
import org.soin.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-19
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {
    /**
     * 申明Redis序列化
     * @return
     */
    @Autowired
    private RedisTemplate<Object ,Object> redisTemplate;
    //查询Redis里面是否存在Redis的缓存
    public List <CourseType> loadByCourseRedis(){
        //查询Redis里面是否有缓存热点数据
        Object result = redisTemplate.opsForValue().get(BaseConstant.RedisConstant.ALL_COURSE_TYPES);
        //如果查到了就直接返回
        if(result!=null){
            return (List<CourseType>) result;
        }else{
            //如果没有查到就查询MySql并且放入Redis里面
            List<CourseType> list = super.selectList(null);
            //吧数据放到redis里面
            redisTemplate.opsForValue().set(BaseConstant.RedisConstant.ALL_COURSE_TYPES,list);
            return list;
        }
    }
    @Override
    public List<CourseType> findTreeData() {
        //查询所有的层级
        List<CourseType> allTypes = loadByCourseRedis();
        //lamba表達式編程
        Map<Long, CourseType> typeMap = allTypes.stream().collect(Collectors.toMap(CourseType::getId, courseType -> courseType));
        //創建一個map
        HashMap<Long, CourseType> map = new HashMap<>();
        //遍歷得到數據
        for(CourseType type : allTypes){
            map.put(type.getId(), type);
        }
        //創建一個集合
        List<CourseType> firstCourseTypes = new ArrayList<>();
        for (CourseType courseType : allTypes) {
            if(courseType.getPid() == null || courseType.getPid().intValue() == 0 ){
                firstCourseTypes.add(courseType);//最顶层的数据
            }else{
                // 第二\三\四。。。。\N 层
//        *    3.只要不是第一层级的，找自己的上级，并将自己放入上级的children中
                CourseType parentType = typeMap.get(courseType.getPid());
                if(parentType != null){
                    parentType.getChildren().add(courseType);
                }
            }
        }
        return firstCourseTypes;
    }
      /*  //查询所有的层级
        List<CourseType> types = super.selectList(null);
        //从所有的层级里面查出父层级的数据
        ArrayList<CourseType> allCourseType = new ArrayList<>();
        //循序遍历里面的所有数据来查询出所有层级
        for (CourseType courseType : types){
            if (courseType.getId() == null || courseType.getPid().intValue() == 0){
                //就是最大的层级
                allCourseType.add(courseType);
            }else{
                for(CourseType parentType : types) {
                    if (courseType.getPid().intValue() == parentType.getId().intValue()) {
                        courseType.getChildren().add(courseType);
                        break;
                    }
                }
            }
        }
        return types;*/

    /**
     * Redis如何保證高可用
     * 在更改數據之後我們要添加數據後刪除數據
     * 來保證高可用
     */
    @Override
    //@CacheEvict(cacheNames= BaseConstant.RedisConstant.ALL_COURSE_TYPES,key="'ALL'")
    public boolean insert(CourseType entity) {
        boolean flag =  super.insert(entity);
        if(flag){
            redisTemplate.delete(BaseConstant.RedisConstant.ALL_COURSE_TYPES);
        }
        return flag;
    }
    @Override
   // @CacheEvict(cacheNames= BaseConstant.RedisConstant.ALL_COURSE_TYPES,key="'ALL'")
    public boolean deleteById(Serializable id) {
        boolean flag = super.deleteById(id);
        if(flag){
            redisTemplate.delete(BaseConstant.RedisConstant.ALL_COURSE_TYPES);
        }
        return flag;
    }
    @Override
   // @CacheEvict(cacheNames= BaseConstant.RedisConstant.ALL_COURSE_TYPES,key="'ALL'")
    public boolean updateById(CourseType entity) {
        boolean flag = super.updateById(entity);
        if(flag){
            redisTemplate.delete(BaseConstant.RedisConstant.ALL_COURSE_TYPES);
        }
        return flag;
    }
}
