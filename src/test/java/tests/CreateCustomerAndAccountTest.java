package tests;

import objectData.AddCustomerObject;
import objectData.TransactionsObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;
import sharedData.transactions.Transactions;

import java.util.List;
import java.util.Map;

public class CreateCustomerAndAccountTest extends Hooks {

    @Test
    public void metodaTest(){

        //deschid pagina principala
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToManagerPage();

        //deschid pagina Bank manager login
        BankManagerPage bankMP = new BankManagerPage(getWebDriver());
        bankMP.navigateToAddCustomerPage();

        //procesez datele din properties files
        PropertyUtility propertyUtilityA = new PropertyUtility("AddCustomerDataA");
        //creeze user
        AddCustomerObject addCustomerObjectA = new AddCustomerObject(propertyUtilityA.getAllData());
        AddCustomerPage addCustomerPageA = new AddCustomerPage(getWebDriver());
        addCustomerPageA.fillAllData(addCustomerObjectA);

        //deschid pagina Open Account si creez conturile
        bankMP.navigateToOpenAccountPage();
        OpenAccountPage openAccountPage = new OpenAccountPage(getWebDriver());
        openAccountPage.openAccount(addCustomerObjectA);

        //deschid Customer Login
        homePage.navigateToHomePage();
        homePage.navigateToCustomerPage();
        CustomerSelectPage customerSelectPage = new CustomerSelectPage(getWebDriver());
        customerSelectPage.selectUserByName(addCustomerObjectA);

        PropertyUtility propertyUtilityB = new PropertyUtility("TransactionDataA");
        Transactions transactions = new Transactions();
        transactions.updateTransactionProperties(propertyUtilityB.getAllData());

        PropertyUtility propertyUtilityC = new PropertyUtility("TransactionDataA");
        TransactionsObject transactionsObject = new TransactionsObject(propertyUtilityC.getAllData());
        UserPage userPage = new UserPage(getWebDriver());
        userPage.depositAndWithdrawl(addCustomerObjectA,transactionsObject);

        //deschid pagina Customers si sterg contul creat
//        bankMP.navigateToCustomersPage();
//        CustomersListPage customersListPage = new CustomersListPage(getWebDriver());
//        customersListPage.searchAndDelete(addCustomerObjectA);

        viewAccountList(addCustomerObjectA);
    }









    public void viewAccountList(AddCustomerObject addCustomerObject) {
        for (Map.Entry<String, List<String>> entry : addCustomerObject.getAccountsCurrencyMap().entrySet()) {
            String bani = entry.getKey();
            List<String> accountValues = entry.getValue();

            if(accountValues != null && !accountValues.isEmpty()){
                System.out.println("Account values for " + bani + ":");
                for(int i=0; i<accountValues.size(); i++) {
                    System.out.print(","+ accountValues.get(i));
                }
                System.out.println();
            }else{
                System.out.println("no account value for: "+bani);
            }
        }
    }
}
