package cover.go.pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends AbstractPage {
    private static final By COMPLETE_HEADER = By.className("complete-header");

    public String getCompletePageHeader() {
        return getTextOf(COMPLETE_HEADER);
    }
}
