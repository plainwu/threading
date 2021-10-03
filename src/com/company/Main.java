package com.company;

public class Main {

    public static void main(String[] args) {
        FizzBuzzer target = new FizzBuzzer();

        Thread buzzer1 = new Thread(target);
        Thread buzzer2 = new Thread(target);
        Thread buzzer3 = new Thread(target);
        Thread buzzer4 = new Thread(target);

        buzzer1.start();
        buzzer2.start();
        buzzer3.start();
        buzzer4.start();

/*
        ValueTester target = new ValueTester();
        Thread vt1 = new Thread(target);
        Thread vt2 = new Thread(target);
        Thread vt3 = new Thread(target);
        Thread vt4 = new Thread(target);
        vt1.start();
        vt2.start();
        vt3.start();
        vt4.start();
*/
    }
}
