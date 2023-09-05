package telran.multithreading;

import java.util.Random;

public class Cockroach  extends Thread {
	public Cockroach(int number, int numCycle) {
		this.number = number;
		this.numCycle = numCycle == 0 ? 10 : numCycle ;
	}
	private  int number;
	private int numCycle;
	
	static public int winner;
	
	
	@Override
	public void run() {
		int i=0;
		while (winner == 0)
		{
			System.out.printf("thread %d \n", number);
			if( i< numCycle) {
				i++;
			
				try {
					int pause = new Random().nextInt(2,5);
					sleep(pause);
				} catch (InterruptedException e) {
				
				}
			}
			else {
				winner = winner == 0 ? number : winner;
			}				
		}
		System.out.printf("thread %d ended  i=%d (from %d) winner = %d\n", number, i,numCycle, winner);
	}
	
}
