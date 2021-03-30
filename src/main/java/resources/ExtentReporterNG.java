package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	ExtentReports extRep;
	public  ExtentReports getReportconfig() {
		String Path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(Path);
		report.config().setReportName("Web-Automation Extents Report");
		report.config().setDocumentTitle("Web-Automation Extents Report");
		
		extRep=new ExtentReports();
		extRep.attachReporter(report);
		extRep.setSystemInfo("Tester","Jenish");
		
		return extRep;
	}

}
