package org.soin.service.impl;

import org.soin.domain.Postition;
import org.soin.mapper.PostitionMapper;
import org.soin.service.IPostitionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-17
 */
@Service
public class PostitionServiceImpl extends ServiceImpl<PostitionMapper, Postition> implements IPostitionService {

}
