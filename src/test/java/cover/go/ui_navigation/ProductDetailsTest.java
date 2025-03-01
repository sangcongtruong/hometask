package cover.go.ui_navigation;

import cover.go.AbstractTest;
import cover.go.pages.ProductDetailsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product Details Tests")
public class ProductDetailsTest extends AbstractTest {
    private ProductDetailsPage productDetailsPage;

    @BeforeEach
    public void setup() {
        super.setupBrowserAndPage();
        productDetailsPage = new ProductDetailsPage();
    }

    @Test
    @DisplayName("View detail of a product")
    public void viewProductDetailTest() {
        login();
        productDetailsPage.viewProductDetail("Sauce Labs Backpack");

        // Verify price and URL of the product detail page
        assertAll("Verify price and URL",
                () -> assertEquals("$29.99", productDetailsPage.getPrice(), "Product price should match expected"),
                () -> assertTrue(driver.getCurrentUrl().contains("inventory-item"), "URL should contain 'inventory-item'")
        );

        productDetailsPage.addProductToCart();
        productDetailsPage.backToInventoryPage();
        navigateToCartPage();
        assertEquals(1, cartPage.countItemsInCart(), "Cart should contain 1 item after adding the product");
    }
}
