package com.executorsconcurrentcollectionscompletablefutureassignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrimeNumbersExecutor {
    private static final int THREAD_COUNT = 4;
    private static final int LIMIT = 100;

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Integer> primeNumbers = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= LIMIT; i++) {
            final int num = i;
            executor.submit(() -> {
                if (isPrime(num)) {
                    primeNumbers.add(num);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CompletableFuture<Void> fileWriteFuture = CompletableFuture.runAsync(() -> writeToFile(primeNumbers));
        fileWriteFuture.join();

        System.out.println("Prime numbers computation completed. Writing results to file...");
    }

    private static void writeToFile(List<Integer> primes) {
        try (FileWriter writer = new FileWriter("prime_numbers.txt")) {
            for (int prime : primes) {
                writer.write(prime + "\n");
            }
            System.out.println("Prime numbers saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
