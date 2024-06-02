import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private double balance;
    private final ArrayList<String> transactionHistory;

    public App() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Montant invalide. Veuillez saisir un nombre positif.");
            return;
        }

        balance += amount;
        String formattedDateTime = getCurrentDateTime();
        transactionHistory.add("Déposé : " + amount + " € Date : " + formattedDateTime);
        System.out.println("Déposé " + amount + " €");
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Le solde négatif ne peut pas être retiré.");
            return;
        }
        System.out.printf("Le montant de %.2f a été retiré du compte%n",amount);
        balance -= amount;
        String formattedDateTime = getCurrentDateTime();
        transactionHistory.add("Retiré : " + amount + "€ Date : " + formattedDateTime);
    }

    public void showAccountBalance() {
        System.out.println("Le solde actuel est de "+ balance+" €");
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Aucune transaction à afficher.");
            return;
        }
        System.out.println("Historique des transactions :");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        App account = new App();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nBienvenue sur l'application La banque virtuelle");
            System.out.println("1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Consulter le solde du compte");
            System.out.println("4. Afficher l'historique des transactions");
            System.out.println("5. Quitter l'application");
            System.out.print("Choisissez une option : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Entrez le montant à déposer (€) ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Entrez le montant à retirer (€) ");
                    double withrdrawAmount = scanner.nextDouble();
                    account.withdraw(withrdrawAmount);
                    break;
                case 3:
                    account.showAccountBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
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
