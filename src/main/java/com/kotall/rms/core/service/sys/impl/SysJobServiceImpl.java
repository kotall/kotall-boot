package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.core.enums.ScheduleStatus;
import com.kotall.rms.common.utils.Page;
import com.kotall.rms.common.utils.Query;
import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.common.manager.sys.SysJobManager;
import com.kotall.rms.core.service.sys.SysJobService;
import com.kotall.rms.core.model.quartz.ScheduleUtils;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:49:18
 */
@Service("quartzJobService")
public class SysJobServiceImpl implements SysJobService {
	
	@Autowired
	private SysJobManager sysJobManager;
	
	/**
	 * 项目启动，初始化任务
	 */
	@PostConstruct
	public void init() {
		List<SysJobEntity> jobList = sysJobManager.listNormalJob();
		for(SysJobEntity job : jobList) {
			CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(job.getJobId());
            /** 如果不存在，则创建 */
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(job);
            }else {
                ScheduleUtils.updateScheduleJob(job);
            }
		}
	}

	@Override
	public Page<SysJobEntity> list(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysJobEntity> page = new Page<>(query);
		sysJobManager.listForPage(page, query);
		return page;
	}

	@Override
	public int saveQuartzJob(SysJobEntity job) {
		job.setStatus(ScheduleStatus.NORMAL.getValue());
		int count = sysJobManager.saveQuartzJob(job);
		ScheduleUtils.createScheduleJob(job);
		return count;
	}

	@Override
	public SysJobEntity getQuartzJobById(Long jobId) {
		SysJobEntity job = sysJobManager.getQuartzJobById(jobId);
		return job;
	}

	@Override
	public int updateQuartzJob(SysJobEntity job) {
		int count = sysJobManager.updateQuartzJob(job);
		ScheduleUtils.updateScheduleJob(job);
		return count;
	}

	@Override
	public int batchRemoveQuartzJob(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.deleteScheduleJob(jobId);
		}
		int count = sysJobManager.batchRemoveQuartzJob(id);
		return count;
	}
	
	@Override
	public int run(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.run(sysJobManager.getQuartzJobById(jobId));
		}
		return 1;
	}
	
	@Override
	public int pause(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.pauseJob(jobId);
		}
		int count = sysJobManager.batchUpdate(id, ScheduleStatus.PAUSE.getValue());
		return count;
	}
	
	@Override
	public int resume(Long[] id) {
		for(Long jobId : id) {
			ScheduleUtils.resumeJob(jobId);
		}
		int count = sysJobManager.batchUpdate(id, ScheduleStatus.NORMAL.getValue());
		return count;
	}

}
