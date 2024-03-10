package at1;

import java.util.Random;

public class Runner implements Runnable {
	public String name;
	public int metersRunned; 
	public Run run;
	
	Runner(String name, Run run) {
		this.name = name;
		this.run = run;
	}

	@Override
	public void run() {
		Random rand = new Random();
		
		while (this.metersRunned < this.run.meters) {
	        int runned = rand.nextInt(5) + 1; 
	        System.out.println("O corredor " + this.name + " correu mais " + runned + " metros!"); 
			
	        this.metersRunned += runned;
	        
	        if (this.metersRunned >= this.run.meters) {
	        	this.run.addToFinalMark(this);
	        	return;
	        }
	        
			try {
				Thread.sleep(1000);
				Thread.yield();
			} catch ( InterruptedException e) {
				e. printStackTrace ();
			}
		}
	}
	
}
