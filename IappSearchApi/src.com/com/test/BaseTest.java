package com.test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.util.Configuration;

public class BaseTest {
	Configuration config;

	@BeforeSuite
	public void beforeSuite() {
		config = new Configuration();
	}

	@AfterSuite
	public void afterSuite() {
		config = null;
	}

}
