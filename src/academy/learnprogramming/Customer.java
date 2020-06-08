package academy.learnprogramming;

import java.util.ArrayList;


public class Customer{
    private String nameOfCustomer;
    private ArrayList<Double> transactions;


    public Customer(String nameOfCustomer, double initialAmount) {
        this.nameOfCustomer = nameOfCustomer;
        this.transactions = new ArrayList<>();
        transactions.add(initialAmount);
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addToTransaction(double initialAmount){
        transactions.add(initialAmount);
    }
}
