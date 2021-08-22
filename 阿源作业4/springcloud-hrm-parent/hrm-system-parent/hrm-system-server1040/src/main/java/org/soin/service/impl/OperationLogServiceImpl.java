package org.soin.service.impl;

import org.soin.domain.OperationLog;
import org.soin.mapper.OperationLogMapper;
import org.soin.service.IOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-15
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

}
