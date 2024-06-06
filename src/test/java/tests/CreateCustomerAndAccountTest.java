package tests;

import objectData.AddCustomerObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;
import sharedData.transactions.Transactions;

import java.util.List;
import java.util.Map;

public class CreateCustomerAndAccountTest extends Hooks {

    @Test
    public void metodaTest() {

        //deschid pagina principala
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

        //procesez datele din properties files si le adaug in obiect
        PropertyUtility propertyUtilityA = new PropertyUtility("AddCustomerDataA");
        AddCustomerObject addCustomerObjectA = new AddCustomerObject(propertyUtilityA.getAllData());

        //deschid pagina Bank manager login
        BankManagerPage bankMP = new BankManagerPage(getWebDriver());
        //creeze user
        bankMP.createCustomer(addCustomerObjectA);
        //deschid pagina Open Account si creez conturile cu valuta
        bankMP.addAccountCurrenyToUser(addCustomerObjectA);
        //deschid Customer Login
        homePage.navigateToHomePage();
        homePage.navigateToCustomerPage();

        CustomerPage customerPage = new CustomerPage(getWebDriver());
        //fac tranzactii pe conturile deschise
        customerPage.makeCustomerTransactions(addCustomerObjectA);

        homePage.navigateToHomePage();
        homePage.navigateToManagerPage();
        bankMP.removeCustomerAccount(addCustomerObjectA);

    }

    public void viewAccountList(AddCustomerObject addCustomerObject) {
        for (Map.Entry<String, List<String>> entry : addCustomerObject.getAccountsCurrencyMap().entrySet()) {
            String bani = entry.getKey();
            List<String> accountValues = entry.getValue();

            if (accountValues != null && !accountValues.isEmpty()) {
                System.out.println("Account values for " + bani + ":");
                for (String accountValue : accountValues) {
                    System.out.print("," + accountValue);
                }
                System.out.println();
            } else {
                System.out.println("no account value for: " + bani);
            }
        }
    }
}
