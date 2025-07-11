package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.EnvLoader;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    @Parameters({"env"})
    public void setup( @Optional("qa") String env) {
        // Check system properties first: //@Optional("chrome") String platform,
        // String sysPlatform = System.getProperty("platform");
        // if (sysPlatform != null && !sysPlatform.isEmpty()) {
        //     platform = sysPlatform;
        // }

        String sysEnv = System.getProperty("env");
        if (sysEnv != null && !sysEnv.isEmpty()) {
            env = sysEnv;
        }

        if (env == null || env.isEmpty()) {
            env = "qa";
        }

        EnvLoader.loadEnv(env);
        baseUrl = EnvLoader.get("BASE_URL");

        driver = DriverFactory.createDriver();
    }

    public void navigateTo(String path) {
        driver.get(baseUrl + path);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
