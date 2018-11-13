package com.kotall.rms.web.util;

import com.kotall.rms.common.utils.Result;

/**
 * 通用工具类
 *
 * @author aracwong
 * @date 2017年8月12日 下午1:34:44
 */
public class ResultKit {

	/**
	 * 操作成功
	 */
	public static final String MSG_OPERATION_SUCCESS = "操作成功！";

	/**
	 * 操作失败
	 */
	public static final String MSG_OPERATION_FAILED = "操作失败！";

	/**
	 * 加载表单数据错误提示
	 */
	public static final String MSG_INIT_FORM = "初始化表单数据失败，请重试！";


	/**
	 * 数据标识
	 */
	public static final String DATA_ROWS = "rows";

	/**
	 * 删除数据项不是全部所选
	 * @param total
	 * @param process
	 * @return
	 */
	public static String removeFailed(int total, int process){
		return "本次共处理："+String.valueOf(total)+"条，成功："+String.valueOf(process)+"条！";
	}

	/**
	 * 对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	private static boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断整数是否大于零
	 * 
	 * @param number
	 * @return
	 */
	private static boolean isIntThanZero(int number) {
		if (number > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 新增，修改提示
	 * @param count
	 * @return
	 */
	public static Result msg(int count) {
		if(isIntThanZero(count)){
			return Result.ok(ResultKit.MSG_OPERATION_SUCCESS);
		}
		return Result.error(ResultKit.MSG_OPERATION_FAILED);
	}
	
	/**
	 * 查询详情提示
	 * @param data
	 * @return
	 */
	public static Result msg(Object data) {
		if(isNullOrEmpty(data)){
			return Result.error(ResultKit.MSG_INIT_FORM);
		}
		return Result.ok().put(DATA_ROWS, data);
	}
	
	/**
	 * 返回数据
	 * @param data
	 * @return
	 */
	public static Result msgNotCheckNull(Object data) {
		return Result.ok().put(DATA_ROWS, data);
	}
	
	/**
	 * 删除提示
	 * @param total
	 * @param count
	 * @return
	 */
	public static Result msg(Object[] total, int count) {
		if(total.length == count){
			return Result.ok(ResultKit.MSG_OPERATION_SUCCESS);
		}else{
			if(isIntThanZero(count)){
				return Result.error(ResultKit.removeFailed(total.length, count));
			}else{
				return Result.error(ResultKit.MSG_OPERATION_FAILED);
			}
		}
	}
	
}
