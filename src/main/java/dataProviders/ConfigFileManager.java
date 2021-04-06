package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {
	
	private Properties properties;
	
	public ConfigFileManager() {
		String Path = "ConfigDetails/Configurations.properties";
		try {
			FileInputStream Locator = new FileInputStream(Path);
			properties = new Properties();
			properties.load(Locator);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
		}
	}
	
	public String  getData(String ElementName) {
		
		String data = properties.getProperty(ElementName);
		if(data!=null)
		return data;
		else throw new RuntimeException("DriverPath is not specified in the Configurations.properties file");
		
	}

}
