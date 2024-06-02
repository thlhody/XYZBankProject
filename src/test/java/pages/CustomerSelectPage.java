package pages;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerSelectPage extends BasePage {
    public CustomerSelectPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "userSelect")
    private WebElement userSelect;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement clickLoginButton;

    public void selectUser(String user) {
        clickMethods.clickBttNormal(userSelect);
        selectMethods.selectObj(userSelect, user);
        LoggerUtility.infoTest("User selects User by full name: " + user);
    }

    public void pressProcess() {
        clickMethods.clickBttNormal(clickLoginButton);
        LoggerUtility.infoTest("User presses the Login Button");
    }

    public void selectUserByName(AddCustomerObject addCustomerObject) {
        selectUser(addCustomerObject.getCustomerFullName());
        pressProcess();
    }
}
