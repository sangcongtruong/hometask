package cover.go.pages;

import org.openqa.selenium.By;

public class ProductDetailsPage extends AbstractPage {
    private static final By DETAIL_PRICE = By.className("inventory_details_price");
    private static final By ADD_TO_CART_BUTTON = By.id("add-to-cart");
    private static final By BACK_TO_PRODUCT = By.id("back-to-products");

    // Clicks on a product image.
    public void viewProductDetail(String productName) {
        clickOn(By.cssSelector("[alt='" + productName + "']"));
    }

    public void addProductToCart() {
        clickOn(ADD_TO_CART_BUTTON);
    }

    public void backToInventoryPage() {
        clickOn(BACK_TO_PRODUCT);
    }

    public String getPrice() {
        return getTextOf(DETAIL_PRICE);
    }
}
