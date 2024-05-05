package helperMethods;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import sharedData.Hooks;

public class WaitMethod extends Hooks {
    private WebDriver webDriver;

    public WaitMethod(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitToSee() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            LoggerUtility.errorTestCase(e.getMessage());
        }
    }
}
