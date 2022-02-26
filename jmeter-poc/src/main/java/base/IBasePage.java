package base;

import org.openqa.selenium.By;

public interface IBasePage {
	
	public void waitForLoad(int seconds);
	
	public void waitForLoad();
	
	public CustomDriver driver();

	public By uniqueLocator();
}