package com.synchronizedblocksandmethodsassignment;

public class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdraw " + amount + ", New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance for withdrawal.");
        }
    }
}
