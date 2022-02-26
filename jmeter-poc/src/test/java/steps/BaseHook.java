package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.BasePage;

public class BaseHook {

	@Before
	public void begin() {
		BasePage.createDriver();
	}
	
	@After
	public void tearDown() {
		BasePage.tearDown();
	}
}