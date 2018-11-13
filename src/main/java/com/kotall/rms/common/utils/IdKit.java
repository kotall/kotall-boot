package com.kotall.rms.common.utils;

/**
 * id 生成工具
 */
public class IdKit {
	
	public static int getId(String args) {
		return args.hashCode();
	}

}
