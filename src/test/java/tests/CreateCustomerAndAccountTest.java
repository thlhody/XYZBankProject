package tests;

import objectData.CustomerObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

public class CreateCustomerAndAccountTest extends Hooks {

    @Test
    public void metodaTest() {

        //deschid pagina principala
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

        //procesez datele din properties files si le adaug in obiect
        PropertyUtility propertyUtilityA = new PropertyUtility("AddCustomerDataA");
        CustomerObject customerObjectA = new CustomerObject(propertyUtilityA.getAllData());

        //deschid pagina Bank manager login
        BankManagerPage bankMP = new BankManagerPage(getWebDriver());
        //creeze user
        bankMP.navigateTo("add customer", customerObjectA);
        //deschid pagina Open Account si creez conturile cu valuta
        bankMP.navigateTo("open account", customerObjectA);
        //deschid Customer Login
        homePage.navigateToHomePage();
        homePage.navigateToCustomerPage();

        CustomerPage customerPage = new CustomerPage(getWebDriver());
        //fac tranzactii pe conturile deschise
        customerPage.makeCustomerTransactions(customerObjectA);

        homePage.navigateToHomePage();
        homePage.navigateToManagerPage();
        bankMP.navigateTo("show customers", customerObjectA);

    }
}
