package com.acadefix;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBienvenue sur l'application La banque virtuelle");
            System.out.println("1. Liste des comptes");
            System.out.println("2. Créer un nouveau compte");
            System.out.println("3. Déposer de l'argent");
            System.out.println("4. Retirer de l'argent");
            System.out.println("5. Consulter le solde du compte");
            System.out.println("6. Afficher l'historique des transactions");
            System.out.println("7. Transférer de l'argent");
            System.out.println("8. Quitter l'application");
            System.out.print("Choisissez une option : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bank.listUserAccounts();
                    break;
                case 2:
                    System.out.print("Entrez le numéro du nouveau compte : ");
                    String newAccountId = scanner.next();
                    bank.addAccount(newAccountId);
                    break;
                case 3:
                    System.out.print("Entrez le numéro du compte : ");
                    String depositAccountId = scanner.next();
                    System.out.print("Entrez le montant à déposer (€) : ");
                    double depositAmount = scanner.nextDouble();
                    Account depositAccount = bank.getAccount(depositAccountId);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;
                case 4:
                    System.out.print("Entrez le numéro du compte : ");
                    String withdrawAccountId = scanner.next();
                    System.out.print("Entrez le montant à retirer (€) : ");
                    double withdrawAmount = scanner.nextDouble();
                    Account withdrawAccount = bank.getAccount(withdrawAccountId);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;
                case 5:
                    System.out.print("Entrez le numéro du compte : ");
                    String balanceAccountId = scanner.next();
                    Account balanceAccount = bank.getAccount(balanceAccountId);
                    if (balanceAccount != null) {
                        balanceAccount.showAccountBalance();
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;
                case 6:
                    System.out.print("Entrez le numéro du compte : ");
                    String historyAccountId = scanner.next();
                    Account historyAccount = bank.getAccount(historyAccountId);
                    if (historyAccount != null) {
                        historyAccount.showTransactionHistory();
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;
                case 7:
                    System.out.print("Entrez le numéro du compte source : ");
                    String fromAccountId = scanner.next();
                    System.out.print("Entrez le numéro du compte destinataire : ");
                    String toAccountId = scanner.next();
                    System.out.print("Entrez le montant à transférer (€) : ");
                    double transferAmount = scanner.nextDouble();
                    try {
                        bank.transfer(fromAccountId, toAccountId, transferAmount);
                    } catch (Exception e ) {
                        System.out.println("Une exception s'est produite. Voici son message : "+e);
                    }
                    break;
                case 8:
                    exit = true;
                    System.out.println("Merci d'utiliser l'application La banque virtuelle. Au revoir.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}
