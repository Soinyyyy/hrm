package org.soin.service.impl;

import org.soin.domain.Config;
import org.soin.mapper.ConfigMapper;
import org.soin.service.IConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-15
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
