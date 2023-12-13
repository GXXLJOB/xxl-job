package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.model.XxlJobLogReport;
import com.xxl.job.admin.dao.XxlJobLogReportDao;
import com.xxl.job.admin.service.IXxlJobLogReportDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 任务执行日志报告DAO实现
 *
 * @author fucy
 * @date 2023/12/12 17:39
 * @since V2.4.0
 */
@Service("XxlJobLogReportDaoImpl")
public class XxlJobLogReportDaoImpl implements IXxlJobLogReportDao {
	
	@Resource
	private XxlJobLogReportDao xxlJobLogReportDao;
	
	@Override
	public int save(XxlJobLogReport xxlJobLogReport) {
		return xxlJobLogReportDao.save(xxlJobLogReport);
	}
	
	@Override
	public int update(XxlJobLogReport xxlJobLogReport) {
		return xxlJobLogReportDao.update(xxlJobLogReport);
	}
}
