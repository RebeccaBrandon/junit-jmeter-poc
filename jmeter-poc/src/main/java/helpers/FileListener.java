package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class FileListener extends RunListener {
	protected static Logger log = LogManager.getLogger(FileListener.class.getName()); 
	
	public void testRunStarted(Description description) throws Exception {
		log.info("Number of tests to execute: " + description.testCount());
	}

	public void testRunFinished(Result result) throws Exception {
		log.info("Number of tests executed: " + result.getRunCount());
	}

	public void testStarted(Description description) throws Exception {
		log.info("Starting: " + description.getMethodName());
	}

	public void testFinished(Description description) throws Exception {
		log.info("Finished: " + description.getMethodName());
	}

	public void testFailure(Failure failure) throws Exception {

		log.error("Failure message: " + failure.getMessage());
		log.error("Failed: " + failure.getDescription().getMethodName());
	}

	public void testAssumptionFailure(Failure failure) {
		log.error("Failure assumption message: " + failure.getMessage());
		log.error("Failed assumption: " + failure.getDescription().getMethodName());
	}

	public void testIgnored(Description description) throws Exception {
		log.info("Ignored: " + description.getMethodName());
	}

}