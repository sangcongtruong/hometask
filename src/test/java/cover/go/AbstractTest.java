package cover.go;

import cover.go.pages.CartPage;
import cover.go.pages.CheckoutPage;
import cover.go.pages.InventoryPage;
import cover.go.pages.LoginPage;
import cover.go.utils.CoverGoUtils;
import cover.go.utils.DriverManager;
import cover.go.utils.TestParameters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class AbstractTest {
    public static WebDriver driver;

    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;

    protected static TestParameters testParams;
    protected static CoverGoUtils utils;

    @BeforeAll
    public static void init() {
        utils = new CoverGoUtils();
        testParams = utils.loadProperties();
    }

    @AfterEach
    public void quitBrowser() {
        DriverManager.quitDriver();
        try {
            Thread.sleep(1000); // Wait 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Initializes the WebDriver and page objects, and navigates to the base URL.
     */
    public void setupBrowserAndPage() {
        driver = DriverManager.getDriver(testParams.getBrowser());

        // Initialize page objects
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage(); // if used in tests

        // Navigate to the root URL
        driver.get(getRootUrl());
    }

    /**
     * Logs in using credentials provided in test parameters.
     */
    public void login() {
        loginPage.login(testParams.getUser(), testParams.getPassword());
    }

    /**
     * Navigates to the Cart page by clicking on the cart icon.
     */
    public void navigateToCartPage() {
        cartPage.clickOnCart();
    }

    /**
     * Constructs the root URL using host information from test parameters.
     *
     * @return The root URL string.
     */
    public String getRootUrl() {
        return "https://" + testParams.getHost() + "/";
    }
}
