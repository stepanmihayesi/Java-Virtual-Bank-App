package com.acadefix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    private double balance;
    private final ArrayList<String> transactionHistory;
    private final String accountId;

    /**
     * @param accountId
     */
    public Account(String accountId) {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.accountId = accountId;
    }

    /**
     * @return
     */
    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    /**
     * @param amount
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Montant invalide. Veuillez saisir un nombre positif.");
            return;
        }

        balance += amount;
        String formattedDateTime = getCurrentDateTime();
        transactionHistory.add("Déposé : " + amount + " € Date : " + formattedDateTime);
        System.out.println("Déposé " + amount + " € sur le compte " + accountId);
    }

    /**
     * @param amount
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Le solde négatif ne peut pas être retiré.");
            return;
        }
        if (amount > balance) {
            System.out.println("Montant invalide. Veuillez saisir un nombre positif inférieur ou égal à votre solde.");
            return;
        }
        System.out.printf("Le montant de %.2f € a été retiré du compte %s%n", amount, accountId);
        balance -= amount;
        String formattedDateTime = getCurrentDateTime();
        transactionHistory.add("Retiré : " + amount + " € Date : " + formattedDateTime);
    }

    /**
     * Method showing the account balance of the Virtual Bank
     */
    public void showAccountBalance() {
        System.out.println("Le solde actuel du compte " + accountId + " est de " + balance + " €");
    }

    /**
     * Method showing transaction history of the Virtual Bank
     */
    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Aucune transaction à afficher pour le compte " + accountId);
            return;
        }
        System.out.println("Historique des transactions du compte " + accountId + " :");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    /**
     * Method to get the Balance of the account in the Virtual Bank
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param transaction
     */
    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    /**
     * @return
     */
    public String getAccountId() {
        return accountId;
    }
}
