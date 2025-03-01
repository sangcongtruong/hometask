package cover.go.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.time.Duration;
import java.util.Properties;

public class CoverGoUtils {
    private static final int DEFAULT_EXPLICIT_WAIT_SECONDS = 10;
    private static final String DEFAULT_PROPERTIES_PATH = System.getProperty("propertiesPath", System.getProperty("user.dir") +
            "/src/test/resources/test.properties".replace("/",
                    FileSystems.getDefault().getSeparator()));

    /**
     * Loads test parameters from a properties file.
     * The path can be overridden by setting the "propertiesPath" system property.
     *
     * @return A new instance of TestParameters loaded from the properties file.
     */
    public static TestParameters loadProperties() {
        Properties testVariables = new Properties();
        String propertiesPath = System.getProperty("propertiesPath", DEFAULT_PROPERTIES_PATH);
        System.out.println("User properties: " + propertiesPath);

        try (FileInputStream in = new FileInputStream(propertiesPath)) {
            testVariables.load(in);
        } catch (IOException e) {
            throw new IllegalArgumentException("Properties weren't loaded from path: " + propertiesPath, e);
        }
        return new TestParameters(testVariables);
    }

    /**
     * Scrolls to the bottom of the page using JavaScript.
     *
     * @param driver The WebDriver instance.
     */
    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    /**
     * Waits for the element located by the given locator to be clickable.
     *
     * @param locator The locator for the element.
     * @param driver  The WebDriver instance.
     */
    public static void waitForElementToBeClickable(By locator, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_EXPLICIT_WAIT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
