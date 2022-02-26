package base;

import org.openqa.selenium.By;

import helpers.AppConfig;

public abstract class BasePage implements IBasePage {
	public static CustomDriver _driver;
	protected AppConfig appConfig = new AppConfig();

	public abstract By uniqueLocator();

	public BasePage() {
		
	}

	public static void createDriver() {
		if (_driver == null) {
			CustomWebDriver driver = new CustomWebDriver();
			driver.start();
			BasePage._driver = new LoggedDriverDecorator(new MetricsCollectorDriverDecorator(driver));
		}
	}

	public CustomDriver driver() {
		return BasePage._driver;
	}

	public static void tearDown() {
		if (BasePage._driver != null)
			BasePage._driver.quit();
	}

	public void goToUrl(String url) {
		if (BasePage._driver != null)
			BasePage._driver.goToUrl(url);
	}

	public void waitForLoad(int seconds) {
		if (BasePage._driver != null)
			BasePage._driver.waitForPageLoad(this, seconds);
	}

	public void waitForLoad() {
		if (BasePage._driver != null)
			BasePage._driver.waitForPageLoad(this, appConfig.getSettingInt("standardPageLoadWait"));
	}
}