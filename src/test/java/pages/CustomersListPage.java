package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomersListPage extends BasePage {

    private WebDriver webDriver;

    public CustomersListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerBy;
    @FindBy(css = "button[ng-click='deleteCust(cust)'")
    private WebElement deleteSearchedCustomer;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> firstNameValue;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> lastNameValue;
    @FindBy(xpath = "//table/tbody/tr/td[3]")
    private List<WebElement> postCodeValue;

    public void searchCustomer(String text) {
        clickMethods.clickBttNormal(searchCustomerBy);
        inputMethods.inputText(searchCustomerBy, text);
        LoggerUtility.infoTest("User enters search Customer: " + text);
        waitMethod.waitToSee();
    }

    public void deleteCustomer() {
        clickMethods.clickBttNormal(deleteSearchedCustomer);
        waitMethod.waitToSee();
    }

    public void searchAndDelete(AddCustomerObject addCustomerObject) {
        searchCustomer(addCustomerObject.getFirstNameValue());
        if (firstNameValue.size() == 1) {
            deleteCustomer();
        }
        inputMethods.clearField(searchCustomerBy);
        searchCustomer(addCustomerObject.getLastNameValue());
        if (lastNameValue.size() == 1) {
            deleteCustomer();
        }
        inputMethods.clearField(searchCustomerBy);
        searchCustomer(addCustomerObject.getPostCodeValue());
        if (postCodeValue.size() == 1) {
            deleteCustomer();
        }
    }
}
