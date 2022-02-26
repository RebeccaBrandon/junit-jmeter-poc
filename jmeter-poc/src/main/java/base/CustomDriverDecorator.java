package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class CustomDriverDecorator extends CustomWebDriver {

	public CustomDriver driver;
	
	public CustomDriverDecorator(CustomDriver driver) {
		super();
		this.driver = driver;
	}
	
	@Override
	public void quit() {
		if (this.driver != null)
			this.driver.quit();
	}

	@Override
	public void waitForPageLoad(IBasePage basePage, int seconds)
	{
		driver.waitForPageLoad(basePage, seconds);
	}

	@Override
	public void goToUrl(String url) {
		if (this.driver != null)
			this.driver.goToUrl(url);
		
	}

	@Override
	public WebElement findElement(By by) {
		if (this.driver != null)
			return this.driver.findElement(by);
		
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		if (this.driver != null)
			return this.driver.findElements(by);
		
		return null;
	}
}