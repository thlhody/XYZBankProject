package objectData;

import java.util.List;
import java.util.Map;

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

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getPostCodeValue() {
        return postCodeValue;
    }

    public void setPostCodeValue(String postCodeValue) {
        this.postCodeValue = postCodeValue;
    }

    public List<String> getAccountCurrencys() {
        return accountCurrencys;
    }

    public void setAccountCurrencys(List<String> accountCurrencys) {
        this.accountCurrencys = accountCurrencys;
    }
}
