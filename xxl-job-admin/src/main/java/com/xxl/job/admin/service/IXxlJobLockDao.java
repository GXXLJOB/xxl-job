package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobLog;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * job lock
 * @author gxxljob
 */
public interface IXxlJobLockDao {

	/**
	 * 获取数据源
	 *
	 * @return 数据源
	 */
	public DataSource getDataSource();
	
	/**
	 * 获取锁SQL
	 *
	 * @return SQL
	 */
	public String getLockSql();

}
