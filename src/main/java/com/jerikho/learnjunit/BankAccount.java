package com.jerikho.learnjunit;

public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean isActive = true;
    private String holderName;

    public BankAccount(double balance, double minimunBalance) {
        this.balance = balance;
        this.minimumBalance = minimunBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw(double amount) {
        if (balance - amount > minimumBalance) {
            balance -= amount;
            return balance;
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    public double deposit(double amount) {

//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return balance += amount;
    }
}
