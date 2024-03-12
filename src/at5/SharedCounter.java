package at5;

import java.util.Random;

public class SharedCounter {
    private int counter;
    private Random random;

    public SharedCounter() {
        this.counter = 0;
        this.random = new Random();
    }

    public synchronized void increment() {
        int randomValue = random.nextInt(100); 
        this.counter += randomValue;
        System.out.println("Incrementado: " + randomValue + ", Total: " + this.counter);
    }

    public synchronized void decrement() {
        int randomValue = random.nextInt(100); 
        this.counter -= randomValue;
        System.out.println("Decrementado: " + randomValue + ", Total: " + this.counter);
    }

    public int getCounter() {
        return this.counter;
    }
}
