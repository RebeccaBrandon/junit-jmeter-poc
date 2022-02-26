package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.AppConfig;

public class CustomWebDriver extends CustomDriver {
	private WebDriver _driver;
	private AppConfig _appConfig = new AppConfig();

	@Override
	public void start() {
		if (_driver == null) {
			
			System.setProperty("webdriver.chrome.driver", _appConfig.getSetting("driverPath"));
			this._driver = new ChromeDriver();
		}

	}

	@Override
	public void waitForPageLoad(IBasePage basePage, int seconds) {
		if (this._driver != null) {
			new WebDriverWait(_driver, Duration.ofSeconds(seconds));
		}

	}

	@Override
	public void quit() {
		if (this._driver != null)
			this._driver.quit();

	}

	@Override
	public void goToUrl(String url) {
		if (this._driver != null)
			this._driver.get(url);

	}

	@Override
	public WebElement findElement(By by) {
		if (this._driver != null)
			return this._driver.findElement(by);

		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		if (this._driver != null)
			return this._driver.findElements(by);

		return null;
	}
}