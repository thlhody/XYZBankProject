package propertyUtility;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtility {

    private Properties properties;
    private FileInputStream fileInputStream;

    public PropertyUtility(String path) {
        loadFile(path);
    }

    private void loadFile(String path) {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/inputData/" + path + ".properties");
            properties.load(fileInputStream);
        } catch (Exception e) {

        }
    }

    public Map<String, String> getAllData() {
        Map<String, String> testData = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            testData.put(key, properties.getProperty(key));
        }
        return testData;
    }
}
