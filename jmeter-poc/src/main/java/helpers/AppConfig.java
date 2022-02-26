package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	public boolean isLoaded = false;
	Properties properties = new Properties();

	public String getSetting(String settingName) {
		if (!isLoaded) {
			try {
				loadConfig();
			} catch (IOException e) {
				e.printStackTrace();
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
		this.isLoaded = true;
	}
}