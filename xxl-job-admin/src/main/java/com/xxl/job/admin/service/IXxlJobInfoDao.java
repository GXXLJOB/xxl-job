package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobInfo;

import java.util.List;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface IXxlJobInfoDao {
	
	/**
	 * 根据ID获取任务信息
	 *
	 * @param id 任务ID
	 * @return 任务信息
	 */
	public XxlJobInfo loadById(int id);
	
	/**
	 * 查询任务列表（下次执行时间内）
	 *
	 * @param maxNextTime 下次执行之间
	 * @param pagesize 最大记录条数
	 * @return 任务列表
	 */
	public List<XxlJobInfo> scheduleJobQuery(long maxNextTime, int pagesize );
	
	/**
	 * 更新任务信息（不存在，不更新）
	 *
	 * @param xxlJobInfo 任务信息
	 * @return 更新结果
	 */
	public int scheduleUpdate(XxlJobInfo xxlJobInfo);


}
