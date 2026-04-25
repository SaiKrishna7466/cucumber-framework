package hooks;
import io.cucumber.java.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import base.BaseClass;
import utils.ExtentManager;

import com.aventstack.extentreports.*;


public class Hooks {
	
	static ExtentReports extent = ExtentManager.getReport();
    static ExtentTest test;
	
	@Before
	public void setUp(Scenario scenario) {
		BaseClass.driver = new ChromeDriver();
		BaseClass.driver.manage().window().maximize();
		
		test = extent.createTest(scenario.getName());
        System.out.println("Browser launched");		
	}
	
	 @After
	    public void tearDown(Scenario scenario) {
		 
		 if(scenario.isFailed()) {
			 
			 System.out.println("Scenario failed, attaching screenshot...");
			 
			 TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
			 
			 //Take screenshot as bytes
			 byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);			 
			 //Attach to cucumber report
			 scenario.attach(screenshot, "image/png", "Failed Screenshot");
			 
			 //local save
			 File src = ts.getScreenshotAs(OutputType.FILE);
			 String fileName = scenario.getName().replaceAll(" ", "_") + ".png";
			 
			// relative path
			 String relativePath = "screenshots/" + fileName;
			 File dest = new File("target/" + relativePath);
			 try {
				 FileUtils.copyFile(src, dest);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			 
			// 3️⃣ Attach to Extent report
	            test.fail("Scenario Failed")
	                .addScreenCaptureFromPath(relativePath);

		 }else {
	            test.pass("Scenario Passed");
	        }

	        BaseClass.driver.quit();
	        extent.flush();
		 
		 	System.out.println("Browser closed");
	    }

}
