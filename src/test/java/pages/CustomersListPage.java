package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersListPage {

    private WebDriver webDriver;

    public CustomersListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomer;
    @FindBy(css = "button[ng-click='deleteCust(cust)'")
    private WebElement selectCurrencyElement;

    public void searchCustomer(){

    }
}
