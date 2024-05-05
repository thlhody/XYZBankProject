package helperMethods;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import propertyUtility.PropertyUtility;

import java.time.Duration;

public class AlertMethods {
    private WebDriver webDriver;

    public AlertMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void copyAlertMesage() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        LoggerUtility.infoTest(alertText);
        PropertyUtility pU = new PropertyUtility("AddCustomerDataTemp");
        if (alertText.contains("customer id")) {
            String alertInfo = alertText.replaceAll("Customer added successfully with customer id :", "");
            pU.updateFile("accountID", alertInfo);
            LoggerUtility.infoTest(alertInfo);
        }
        if (alertText.contains("Number")) {
            String alertInfoA = alertText.replaceAll("Account created successfully with account Number :", "");
            pU.updateFile("accountCurrencyNumber", alertInfoA);
            LoggerUtility.infoTest(alertInfoA);
        }
    }

    public void acceptAlert() {
        Alert alert = webDriver.switchTo().alert();
        LoggerUtility.infoTest(alert.getText());
        alert.accept();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
