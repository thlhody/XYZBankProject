package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TransactionsObject extends GeneralObject {

    private String depositAmount;
    private String withdrawAmount;
    private List<String> transactionCurrencies;


    public TransactionsObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
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
}
