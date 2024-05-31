package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersListPage extends BasePage {

    private WebDriver webDriver;

    public CustomersListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerBy;
    @FindBy(css = "button[ng-click='deleteCust(cust)'")
    private WebElement deleteSearchedCustomer;


    public void searchCustomer(String text) {
        clickMethods.clickBttNormal(searchCustomerBy);
        inputMethods.inputText(searchCustomerBy, text);
        LoggerUtility.infoTest("User enters search Customer: " + text);
    }

    public void deleteCustomer() {
        clickMethods.clickBttNormal(deleteSearchedCustomer);
    }

    public void searchAndDelete(AddCustomerObject addCustomerObject) {
        searchCustomer(addCustomerObject.getPostCodeValue());
        deleteCustomer();
        LoggerUtility.infoTest("User enters deletes Customer: " + addCustomerObject.getCustomerFullName());
     }
}
