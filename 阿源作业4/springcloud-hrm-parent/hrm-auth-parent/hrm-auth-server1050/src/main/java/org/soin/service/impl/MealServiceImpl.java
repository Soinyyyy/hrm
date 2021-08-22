package org.soin.service.impl;

import org.soin.domain.Meal;
import org.soin.mapper.MealMapper;
import org.soin.service.IMealService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.soin.dto.LoginMealTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 套餐表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {

    @Autowired
    private MealMapper mealMapper;
    @Override
    public void insertMealTo(LoginMealTo loginMealTo) {
        mealMapper.insertMealTo(loginMealTo);
    }
}
