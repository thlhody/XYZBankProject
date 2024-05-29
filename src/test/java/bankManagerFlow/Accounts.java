package bankManagerFlow;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Accounts {

    public Integer customerId;

    public Map<String, String> currencyAccountMap;


    public Accounts(Integer customerId, Map<String, String> currencyAccountMap) {
        this.customerId = customerId;
        this.currencyAccountMap = currencyAccountMap;
    }
}
