package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import objectData.TransactionsObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class UserPage extends BasePage {
    public UserPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "userSelect")
    private WebElement userSelect;
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

    public void selectAccountNumber(String accNr, String currency) {
        clickMethods.clickBttNormal(accountDropdown);
        selectMethods.selectObj(accountDropdown, accNr);
        LoggerUtility.infoTest("User selects Currency "+currency+" Account Number " + accNr);
    }

    public void depositCurrency() {
        clickMethods.clickBttNormal(depositButton);
        LoggerUtility.infoTest("User clicks on Deposit Button!");
    }

    public void withdrawCurrency() {
        clickMethods.clickBttNormal(withdrawlButton);
        LoggerUtility.infoTest("User clicks on Withdrawl Button!");
    }

    public void enterAmount(String amount) {
        clickMethods.clickBttNormal(enterAmountElement);
        inputMethods.inputText(enterAmountElement, amount);
        clickMethods.clickBttNormal(submitAmount);
        LoggerUtility.infoTest("User entered amount: " + amount);
    }

    public void navigateToTransactionsPage() {
        clickMethods.clickBttNormal(transactionButton);
        LoggerUtility.infoTest("User clicks on Deposit Button!");
    }


    public void depositAndWithdrawl(AddCustomerObject addCustomerObject, TransactionsObject transactionsObject) {
        Map<String, List<String>> accountsCurrencyMap = addCustomerObject.getAccountsCurrencyMap();// preia conturile din addCustomerObject
        List<String> currencies = transactionsObject.getTransactionCurrencies(); // preia valuta din property file
        String amountDeposit = transactionsObject.getDepositAmount(); // preia suma pentru deposit din property file
        String amountWithdraw = transactionsObject.getWithdrawAmount(); // preia suma pentru retragere din property file
        for (String currency : currencies) {
            List<String> accountDetails = accountsCurrencyMap.get(currency);
            if (!accountDetails.isEmpty()) {
                String accountNumber = accountDetails.get(0);
                selectAccountNumber(accountNumber, currency);
                waitMethod.waitToSee();
                depositCurrency();
                waitMethod.waitToSee();
                enterAmount(amountDeposit);
                waitMethod.waitToSee();
                withdrawCurrency();
                waitMethod.waitToSee();
                enterAmount(amountWithdraw);
                waitMethod.waitToSee();
            } else {
                System.out.println("Account info not found!");
            }
        }
    }
}
