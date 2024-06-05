package sharedData.transactions;

import loggerUtility.LoggerUtility;
import objectData.GeneralObject;
import objectData.TransactionsObject;


public class Transactions extends GeneralObject {

    public void updateTransactionProperties(TransactionsObject transactionsObject) {

        String transactionCurrencies = System.getProperty("transactionCurrencies");
        String depositAmount = System.getProperty("depositAmount");
        String withdrawAmount = System.getProperty("withdrawAmount");

        LoggerUtility.infoTest("GitHub Action values: " + depositAmount + "  " + withdrawAmount);

        String cIcD = System.getProperty("cIcD");//l-am folosit ca sa pot sa folosesc programul si offline si online

        if (Boolean.parseBoolean(cIcD)) {
            transactionsObject.setDepositAmount(depositAmount);
            transactionsObject.setWithdrawAmount(withdrawAmount);
            transactionsObject.setTransactionCurrencies(getPreparedValue(transactionCurrencies));
        }
    }
}
