package com.application.libs.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class common_utilities {
	
	public static String get_property_value(String file_path,String propery_name) throws IOException {
		Properties prop = new Properties();
		File f = new File(file_path);
		FileInputStream iStream = new FileInputStream(f);
		prop.load(iStream);
		return prop.getProperty(propery_name).toString();
	}
	
	
	
}
