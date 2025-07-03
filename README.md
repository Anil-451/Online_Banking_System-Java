**You have two main files:**


**User.java** – Class representing a bank user.

**BankSystem.java** – Main program that handles user interaction and banking operations.

1. User.java – Class for User Details
   
   
        public class User
        {
          private String accountNumber;
          private String name;
          private String pin;
          private double balance;
          
   
**🔸 Fields:**
These are private variables (data hiding):

accountNumber, name, pin, balance


    public User(String accountNumber, String name, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    } 
    
**🔸 Constructor:**
Initializes a user with values (used when creating a user object).


    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; } 
    
**🔸 Getters (Accessors):**
Used to access private variables safely from outside the class.


    public void deposit(double amount) {
        balance += amount;
    }

      public boolean withdraw(double amount) {
          if (amount > balance) return false;
          balance -= amount;
          return true;
      }
    } 

**🔸 Business Logic:**
deposit: adds amount to balance.

withdraw: subtracts amount if enough balance exists.

2. BankSystem.java – Main Banking System
   
        import java.util.*;

Imports the Scanner class to take user input.

      static Scanner sc = new Scanner(System.in);
      static User currentUser; 

sc – Scanner object for input
currentUser – Holds currently logged-in user (for now, only one user)

**Login Flow**

      currentUser = new User("123456", "Anil Kumar", "1234", 1000.0);
      System.out.print("Enter PIN: ");
      String pin = sc.next();
      Creates a dummy user with name, pin, and ₹1000 balance.

Asks user to enter PIN.

      if (!currentUser.getPin().equals(pin)) {
          System.out.println("Invalid PIN.");
          return;
      }
If entered PIN doesn’t match the user's PIN → exit program.

**Main Menu Loop**      
      int choice;
      do {
          System.out.println("\\nWelcome, " + currentUser.getName());
          System.out.println("1. Check Balance");
          System.out.println("2. Deposit");
          System.out.println("3. Withdraw");
          System.out.println("4. Exit");
          System.out.print("Choose option: ");
          choice = sc.nextInt(); 
    
**Shows menu**
Takes user choice

Switch Statement: Handling User Actions

      switch (choice) {
          case 1:
              System.out.println("Balance: ₹" + currentUser.getBalance());
              break;
      Option 1: Shows current balance
      
      
          case 2:
              System.out.print("Enter deposit amount: ₹");
              double deposit = sc.nextDouble();
              currentUser.deposit(deposit);
              System.out.println("Deposited successfully.");
              break;
Option 2: Deposits amount

          case 3:
              System.out.print("Enter withdraw amount: ₹");
              double withdraw = sc.nextDouble();
              if (currentUser.withdraw(withdraw))
                  System.out.println("Withdrawn successfully.");
              else
                  System.out.println("Insufficient balance.");
              break;
Option 3: Withdraws amount only if there is enough balance

          case 4:
              System.out.println("Thank you for using our bank.");
              break;
          default:
              System.out.println("Invalid choice.");
      }
Option 4: Exit the system

      Any other input: Shows "Invalid choice"

Loop Continues Until Exit

      } while (choice != 4);

**Summary of Concepts Used:**
Concept	How It’s Used
OOP	User class (encapsulation)
Scanner	Input from user
Conditionals	if, switch
Loops	do-while for menu navigation
Modularity	Code is split into classes
Validation	PIN check, withdraw limit check
