package at1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Quantos metros tem a corrida?");
			int runMeters = scanner.nextInt();
			
			Run run = new Run(3, runMeters);
			ArrayList<Runner> runnersList = new ArrayList<Runner>();
			String name;
			
			for (int i = 0; i < 3; i++) {
				System.out.println("Informe o nome do corredor número " + (i + 1));
				name = scanner.next();
				runnersList.add(new Runner(name, run));
			}
			
			Thread runner1 = new Thread(runnersList.get(0));
			Thread runner2 = new Thread(runnersList.get(1));
			Thread runner3 = new Thread(runnersList.get(2));
			
			runner1.start();
			runner2.start();
			runner3.start();
		
			runner1.join();
			runner2.join();
			runner3.join();
			
			System.out.println(run.finalMark.toString());
		}

	}

}
