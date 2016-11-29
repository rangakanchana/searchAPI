package com.test;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.util.Configuration;
import com.util.RestUtil;


public class ITunesSearchTest extends BaseTest {
	RestUtil util;

	@BeforeClass
	public void beforeClass() {
		util = new RestUtil();
		// Multiple set of data like key, value pairs for uri
		// can be read from excel using annotation @dataprovider
		// Due to lack of time, testing single uri reading from config
		util.getRequest(Configuration.URI);
	}
	
	@Test
	public void testStatusCode() {
		Assert.assertEquals(HttpStatus.SC_OK, util.validateStatusCode());
	}

	@Test
	public void testResultCount() {
		Assert.assertEquals("2", util.validateResultCount());
	}

	@Test
	public void testArtistId() {
		Assert.assertEquals("909253", util.validateArtistId());
	}

	@Test
	public void testArtistName() {
		Assert.assertEquals("Jack Johnson", util.validateArtistName());
	}

}
