package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.model.XxlJobLog;
import com.xxl.job.admin.dao.XxlJobLogDao;
import com.xxl.job.admin.service.IXxlJobLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 任务执行日志DAO实现
 *
 * @author fucy
 * @date 2023/12/12 17:36
 * @since V2.4.0
 */
@Service("XxlJobLogDaoImpl")
public class XxlJobLogDaoImpl implements IXxlJobLogDao {
	
	@Resource
	private XxlJobLogDao xxlJobLogDao;
	
	@Override
	public XxlJobLog load(long id) {
		return xxlJobLogDao.load(id);
	}
	
	@Override
	public long save(XxlJobLog xxlJobLog) {
		return xxlJobLogDao.save(xxlJobLog);
	}
	
	@Override
	public int updateTriggerInfo(XxlJobLog xxlJobLog) {
		return xxlJobLogDao.updateTriggerInfo(xxlJobLog);
	}
	
	@Override
	public int updateHandleInfo(XxlJobLog xxlJobLog) {
		return xxlJobLogDao.updateHandleInfo(xxlJobLog);
	}
	
	@Override
	public Map<String, Object> findLogReport(Date from, Date to) {
		return xxlJobLogDao.findLogReport(from, to);
	}
	
	@Override
	public List<Long> findClearLogIds(int jobGroup, int jobId, Date clearBeforeTime, int clearBeforeNum, int pagesize) {
		return xxlJobLogDao.findClearLogIds(jobGroup, jobId, clearBeforeTime, clearBeforeNum, pagesize);
	}
	
	@Override
	public int clearLog(List<Long> logIds) {
		return xxlJobLogDao.clearLog(logIds);
	}
	
	@Override
	public List<Long> findFailJobLogIds(int pagesize) {
		return xxlJobLogDao.findFailJobLogIds(pagesize);
	}
	
	@Override
	public int updateAlarmStatus(long logId, int oldAlarmStatus, int newAlarmStatus) {
		return xxlJobLogDao.updateAlarmStatus(logId, oldAlarmStatus, newAlarmStatus);
	}
	
	@Override
	public List<Long> findLostJobIds(Date losedTime) {
		return xxlJobLogDao.findLostJobIds(losedTime);
	}
}
