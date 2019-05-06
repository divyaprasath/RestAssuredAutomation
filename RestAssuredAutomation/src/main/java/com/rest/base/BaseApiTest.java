package com.rest.base;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.rest.helper.ConfigUtils;

public class BaseApiTest {

	protected String endPoint;

	@BeforeSuite
	public void beforeSuite() {
		Properties prop = ConfigUtils.loadproperties("config.properties");
		endPoint = prop.getProperty("Url");
	}

}
