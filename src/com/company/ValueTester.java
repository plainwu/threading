package com.company;

public class ValueTester implements Runnable {
    private int value = 0;

    public void add() {
        value = value + 1;
    }

    @Override
    public void run() {
        add();
        System.out.println(Thread.currentThread().getName() + ": " + value);
    }
}
