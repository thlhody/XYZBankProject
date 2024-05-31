package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMethods {
    private WebDriver webDriver;

    public SelectMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectObj(WebElement element, String text) {
        Select selectObject = new Select(element);
        selectObject.selectByVisibleText(text);
    }
}
