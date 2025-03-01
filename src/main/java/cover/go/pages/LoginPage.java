package cover.go.pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    /**
     * Returns the error message displayed on the login page.
     *
     * @return the error message text.
     */
    public String getErrorMessage() {
        return getTextOf(ERROR_MESSAGE);
    }

    /**
     * Clicks the login button without entering any data.
     */
    public void clickLoginButton() {
        clickOn(LOGIN_BUTTON);
    }

    /**
     * Enters the provided username and password, and then clicks the login button.
     *
     * @param user     The username to use.
     * @param password The password to use.
     */
    public void login(String user, String password) {
        getElement(USERNAME_FIELD).clear();
        getElement(USERNAME_FIELD).sendKeys(user);
        getElement(PASSWORD_FIELD).clear();
        getElement(PASSWORD_FIELD).sendKeys(password);
        clickOn(LOGIN_BUTTON);
    }
}
