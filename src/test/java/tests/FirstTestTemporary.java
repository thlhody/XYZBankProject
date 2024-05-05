package tests;

import objectData.AddCustomerObject;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.HomePage;
import pages.OpenAccountPage;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

public class FirstTestTemporary extends Hooks {

    @Test
    public void metodaTest(){

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

        BankManagerPage bankMP = new BankManagerPage(getWebDriver());
        bankMP.navigateToAddCustomerPage();

        PropertyUtility propertyUtility = new PropertyUtility("AddCustomerDataA");
        AddCustomerObject addCustomerObject = new AddCustomerObject(propertyUtility.getAllData());

        AddCustomerPage addCustomerPage = new AddCustomerPage(getWebDriver());
        addCustomerPage.fillAllData(addCustomerObject);
        bankMP.navigateToOpenAccountPage();

        OpenAccountPage openAccountPage = new OpenAccountPage(getWebDriver());
        openAccountPage.openAccount(addCustomerObject);

    }
}
