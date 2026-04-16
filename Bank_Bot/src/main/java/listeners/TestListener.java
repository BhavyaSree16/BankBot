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

        BaseTest test = (BaseTest) result.getInstance();

        try {
            // ✅ HANDLE ALERT FIRST
            try {
                Alert alert = test.driver.switchTo().alert();
                System.out.println("⚠️ Listener Alert: " + alert.getText());
                alert.accept();
            } catch (NoAlertPresentException e) {
                // no alert
            }

            // ✅ NOW TAKE SCREENSHOT
            ScreenshotUtil.capture(test.driver, result.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}