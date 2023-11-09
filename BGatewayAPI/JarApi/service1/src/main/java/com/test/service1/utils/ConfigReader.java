package com.test.service1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final String FILE_CONFIG = "/config.properties"; // Make sure the file is placed under "src/resources"
    private static Properties properties;

    static {
        try (InputStream inputStream = ConfigReader.class.getResourceAsStream(FILE_CONFIG)) {
            if (inputStream != null) {
                properties = new Properties();
                properties.load(inputStream);
            } else {
                throw new IOException("config.properties file not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String gethostName() {
    	return properties.getProperty("db.hostName");
    }
    
    public static String getname() {
    	return properties.getProperty("db.name");
    }

    public static String getuserId() {
        return properties.getProperty("db.userId");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
    
    public static String getApiUserLogin() {
    	return properties.getProperty("api.userLogin");
    }

	public static String getApiPath() {
		return properties.getProperty("api.path");
	}
}