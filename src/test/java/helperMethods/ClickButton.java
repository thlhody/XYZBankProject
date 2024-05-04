package helperMethods;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sharedData.Hooks;

public class ClickButton extends Hooks {
    public WebDriver webDriver;

    public ClickButton(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickBttNormal(WebElement element) {
        element.click();
    }

    public void clickBttForce(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", element);
    }

    public void clickButtonWait() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LoggerUtility.errorTestCase(e.getMessage());
        }
    }
}
