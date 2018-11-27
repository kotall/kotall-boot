package com.kotall.rms.core;

/**
 * 自定义异常
 *
 * @author aracwong
 * @date 2017年8月8日 上午11:59:32
 * @since 1.0.0
 */
public class RmsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public static final RmsException HAS_CHILD_EXCEPTION = new RmsException("操作失败，当前所选数据有子节点数据！");
	
    private String msg;
    
    private int code = 500;
    
    public RmsException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public RmsException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public RmsException(int code, String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public RmsException(int code, String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
