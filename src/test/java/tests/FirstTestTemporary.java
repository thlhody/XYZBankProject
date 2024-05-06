package tests;

import objectData.AddCustomerObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

public class FirstTestTemporary extends Hooks {

    @Test
    public void metodaTest(){

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

        BankManagerPage bankMP = new BankManagerPage(getWebDriver());


        bankMP.navigateToAddCustomerPage();
        PropertyUtility propertyUtilityA = new PropertyUtility("AddCustomerDataA");
        AddCustomerObject addCustomerObjectA = new AddCustomerObject(propertyUtilityA.getAllData());
        AddCustomerPage addCustomerPageA = new AddCustomerPage(getWebDriver());
        addCustomerPageA.fillAllData(addCustomerObjectA);

        bankMP.navigateToOpenAccountPage();
        OpenAccountPage openAccountPage = new OpenAccountPage(getWebDriver());
        openAccountPage.openAccount(addCustomerObjectA);

        bankMP.navigateToAddCustomerPage();
        PropertyUtility propertyUtilityB = new PropertyUtility("AddCustomerDataB");
        AddCustomerObject addCustomerObjectB = new AddCustomerObject(propertyUtilityB.getAllData());
        AddCustomerPage addCustomerPageB = new AddCustomerPage(getWebDriver());
        addCustomerPageB.fillAllData(addCustomerObjectB);

        bankMP.navigateToOpenAccountPage();
        OpenAccountPage openAccountPageB = new OpenAccountPage(getWebDriver());
        openAccountPageB.openAccount(addCustomerObjectB);

        bankMP.navigateToCustomersPage();
        CustomersListPage customersListPage = new CustomersListPage(getWebDriver());
        customersListPage.searchAndDelete(addCustomerObjectA);

    }
}
