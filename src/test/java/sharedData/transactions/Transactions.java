package sharedData.transactions;

import loggerUtility.LoggerUtility;
import objectData.GeneralObject;
import objectData.TransactionsObject;
import propertyUtility.PropertyUtility;

import java.util.List;
import java.util.Map;

public class Transactions extends GeneralObject {

    public void updateTransactionProperties(Map<String, String> transactionData) {


        String transactionCurrencies = System.getProperty("transactionCurrencies");
        String depositAmount = System.getProperty("depositAmount");
        String withdrawAmount = System.getProperty("withdrawAmount");
        TransactionsObject transactionsObject = new TransactionsObject(transactionData);
        LoggerUtility.infoTest("update"+ depositAmount+"  "+withdrawAmount);

        String cIcD = System.getProperty("cIcD");

        if (Boolean.parseBoolean(cIcD)) {
            transactionsObject.setDepositAmount(depositAmount);
            transactionsObject.setWithdrawAmount(withdrawAmount);
            transactionsObject.setTransactionCurrencys(getPreparedValue(transactionCurrencies));
        }
    }
}
