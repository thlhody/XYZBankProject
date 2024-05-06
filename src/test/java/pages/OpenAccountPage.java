package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyUtility.PropertyUtility;

import java.util.Arrays;
import java.util.List;

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
    @FindBy(xpath = "//*[@id='userSelect']/option")
    private List<WebElement> findByUserID;

    public void selectCustomer(String value) {
        clickMethods.clickBttNormal(selectCustomerElement);
        PropertyUtility pU = new PropertyUtility("AddCustomerDataTemp");
        Integer customerIDnr = Integer.valueOf(pU.getAllData().get("CustomerID"));
        clickMethods.clickBttNormal(findByUserID.get(customerIDnr));
        LoggerUtility.infoTest("User enters Customer: "+ value+"_ID_"+customerIDnr);
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
