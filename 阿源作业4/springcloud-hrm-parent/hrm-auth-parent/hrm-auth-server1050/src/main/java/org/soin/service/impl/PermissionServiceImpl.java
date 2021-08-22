package org.soin.service.impl;

import org.soin.domain.Permission;
import org.soin.mapper.PermissionMapper;
import org.soin.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
