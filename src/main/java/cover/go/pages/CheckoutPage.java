package cover.go.pages;

import org.openqa.selenium.By;

public class CheckoutPage extends AbstractPage {
    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CANCEL_BUTTON = By.id("cancel");

    /**
     * Fills out the checkout information and proceeds to the next step.
     */
    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        getElement(FIRST_NAME_FIELD).sendKeys(firstName);
        getElement(LAST_NAME_FIELD).sendKeys(lastName);
        getElement(POSTAL_CODE).sendKeys(postalCode);
        clickOn(CONTINUE_BUTTON);
    }

    /**
     * Cancels the checkout process.
     */
    public void cancelTheCheckout() {
        clickOn(CANCEL_BUTTON);
    }
}
