package com.company;

public class FizzBuzzer implements Runnable {
    private static int ordering = 1;
    private int counter = 1;

    @Override
    public void run() {
        int number = ordering++;
        int i = 1;
        int MAX = 100;

        while (i <= MAX) {
            while (i > counter) {
                // wait
                try {
                    synchronized (this) {
//                        System.out.println("W" + number + ": waiting in " + i + " round. C=" + counter);
                        wait();
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }

            boolean touched = false;
            switch (number) {
                case 1:
                    if (i % 15 == 0) {
                        System.out.println("W" + number + ": FizzBuzz");
                        touched = true;
                    }
                    break;
                case 2:
                    if (i % 5 == 0 && i % 3 != 0) {
                        System.out.println("W" + number + ": Buzz");
                        touched = true;
                    }
                    break;
                case 3:
                    if (i % 3 == 0 && i % 5 != 0) {
                        System.out.println("W" + number + ": Fizz");
                        touched = true;
                    }
                    break;
                case 4:
                    if (i % 3 != 0 && i % 5 != 0) {
                        System.out.println("W" + number + ": " + i);
                        touched = true;
                    }
                    break;
                default:
                    // no-op
                    break;
            }

            if (touched) {
                counter++;
            }

            synchronized (this) {
//                System.out.println("W" + number + ": Notify others. C=" + counter);
                notifyAll();
            }

            i++;
        }
    }
}
