package tests;

import objectData.AddCustomerObject;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.Hooks;

import java.util.List;
import java.util.Map;

public class FirstTestTemporary extends Hooks {

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

        AddCustomerObject addCustomerObjectA = new AddCustomerObject(propertyUtilityA.getAllData());
        AddCustomerPage addCustomerPageA = new AddCustomerPage(getWebDriver());

        addCustomerPageA.fillAllData(addCustomerObjectA);

        System.out.println(addCustomerObjectA.getCustomerId()+addCustomerObjectA.getFirstNameValue()+addCustomerObjectA.getLastNameValue()+addCustomerObjectA.getPostCodeValue());
        bankMP.navigateToOpenAccountPage();

        OpenAccountPage openAccountPage = new OpenAccountPage(getWebDriver());
        openAccountPage.openAccount(addCustomerObjectA);
        viewAccountList(addCustomerObjectA);

        bankMP.navigateToCustomersPage();
        CustomersListPage customersListPage = new CustomersListPage(getWebDriver());
        //customersListPage.searchAndDelete(addCustomerObjectA);
    }
    public void viewAccountList(AddCustomerObject addCustomerObject) {
        for (Map.Entry<String, List<Integer>> entry : addCustomerObject.getAccountsCurrencyMap().entrySet()) {
            String bani = entry.getKey();
            List<Integer> accountValues = entry.getValue();

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
