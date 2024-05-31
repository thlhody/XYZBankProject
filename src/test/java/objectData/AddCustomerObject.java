package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AddCustomerObject extends GeneralObject {

    private String firstNameValue;//din properties files
    private String lastNameValue;//din properties files
    private String postCodeValue;//din properties files
    private String customerFullName;
    private List<String> inputCurrency;//din properties files dupa parsare o lista cu currency in Dollar,Pound,Value
    private Integer customerId;//din alerta dupa creeare user

    private Map<String, List<Integer>> accountsCurrencyMap = new HashMap<>(); // din alerta dupa adaugare conturi

    public AddCustomerObject(Map<String, String> testData) {
        prepareObject(testData);
        prepareAccountMap();
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
                case "inputCurrency":
                    inputCurrency = getPreparedValue(testData.get(key));
                    break;
            }
        }
    }

    public void prepareAccountMap() {
        accountsCurrencyMap.put("Dollar", new ArrayList<>());
        accountsCurrencyMap.put("Pound", new ArrayList<>());
        accountsCurrencyMap.put("Rupee", new ArrayList<>());
    }

    public void addAccountValue(String currency, Integer value) {
        if (accountsCurrencyMap.containsKey(currency)) {
            List<Integer> accountList = accountsCurrencyMap.get(currency);
            if (accountList != null) {
                accountList.add(value);
            }
        }
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
        this.updateCustomerFullName();
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
        this.updateCustomerFullName();
    }

    private void updateCustomerFullName() {
        this.customerFullName = this.firstNameValue + " " + this.lastNameValue;
    }

}
