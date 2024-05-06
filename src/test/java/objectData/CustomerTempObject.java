package objectData;

import java.util.Map;

public class CustomerTempObject {
    private String accountID;
    private String NumberAccount0;
    private String NumberAccount1;
    private String NumberAccount2;

    public CustomerTempObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "accountID":
                    setAccountID(testData.get(key));
                    break;
                case "NumberAccount0":
                    setNumberAccount0(testData.get(key));
                    break;
                case "NumberAccount1":
                    setNumberAccount1(testData.get(key));
                    break;
                case "NumberAccount2":
                    setNumberAccount2(testData.get(key));
                    break;
            }
        }
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getNumberAccount0() {
        return NumberAccount0;
    }

    public void setNumberAccount0(String numberAccount0) {
        this.NumberAccount0 = numberAccount0;
    }

    public String getNumberAccount1() {
        return NumberAccount1;
    }

    public void setNumberAccount1(String numberAccount1) {
        this.NumberAccount1 = numberAccount1;
    }

    public String getNumberAccount2() {
        return NumberAccount2;
    }

    public void setNumberAccount2(String numberAccount2) {
        this.NumberAccount2 = numberAccount2;
    }
}
