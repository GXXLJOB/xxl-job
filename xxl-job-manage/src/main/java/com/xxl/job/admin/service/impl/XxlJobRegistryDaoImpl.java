package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.model.XxlJobRegistry;
import com.xxl.job.admin.dao.XxlJobRegistryDao;
import com.xxl.job.admin.service.IXxlJobRegistryDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 执行器服务DAO实现
 *
 * @author fucy
 * @date 2023/12/12 17:41
 * @since V2.4.0
 */
@Service("XxlJobRegistryDaoImpl")
public class XxlJobRegistryDaoImpl implements IXxlJobRegistryDao {
    
    @Resource
    private XxlJobRegistryDao xxlJobRegistryDao;
    
    @Override
    public List<Integer> findDead(int timeout, Date nowTime) {
        return xxlJobRegistryDao.findDead(timeout, nowTime);
    }
    
    @Override
    public int removeDead(List<Integer> ids) {
        return xxlJobRegistryDao.removeDead(ids);
    }
    
    @Override
    public List<XxlJobRegistry> findAll(int timeout, Date nowTime) {
        return xxlJobRegistryDao.findAll(timeout, nowTime);
    }
    
    @Override
    public int registryUpdate(String registryGroup, String registryKey, String registryValue, Date updateTime) {
        return xxlJobRegistryDao.registryUpdate(registryGroup, registryKey, registryValue, updateTime);
    }
    
    @Override
    public int registrySave(String registryGroup, String registryKey, String registryValue, Date updateTime) {
        return xxlJobRegistryDao.registrySave(registryGroup, registryKey, registryValue, updateTime);
    }
    
    @Override
    public int registryDelete(String registryGroup, String registryKey, String registryValue) {
        return xxlJobRegistryDao.registryDelete(registryGroup, registryKey, registryValue);
    }
}
