package sharedData.transactions;

import propertyUtility.PropertyUtility;

import java.util.Map;

public class Transactions {

    public void updateTransactionProperties() {

        boolean updateRequired = false;
        PropertyUtility propertyUtility = new PropertyUtility("TransactionDataA");
        Map<String, String> transcationData = propertyUtility.getAllData();

        String transactionCurrencies = System.getProperty("transactionCurrencies");
        String depositAmount = System.getProperty("depositAmount");
        String withdrawAmount = System.getProperty("withdrawAmount");

        transcationData.put("transactionCurrencies",transactionCurrencies);
        transcationData.put("depositAmount",depositAmount);
        transcationData.put("withdrawAmount",withdrawAmount);

        propertyUtility.updateFile(transcationData);
    }
}
