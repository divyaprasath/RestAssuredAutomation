package com.rest.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

	public static Properties loadproperties(String fileName) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(Constans.path + fileName));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}
}