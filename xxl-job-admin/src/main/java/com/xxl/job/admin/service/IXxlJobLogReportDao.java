package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobLogReport;

/**
 * job log
 * @author xuxueli 2019-11-22
 */
public interface IXxlJobLogReportDao {
	
	/**
	 * 保存任务执行报告（新插入数据）
	 *
	 * @param xxlJobLogReport 任务执行报告
	 * @return 保存结果
	 */
	public int save(XxlJobLogReport xxlJobLogReport);
	
	/**
	 * 更新任务执行报告
	 *
	 * @param xxlJobLogReport 任务执行报告
	 * @return 更新结果，如果不存在此记录（通过trigger_day判断），则直接返回-1
	 */
	public int update(XxlJobLogReport xxlJobLogReport);

}
