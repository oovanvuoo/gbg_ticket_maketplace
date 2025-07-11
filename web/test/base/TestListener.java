package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

// import utils.AllureScreenshotHelper;
import utils.Screenshot;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).getDriver();
            String testName = result.getName();
            String[] packageParts = result.getTestClass().getName().split("\\.");
            String subDir = packageParts.length >= 2 ? packageParts[1] : packageParts[0];
            Screenshot.takeScreenshot(driver, testName, subDir);
        }
    }

    // @Override
    // public void onTestFailure(ITestResult result) {
    //     Object testClass = result.getInstance();
    //     try {
    //         WebDriver driver = (WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
    //         AllureScreenshotHelper.saveScreenshot(driver);
    //     } catch (Exception e) {
    //         // Handle exception or log
    //     }
    // }
}