package tests;

import objectData.AddCustomerObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

public class FirstTestTemporary extends Hooks {

    @Test
    public void metodaTest(){

        //deschid pagina principala
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

        //deschid pagina Bank manager login
        BankManagerPage bankMP = new BankManagerPage(getWebDriver());
        bankMP.navigateToAddCustomerPage();

        //procesez datele din
        PropertyUtility propertyUtilityA = new PropertyUtility("AddCustomerDataA");

        AddCustomerObject addCustomerObjectA = new AddCustomerObject(propertyUtilityA.getAllData());
        AddCustomerPage addCustomerPageA = new AddCustomerPage(getWebDriver());
        addCustomerPageA.fillAllData(addCustomerObjectA);

        bankMP.navigateToOpenAccountPage();

        OpenAccountPage openAccountPage = new OpenAccountPage(getWebDriver());
        openAccountPage.openAccount(addCustomerObjectA);

        bankMP.navigateToCustomersPage();
        CustomersListPage customersListPage = new CustomersListPage(getWebDriver());
        customersListPage.searchAndDelete(addCustomerObjectA);

    }
}
