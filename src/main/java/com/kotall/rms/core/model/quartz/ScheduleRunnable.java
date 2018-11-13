package com.kotall.rms.core.model.quartz;

import java.lang.reflect.Method;

import com.kotall.rms.common.exception.RmsException;
import com.kotall.rms.common.utils.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

/**
 * 执行定时任务
 *
 * @author aracwong
 * @date 2017年8月20日 下午10:49:36
 */
public class ScheduleRunnable implements Runnable {
	
	private Object target;
	
	private Method method;
	
	private String params;
	
	public ScheduleRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException {
		this.target = SpringContextUtils.getBean(beanName);
		this.params = params;
		
		if(StringUtils.isNotBlank(params)){
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		}else{
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}

	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if(StringUtils.isNotBlank(params)){
				method.invoke(target, params);
			}else{
				method.invoke(target);
			}
		}catch (Exception e) {
			throw new RmsException("执行定时任务失败", e);
		}
	}

}
