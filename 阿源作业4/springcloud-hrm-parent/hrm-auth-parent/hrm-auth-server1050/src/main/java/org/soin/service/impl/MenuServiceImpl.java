package org.soin.service.impl;

import org.soin.domain.Menu;
import org.soin.mapper.MenuMapper;
import org.soin.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
