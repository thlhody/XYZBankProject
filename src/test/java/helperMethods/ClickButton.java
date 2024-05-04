package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickButton {
    private WebDriver webDriver;

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
}
