package org.soin.service;

import org.soin.domain.Systemdictionarydetail;
import org.soin.domain.Systemdictionarytype;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author soin
 * @since 2021-08-20
 */
public interface ISystemdictionarytypeService extends IService<Systemdictionarytype> {

    List<Systemdictionarydetail> listBySn(String sn);
}
