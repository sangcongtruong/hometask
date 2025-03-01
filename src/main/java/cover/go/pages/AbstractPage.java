package cover.go.pages;

import cover.go.utils.CoverGoUtils;
import cover.go.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * AbstractPage provides common methods for interacting with WebElements,
 * waiting for elements, and managing page navigation.
 */
public abstract class AbstractPage {

    /**
     * Retrieves the WebDriver instance.
     *
     * @return the current WebDriver
     */
    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    /**
     * Finds and returns the WebElement identified by the given locator.
     *
     * @param locator the By locator of the element
     * @return the found WebElement
     */
    protected WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    /**
     * Waits for the element to be clickable and then clicks it.
     *
     * @param locator the By locator of the element to click
     */
    protected void clickOn(By locator) {
        CoverGoUtils.waitForElementToBeClickable(locator, getDriver());
        getElement(locator).click();
    }

    /**
     * Retrieves the text of the element identified by the given locator.
     *
     * @param locator the By locator of the element
     * @return the text content of the element
     */
    protected String getTextOf(By locator) {
        return getElement(locator).getText();
    }

    /**
     * Refreshes the current page.
     */
    public void refreshPage() {
        getDriver().navigate().refresh();
    }
}
