package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputMethods {
    private WebDriver webDriver;

    public InputMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clearField(WebElement element) {
        element.clear();
    }
}

