package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.service.IXxlJobGroupDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 执行器DAO实现
 *
 * @author fucy
 * @date 2023/12/12 17:28
 * @since V2.4.0
 */
@Service("XxlJobGroupDaoImpl")
public class XxlJobGroupDaoImpl implements IXxlJobGroupDao {
    
    @Resource
    XxlJobGroupDao xxlJobGroupDao;
    
    @Override
    public List<XxlJobGroup> findByAddressType(int addressType) {
        return xxlJobGroupDao.findByAddressType(addressType);
    }
    
    @Override
    public int update(XxlJobGroup xxlJobGroup) {
        return xxlJobGroupDao.update(xxlJobGroup);
    }
    
    @Override
    public XxlJobGroup load(int id) {
        return xxlJobGroupDao.load(id);
    }
}
