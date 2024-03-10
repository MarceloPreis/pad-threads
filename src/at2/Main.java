package at2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);

		System.out.println("Informe um número maior que 5000");
		int num = in.nextInt();
		
		if (num < 500)
			return;
		
		Counter counter = new Counter(num);
		
		MyThread t1 = new MyThread(counter, "T1");
		MyThread t2 = new MyThread(counter, "T2");
		MyThread t3 = new MyThread(counter, "T3");
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Finalizado! Contagem em: " + counter.counter);
	}

}
