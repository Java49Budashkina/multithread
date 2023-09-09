package telran.multithreading;


import java.util.Random;

public class CockroachesRaceAppl {
	static int minNumCocroaches = 3; //TODO input
	static int maxNumCocroaches = 10;
	static int minDistance = 100;  //TODO input
	static int maxDistance = 500;
	public static void main(String[] args) throws InterruptedException {
     int numCockroaches =  new Random().nextInt(minNumCocroaches, maxNumCocroaches);  
     int distance = new Random().nextInt(minDistance, maxDistance);
     
    
     Cockroach[] racers = new Cockroach[numCockroaches];
     
     for (int i=0; i<numCockroaches; i++ )
     {
    	 
    	 racers[i] = new Cockroach(i+1, distance );
     }
     
     for (int i=0; i<numCockroaches; i++ )
     {
    	
    	 racers[i].start();
     }
     racers[0].join();

     if(Cockroach.winner.get() !=0)
    	 System.out.printf("Congratulations to thread #%d - winner \n", Cockroach.winner);

	}

}
