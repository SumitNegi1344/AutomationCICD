package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {//test ng listeners is used to keep track of tests
	//for Report entry
	public static ExtentReports getReportObject()//ij sytatic no need to create obj access with class name
	{
		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";// path file location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");//report name
		reporter.config().setDocumentTitle("Test Results");//title

		ExtentReports extent = new ExtentReports();// main class responsible for all test execution
		extent.attachReporter(reporter);// main class will have the knowledge of the object
		extent.setSystemInfo("Tester", "Sumit Negi");
		return extent;

}
}
