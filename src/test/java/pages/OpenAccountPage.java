package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends BasePage {
    public WebDriver webDriver;

    public OpenAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "userSelect")
    private WebElement selectCustomerElement;
    @FindBy(id = "currency")
    private WebElement selectCurrencyElement;
    @FindBy(xpath = "//button[text()='Process']")
    private WebElement clickProcessButton;

    public void selectCustomer(String text) {
        clickMethods.clickBttNormal(selectCustomerElement);
        inputMethods.inputText(selectCustomerElement, text);
        LoggerUtility.infoTest("User enters Customer: " + text);
        waitMethod.waitToSee();
    }

    public void selectCurrency(String text) {
        clickMethods.clickBttNormal(selectCurrencyElement);
        inputMethods.inputText(selectCurrencyElement, text);
        LoggerUtility.infoTest("User selects Currency: " + text);
        waitMethod.waitToSee();
    }

    public void pressProcess() {
        clickMethods.clickBttNormal(clickProcessButton);
        LoggerUtility.infoTest("User presses the Process Button");
        alertMethods.copyAlertMesage();
        waitMethod.waitToSee();
        alertMethods.acceptAlert();
    }

    public void openAccount(AddCustomerObject addCustomerObject) {
        for (String currency : addCustomerObject.getAccountCurrencys()) {
            selectCustomer(addCustomerObject.getFirstNameValue() + " " + addCustomerObject.getLastNameValue());
            selectCurrency(currency);
            pressProcess();
        }
    }
}
