package bankManagerFlow;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Accounts {

    public Integer customerId;

    public Map<String, List<Integer>> currencyAccountMap;


    public Accounts(Integer customerId, Map<String, List<Integer>> currencyAccountMap) {
        this.customerId = customerId;
        this.currencyAccountMap = currencyAccountMap;
    }
}
