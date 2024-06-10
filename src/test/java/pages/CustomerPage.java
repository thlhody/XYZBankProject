package pages;

import loggerUtility.LoggerUtility;
import objectData.CustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class CustomerPage extends BasePage {
    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "userSelect")
    private WebElement userSelect;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement clickLoginButton;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement clickLogoutButton;
    @FindBy(css = "button[ng-click='transactions()']")
    private WebElement transactionButton;
    @FindBy(css = "button[ng-click='deposit()']")
    private WebElement depositButton;
    @FindBy(css = "button[ng-click='withdrawl()']")
    private WebElement withdrawlButton;
    @FindBy(css = "input[placeholder='amount'")
    private WebElement enterAmountElement;
    @FindBy(css = "button[type='submit']")
    private WebElement submitAmount;
    @FindBy(id = "accountSelect")
    private WebElement accountDropdown;


    public void selectUserByName(CustomerObject customerObject) {
        clickMethods.clickBttNormal(userSelect);
        selectMethods.selectObj(userSelect, customerObject.getCustomerFullName());
        LoggerUtility.infoTest("User selects User by full name: " + customerObject.getCustomerFullName());
        clickMethods.clickBttNormal(clickLoginButton);
        LoggerUtility.infoTest("User presses the Login Button");
    }

    public void makeCustomerTransactions(CustomerObject customerObject) {
        selectUserByName(customerObject);

        Map<String, List<String>> accountsCurrencyMap = customerObject.getAccountsCurrencyMap();// preia conturile din addCustomerObject
        List<String> currencies = customerObject.getTransactionCurrencies(); // preia valuta din property file
        String amountDeposit = customerObject.getDepositAmount(); // preia suma pentru deposit din property file
        String amountWithdraw = customerObject.getWithdrawAmount(); // preia suma pentru retragere din property file

        for (String currency : currencies) {
            List<String> accountDetails = accountsCurrencyMap.get(currency);
            if (!accountDetails.isEmpty()) {
                String accountNumber = accountDetails.get(0);
                clickMethods.clickBttNormal(accountDropdown);
                selectMethods.selectObj(accountDropdown, accountNumber);
                LoggerUtility.infoTest("User selects Currency " + currency + " Account Number " + accountNumber);
                waitMethod.waitToSee();
                clickMethods.clickBttNormal(depositButton);
                LoggerUtility.infoTest("User clicks on Deposit Button!");
                waitMethod.waitToSee();
                enterAmount(amountDeposit);
                LoggerUtility.infoTest("User made a deposit!");
                waitMethod.waitToSee();
                clickMethods.clickBttNormal(withdrawlButton);
                LoggerUtility.infoTest("User clicks on Withdraw Button!");
                waitMethod.waitToSee();
                enterAmount(amountWithdraw);
                LoggerUtility.infoTest("User made a withdraw!");
                waitMethod.waitToSee();
            } else {
                System.out.println("Account info not found!");
            }
        }
        navigateToTransactionsPage();
        waitMethod.waitToSee();
        clickMethods.clickBttNormal(clickLogoutButton);
    }

    public void enterAmount(String amount) {
        clickMethods.clickBttNormal(enterAmountElement);
        inputMethods.inputText(enterAmountElement, amount);
        clickMethods.clickBttNormal(submitAmount);
        LoggerUtility.infoTest("User entered amount: " + amount);
    }

    public void navigateToTransactionsPage() {
        clickMethods.clickBttNormal(transactionButton);
        LoggerUtility.infoTest("User opens Transcation Page!");
    }

}

