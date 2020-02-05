package com.project.base;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static String REPORT_FILE_NAME = "Auto_test_report"+".html";
    private static String FILE_SEPERATOR = System.getProperty("file.separator");
    private static String REPORT_FILE_PATH = System.getProperty("user.dir") +FILE_SEPERATOR+ "TestReport";
    private static String REPORT_FILE_LOCATION =  REPORT_FILE_PATH +FILE_SEPERATOR+ REPORT_FILE_NAME;
  
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(REPORT_FILE_PATH);
       
        ExtentHtmlReporter extntHtmlReporter = new ExtentHtmlReporter(fileName);
        extntHtmlReporter.config().setTheme(Theme.STANDARD);
        extntHtmlReporter.config().setDocumentTitle(REPORT_FILE_NAME);
        extntHtmlReporter.config().setEncoding("utf-8");
        extntHtmlReporter.config().setReportName(REPORT_FILE_NAME);
 
        extent = new ExtentReports();
        extent.attachReporter(extntHtmlReporter);
 
        return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return REPORT_FILE_LOCATION;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return REPORT_FILE_LOCATION;
    }
 
}