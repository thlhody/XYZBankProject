package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertMethods {
    private WebDriver webDriver;

    public AlertMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String extractedAlertString() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        return alertText.split(":")[1].trim();
    }

    public Integer extractedAlertInteger() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        return Integer.parseInt(alertText.split(":")[1].trim());
    }

    public void acceptAlert() {
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

}
