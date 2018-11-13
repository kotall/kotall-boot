package com.kotall.rms.web.handler;

import com.kotall.rms.common.utils.Result;
import com.kotall.rms.common.exception.RmsException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author aracwong
 * @date 2017年8月8日 上午11:59:32
 * @since 1.0.0
 */
@RestControllerAdvice
public class RmsExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(RmsException.class)
	public Result handleRRException(RmsException e){
		Result result = new Result();
		result.put("code", e.getCode());
		result.put("msg", e.getMessage());

		return result;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Result handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return Result.error("数据库中已存在该记录");
	}

	@ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
	public Result handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return Result.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e){
		logger.error(e.getMessage(), e);
		return Result.error();
	}
	
}
