package sharedData.transactions;

import loggerUtility.LoggerUtility;
import objectData.AddCustomerObject;
import objectData.GeneralObject;


public class Transactions extends GeneralObject {

    public void updateTransactionProperties(AddCustomerObject transactionsObject) {

        String transactionCurrencies = System.getProperty("transactionCurrencies");
        String depositAmount = System.getProperty("depositAmount");
        String withdrawAmount = System.getProperty("withdrawAmount");

        LoggerUtility.infoTest("GitHub Action values: " + depositAmount + "  " + withdrawAmount);

        String cIcD = System.getProperty("cIcD");

        if (Boolean.parseBoolean(cIcD)) {
            transactionsObject.setDepositAmount(depositAmount);
            transactionsObject.setWithdrawAmount(withdrawAmount);
            transactionsObject.setTransactionCurrencies(getPreparedValue(transactionCurrencies));
        }
    }
}
