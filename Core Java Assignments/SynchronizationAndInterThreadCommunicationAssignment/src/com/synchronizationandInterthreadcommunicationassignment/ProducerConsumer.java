package com.synchronizationandInterthreadcommunicationassignment;

import java.util.LinkedList;

class ProducerConsumer {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;
    private boolean producing = true; 

    
    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            while (!producing) {
                wait();
            }
            System.out.println("\n[Producer starts producing 5 items]");
            for (int i = 0; i < capacity; i++) {
                value++;
                buffer.add(value);
                System.out.println("Produced: " + value);
                Thread.sleep(500);
            }
            producing = false;
            notify();
            wait();
        }
    }

  
    public synchronized void consume() throws InterruptedException {
        while (true) {
            while (producing) { 
                wait();
            }
            System.out.println("\n[Consumer starts consuming 5 items]");
            for (int i = 0; i < capacity; i++) {
                int value = buffer.removeFirst();
                System.out.println("Consumed: " + value);
                Thread.sleep(500);
            }
            producing = true;
            notify();
            wait();
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
