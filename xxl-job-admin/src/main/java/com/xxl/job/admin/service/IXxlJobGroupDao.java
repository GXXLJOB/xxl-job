package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobGroup;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface IXxlJobGroupDao {
    
    /**
     * 根据地址类型查询执行器列表
     *
     * @param addressType 执行器地址类型：0=自动注册、1=手动录入
     * @return 执行器列表
     */
    public List<XxlJobGroup> findByAddressType(int addressType);
    
    /**
     * 更新执行器信息
     *
     * @param xxlJobGroup 执行器
     * @return 更新结果
     */
    public int update(XxlJobGroup xxlJobGroup);
    
    /**
     * 根据ID获取执行器
     *
     * @param id 执行器ID
     * @return 执行器信息
     */
    public XxlJobGroup load(int id);

}
