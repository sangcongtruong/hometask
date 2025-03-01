package cover.go.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DriverManager {
    // Using ThreadLocal to ensure each thread gets its own WebDriver instance.
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final int IMPLICIT_TIMEOUT_SECONDS = 3;

    private DriverManager() {
        // Prevent instantiation
    }

    /**
     * Initializes and returns the WebDriver based on the provided browser name.
     * Each thread will have its own driver instance.
     *
     * @param browser The browser to use ("chrome", "firefox", "edge").
     * @return The initialized WebDriver instance.
     */
    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            WebDriver newDriver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    newDriver = new ChromeDriver(chromeOptions);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    newDriver = new EdgeDriver(edgeOptions);
                    break;
                case "firefox":
                default:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    newDriver = new FirefoxDriver(firefoxOptions);
                    break;
            }
            newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT_SECONDS));
            // Optionally maximize the browser window:
            // newDriver.manage().window().maximize();
            driver.set(newDriver);
        }
        return driver.get();
    }

    /**
     * Returns the current WebDriver instance.
     *
     * @return The WebDriver instance.
     * @throws IllegalStateException if the driver has not been initialized.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver is not initialized. Call getDriver(String browser) first.");
        }
        return driver.get();
    }

    /**
     * Quits the driver for the current thread and removes it from the ThreadLocal storage.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
