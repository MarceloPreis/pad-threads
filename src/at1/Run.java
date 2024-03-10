package at1;

import java.util.ArrayList;

public class Run {
	public int meters;
	public int totalRunners;
	public ArrayList<String> finalMark;
	public ArrayList<Runner> runnersList;
	
	Run (int totalRunners, int meters) {
		this.totalRunners = totalRunners;
		this.meters = meters;
		this.finalMark = new ArrayList<String>();
	}
	
	synchronized void addToFinalMark(Runner runner) {
		this.finalMark.add(runner.name);
	}
} 
