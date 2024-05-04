package sharedData.browser;

import java.util.Map;

public interface BrowserService {

    void openBrowser(Map<String, String> testData);

    Object getBrowserOptions(Map<String, String> testData);
}
