package base;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helpers.FileListener;

public class LoggedDriverDecorator extends CustomDriverDecorator {

	protected static Logger log = LogManager.getLogger(FileListener.class.getName()); 
		
	public LoggedDriverDecorator(CustomDriver driver) {
		super(driver);
		
		/*if(driver == null)
		{
			throw new NullPointerException("driver is null");
		}*/
	}
	
	@Override
	public void goToUrl(String url) {
		
		if(driver == null)
			return;
		
		log.info("Going to url: " + url);
		driver.goToUrl(url);
	}

	@Override
	public void waitForPageLoad(IBasePage basePage, int seconds) {
		
		if(driver == null)
			return;
		
		log.info("waiting up to " + seconds + "s for page to load: " + basePage.getClass().getName());
		driver.waitForPageLoad(basePage, seconds);	
	}
	
	@Override
	public WebElement findElement(By by) {
		if (this.driver != null)
		{
			log.info("Finding element by " + by);
			return this.driver.findElement(by);
		}
		
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		if (this.driver != null)
		{
			log.info("Finding elements by " + by);
			return this.driver.findElements(by);
		}
		
		return null;
	}
	
	@Override
	public void start() {
		if (this.driver != null)
		{
			log.info("Starting driver");
			this.driver.start();
		}
	}
}