package com.tu.supportUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class lib {

	public static String resourceLocation = Constants.RESOURCE_DIR;
	public static String dataInputLocation = Constants.DATAINPUT_DIR;

	public static Logger logger = LogManager.getLogger(lib.class.getName());
	public static ThreadLocal<String> testName = new ThreadLocal<String>();
	public static Properties configData = new Properties();
	static {
		try {
			File file = new File((System.getProperty("user.dir").toString().replace("\\", "\\\\")
					+ "//src//test//resources//" + "DBDataUtils.xml"));
			FileInputStream fileInput = new FileInputStream(file);

			configData.loadFromXML(fileInput);
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isInvalid(String sInput) throws Exception {
		boolean isInvalid = true;
		if (sInput != null && sInput.trim().length() > 0)
			isInvalid = false;
		return isInvalid;
	}
}
