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
                        wait(); // Espera por uma notificação
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            	}
			}
        	
        	
            isGreen = true;
            System.out.println("Semáforo " + id + " está verde");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            isGreen = false;
            
            System.out.println("Semáforo " + id + " está vermelho");
            
            if (nextSemaphore != null) {
                synchronized (nextSemaphore) {
                	nextSemaphore.isGreen = true;
                    nextSemaphore.notify();
                }
            }
        }
    }
}
