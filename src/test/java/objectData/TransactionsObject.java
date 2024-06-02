package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TransactionsObject extends GeneralObject{

    private String depositAmount;
    private String withdrawAmount;
    private List<String> transactionCurrencys;


    public TransactionsObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "deposit":
                    setDepositAmount(testData.get(key));
                    break;
                case "withdraw":
                    setWithdrawAmount(testData.get(key));
                    break;
                case "transactionCurrencys":
                    transactionCurrencys = getPreparedValue(testData.get(key));
                    break;
            }
        }
    }
}