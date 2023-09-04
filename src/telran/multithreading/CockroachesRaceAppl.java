package telran.multithreading;


import java.util.Random;

public class CockroachesRaceAppl {

	public static void main(String[] args) {
     int numCockroaches = 3 ;  //TODO input
    
     Cockroach[] racers = new Cockroach[numCockroaches];
     
     for (int i=0; i<numCockroaches; i++ )
     {
    	 int distance = new Random().nextInt(100, 500);//TODO input
    	 racers[i] = new Cockroach(i+1, distance );
     }
     for (int i=0; i<numCockroaches; i++ )
     {
    	
    	 racers[i].start();
     }
     if(Cockroach.winner !=0)
    	 System.out.printf("Congratulations to thread #%d - winner \n", Cockroach.winner);

	}

}
