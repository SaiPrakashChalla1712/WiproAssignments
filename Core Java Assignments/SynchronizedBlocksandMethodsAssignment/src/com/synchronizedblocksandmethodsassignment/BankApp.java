package com.synchronizedblocksandmethodsassignment;

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.deposit(1500);
            account.withdraw(1300);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            account.withdraw(500);
            account.deposit(200);
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
