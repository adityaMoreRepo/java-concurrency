package com.demo.multithread;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("We are in thread: " + Thread.currentThread().getName());
            System.out.println("Current thread priority: " + Thread.currentThread().getPriority());
            throw new RuntimeException("Intentional Exception");
        });
        t.setName("new worker thread");
        t.setPriority(Thread.MAX_PRIORITY);
        //we can handle an uncaught exception in a thread by setting an uncaught exception handler
        t.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println("A critical error happened in thread: " + thread.getName() + " the error is: " + e.getMessage());
        });
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        t.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread.");
    }
}