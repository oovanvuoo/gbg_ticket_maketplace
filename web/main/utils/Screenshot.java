package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {

    private static final String DEFAULT_DIR = "screenshots";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    public static void takeScreenshot(WebDriver driver, String testName) {
        takeScreenshot(driver, testName, DEFAULT_DIR);
    }

    public static void takeScreenshot(WebDriver driver, String testName, String customDir) {
        if (driver == null || testName == null || testName.isEmpty()) {
            System.err.println("[Screenshot] Invalid parameters. Driver or testName is null/empty.");
            return;
        }

        final File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        final String timestamp = LocalDateTime.now().format(FORMATTER);
        final String fileName = testName + "_" + timestamp + ".png";
        final String targetDir = (customDir == null || customDir.isBlank()) ? DEFAULT_DIR : DEFAULT_DIR + "/" + customDir;

        final Path destPath = Paths.get(targetDir, fileName);

        try {
            Files.createDirectories(destPath.getParent());
            Files.copy(srcFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("[Screenshot] Saved to: " + destPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("[Screenshot] Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
