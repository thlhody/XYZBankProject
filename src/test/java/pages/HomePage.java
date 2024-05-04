package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "button[ng-click='home()']")
    private WebElement homeButton;
    @FindBy(css = "button[ng-click='customer()']")
    private WebElement customerButtonLogin;
    @FindBy(css = "button[ng-click='manager()']")
    private WebElement managerButtonLogin;

    public void navigateToHomePage() {
        clickButton.clickBttNormal(homeButton);
        LoggerUtility.infoTest("User clicks on Home Button!");
        clickButton.clickButtonWait();
    }

    public void navigateToCustomerPage() {
        clickButton.clickBttNormal(customerButtonLogin);
        LoggerUtility.infoTest("User clicks on Customer Login Button!");
        clickButton.clickButtonWait();
    }

    public void navigateToManagerPage() {
        clickButton.clickBttNormal(managerButtonLogin);
        LoggerUtility.infoTest("User clicks on Bank Manager Login Button!");
        clickButton.clickButtonWait();
    }

}
