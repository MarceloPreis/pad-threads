package at3;

class Semaphore extends Thread {
    private String id;
    public boolean isGreen;
    public Semaphore nextSemaphore;

    public Semaphore(String id, Semaphore nextSemaphore) {
        this.id = id;
        this.isGreen = false;
        this.nextSemaphore = nextSemaphore;
    }

    public void run() {
        while (true) {
        	synchronized (this) {
        		while (!this.isGreen) {
            		try {
                        wait(); // Espera por uma notifica��o
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            	}
			}
        	
        	
            isGreen = true;
            System.out.println("Sem�foro " + id + " est� verde");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            isGreen = false;
            
            System.out.println("Sem�foro " + id + " est� vermelho");
            
            if (nextSemaphore != null) {
                synchronized (nextSemaphore) {
                	nextSemaphore.isGreen = true;
                    nextSemaphore.notify();
                }
            }
        }
    }
}
