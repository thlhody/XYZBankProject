package tests;

import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.HomePage;
import sharedData.Hooks;

public class firstTestComplete extends Hooks {

    @Test
    public void metodaTest(){
        HomePage homePage = new HomePage(getWebDriver());
        BankManagerPage bMP = new BankManagerPage(getWebDriver());

        homePage.navigateToManagerPage();
        bMP.navigateToAddCustomerPage();
        bMP.navigateToOpenAccountPage();
        bMP.navigateToCustomersPage();

    }
}
