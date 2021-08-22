package org.soin.service.impl;

import org.soin.domain.Role;
import org.soin.mapper.RoleMapper;
import org.soin.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
