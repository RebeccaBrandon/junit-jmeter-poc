package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class JMeterHomePage extends BasePage {
	
	public By uniqueLocator() {
		return By.xpath("//*[@id=\"junit\"]");
	}
	
	private WebElement introParagraph()
	{
		return driver().findElement(By.xpath("//*[@id=\"content\"]/div[2]/p"));
	}
	
	public String getIntroText()
	{
		return introParagraph().getText();
	}
}