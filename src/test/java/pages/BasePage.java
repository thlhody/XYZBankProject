package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver webDriver;
    public ClickMethods clickMethods;
    public InputMethods inputMethods;
    public WaitMethod waitMethod;
    public AlertMethods alertMethods;
    public SelectMethods selectMethods;

    public BasePage(WebDriver webDriver) {

        this.webDriver = webDriver;
        clickMethods = new ClickMethods(webDriver);
        inputMethods = new InputMethods(webDriver);
        waitMethod = new WaitMethod(webDriver);
        alertMethods = new AlertMethods(webDriver);
        selectMethods = new SelectMethods(webDriver);
        PageFactory.initElements(webDriver, this);
    }

}
