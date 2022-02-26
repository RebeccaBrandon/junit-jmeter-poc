package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import helpers.CSVWriter;

public class MetricsCollectorDriverDecorator extends CustomDriverDecorator {

	protected CSVWriter logger = new CSVWriter();
	
	public MetricsCollectorDriverDecorator(CustomDriver driver) {
		super(driver);
	}
	
	private String getStopWatchTimeInMilliSeconds(StopWatch stopWatch)
	{
		return Long.toString(TimeUnit.MILLISECONDS.convert(stopWatch.getNanoTime(), TimeUnit.NANOSECONDS)); 
	}
	
	@Override
	public void goToUrl(String url) {
		
		if(driver == null)
			return;
		
		StopWatch stopWatch = StopWatch.createStarted();
		driver.goToUrl(url);
		stopWatch.stop();
		
		String col1Text = "\"Go to url " + url + " time in ms\"";
		try {
			logger.writeCsvEntry(col1Text, getStopWatchTimeInMilliSeconds(stopWatch));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void waitForPageLoad(IBasePage basePage, int seconds) {
		
		if(driver == null)
			return;
		StopWatch stopWatch = StopWatch.createStarted();
		driver.waitForPageLoad(basePage, seconds);
		stopWatch.stop();
		
		String col1Text = "\"load " + basePage.getClass().getName() + " time in ms\"";
		try {
			logger.writeCsvEntry(col1Text, getStopWatchTimeInMilliSeconds(stopWatch));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}