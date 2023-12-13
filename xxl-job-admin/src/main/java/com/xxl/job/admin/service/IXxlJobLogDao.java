package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobLog;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * job log
 * @author xuxueli 2016-1-12 18:03:06
 */
public interface IXxlJobLogDao {

	/**
	 * 根据ID查询日志
	 *
	 * @param id 日志ID
	 * @return 日志信息
	 */
	public XxlJobLog load(long id);
	
	/**
	 * 保存日志
	 *
	 * @param xxlJobLog 日志
	 * @return 保存结果
	 */
	public long save(XxlJobLog xxlJobLog);
	
	/**
	 * 更新日志的触发信息
	 *
	 * @param xxlJobLog 日志
	 * @return 保存结果
	 */
	public int updateTriggerInfo(XxlJobLog xxlJobLog);
	
	/**
	 * 更新日志的处理信息
	 *
	 * @param xxlJobLog 日志
	 * @return 更新结果
	 */
	public int updateHandleInfo(XxlJobLog xxlJobLog);
	
	/**
	 * 日志统计
	 * @param from 开始时间
	 * @param to 结束时间
	 * @return 统计结果：triggerDayCount-任务调度次数，triggerDayCountRunning-运行中的任务数，triggerDayCountSuc-成功的调度次数
	 */
	public Map<String, Object> findLogReport(Date from,
											 Date to);
	
	/**
	 * 查询需要清理的日志ID列表
	 *
	 * @param jobGroup 执行器ID
	 * @param jobId 任务ID
	 * @param clearBeforeTime 查询日志的时间点
	 * @param clearBeforeNum 查询的日志起始点
	 * @param pagesize 查询最大记录条数
	 * @return 日志ID列表
	 */
	public List<Long> findClearLogIds(int jobGroup,
									  int jobId,
									  Date clearBeforeTime,
									  int clearBeforeNum,
									  int pagesize);
	
	/**
	 * 清理日志
	 *
	 * @param logIds 日志ID列表
	 * @return 清理结果
	 */
	public int clearLog(List<Long> logIds);
	
	/**
	 * 查询失败日志ID列表
	 *
	 * @param pagesize 查询记录条数
	 * @return 日志ID列表
	 */
	public List<Long> findFailJobLogIds(int pagesize);
	
	/**
	 * 更新告警状态
	 *
	 * @param logId 日志ID
	 * @param oldAlarmStatus 旧告警状态
	 * @param newAlarmStatus 新告警状态
	 * @return 更新结果
	 */
	public int updateAlarmStatus(long logId,
								 int oldAlarmStatus,
								 int newAlarmStatus);
	
	/**
	 * 查询任务结果的日志ID列表
	 *
	 * @param losedTime 丢失时间
	 * @return 日志ID列表
	 */
	public List<Long> findLostJobIds(Date losedTime);

}
