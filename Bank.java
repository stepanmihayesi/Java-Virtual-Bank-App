package com.acadefix;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts;

    /**
     * The Bank class
     */
    public Bank() {
        this.accounts = new HashMap<>();
    }

    /**
     * @param accountId
     */
    public void addAccount(String accountId) {
        if (accounts.containsKey(accountId)) {
            System.out.println("Un compte avec cet numéro existe déjà.");
            return;
        }
        accounts.put(accountId, new Account(accountId));
        System.out.println("Compte " + accountId + " créé avec succès.");
    }

    /**
     * @param accountId
     * @return
     */
    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    /**
     * @param fromAccountId
     * @param toAccountId
     * @param amount
     */
    public void transfer(String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        if (fromAccount == null || toAccount == null) {
            System.out.println("Un ou les deux comptes spécifiés n'existe(nt) pas.");
            return;
        }
        if (amount <= 0 || amount > fromAccount.getBalance()) {
            System.out.println("Montant invalide. Veuillez saisir un nombre positif inférieur ou égal au solde du compte source.");
            return;
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        String transaction = String.format("Transféré : %.2f € de %s à %s", amount, fromAccountId, toAccountId);
        fromAccount.addTransaction(transaction);
        toAccount.addTransaction(transaction);
        System.out.println(transaction);
    }
}
