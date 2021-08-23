package org.soin.mapper;

import org.soin.domain.Meal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.soin.dto.LoginMealTo;

/**
 * <p>
 * 套餐表 Mapper 接口
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
public interface MealMapper extends BaseMapper<Meal> {

    void insertMealTo(LoginMealTo loginMealTo);
}
