package com.kotall.rms.common.integration.quartz;

import com.kotall.rms.common.dao.sys.SysJobLogMapper;
import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.common.entity.sys.SysJobLogEntity;
import com.kotall.rms.common.utils.JSONUtils;
import com.kotall.rms.common.utils.SpringContextUtils;
import com.kotall.rms.core.constants.Constant;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午10:54:01
 */
public class ScheduleJob extends QuartzJobBean {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private ExecutorService service = Executors.newSingleThreadExecutor(); 
	
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobStr = context.getMergedJobDataMap().getString(Constant.JOB_PARAM_KEY);
    	SysJobEntity scheduleJob = JSONUtils.jsonToBean(jobStr, SysJobEntity.class);
        
        // 获取spring bean
		SysJobLogMapper sysJobLogMapper = (SysJobLogMapper) SpringContextUtils.getBean("sysJobLogMapper");
        
        // 数据库保存执行记录
        SysJobLogEntity log = new SysJobLogEntity();
        log.setJobId(scheduleJob.getJobId());
        log.setBeanName(scheduleJob.getBeanName());
        log.setMethodName(scheduleJob.getMethodName());
        log.setParams(scheduleJob.getParams());
        
        // 任务开始时间
        long startTime = System.currentTimeMillis();
        
        try {
            // 执行任务
        	logger.info("任务准备执行，任务ID：" + scheduleJob.getJobId());
            ScheduleTask task = new ScheduleTask(scheduleJob.getBeanName(),
            		scheduleJob.getMethodName(), scheduleJob.getParams());
            Future<?> future = service.submit(task);
            
			future.get();
			
			// 任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			// 任务状态    0：失败    1：成功
			log.setStatus(1);
			
			logger.info("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
			
		} catch (Exception e) {
			
			logger.error("任务执行失败，任务ID：" + scheduleJob.getJobId(), e);
			
			// 任务执行总时长
			long times = System.currentTimeMillis() - startTime;
			log.setTimes((int)times);
			
			// 任务状态    0：失败    1：成功
			log.setStatus(0);
			log.setError(StringUtils.substring(e.toString(), 0, 2000));
			
		} finally {
			sysJobLogMapper.insert(log);
		}
    }
}
