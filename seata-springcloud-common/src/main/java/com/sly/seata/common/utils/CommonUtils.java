package com.sly.seata.common.utils;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 通用工具类(UUID,MD5,Token)
 * @author sly
 * @time 2019年4月28日
 */
public class CommonUtils {
	
	/**
	 * md5加密
	 * @param text
	 * @param salt
	 * @return
	 * @author sly
	 * @time 2018年12月12日
	 */
	public static String encodeMD5(String text,String salt) {
		return StringUtils.upperCase(DigestUtils.md5Hex(text + salt));
	}
	
	/**
	 * 生成token
	 * @return
	 * @author sly
	 * @time 2018年11月23日
	 */
	public static String genToken() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		return uuid;
	}
	
	/**
	 * 生成uuid
	 * @return
	 * @author sly
	 * @time 2018年11月23日
	 */
	public static String genUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		return uuid;
	}
}
