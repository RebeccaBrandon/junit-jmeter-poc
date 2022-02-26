package steps;

import io.cucumber.java.en.Given;
import base.BasePage;
import base.IBasePage;
import helpers.AppConfig;
import pages.JMeterHomePage;

public class Steps {
	
	public JMeterHomePage jMeterHomePage;
	public AppConfig appConfig;
	
	public Steps(JMeterHomePage jMeterHomePage, AppConfig appConfig)
	{
		this.jMeterHomePage = jMeterHomePage;
		this.appConfig = appConfig;
	}
	
	@Given("I load the JMeter Junit Sampler page")
	public void i_open_a_browser() throws InterruptedException {
		
		jMeterHomePage.goToUrl(appConfig.getSetting("jmeterJUnitPageUrl"));
		jMeterHomePage.waitForLoad();
		
		System.out.print(jMeterHomePage.getIntroText());
	}
}