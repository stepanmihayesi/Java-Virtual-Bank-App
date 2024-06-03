package com.acadefix;

public interface IBank {
    /**
     * @param accountId
     */
    void addAccount(String accountId);
    /**
     * @param accountId
     * @return
     */
    Account getAccount(String accountId);
    /**
     * @param fromAccountId
     * @param toAccountId
     * @param amount 
     */
    void transfer(String fromAccountId, String toAccountId, double amount);
}
