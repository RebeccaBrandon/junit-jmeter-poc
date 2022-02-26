package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class CustomDriver
{
	public abstract void waitForPageLoad(IBasePage basePage, int seconds);
	
	public abstract void quit();
	
	public abstract void goToUrl(String url);
	
	public abstract List<WebElement> findElements(By by);

	public abstract WebElement findElement(By by);

	public abstract void start();
}