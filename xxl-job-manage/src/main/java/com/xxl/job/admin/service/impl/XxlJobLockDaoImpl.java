package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.service.IXxlJobLockDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 数据库锁实现
 *
 * @author fucy
 * @date 2023/12/12 17:28
 * @since V2.4.0
 */
@Service("XxlJobLockDaoImpl")
public class XxlJobLockDaoImpl implements IXxlJobLockDao {
    
    @Resource
    DataSource dataSource;
    
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
    
    @Override
    public String getLockSql() {
        return "select * from xxl_job_lock where lock_name = 'schedule_lock' for update";
    }
}
