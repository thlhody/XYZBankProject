package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
public class AddCustomerObject extends GeneralObject {

    private String firstNameValue;
    private String lastNameValue;
    private String postCodeValue;
    private List<String> accountCurrencys;

    public AddCustomerObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "firstNameValue":
                    setFirstNameValue(testData.get(key));

                    break;
                case "lastNameValue":
                    setLastNameValue(testData.get(key));
                    break;
                case "postCodeValue":
                    setPostCodeValue(testData.get(key));
                    break;
                case "accountCurrencys":
                    accountCurrencys = getPreparedValue(testData.get(key));
                    break;
            }
        }
    }
}
