package com.writingthreadsafecodeimmutableobjectsassignment;



public class ThreadSafeDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Counter Value: " + counter.getValue());

        ImmutableData data = new ImmutableData(55);
        System.out.println("Immutable Value: " + data.getValue());
    }
}
