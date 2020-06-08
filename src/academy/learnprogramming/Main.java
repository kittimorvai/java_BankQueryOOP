package academy.learnprogramming;

public class Main {

    private static Branches branch1 = new Branches("");
    private static Bank bank1 = new Bank("");

    public static void main(String[] args) {
            bank1.addNewBranch("branch1");
            bank1.addNewBranch("branch2");
            bank1.addNewBranch("branch3");
            bank1.addNewCustomerToBranch("branch1", "customer1", 300.0);
            bank1.addNewCustomerToBranch("branch2", "customer2", 300.0);
            bank1.addNewCustomerToBranch("branch3", "customer2", 300.0);
            bank1.addNewCustomerToBranch("branch1", "customer2", 300.0);
            bank1.addNewCustomerToBranch("branch1", "customer2", 300.0);

            bank1.addTransaction("customer1", "branch1", 300.0);

            branch1.printCustomerList();

            bank1.printBranches();
    }
}
