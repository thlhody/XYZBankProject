package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    private WebDriver webDriver;

    public AlertMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String extractedAlertString() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        String alertInfo = alertText.split(":")[1].trim();
        return alertInfo;
    }

    public Integer extractedAlertInteger() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Integer accountID = Integer.parseInt(alertText.split(":")[1].trim());
        return accountID;
    }

    public void acceptAlert() {
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
