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
    private Integer nextNumber=0;

    public AlertMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void copyAlertMesage() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        PropertyUtility propertyUtility = new PropertyUtility("AddCustomerDataTemp");

        if (alertText.contains("customer id")) {
            String accountInfo = alertText.split(":")[1].trim();
            propertyUtility.updateFile("CustomerID", accountInfo);
            LoggerUtility.infoTest("Temp properties file updated with Customer ID=" + accountInfo);
        }
        if (alertText.contains("Number")) {
            String accountInfoNr = alertText.split(":")[1].trim();
            Integer counter = counter();
            propertyUtility.updateFile("NumberAccount"+counter, accountInfoNr);
            LoggerUtility.infoTest("Temp properties file updated with number Account"+counter+"=" + accountInfoNr);
        }
    }

    public int counter ( ){

        int currentNumber = nextNumber;
        nextNumber = nextNumber %3+1;
        return currentNumber;
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
