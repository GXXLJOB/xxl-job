package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobRegistry;

import java.util.Date;
import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface IXxlJobRegistryDao {
    
    /**
     * 查询未运行的服务ID列表
     *
     * @param timeout 超时时间
     * @param nowTime 当前时间
     * @return 服务ID列表
     */
    public List<Integer> findDead(int timeout,
                                  Date nowTime);
    
    /**
     * 删除未运行的服务
     *
     * @param ids 服务ID列表
     * @return 删除结果
     */
    public int removeDead(List<Integer> ids);
    
    /**
     * 查询运行的服务列表
     *
     * @param timeout 超时时间
     * @param nowTime 当前时间
     * @return 服务列表
     */
    public List<XxlJobRegistry> findAll(int timeout,
                                        Date nowTime);
    
    /**
     * 更新服务
     *
     * @param registryGroup 注册服务类型：EXECUTOR：执行器，ADMIN：调度器（目前不会存在）
     * @param registryKey 注册服务标识，即为执行器指定的应用名称，对应配置：xxl.job.executor.appname
     * @param registryValue 注册服务信息，即为执行器被调度的地址
     * @param updateTime 更新时间
     * @return 更新结果，如果不存在（通过registryGroup、registryKey和registryValue三个属性查询），则直接返回-1；
     */
    public int registryUpdate(String registryGroup,
                              String registryKey,
                              String registryValue,
                              Date updateTime);
    
    /**
     * 保存服务（插入记录）
     *
     * @param registryGroup 注册服务类型：EXECUTOR：执行器，ADMIN：调度器（目前不会存在）
     * @param registryKey 注册服务标识，即为执行器指定的应用名称，对应配置：xxl.job.executor.appname
     * @param registryValue 注册服务信息，即为执行器被调度的地址
     * @param updateTime 更新时间
     * @return 保存结果
     */
    public int registrySave(String registryGroup,
                            String registryKey,
                            String registryValue,
                            Date updateTime);
    
    /**
     * 删除服务
     *
     * @param registryGroup 注册服务类型：EXECUTOR：执行器，ADMIN：调度器（目前不会存在）
     * @param registryKey 注册服务标识，即为执行器指定的应用名称，对应配置：xxl.job.executor.appname
     * @param registryValue 注册服务信息，即为执行器被调度的地址
     * @return 删除结果
     */
    public int registryDelete(String registryGroup,
                          String registryKey,
                          String registryValue);

}
