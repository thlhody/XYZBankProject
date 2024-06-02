package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class OpenAccountPage extends BasePage {

    public OpenAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "userSelect")
    private WebElement selectCustomerElement;
    @FindBy(id = "currency")
    private WebElement currencyDropdown;
    @FindBy(xpath = "//button[text()='Process']")
    private WebElement clickProcessButton;
    @FindBy(xpath = "//*[@id='userSelect']/option")
    private List<WebElement> findUserByID;

    public void selectCustomer(String value) {
        clickMethods.clickBttNormal(selectCustomerElement);
        for(WebElement userOption : findUserByID){
            if(userOption.getText().contains(value)){
                userOption.click();
                break;
            }
        }
        LoggerUtility.infoTest("User enters Customer " + value);
    }

    public void selectCurrency(String currency) {
        clickMethods.clickBttNormal(currencyDropdown);
        selectMethods.selectObj(currencyDropdown,currency);
        LoggerUtility.infoTest("User selects Currency: " + currency);
    }

    public void pressProcess() {
        clickMethods.clickBttNormal(clickProcessButton);
        LoggerUtility.infoTest("User presses the Process Button");
    }
    public void openAccount(AddCustomerObject addCustomerObject) {
        for (String currency : addCustomerObject.getInputCurrency()) {
            selectCustomer(addCustomerObject.getCustomerFullName());
            selectCurrency(currency);
            pressProcess();
            String accountNumber = alertMethods.extractedAlertString();
            addCustomerObject.addAccountValue(currency,accountNumber);
            alertMethods.acceptAlert();
        }
    }
}


