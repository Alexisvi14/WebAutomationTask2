package utils;

import base.AbstractTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomListener extends AbstractTest implements ITestListener {
    String pathFile = "/Users/alexisvillamayor/Solvd/WebAutomationTask2/src/test/screenshots";

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName();
        ITestContext context = result.getTestContext();
        WebDriver driverContext = (WebDriver)context.getAttribute("WebDriver");
        try {
            takeScreenshot(methodName, driverContext);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshot (String testName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(pathFile + testName + ".png"));
    }
}
