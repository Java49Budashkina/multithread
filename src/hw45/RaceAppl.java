package hw45;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class RaceAppl {  
	static int minDistance = 10;  
	static int maxDistance = 100;
	static int minSleep = 2;  
	static int maxSleep = 5;
	private static final int MAX_THREADS = 10;
	private static final int MIN_THREADS = 3;
	
	public static void main(String[] args) {
		int distance = new Random().nextInt(minDistance, maxDistance);
		int nRunners = new Random().nextInt(MIN_THREADS, MAX_THREADS );
		Race race = new Race(distance, minSleep, maxSleep, new ArrayList<Runner>(), Instant.now());
		Runner[] runners = new Runner[nRunners];
		
		startRunners(runners,race);
		joinRunners(runners);
		displayResult( race);
		
		
	}


	
	private static void joinRunners(Runner[] runners) {
		IntStream.range(0, runners.length).forEach(i -> {
			try {
				   runners[i].join();
			   }
			   catch(InterruptedException e) {
				   throw new IllegalStateException();
			   }
		});
	}

	private static void startRunners(Runner[] runners, Race race) {
		IntStream.range(0, runners.length).forEach(i  -> {
		   runners[i] = new Runner(race, i+1);
		    runners[i].start();
		});
		
	}
	private static void displayResult(Race race) {
		ArrayList<Runner> tabl = race.getResultsTable();

		IntStream.range(0, tabl.size()).forEach(i  -> {
			System.out.printf("%3d\t number %7d\t time \t%d ms\n", i+1, tabl.get(i).getRunnerId(),
					ChronoUnit.MILLIS.between(race.getStartTime(), tabl.get(i).getFinsishTime()));
			});
	}
	
}
		
	
	

	
	

