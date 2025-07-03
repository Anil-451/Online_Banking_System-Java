import java.util.*;

public class BankSystem {
    static Scanner sc = new Scanner(System.in);
    static User currentUser;

    public static void main(String[] args) {
        currentUser = new User("123456", "Anil Kumar", "1234", 1000.0);

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (!currentUser.getPin().equals(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }

        int choice;
        do {
            System.out.println("\nWelcome, " + currentUser.getName());
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + currentUser.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();
                    currentUser.deposit(deposit);
                    System.out.println("Deposited successfully.");
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ₹");
                    double withdraw = sc.nextDouble();
                    if (currentUser.withdraw(withdraw))
                        System.out.println("Withdrawn successfully.");
                    else
                        System.out.println("Insufficient balance.");
                    break;
                case 4:
                    System.out.println("Thank you for using our bank.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}