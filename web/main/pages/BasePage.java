package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Config;

public class BasePage {
    protected WebDriver driver;

    // Constructor to initialize the WebDriver
    public BasePage(WebDriver driver) {
        this.driver = driver;  
    }

    // Common methods for all pages can be added here
    public void scrollDownUntilElementVisible(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + Config.TIMEOUT_SEC * 1000L;

        while (System.currentTimeMillis() < endTime) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    // Scroll to center the element
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
                    return;
                }
            } catch (NoSuchElementException ignored) {
            }

            // Scroll by screen height
            js.executeScript("window.scrollBy(0, window.innerHeight);");
            try {
                Thread.sleep(200); // Wait for content to load
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void scrollUpUntilElementVisible(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + Config.TIMEOUT_SEC * 1000L;

        while (System.currentTimeMillis() < endTime) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    // Scroll to center the element
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
                    return;
                }
            } catch (NoSuchElementException ignored) {
            }

            // Scroll by screen height
            js.executeScript("window.scrollBy(0, -window.innerHeight);");
            try {
                Thread.sleep(200); // Wait for content to load
            } catch (InterruptedException ignored) {
            }
        }
    }
}
