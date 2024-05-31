package bankManagerFlow;

import lombok.Getter;
import lombok.Setter;
import objectData.AddCustomerObject;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BankManager {

    public List<AddCustomerObject> customers = new ArrayList<>();

    public BankManager(List<AddCustomerObject> customers) {
        this.customers = customers;
    }
}
