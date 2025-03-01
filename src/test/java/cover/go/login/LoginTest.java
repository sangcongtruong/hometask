package cover.go.login;

import cover.go.AbstractTest;
import cover.go.pages.LoginPage;
import cover.go.pages.TheBurgerMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Login Tests")
public class LoginTest extends AbstractTest {

    private LoginPage loginPage;
    private TheBurgerMenu burgerMenu;

    @BeforeEach
    public void setupBrowserAndPage() {
        super.setupBrowserAndPage();
        loginPage = new LoginPage();
        burgerMenu = new TheBurgerMenu();
    }

    @Test
    @DisplayName("Login with valid credentials")
    public void testValidLogin() {
        login(); // Uses default valid credentials
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(),
                "After valid login, the URL should be the inventory page.");
    }

    @Test
    @DisplayName("Login with missing and invalid credentials")
    public void testInvalidLogin() {
        // Attempt login without any credentials
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage(),
                "Error should indicate that the username is required.");

        // Attempt login with missing password
        loginPage.login("invalidUser", "");
        assertEquals("Epic sadface: Password is required", loginPage.getErrorMessage(),
                "Error should indicate that the password is required.");

        // Attempt login with invalid credentials
        loginPage.login("invalidUser", "invalidPass");
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage(),
                "Error should indicate that the username and password do not match any user.");
    }

    @Test
    @DisplayName("Login then logout")
    public void testLogout() {
        login();
        burgerMenu.logoutFromInventoryPage();
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl(),
                "After logout, the URL should return to the login page.");
    }
}
