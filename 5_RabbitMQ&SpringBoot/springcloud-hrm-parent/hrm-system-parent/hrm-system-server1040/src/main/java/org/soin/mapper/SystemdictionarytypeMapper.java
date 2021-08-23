package org.soin.mapper;

import org.soin.domain.Systemdictionarydetail;
import org.soin.domain.Systemdictionarytype;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soin
 * @since 2021-08-20
 */
public interface SystemdictionarytypeMapper extends BaseMapper<Systemdictionarytype> {

    List<Systemdictionarydetail> selectBySn(String sn);
}
