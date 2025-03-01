package cover.go.ui_navigation;

import cover.go.AbstractTest;
import cover.go.pages.TheBurgerMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Burger Menu Navigation Tests")
public class TheBurgerMenuTest extends AbstractTest {
    private TheBurgerMenu burgerMenu;

    @BeforeEach
    public void setup() {
        super.setupBrowserAndPage();
        burgerMenu = new TheBurgerMenu();
    }

    @Test
    @DisplayName("Reset state: Ensure product and cart state are reset correctly")
    public void resetProductAndCartStateTest() {
        // Log in and add products to the cart
        login();
        inventoryPage.addItemToCart("Test.allTheThings() T-Shirt (Red)");
        inventoryPage.addItemToCart("Sauce Labs Bolt T-Shirt");

        // Reset items using the burger menu and refresh page to reflect changes
        burgerMenu.resetAllItems();
        burgerMenu.refreshPage();

        // Navigate to the cart page and verify the cart is empty
        navigateToCartPage();
        assertEquals(0, cartPage.countItemsInCart(), "Cart should be empty after resetting items.");
    }

    @Test
    @DisplayName("Verify About link navigates to correct page")
    public void testAboutLinkNavigation() {
        // Log in and navigate to the About page using the burger menu
        login();
        burgerMenu.viewAbout();

        // Verify that the page title is as expected
        String expectedTitle = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
        assertEquals(expectedTitle, driver.getTitle(), "Page title should match the expected title after clicking About link.");
    }

    @Test
    @DisplayName("Verify navigation to view all items from the cart page")
    public void viewAllItemsTest() {
        // Log in, navigate to the cart, and verify current URL
        login();
        navigateToCartPage();
        String cartUrl = "https://www.saucedemo.com/cart.html";
        assertEquals(cartUrl, driver.getCurrentUrl(), "Current URL should be the cart page before navigating back.");

        // Use the burger menu to navigate back to the inventory page and verify the URL
        burgerMenu.viewAllItems();
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(inventoryUrl, driver.getCurrentUrl(), "Current URL should be the inventory page after clicking view all items.");
    }
}
