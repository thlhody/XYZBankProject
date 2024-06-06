package objectData;

import loggerUtility.LoggerUtility;
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
    private String depositAmount;
    private String withdrawAmount;
    private List<String> transactionCurrencies;

    private Map<String, List<String>> accountsCurrencyMap = new HashMap<>(); // din alerta dupa adaugare conturi

    public AddCustomerObject(Map<String, String> testData) {

        prepareObject(testData);
        updateTransactionProperties();
        prepareAccountMap();
        updateCustomerFullName();

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
                case "depositAmount":
                    setDepositAmount(testData.get(key));
                    break;
                case "withdrawAmount":
                    setWithdrawAmount(testData.get(key));
                    break;
                case "transactionCurrencies":
                    transactionCurrencies = getPreparedValue(testData.get(key));
                    break;

            }
        }
    }

    private void prepareAccountMap() {
        for (String currency : inputCurrency) {
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

    private void updateCustomerFullName() {
        this.customerFullName = this.firstNameValue + " " + this.lastNameValue;
    }

    public void updateTransactionProperties() {

        String transactionCurrencies = System.getProperty("transactionCurrencies");
        String depositAmount = System.getProperty("depositAmount");
        String withdrawAmount = System.getProperty("withdrawAmount");

        LoggerUtility.infoTest("GitHub Action values: " + depositAmount + "  " + withdrawAmount);

        String cIcD = System.getProperty("cIcD");

        if (Boolean.parseBoolean(cIcD)) {
            setDepositAmount(depositAmount);
            setWithdrawAmount(withdrawAmount);
            setTransactionCurrencies(getPreparedValue(transactionCurrencies));
        }
    }

}
