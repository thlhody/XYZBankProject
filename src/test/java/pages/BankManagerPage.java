package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerPage extends BasePage {
    public BankManagerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "button[ng-click='addCust()']")
    private WebElement addCustomerButton;
    @FindBy(css = "button[ng-click='openAccount()']")
    private WebElement openAccountButton;
    @FindBy(css = "button[ng-click='showCust()']")
    private WebElement showCustomerButton;

    public void navigateToAddCustomerPage() {
        clickButton.clickBttNormal(addCustomerButton);
        LoggerUtility.infoTest("User clicks on Add Customer Button!");
        clickButton.clickButtonWait();
    }

    public void navigateToOpenAccountPage() {
        clickButton.clickBttNormal(openAccountButton);
        LoggerUtility.infoTest("User clicks on Open Account Button!");
        clickButton.clickButtonWait();
    }

    public void navigateToCustomersPage() {
        clickButton.clickBttNormal(showCustomerButton);
        LoggerUtility.infoTest("User clicks on Show Cusomer Button!");
        clickButton.clickButtonWait();
    }

}
