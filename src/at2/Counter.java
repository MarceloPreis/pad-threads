package at2;

public class Counter {
	int counter = 0;
	int countTo;
	
	Counter(int countTo) {
		this.countTo = countTo;
	}
	
	void increment(MyThread thread) {
		if (this.done()) return; 
		
		this.counter++;
		System.out.println("Contador em: " + this.counter + " - " + thread.name);
	}
	
	public boolean done() {
		return this.countTo <= this.counter;
	}

}
