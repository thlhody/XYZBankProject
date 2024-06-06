package sharedData;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import sharedData.browser.BrowserFactory;

@Getter
public class SharedData {
    private WebDriver webDriver;

    public void prepareDriver() {
        webDriver = new BrowserFactory().getBrowserInstance();
    }

    public void clearData() {
        webDriver.quit();
    }
}