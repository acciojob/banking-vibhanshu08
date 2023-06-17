package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0) {
            throw new IllegalArgumentException("Number of digits should be positive.");
        }

        if (sum < 0 || sum > digits * 9) {
            throw new Exception("Account Number cannot be generated with the given sum.");
        }

        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            int digit = 0;

            // To ensure the sum constraint is satisfied, we need to adjust the digit value
            if (i == digits - 1) {
                digit = sum;
            } else if (sum > 9) {
                digit = 9;
                sum -= 9;
            } else {
                digit = sum;
                sum = 0;
            }

            accountNumber.append(digit);
        }

        return accountNumber.toString();

    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount < this.minBalance){
            throw new InsufficientBalanceException();
        }
        this.balance -= amount;
    }

}
