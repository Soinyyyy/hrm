package org.soin.service.impl;

import org.soin.domain.LoginLog;
import org.soin.mapper.LoginLogMapper;
import org.soin.service.ILoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
