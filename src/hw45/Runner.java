package hw45;


import java.time.Instant;


public class Runner extends Thread {
	private Race race;
	private int runnerId;
	private Instant finishTime;
	public Runner(Race race, int runnerId) {
		this.race = race;
		this.runnerId = runnerId; 
	}
	public int getRunnerId() {
		return runnerId;
	}
	@Override
	public void run() {
		int dist = race.getDistance();
		for (int i =0 ; i < dist; i++) {
			try {
				sleep(race.getRandomSleep());
			}catch (InterruptedException e) {
				throw new IllegalStateException();
			}
			System.out.println(runnerId);
		}
	/*	synchronized (race) {
			finishTime = Instant.now();
			finishRace();
		}*/  
		
		try {
			race.lock.lock();
			finishTime = Instant.now();
			finishRace();
		
		}
		finally {
			race.lock.unlock();
		}
		
	}
	
	private void finishRace() {
		race.getResultsTable().add(this);

	}
	public Instant getFinsishTime() {
		return finishTime;
	}

}
