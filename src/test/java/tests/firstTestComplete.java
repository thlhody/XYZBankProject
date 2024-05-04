package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import sharedData.Hooks;

public class firstTestComplete extends Hooks {

    @Test
    public void metodaTest(){
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

    }
}
