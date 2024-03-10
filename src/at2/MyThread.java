package at2;

public class MyThread extends Thread {
	
	Counter counter;
	String name;
	
	MyThread(Counter counter, String name) {
		this.counter = counter;
		this.name = name;
	}
	
	@Override
	public void run() {
		while (!this.counter.done()) {
			this.counter.increment(this);
			Thread.yield();
		}
	}
}
