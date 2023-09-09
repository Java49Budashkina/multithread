package telran.multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Cockroach  extends Thread {
	public Cockroach(int number, int numCycle) {
		this.number = number;
		this.numCycle = numCycle == 0 ? 10 : numCycle ;
	}
	private  int number;
	private int numCycle;
	
	static public AtomicInteger winner = new AtomicInteger();
	
	
	@Override
	public void run() {
		int i=0;
		while (winner.get() == 0)
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
				if(winner.get() == 0)
					winner.set(number);
			}				
		}
		System.out.printf("thread %d ended  i=%d (from %d) winner = %d\n", number, i,numCycle, winner);
	}
	
}
