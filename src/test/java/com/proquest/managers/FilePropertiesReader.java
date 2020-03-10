package com.proquest.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilePropertiesReader {

	protected Properties loadFileProperties(String fileLoc) {
		InputStream input = null;
		Properties prop = null;
		try {
			input = new FileInputStream(fileLoc);
			prop = new Properties();
			prop.load(input);
			input.close();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return prop;
	}

	protected String getFileProperties(String key, Properties prop) {
		String val = prop.getProperty(key);
		if (val.isEmpty() || val == null) {
			throw new RuntimeException("Value of the key " + key + " is: " + val);
		}
		return val;
	}

}
