package pages;

import loggerUtility.LoggerUtility;
import objectData.CustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BankManagerPage extends BasePage {
    public BankManagerPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Add Customer
    @FindBy(css = "button[ng-click='addCust()']")
    private WebElement addCustomerElement;
    @FindBy(css = "input[placeholder='First Name'")
    private WebElement addFirstNameElement;
    @FindBy(css = "input[placeholder='Last Name'")
    private WebElement addLastNameElement;
    @FindBy(css = "input[placeholder='Post Code'")
    private WebElement addPostCodeElement;
    @FindBy(xpath = "//button[text()='Add Customer']")
    private WebElement addCustomerButton;

    //Open Account for that customer
    @FindBy(css = "button[ng-click='openAccount()']")
    private WebElement openAccountButton;
    @FindBy(id = "userSelect")
    private WebElement selectCustomerElement;
    @FindBy(id = "currency")
    private WebElement currencyDropdown;
    @FindBy(xpath = "//button[text()='Process']")
    private WebElement clickProcessButton;
    @FindBy(xpath = "//*[@id='userSelect']/option")
    private List<WebElement> findUserByID;

    //show customers list
    @FindBy(css = "button[ng-click='showCust()']")
    private WebElement showCustomerButton;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerBy;
    @FindBy(css = "button[ng-click='deleteCust(cust)'")
    private WebElement deleteSearchedCustomer;

    public void navigateTo(String menuOption, CustomerObject customerObject) {
        switch (menuOption.toLowerCase()) {
            case "add customer":
                clickMethods.clickBttNormal(addCustomerElement);
                LoggerUtility.infoTest("Navigated to Add Customer!");
                inputMethods.inputText(addFirstNameElement, customerObject.getFirstNameValue());
                LoggerUtility.infoTest("User enter First Name Value: " + customerObject.getFirstNameValue());
                inputMethods.inputText(addLastNameElement, customerObject.getLastNameValue());
                LoggerUtility.infoTest("User enters Last Name Value: " + customerObject.getLastNameValue());
                inputMethods.inputText(addPostCodeElement, customerObject.getPostCodeValue());
                LoggerUtility.infoTest("User enter Post Code Value: " + customerObject.getPostCodeValue());
                clickMethods.clickBttNormal(addCustomerButton);
                customerObject.setCustomerId(alertMethods.extractedAlertInteger());
                waitMethod.waitToSee();
                alertMethods.acceptAlert();
                LoggerUtility.infoTest("User clicks on Add Customer Button and creates Customer: " + customerObject.getCustomerFullName() + " with ID: " + customerObject.getCustomerId() + ".");
                break;
            case "open account":
                clickMethods.clickBttNormal(openAccountButton);
                LoggerUtility.infoTest("Navigated to Open Account!");
                clickMethods.clickBttNormal(selectCustomerElement);
                for (String currency : customerObject.getInputCurrency()) {
                    for (WebElement userOption : findUserByID) {
                        if (userOption.getText().contains(customerObject.getCustomerFullName())) {
                            userOption.click();
                        }
                    }
                    LoggerUtility.infoTest("User enters Customer: " + customerObject.getCustomerFullName() + " Currency: " + currency);
                    clickMethods.clickBttNormal(currencyDropdown);
                    selectMethods.selectObj(currencyDropdown, currency);
                    clickMethods.clickBttNormal(clickProcessButton);
                    LoggerUtility.infoTest("User presses the Process Button");
                    String accountNumber = alertMethods.extractedAlertString();
                    customerObject.addAccountValue(currency, accountNumber);
                    waitMethod.waitToSee();
                    alertMethods.acceptAlert();
                }
                break;
            case "show customers":
                clickMethods.clickBttNormal(showCustomerButton);
                LoggerUtility.infoTest("Navigates to Show Customer!");
                clickMethods.clickBttNormal(searchCustomerBy);
                inputMethods.inputText(searchCustomerBy, customerObject.getPostCodeValue());
                LoggerUtility.infoTest("User enters search Customer: " + customerObject.getPostCodeValue());
                clickMethods.clickBttNormal(deleteSearchedCustomer);
                LoggerUtility.infoTest("User Deletes searched Customer: " + customerObject.getPostCodeValue() + " - " + customerObject.getCustomerFullName());
                break;
            default:
                LoggerUtility.infoTest("Invalid Meniu option: " + menuOption);
                break;
        }
    }
}
