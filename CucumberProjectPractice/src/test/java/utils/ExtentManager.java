package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
	}

}
