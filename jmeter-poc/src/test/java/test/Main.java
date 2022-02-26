package test;

import helpers.AppConfig;

public class Main
{
	public static void main(String[] args){
		AppConfig appConfig = new AppConfig();
		System.out.println("Run tests by using JUnit Sampler to target JMeterHelper.executeTest();");
		System.out.println("Loading config for debugging purposes...");
		System.out.println("metricsOutputPath:  " + appConfig.getSetting("metricsOutputPath"));
		System.out.println("jmeterJUnitPageUrl:  " + appConfig.getSetting("jmeterJUnitPageUrl"));
		System.out.println("driverPath:  " + appConfig.getSetting("driverPath"));
		System.out.println("standardPageLoadWait:  " + appConfig.getSetting("standardPageLoadWait"));
	}
}