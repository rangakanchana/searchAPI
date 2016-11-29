package com.util;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Configuration {
	public static String URI;

	public Configuration() {
		loadProperties();
	}

	public void loadProperties() {
		try {
			Properties prop = new Properties();
			FileReader fr = new FileReader(
					new File(String.format("%s/src/com/resources/config.properties", System.getProperty("user.dir"))));
			prop.load(fr);
			URI = prop.getProperty("uri");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
