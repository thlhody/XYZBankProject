package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver webDriver;
    public ClickButton clickButton;
    //public - declaram toate metodele care le vom folosi din helpermethods

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        clickButton = new ClickButton(webDriver);
        //creem contructor pentru toate metodele care le declaram mai sus
        PageFactory.initElements(webDriver,this);
    }
}
