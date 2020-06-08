package academy.learnprogramming;

import java.util.ArrayList;

public class Bank {
    private final String bankName;
    private ArrayList<Branches> branches;


    public Bank(String name) {
        this.bankName = name;
        branches = new ArrayList<>();
    }

    private Branches findBranch(String nameOfBranch) {
        for (Branches toBeChecked : branches) {
            if (nameOfBranch.equals(toBeChecked.getBranchName())) {
                return toBeChecked;
            }
        }
        return null;
    }

    private int findBranchPosition(String nameOfBranch) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().equals(nameOfBranch)) {
                return i;
            }
        }
        return -1;
    }

    private Customer findCustomer(String nameOfCustomer) {
        for (Branches branch : branches) {
            for (int j = 0; j < branch.getCustomers().size(); j++) {
                Customer customerToBeChecked = branch.getCustomers().get(j);
                if (nameOfCustomer.equals(customerToBeChecked.getNameOfCustomer())) {
                    return customerToBeChecked;
                }
            }
        }
        return null;
    }

    public void printBranches() {
        for (Branches branch : branches) {
            System.out.println("\n" + branch.getBranchName());
            branch.printCustomerList();
        }
    }

    public void addNewBranch(String nameOfBranch) {
        Branches branch = new Branches(nameOfBranch);
        if (findBranch(nameOfBranch) == null) {
            branches.add(branch);
        }

    }

    public void addNewCustomerToBranch(String nameOfBranch, String nameOfCustomer, double initialAmount) {
        int positionOfBranch = findBranchPosition(nameOfBranch);

        if (findBranch(nameOfBranch) == null) {
            branches.add(Branches.createBranch(nameOfBranch));
            branches.get(positionOfBranch).addNewCustomer(nameOfCustomer, initialAmount);
        } else {
            branches.get(positionOfBranch).addNewCustomer(nameOfCustomer, initialAmount);
        }
    }

    public void addTransaction(String nameOfCustomer, String nameOfBranch, double amount) {
        int positionOfBranch = findBranchPosition(nameOfBranch);

        if (findBranch(nameOfBranch) == null) {
            System.out.println("No such branch");
        } else {
            if (findCustomer(nameOfCustomer) == null) {
                System.out.println("No such customer");
            } else {
                branches.get(positionOfBranch).addAdditionalTransaction(nameOfCustomer, amount);
            }
        }

    }


}
