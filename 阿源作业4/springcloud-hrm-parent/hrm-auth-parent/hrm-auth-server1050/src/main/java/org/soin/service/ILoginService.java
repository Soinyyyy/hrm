package org.soin.service;

import org.soin.domain.Login;
import com.baomidou.mybatisplus.service.IService;
import org.soin.dto.LoginTo;

/**
 * <p>
 * 登录表 服务类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
public interface ILoginService extends IService<Login> {

    Login sava(LoginTo loginTo);
}
