package com.xxl.job.admin.core.conf;

import com.xxl.job.admin.core.alarm.JobAlarmer;
import com.xxl.job.admin.core.scheduler.XxlJobScheduler;
import com.xxl.job.admin.service.IXxlJobGroupDao;
import com.xxl.job.admin.service.IXxlJobInfoDao;
import com.xxl.job.admin.service.IXxlJobLockDao;
import com.xxl.job.admin.service.IXxlJobLogDao;
import com.xxl.job.admin.service.IXxlJobLogReportDao;
import com.xxl.job.admin.service.IXxlJobRegistryDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */

@Component
public class XxlJobAdminConfig implements InitializingBean, DisposableBean {

    private static XxlJobAdminConfig adminConfig = null;
    public static XxlJobAdminConfig getAdminConfig() {
        return adminConfig;
    }


    // ---------------------- XxlJobScheduler ----------------------

    private XxlJobScheduler xxlJobScheduler;

    @Override
    public void afterPropertiesSet() throws Exception {
        adminConfig = this;

        xxlJobScheduler = new XxlJobScheduler();
        xxlJobScheduler.init();
    }

    @Override
    public void destroy() throws Exception {
        xxlJobScheduler.destroy();
    }


    // ---------------------- XxlJobScheduler ----------------------

    // conf
    @Value("${xxl.job.i18n}")
    private String i18n;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${spring.mail.from}")
    private String emailFrom;

    @Value("${xxl.job.triggerpool.fast.max}")
    private int triggerPoolFastMax;

    @Value("${xxl.job.triggerpool.slow.max}")
    private int triggerPoolSlowMax;

    @Value("${xxl.job.logretentiondays}")
    private int logretentiondays;

    // dao, service

    @Resource
    private IXxlJobLogDao xxlJobLogDaoI;
    @Resource
    private IXxlJobInfoDao xxlJobInfoDaoI;
    @Resource
    private IXxlJobRegistryDao xxlJobRegistryDaoI;
    @Resource
    private IXxlJobGroupDao xxlJobGroupDaoI;
    @Resource
    private IXxlJobLogReportDao xxlJobLogReportDaoI;
    @Resource
    private IXxlJobLockDao xxlJobLockDaoI;
    @Resource
    private JavaMailSender mailSender;
    @Resource
    private JobAlarmer jobAlarmer;


    public String getI18n() {
        if (!Arrays.asList("zh_CN", "zh_TC", "en").contains(i18n)) {
            return "zh_CN";
        }
        return i18n;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public int getTriggerPoolFastMax() {
        if (triggerPoolFastMax < 200) {
            return 200;
        }
        return triggerPoolFastMax;
    }

    public int getTriggerPoolSlowMax() {
        if (triggerPoolSlowMax < 100) {
            return 100;
        }
        return triggerPoolSlowMax;
    }

    public int getLogretentiondays() {
        if (logretentiondays < 7) {
            return -1;  // Limit greater than or equal to 7, otherwise close
        }
        return logretentiondays;
    }

    public IXxlJobLogDao getXxlJobLogDao() {
        return xxlJobLogDaoI;
    }

    public IXxlJobInfoDao getXxlJobInfoDao() {
        return xxlJobInfoDaoI;
    }

    public IXxlJobRegistryDao getXxlJobRegistryDao() {
        return xxlJobRegistryDaoI;
    }

    public IXxlJobGroupDao getXxlJobGroupDao() {
        return xxlJobGroupDaoI;
    }

    public IXxlJobLogReportDao getXxlJobLogReportDao() {
        return xxlJobLogReportDaoI;
    }
    
    public IXxlJobLockDao getXxlJobLockDao() {
        return xxlJobLockDaoI;
    }
    
    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public JobAlarmer getJobAlarmer() {
        return jobAlarmer;
    }

}
