package bankManagerFlow;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Customer {

    public String firstName;
    public String lastName;
    public String postCode;
    public Integer customerId;
    public List<Accounts> accounts;

    public Customer(String firstName, String lastName, String postCode, List<Accounts> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
        this.accounts = accounts;
    }

    public Customer(String firstName, String lastName, String postCode, Integer customerId, List<Accounts> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
        this.customerId = customerId;
        this.accounts = accounts;
    }
}
