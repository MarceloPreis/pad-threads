package examples;

public class CaraCoroa {
	boolean flag ;
	
	synchronized void cara (boolean running) {
		if (!running) {
			flag = true ;
			notify ();
			return ;
		}
		
		System.out.print (" Cara ");
		flag = true;
		
		notify ();
		
		try {
			while (flag) {
				wait ();
			}
		} catch (InterruptedException e) {
			e. printStackTrace ();
		}
	}
	
	synchronized void coroa (boolean running) {
		if (!running) {
			flag = true ;
			notify ();
			return ;
		}
		
		System.out.print (" Coroa ");
		flag = true;
		
		notify ();
		
		try {
			while (flag) {
				wait();
			}
		} catch (InterruptedException e) {
			e. printStackTrace();
		}
	}
}