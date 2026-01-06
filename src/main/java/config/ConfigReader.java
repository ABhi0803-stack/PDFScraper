package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	
	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/configr.properties");
			prop = new Properties();
			prop.load(fis);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getProperty (String key) {
		return prop.getProperty(key);
	}

}
