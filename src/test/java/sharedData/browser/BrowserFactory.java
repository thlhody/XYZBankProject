package sharedData.browser;

import org.openqa.selenium.WebDriver;
import propertyUtility.PropertyUtility;

import java.util.Map;

public class BrowserFactory {

    public WebDriver getBrowserInstance() {
        PropertyUtility propertyUtility = new PropertyUtility("ATFData");
        Map<String, String> browserData = propertyUtility.getAllData();
        String cIcD = System.getProperty("cIcD");
        String browser = System.getProperty("browser");
        if (Boolean.parseBoolean(cIcD)) {
            browserData.put("headless", "--headless=new");
        } else {
            browser = browserData.get("browser");
        }

        switch (browser) {
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser(browserData);
                return chromeService.getWebDriver();
            case "edge":
                EdgeService edgeService = new EdgeService();
                edgeService.openBrowser(browserData);
                return edgeService.getWebDriver();
        }
        return null;
    }
}
