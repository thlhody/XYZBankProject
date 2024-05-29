package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends BasePage {
    public AddCustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "input[placeholder='First Name'")
    private WebElement addFirstNameElement;
    @FindBy(css = "input[placeholder='Last Name'")
    private WebElement addLastNameElement;
    @FindBy(css = "input[placeholder='Post Code'")
    private WebElement addPostCodeElement;
    @FindBy(xpath = "//button[text()='Add Customer']")
    private WebElement addCustomerButton;

    public void fillFirstName(String firstNameValue) {
        inputMethods.inputText(addFirstNameElement, firstNameValue);
        LoggerUtility.infoTest("User enter First Name Value:  " + firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        inputMethods.inputText(addLastNameElement, lastNameValue);
        LoggerUtility.infoTest("User enters Last Name Value:  " + lastNameValue);
    }

    public void fillPostalCode(String postCodeValue) {
        inputMethods.inputText(addPostCodeElement, postCodeValue);
        LoggerUtility.infoTest("User enter Post Code Value:  " + postCodeValue);
    }

    public void clickAddCustomer() {
        clickMethods.clickBttNormal(addCustomerButton);
        LoggerUtility.infoTest("User clicks on Add Customer Button");
        alertMethods.copyAlertMesage();
        alertMethods.acceptAlert();
    }

    public void fillAllData(AddCustomerObject addCustomerObject) {
        fillFirstName(addCustomerObject.getFirstNameValue());
        fillLastName(addCustomerObject.getLastNameValue());
        fillPostalCode(addCustomerObject.getPostCodeValue());
        clickAddCustomer();

    }

}
