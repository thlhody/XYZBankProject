package sharedData;

import loggerUtility.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    private String testName;

    @BeforeMethod
    public void prepareEnviroment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        prepareDriver();
        LoggerUtility.infoTest("The driver is opened with succes!");

    }

    @AfterMethod
    public void clearEnviroment(ITestResult result) {
        if (!result.isSuccess()) {
            LoggerUtility.errorTestCase(result.getThrowable().getMessage());
        }
        testName = this.getClass().getSimpleName();
        clearData();
        LoggerUtility.infoTest("The driver is closed with succes!");
        LoggerUtility.finishTestCase(testName);
    }
}