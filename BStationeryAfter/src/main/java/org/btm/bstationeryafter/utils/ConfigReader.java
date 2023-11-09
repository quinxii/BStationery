package org.btm.bstationeryafter.utils;

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
    
//    Database
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
    
    
//    User Management
    public static String getApiUserLogin() {
    	return properties.getProperty("api.userLogin");
    }
    
    public static String getApiUserRegister() {
    	return properties.getProperty("api.userRegister");
    }
    
    public static String getApiUserGetById() {
    	return properties.getProperty("api.userGetById");
    }
    
    public static String getApiUserUpdate() {
    	return properties.getProperty("api.userUpdate");
    }
    
    public static String getApiUserUpdatePassword() {
    	return properties.getProperty("api.userUpdatePassword");
    }
    
    public static String getApiUserDeactive() {
    	return properties.getProperty("api.userDeactive");
    }

    
//    Inventory Management
    public static String getApiProductFindById() {
    	return properties.getProperty("api.productFindById");
    }
    
    public static String getApiProductFindByName() {
    	return properties.getProperty("api.productFindByName");
    }
    
    public static String getApiProductFindByPrice() {
    	return properties.getProperty("api.productFindByPrice");
    }
    
    public static String getApiProductInsert() {
    	return properties.getProperty("api.productInsert");
    }
    
    public static String getApiProductUpdate() {
    	return properties.getProperty("api.productUpdate");
    }
    
    public static String getApiProductDelete() {
    	return properties.getProperty("api.productDelete");
    }

    
//    Default
    //    User Management
	public static String getApiUserPath() {
		return properties.getProperty("api.userPath");
	}

	//	Inventory Management
	public static String getApiProductPath() {
		return properties.getProperty("api.productPath");
	}
}
