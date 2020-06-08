package academy.learnprogramming;

import java.util.ArrayList;

public class Branches{
    private String branchName;
    private ArrayList<Customer> customers;



    public Branches(String name) {
        this.branchName = name;
        this.customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getBranchName() {
        return branchName;
    }
    public void printCustomerList(){
        for (Customer customer : customers) {
            System.out.println("\t" + customer.getNameOfCustomer());
            for (int j = 0; j < customer.getTransactions().size(); j++) {
                System.out.println("\t\t" + customer.getTransactions().get(j));
            }

        }
    }

    private Customer findCustomer (String name){
        for (Customer toBeChecked : this.customers) {
            if (name.equals(toBeChecked.getNameOfCustomer())) {
                return toBeChecked;
            }
        }
        return null;
    }

    public void addNewCustomer (String name, double initialAmount){
        if(findCustomer(name) == null){
            this.customers.add(new Customer (name, initialAmount));
        }
    }

    public void addAdditionalTransaction(String nameOfCustomer, double additionalAmount){
        Customer customerWithNewTransaction = findCustomer(nameOfCustomer);
        assert customerWithNewTransaction != null;
        customerWithNewTransaction.addToTransaction(additionalAmount);
    }
    public static Branches createBranch (String name){
        return new Branches(name);
    }

}
