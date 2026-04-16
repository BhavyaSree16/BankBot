package listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

import base.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest base = (BaseTest) result.getInstance();

        try {
            // Handle alert
            try {
                Alert alert = base.driver.switchTo().alert();
                System.out.println("Alert in Listener: " + alert.getText());
                alert.accept();
            } catch (NoAlertPresentException e) {}

            // Take screenshot
            String path = ScreenshotUtil.capture(base.driver, result.getName());

            // Attach to report
            test.fail("Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush(); // 🔥 VERY IMPORTANT
    }
}