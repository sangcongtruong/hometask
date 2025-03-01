package cover.go.shopping;

import cover.go.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cart Tests")
public class CartTest extends AbstractTest {

    @BeforeEach
    public void setup() {
        super.setupBrowserAndPage();
    }

    @Test
    @DisplayName("Add a product to the cart")
    public void testAddAnItemToCart() {
        login();
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        navigateToCartPage();
        assertEquals(1, cartPage.countItemsInCart(), "Cart should contain exactly 1 item after adding Sauce Labs Backpack.");
    }

    @Test
    @DisplayName("Add multiple products and continue shopping")
    public void testAddManyItemsToCart() {
        login();
        inventoryPage.addItemToCart("Test.allTheThings() T-Shirt (Red)");
        inventoryPage.addItemToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addItemToCart("Sauce Labs Bike Light");
        navigateToCartPage();
        assertEquals(3, cartPage.countItemsInCart(), "Cart should contain 3 items.");
        cartPage.continueShopping();
        assertEquals("Products", inventoryPage.getTitleText(), "After continuing shopping, the inventory page title should be 'Products'.");
        inventoryPage.addItemToCart("Sauce Labs Fleece Jacket");
        navigateToCartPage();
        assertEquals(4, cartPage.countItemsInCart(), "Cart should contain 4 items after adding another product.");
    }

    @Test
    @DisplayName("Remove a product from the cart")
    public void testRemoveItemFromCart() {
        login();
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        inventoryPage.addItemToCart("Sauce Labs Bike Light");
        navigateToCartPage();
        assertEquals(2, cartPage.countItemsInCart(), "Cart should initially contain 2 items.");
        cartPage.removeItemFromCart("Sauce Labs Backpack");
        assertEquals(1, cartPage.countItemsInCart(), "Cart should contain 1 item after removing Sauce Labs Backpack.");
    }
}
