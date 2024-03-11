package at4;

import javax.swing.JLabel;

public class Counter implements Runnable {
	public int counter;
	public JLabel label;
	public boolean running = true;
	public boolean paused = false;
	
	Counter(int counter, JLabel label) {
		this.counter = counter;
		this.label = label;
	}
	
	synchronized void increment() {
		this.counter++;
		label.setText("Contador: " + this.counter);
	}

	@Override
	public void run() {
		while (true) {	
			if (!running){
				paused = true;
				return ;
			}
			
			synchronized (this) {
				while (paused) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			try {
				this.increment();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
        }
	}
	
	public void stop() {
		this.running = false;
	}
	
	public void pause() {
	    synchronized (this) {
	        if (this.paused) {
	            notify();
	        }
	        
	        this.paused = !this.paused;
	    }
	}

}
