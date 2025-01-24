package src;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OperationMenu extends Account {

    Scanner inputMenu = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    // Validating login credentials
    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                // Adding sample data
                data.put(9876543, 9876);
                data.put(1234567, 1234);

                System.out.println("Welcome To The ATM Machine");
                System.out.println("Enter Your Account Number:");
                setAccountNumber(inputMenu.nextInt());
                System.out.println("Enter Your Account Pin:");
                setAccountPin(inputMenu.nextInt());

                boolean isAuthenticated = false;

                for (Entry<Integer, Integer> entry : data.entrySet()) {
                    if (entry.getKey().equals(getAccountNumber()) && entry.getValue().equals(getAccountPin())) {
                        isAuthenticated = true;
                        break;
                    }
                }

                if (isAuthenticated) {
                    getAccountType();
                } else {
                    System.out.println("Invalid Account Number or Pin. Please Try Again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid Characters, Enter valid numbers only.");
                inputMenu.next(); // Clear invalid input
            }
        } while (x == 1);
    }

    // Get Account Type
    public void getAccountType() {
        System.out.println("Select the Account you want to access:");
        System.out.println("Type 1: Checking Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.println("Enter Your Choice:");

        int selection = inputMenu.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You For Visiting The ATM.");
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again.");
                getAccountType();
        }
    }

    // Display Checking Account Menu
    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");

        int selection = inputMenu.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You For Visiting The ATM.");
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again.");
                getChecking();
        }
    }

    // Display Saving Account Menu
    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");

        int selection = inputMenu.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getSaving();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You For Visiting The ATM.");
                break;
            default:
                System.out.println("Invalid Choice. Please Try Again.");
                getSaving();
        }
    }
}
