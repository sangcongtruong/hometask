package cover.go.shopping;

import cover.go.AbstractTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Inventory Page Tests")
public class InventoryTest extends AbstractTest {
    private static final String EXPECTED_TITLE = "Products";
    private static final String SORT_OPTION_HIGH_TO_LOW = "Price (high to low)";
    private static final String EXPECTED_HIGHEST_PRICE = "$49.99";
    private static final String EXPECTED_LOWEST_PRICE = "$7.99";
    private static final int NUMBER_OF_PRODUCTS = 6;

    @BeforeEach
    public void setup() {
        super.setupBrowserAndPage();
    }

    @Test
    @DisplayName("Verify Inventory page")
    public void testTitle() {
        login();
        assertEquals(EXPECTED_TITLE, inventoryPage.getTitleText(), "Page title should match expected.");
        // Scroll to the bottom to ensure all products are loaded
        utils.scrollToBottom(driver);
        assertEquals(NUMBER_OF_PRODUCTS, inventoryPage.numberOfProducts(), "Total products should be " + NUMBER_OF_PRODUCTS);
    }

    @Test
    @DisplayName("Verify Sorting by Price (High to Low)")
    public void testSort() {
        login();
        inventoryPage.openSortDropdown();
        inventoryPage.selectSortOption(SORT_OPTION_HIGH_TO_LOW);
        assertAll(
                "Verifying sorted item prices",
                () -> assertEquals(EXPECTED_HIGHEST_PRICE, inventoryPage.getFirstItemPrice(), "Highest price mismatch."),
                () -> assertEquals(EXPECTED_LOWEST_PRICE, inventoryPage.getLastItemPrice(), "Lowest price mismatch.")
        );
    }
}
