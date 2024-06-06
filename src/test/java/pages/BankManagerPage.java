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

    public void navigateToAddCustomer() {
        clickMethods.clickBttNormal(addCustomerElement);
        LoggerUtility.infoTest("User clicks on Add Customer Button!");
    }

    public void fillFirstName(String firstNameValue) {
        inputMethods.inputText(addFirstNameElement, firstNameValue);
        LoggerUtility.infoTest("User enter First Name Value:  " + firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        inputMethods.inputText(addLastNameElement, lastNameValue);
        LoggerUtility.infoTest("User enters Last Name Value:  " + lastNameValue);
    }

    public void fillPostalCode(String postCodeValue) {
        inputMethods.inputText(addPostCodeElement, postCodeValue);
        LoggerUtility.infoTest("User enter Post Code Value:  " + postCodeValue);
    }

    public void clickAddCustomer() {
        clickMethods.clickBttNormal(addCustomerButton);
        LoggerUtility.infoTest("User clicks on Add Customer Button");
    }

    public void createCustomer(CustomerObject customerObject) {
        navigateToAddCustomer();
        fillFirstName(customerObject.getFirstNameValue());
        fillLastName(customerObject.getLastNameValue());
        fillPostalCode(customerObject.getPostCodeValue());
        clickAddCustomer();
        customerObject.setCustomerId(alertMethods.extractedAlertInteger());
        alertMethods.acceptAlert();
    }

    public void navigateToOpenAccount() {
        clickMethods.clickBttNormal(openAccountButton);
        LoggerUtility.infoTest("User clicks on Open Account Button!");
    }

    public void selectCustomer(String value) {
        clickMethods.clickBttNormal(selectCustomerElement);
        for (WebElement userOption : findUserByID) {
            if (userOption.getText().contains(value)) {
                userOption.click();
                break;
            }
        }
        LoggerUtility.infoTest("User enters Customer " + value);
    }

    public void selectCurrency(String currency) {
        clickMethods.clickBttNormal(currencyDropdown);
        selectMethods.selectObj(currencyDropdown, currency);
        LoggerUtility.infoTest("User selects Currency: " + currency);
    }

    public void pressProcess() {
        clickMethods.clickBttNormal(clickProcessButton);
        LoggerUtility.infoTest("User presses the Process Button");
    }

    public void addAccountCurrenyToUser(CustomerObject customerObject) {
        navigateToOpenAccount();
        for (String currency : customerObject.getInputCurrency()) {
            selectCustomer(customerObject.getCustomerFullName());
            selectCurrency(currency);
            pressProcess();
            String accountNumber = alertMethods.extractedAlertString();
            customerObject.addAccountValue(currency, accountNumber);
            alertMethods.acceptAlert();
        }
    }

    public void navigateToCustomers() {
        clickMethods.clickBttNormal(showCustomerButton);
        LoggerUtility.infoTest("User clicks on Show Customer Button!");
    }

    public void searchCustomer(String text) {
        clickMethods.clickBttNormal(searchCustomerBy);
        inputMethods.inputText(searchCustomerBy, text);
        LoggerUtility.infoTest("User enters search Customer: " + text);
    }

    public void deleteCustomer() {
        clickMethods.clickBttNormal(deleteSearchedCustomer);
    }

    public void removeCustomerAccount(CustomerObject customerObject) {
        navigateToCustomers();
        searchCustomer(customerObject.getPostCodeValue());
        deleteCustomer();
        LoggerUtility.infoTest("User enters deletes Customer: " + customerObject.getCustomerFullName());
    }

}
