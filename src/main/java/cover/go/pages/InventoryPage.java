package cover.go.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends AbstractPage {
    private static final By TITLE = By.className("title");
    private static final By PRODUCT_SORT = By.className("product_sort_container");
    private static final By FIRST_ITEM_PRICE = By.cssSelector(".inventory_item:first-of-type .inventory_item_price");
    private static final By LAST_ITEM_PRICE = By.cssSelector(".inventory_item:last-of-type .inventory_item_price");
    private static final By ALL_PRODUCTS = By.className("inventory_item_label");

    // Returns the title text of the Inventory page
    public String getTitleText() {
        return getTextOf(TITLE);
    }

    // Opens the sorting dropdown
    public void openSortDropdown() {
        clickOn(PRODUCT_SORT);
    }

    // Selects a sort option by its visible text
    public void selectSortOption(String option) {
        Select sortSelection = new Select(getElement(PRODUCT_SORT));
        sortSelection.selectByVisibleText(option);
    }

    // Returns the price text of the first product
    public String getFirstItemPrice() {
        return getTextOf(FIRST_ITEM_PRICE);
    }

    // Returns the price text of the last product
    public String getLastItemPrice() {
        return getTextOf(LAST_ITEM_PRICE);
    }

    // Returns the total number of products displayed
    public int numberOfProducts() {
        return getDriver().findElements(ALL_PRODUCTS).size();
    }

    /**
     * Adds an item to the cart by locating it based on its name.
     *
     * @param itemName The exact name of the item to add.
     */
    public void addItemToCart(String itemName) {
        clickOn(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button"));
    }
}
