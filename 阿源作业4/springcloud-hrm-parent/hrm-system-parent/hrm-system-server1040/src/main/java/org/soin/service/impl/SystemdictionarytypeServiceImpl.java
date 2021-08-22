package org.soin.service.impl;

import org.soin.domain.Systemdictionarydetail;
import org.soin.domain.Systemdictionarytype;
import org.soin.mapper.SystemdictionarytypeMapper;
import org.soin.service.ISystemdictionarytypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author soin
 * @since 2021-08-20
 */
@Service
public class SystemdictionarytypeServiceImpl extends ServiceImpl<SystemdictionarytypeMapper, Systemdictionarytype> implements ISystemdictionarytypeService {
    @Autowired
    private SystemdictionarytypeMapper systemdictionarytypeMapper;
    @Override
    public List<Systemdictionarydetail> listBySn(String sn) {
        return systemdictionarytypeMapper.selectBySn(sn);
    }
}
