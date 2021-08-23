package org.soin.service;

import org.soin.domain.Meal;
import com.baomidou.mybatisplus.service.IService;
import org.soin.dto.LoginMealTo;

/**
 * <p>
 * 套餐表 服务类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
public interface IMealService extends IService<Meal> {

    void insertMealTo(LoginMealTo loginMealTo);
}
