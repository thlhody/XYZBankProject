package objectData;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
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
}
