package org.soin.service.impl;

import org.soin.domain.Login;
import org.soin.mapper.LoginMapper;
import org.soin.service.ILoginService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.soin.dto.LoginTo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

    @Override
    public Login sava(LoginTo loginTo) {
        Login login = new Login();
        BeanUtils.copyProperties(loginTo,login);
        login.setEnabled(true);
        super.insert(login);
        return login;
    }
}
