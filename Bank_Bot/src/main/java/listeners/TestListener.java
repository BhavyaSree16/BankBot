package listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        // Get driver from BaseTest
        BaseTest test = (BaseTest) result.getInstance();

        try {
            // 🔥 STEP 1: HANDLE ALERT FIRST (VERY IMPORTANT)
            try {
                Alert alert = test.driver.switchTo().alert();
                System.out.println("⚠️ Alert in Listener: " + alert.getText());
                alert.accept();
            } catch (NoAlertPresentException e) {
                // no alert
            }

            // 🔥 STEP 2: TAKE SCREENSHOT
            ScreenshotUtil.capture(test.driver, result.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}