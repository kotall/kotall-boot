package com.kotall.rms.core.service.sys.impl;

import com.kotall.rms.common.entity.sys.SysJobEntity;
import com.kotall.rms.common.integration.quartz.ScheduleUtils;
import com.kotall.rms.core.enums.ScheduleStatus;
import com.kotall.rms.core.manager.sys.SysJobManager;
import com.kotall.rms.core.service.BaseServiceImpl;
import com.kotall.rms.core.service.sys.SysJobService;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午11:49:18
 */
@Service("quartzJobService")
public class SysJobServiceImpl extends BaseServiceImpl<SysJobManager, SysJobEntity>  implements SysJobService {
	
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
	public boolean saveQuartzJob(SysJobEntity job) {
		job.setStatus(ScheduleStatus.NORMAL.getValue());
		boolean count = sysJobManager.save(job);
		ScheduleUtils.createScheduleJob(job);
		return count;
	}

	@Override
	public boolean updateQuartzJob(SysJobEntity job) {
		boolean count = sysJobManager.update(job);
		ScheduleUtils.updateScheduleJob(job);
		return count;
	}

	@Override
	public boolean batchRemoveQuartzJob(Integer[] id) {
		for(Integer jobId : id) {
			ScheduleUtils.deleteScheduleJob(jobId);
		}
		boolean count = sysJobManager.deleteByIds(id);
		return count;
	}
	
	@Override
	public int run(Integer[] id) {
		for(Integer jobId : id) {
			ScheduleUtils.run(sysJobManager.getById(jobId));
		}
		return 1;
	}
	
	@Override
	public int pause(Integer[] id) {
		for(Integer jobId : id) {
			ScheduleUtils.pauseJob(jobId);
		}
		int count = sysJobManager.batchUpdate(id, ScheduleStatus.PAUSE.getValue());
		return count;
	}
	
	@Override
	public int resume(Integer[] id) {
		for(Integer jobId : id) {
			ScheduleUtils.resumeJob(jobId);
		}
		int count = sysJobManager.batchUpdate(id, ScheduleStatus.NORMAL.getValue());
		return count;
	}

}
