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
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return properties.getProperty(settingName);
	}

	public int getSettingInt(String settingName) {
		return Integer.parseInt(this.getSetting(settingName));
	}

	private void loadConfig() throws IOException {
		InputStream configStream = AppConfig.class.getClassLoader().getResourceAsStream("appconfig.properties");

		if (configStream == null) {
			configStream = AppConfig.class.getResourceAsStream("/resources/appconfig.properties");
		}

		this.properties.load(configStream);
		configStream.close();
	}
}