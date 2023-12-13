package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.dao.XxlJobInfoDao;
import com.xxl.job.admin.service.IXxlJobInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 任务DAO实现
 *
 * @author fucy
 * @date 2023/12/12 17:34
 * @since V2.4.0
 */
@Service("XxlJobInfoDaoImpl")
public class XxlJobInfoDaoImpl implements IXxlJobInfoDao {
	
	@Resource
	private XxlJobInfoDao xxlJobInfoDao;
	
	@Override
	public XxlJobInfo loadById(int id) {
		return xxlJobInfoDao.loadById(id);
	}
	
	@Override
	public List<XxlJobInfo> scheduleJobQuery(long maxNextTime, int pagesize) {
		return xxlJobInfoDao.scheduleJobQuery(maxNextTime, pagesize);
	}
	
	@Override
	public int scheduleUpdate(XxlJobInfo xxlJobInfo) {
		return xxlJobInfoDao.scheduleUpdate(xxlJobInfo);
	}
}
