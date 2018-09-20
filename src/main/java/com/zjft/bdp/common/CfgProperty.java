package com.zjft.bdp.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 通訊配置信息加載
 */

public class CfgProperty {
	private static Log log = LogFactory.getLog(CfgProperty.class);

	private static final String NAME = "cfg";

	private static final String LAST_FILE = ".properties";

	private static PropertyResourceBundle pr = null;

	static {
		try {
			String fileName = new StringBuffer(getfilePath(CfgProperty.class))
					.append(NAME + LAST_FILE).toString();
			InputStream is = new FileInputStream(fileName);
			pr = new PropertyResourceBundle(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (pr == null) {
			log.error("can not find cfg.properties");
		}
	}

	public static String getfilePath(Class<?> cls) {

		try {
			String fileName[] = cls.getResource("").toString().split("/");
			String file = "";
			String filePath = "";
			for (int i = 0; i < fileName.length - 4; i++) {
				file = fileName[i].replace("%20", " ");
				if (file != null) {
					filePath = filePath + file+ System.getProperty("file.separator");
				}
			}
			return filePath.substring(5);
		} catch (Exception e) {
			log.info("获取项目根路径失败", e);
			return null;
		}
	}

	public static String getProperty(String disStr) {
		if (disStr == null || disStr.equals("")) {
			return "";
		}
		String ret = "";
		try {
			ret = new String(pr.getString(disStr).getBytes("ISO-8859-1"),"GB18030");
			return ret;
		} catch (Exception e) {
			log.error("获取属性["+disStr+"]失败", e);
			return disStr;
		}
	}
	
	public static String getProjectfilePath() {
		
		try {
			String fileName[] = CfgProperty.class.getResource("").toString().split("/");
			String file = "";
			String filePath = "";
			for (int i = 0; i < fileName.length - 4; i++) {
				file = fileName[i].replace("%20", " ");
				if (file != null) {
					filePath = filePath + file + System.getProperty("file.separator");
				}
			}
			return filePath.substring(5);
		} catch (Exception e) {
			log.error("获取项目根路径失败",e);
			return null;
		}
	}
	public static void main(String[] args) {
		System.out.println(getProjectfilePath());
	}
}