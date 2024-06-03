package com.acadefix;

public interface IAccount {
    /**
     * @param amount
     */
    void deposit(double amount);
    /**
     * @param amount
     */
    void withdraw(double amount);
    /**
     * Method showing the account balance of the Virtual Bank
     */
    void showAccountBalance();
    /**
     * Method showing transaction history of the Virtual Bank
     */
    void showTransactionHistory();
    /**
     * Method to get the Balance of the account in the Virtual Bank
     * @return
     */
    double getBalance();
    /**
     * @param transaction
     */
    void addTransaction(String transaction);
}
