package com.project.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	public String takeScreenShot(WebDriver webdriver) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
                

            //Move image file to new destination

                File DestFile=new File(path);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
                
                return path;
    }

}
