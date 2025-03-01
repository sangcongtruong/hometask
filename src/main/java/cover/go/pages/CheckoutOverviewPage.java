package cover.go.pages;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends AbstractPage {
    private static final By CANCEL_BUTTON = By.id("cancel");
    private static final By TOTAL_PRICE = By.className("summary_total_label");
    private static final By TAX = By.className("summary_tax_label");
    private static final By SHIPPING_INFO = By.cssSelector("[data-test=shipping-info-value]");
    private static final By FINISH_BUTTON = By.id("finish");

    public void cancelTheCheckout() {
        clickOn(CANCEL_BUTTON);
    }

    public void finishCheckout() {
        clickOn(FINISH_BUTTON);
    }

    public String getShippingInfo() {
        return getTextOf(SHIPPING_INFO);
    }

    public String getTax() {
        return getTextOf(TAX);
    }

    public String getTotalPrice() {
        return getTextOf(TOTAL_PRICE);
    }
}
