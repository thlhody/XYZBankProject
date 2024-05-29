package bankManagerFlow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BankManager {

    public List<Customer> customers = new ArrayList<>();

    public BankManager(List<Customer> customers) {
        this.customers = customers;
    }
}
