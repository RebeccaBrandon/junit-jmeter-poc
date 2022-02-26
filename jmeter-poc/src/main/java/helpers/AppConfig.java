package helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class AppConfig {
	public boolean isLoaded = false;
	Properties properties = new Properties();
	public String pathToResource = System.getenv("JMETER_POC_APP_CONFIG_PATH");
				
	public String getSetting(String settingName) {
		if (!isLoaded) {
			try
			{
				loadConfig();
			}
			catch(IOException | NullPointerException ex)
			{
				try {
					loadConfigWithFileReader();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

		return properties.getProperty(settingName);
	}
	
	public int getSettingInt(String settingName) {
			return Integer.parseInt(this.getSetting(settingName));
	}
    
	private void loadConfig() throws IOException {
        InputStream configFileStream = AppConfig.class.getClassLoader().getResourceAsStream("appconfig.properties");
        this.properties.load(configFileStream);
        configFileStream.close();
    }
	
	private void loadConfigWithFileReader() throws IOException {
		if(pathToResource == null)
		{
			System.out.println("env. variable JMETER_POC_APP_CONFIG_PATH not set");
			pathToResource = "C://temp/appconfig.properties";
		}
		
		System.out.println("Checking " + pathToResource + " for app config");
		
		FileReader fr = null;
		try {
		    fr = new FileReader(Paths.get(pathToResource).toFile());
		} catch (FileNotFoundException e) {
		    System.err.println("Couldn't load resources file!");
		    e.printStackTrace();
		}
		this.properties.load(fr);
		fr.close();
		this.isLoaded = true;
	}
}