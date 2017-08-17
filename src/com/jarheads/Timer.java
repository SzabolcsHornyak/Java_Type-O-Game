package com.jarheads;

public class Timer implements Runnable{

    public static int counter;

    public void run() {
        while(counter > 0) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Interrupt caught!");
            }
            counter--;
        }
    }
}
