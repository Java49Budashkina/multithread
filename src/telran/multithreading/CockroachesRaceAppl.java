package telran.multithreading;


import java.util.Random;

public class CockroachesRaceAppl {

	public static void main(String[] args) throws InterruptedException {
     int numCockroaches =  new Random().nextInt(3, 10);  //TODO input
     int distance = new Random().nextInt(100, 500);//TODO input
     
    
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

     if(Cockroach.winner !=0)
    	 System.out.printf("Congratulations to thread #%d - winner \n", Cockroach.winner);

	}

}
