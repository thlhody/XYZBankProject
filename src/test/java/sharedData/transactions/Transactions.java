package sharedData.transactions;

import propertyUtility.PropertyUtility;

import java.util.Map;

public class Transactions {

    public void updateTransactionProperties() {

        PropertyUtility propertyUtility = new PropertyUtility("TransactionDataA");
        Map<String, String> transactionData = propertyUtility.getAllData();

        String transactionCurrencies = System.getProperty("transactionCurrencies");
        String depositAmount = System.getProperty("depositAmount");
        String withdrawAmount = System.getProperty("withdrawAmount");
        if (transactionData.isEmpty() && transactionCurrencies != null && depositAmount != null && withdrawAmount != null) {
            transactionData.put("transactionCurrencies", transactionCurrencies);
            transactionData.put("depositAmount", depositAmount);
            transactionData.put("withdrawAmount", withdrawAmount);

            propertyUtility.updateFile(transactionData);
        }
        propertyUtility.updateFile(transactionData);
    }
}
