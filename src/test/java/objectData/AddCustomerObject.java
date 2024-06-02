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
    private String customerFullName; // creat intern pentru al folosi la nevoie
    private List<String> inputCurrency; //din properties files dupa parsare o lista cu currency in Dollar,Pound,Value...
    private Integer customerId;//din alerta dupa creare user

    private Map<String, List<String>> accountsCurrencyMap = new HashMap<>(); // din alerta dupa adaugare conturi

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

    private void prepareAccountMap() {
        for(String currency : inputCurrency) {
            accountsCurrencyMap.put(currency, new ArrayList<>());
        }
    }

    public void addAccountValue(String currency, String value) {
        if (accountsCurrencyMap.containsKey(currency)) {
            List<String> accountList = accountsCurrencyMap.get(currency);
            if (accountList != null) {
                accountList.add(value);
            }
        }
    }

    private void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
        this.updateCustomerFullName();
    }

    private void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
        this.updateCustomerFullName();
    }

    private void updateCustomerFullName() {
        this.customerFullName = this.firstNameValue + " " + this.lastNameValue;
    }

}
