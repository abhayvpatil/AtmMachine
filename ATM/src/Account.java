package src;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int accountNumber;
    private int accountPin;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    // Set Account Number
    public int setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Set Account Pin
    public int setAccountPin(int accountPin) {
        this.accountPin = accountPin;
        return accountPin;
    }

    public int getAccountPin() {
        return accountPin;
    }

    // Get Checking Account Balance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // Get Saving Account Balance
    public double getSavingBalance() {
        return savingBalance;
    }

    // Calculate Withdrawal for Checking Account
    public double calCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    // Calculate Withdrawal for Saving Account
    public double calSavingWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    // Calculate Deposit for Checking Account
    public double calCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    // Calculate Deposit for Saving Account
    public double calSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    // Customer Checking Account Withdrawal Input
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to withdraw from the Checking Account:");
        double amount = input.nextDouble();

        if (checkingBalance - amount >= 0) {
            calCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient funds in Checking Account.");
        }
    }

    // Customer Saving Account Withdrawal Input
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you want to withdraw from the Saving Account:");
        double amount = input.nextDouble();

        if (savingBalance - amount >= 0) {
            calSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient funds in Saving Account.");
        }
    }

    // Customer Checking Account Deposit Input
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to deposit into the Checking Account:");
        double amount = input.nextDouble();

        if (amount > 0) {
            calCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Customer Saving Account Deposit Input
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you want to deposit into the Saving Account:");
        double amount = input.nextDouble();

        if (amount > 0) {
            calSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }
}
