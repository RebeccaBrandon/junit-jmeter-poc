package test;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import helpers.FileListener;

public class JMeterHelper
{
	public JMeterHelper()
	{
		
	}
	
	public JMeterHelper(String params)
	{
		
	}
	
	@Test
	public void executeTest(){
		JUnitCore junit = new JUnitCore();
		junit.addListener(new FileListener());
		junit.run(TestRunner.class);
	}
}