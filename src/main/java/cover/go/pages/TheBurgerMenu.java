package cover.go.pages;

import org.openqa.selenium.By;

public class TheBurgerMenu extends AbstractPage {
    private static final By BURGER_MENU = By.id("react-burger-menu-btn");
    private static final By LOGOUT_LINK = By.id("logout_sidebar_link");
    private static final By RESET_APP_STATE_LINK = By.id("reset_sidebar_link");
    private static final By ABOUT_LINK = By.id("about_sidebar_link");
    private static final By ALL_ITEMS_LINK = By.id("inventory_sidebar_link");

    public void openBurgerMenu() {
        clickOn(BURGER_MENU);
    }

    public void logoutFromInventoryPage() {
        openBurgerMenu();
        clickOn(LOGOUT_LINK);
    }

    public void resetAllItems() {
        openBurgerMenu();
        clickOn(RESET_APP_STATE_LINK);
    }

    public void viewAbout() {
        openBurgerMenu();
        clickOn(ABOUT_LINK);
    }

    public void viewAllItems() {
        openBurgerMenu();
        clickOn(ALL_ITEMS_LINK);
    }
}
