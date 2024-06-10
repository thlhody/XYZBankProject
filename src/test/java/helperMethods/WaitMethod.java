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
            Integer waitTime = 1000;
            Thread.sleep(waitTime);
            LoggerUtility.infoTest("User Waits: "+ waitTime+"millis");
        } catch (Exception e) {
            LoggerUtility.errorTestCase(e.getMessage());
        }
    }
}
