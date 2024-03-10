package at3;

public class Main {
	public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore("1", null);
        Semaphore semaphore2 = new Semaphore("2", semaphore1);
        Semaphore semaphore3 = new Semaphore("3", semaphore2);
        Semaphore semaphore4 = new Semaphore("4", semaphore3);

        semaphore1.nextSemaphore = semaphore4;
        semaphore1.isGreen = true;
        semaphore1.start();
        semaphore2.start();
        semaphore3.start();
        semaphore4.start();
    }
}
