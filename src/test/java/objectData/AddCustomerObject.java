package objectData;

import java.util.Map;

public class AddCustomerObject {
    private String firstNameValue;
    private String lastNameValue;
    private String postCodeValue;
    private String accountCurrencyDollarValue;
    private String accountCurrencyPoundValue;
    private String accountCurrencyRupeeValue;
    private String accountID;
    private String accountCurrencySelected;
    private String accountCurrencyNumber;


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
                case "accountCurrencyDollar":
                    setAccountCurrencyDollarValue(testData.get(key));
                    break;
                case "accountCurrencyPound":
                    setAccountCurrencyPoundValue(testData.get(key));
                    break;
                case "accountCurrencyRupee":
                    setAccountCurrencyRupeeValue(testData.get(key));
                    break;
                case "accountID":
                    setAccountCurrencyDollarValue(testData.get(key));
                    break;
                case "accountCurrencySelected":
                    setAccountCurrencyPoundValue(testData.get(key));
                    break;
                case "accountCurrencyNumber":
                    setAccountCurrencyRupeeValue(testData.get(key));
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

    public String getAccountCurrencyDollarValue() {
        return accountCurrencyDollarValue;
    }

    public void setAccountCurrencyDollarValue(String accountCurrencyDollarValue) {
        this.accountCurrencyDollarValue = accountCurrencyDollarValue;
    }

    public String getAccountCurrencyPoundValue() {
        return accountCurrencyPoundValue;
    }

    public void setAccountCurrencyPoundValue(String accountCurrencyPoundValue) {
        this.accountCurrencyPoundValue = accountCurrencyPoundValue;
    }

    public String getAccountCurrencyRupeeValue() {
        return accountCurrencyRupeeValue;
    }

    public void setAccountCurrencyRupeeValue(String accountCurrencyRupeeValue) {
        this.accountCurrencyRupeeValue = accountCurrencyRupeeValue;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountCurrencySelected() {
        return accountCurrencySelected;
    }

    public void setAccountCurrencySelected(String accountCurrencySelected) {
        this.accountCurrencySelected = accountCurrencySelected;
    }

    public String getAccountCurrencyNumber() {
        return accountCurrencyNumber;
    }

    public void setAccountCurrencyNumber(String accountCurrencyNumber) {
        this.accountCurrencyNumber = accountCurrencyNumber;
    }
}
