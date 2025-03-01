package cover.go.pages;

import org.openqa.selenium.By;

public class CartPage extends AbstractPage {
    private static final By CART = By.id("shopping_cart_container");
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By CART_ITEMS = By.className("cart_item");
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    /**
     * Removes an item from the cart based on its product name.
     *
     * @param itemName The exact name of the product to remove.
     */
    public void removeItemFromCart(String itemName) {
        clickOn(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='cart_item']//button"));
    }

    /**
     * Returns the number of items currently in the cart.
     *
     * @return the count of cart items.
     */
    public int countItemsInCart() {
        return getDriver().findElements(CART_ITEMS).size();
    }

    /**
     * Clicks the 'Continue Shopping' button to return to the products page.
     */
    public void continueShopping() {
        clickOn(CONTINUE_SHOPPING_BUTTON);
    }

    /**
     * Clicks the 'Checkout' button to begin the checkout process.
     */
    public void proceedToCheckout() {
        clickOn(CHECKOUT_BUTTON);
    }

    /**
     * Clicks the 'Cart' icon on top right.
     */
    public void clickOnCart(){
        clickOn(CART);
    }
}
