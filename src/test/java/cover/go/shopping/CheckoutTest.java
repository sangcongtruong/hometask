package cover.go.shopping;

import cover.go.AbstractTest;
import cover.go.pages.CheckoutCompletePage;
import cover.go.pages.CheckoutOverviewPage;
import cover.go.pages.CheckoutPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Checkout Process Tests")
public class CheckoutTest extends AbstractTest {
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeEach
    public void setup() {
        super.setupBrowserAndPage();
        checkoutPage = new CheckoutPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }

    @Test
    @DisplayName("Proceed to Checkout from Cart Page")
    public void testProceedToCheckout() {
        login();
        inventoryPage.addItemToCart("Sauce Labs Bike Light");
        navigateToCartPage();
        cartPage.proceedToCheckout();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl(),
                "URL should navigate to checkout step one.");
    }

    @Test
    @DisplayName("Cancel Checkout at First Step")
    public void testCancelRightAfterCheckout() {
        login();
        inventoryPage.addItemToCart("Sauce Labs Bike Light");
        navigateToCartPage();
        cartPage.proceedToCheckout();
        checkoutPage.cancelTheCheckout();
        assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl(),
                "After cancelling, URL should return to the cart page.");
    }

    @Test
    @DisplayName("Cancel at Overview Step after Filling Information")
    public void testInputInfoThenCancelAtOverview() {
        login();
        inventoryPage.addItemToCart("Sauce Labs Bike Light");
        navigateToCartPage();
        cartPage.proceedToCheckout();
        checkoutPage.fillCheckoutInformation("Cancel", "Overview", "12345");
        assertAll("Verify Overview page values",
                () -> assertTrue(checkoutOverviewPage.getTax().contains("Tax: $0.80"), "Tax should be $0.80"),
                () -> assertEquals("Total: $10.79", checkoutOverviewPage.getTotalPrice(), "Total price should be $10.79")
        );
        checkoutOverviewPage.cancelTheCheckout();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(),
                "After cancelling at overview, URL should return to the inventory page.");
    }

    @Test
    @DisplayName("Complete Checkout Process Successfully")
    public void testCheckoutFinishProcess() {
        login();
        inventoryPage.addItemToCart("Sauce Labs Fleece Jacket");
        inventoryPage.addItemToCart("Sauce Labs Onesie");
        inventoryPage.addItemToCart("Test.allTheThings() T-Shirt (Red)");
        navigateToCartPage();
        cartPage.proceedToCheckout();
        checkoutPage.fillCheckoutInformation("Sang", "Truong", "12345");
        assertAll("Verify Overview page shipping and total price",
                () -> assertTrue(checkoutOverviewPage.getShippingInfo().contains("Free Pony Express Delivery!"),
                        "Shipping info should mention 'Free Pony Express Delivery!'"),
                () -> assertEquals("Total: $79.89", checkoutOverviewPage.getTotalPrice(), "Total price should be $79.89")
        );
        checkoutOverviewPage.finishCheckout();
        assertTrue(checkoutCompletePage.getCompletePageHeader().contains("Thank you for your order!"),
                "Checkout complete header should confirm order completion.");
    }
}
