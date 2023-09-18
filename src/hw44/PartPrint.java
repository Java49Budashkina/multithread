package hw44;

public class PartPrint extends Thread{
	private static final long SLEEPING_TIME = 100;
	 
	private	static int numbers; 
	private	static int part ;
	private	int  nSymbols;
	private	int printerNumber;
	private	PartPrint nextPrinter;
	
	public PartPrint(int  nomer) {
		printerNumber = nomer;
	
		
	}
	
	public  void setNext(PartPrint next) {
		nextPrinter = next;
	}
	public static void setPart(int part) {
		PartPrint.part = part;
	}
	
	public static void setNumbers(int numbers) {
		PartPrint.numbers = numbers;
	}
	
	
	@Override
	public void run() {
		int count =0;
		nSymbols = numbers / part;
		String line = (" " + printerNumber).repeat(nSymbols);
		while(count < part) {
			
			try {
					join();
				//sleep(SLEEPING_TIME);
				
			}catch (InterruptedException e) {
				//System.out.println("count " + count + nSymbols);
				System.out.println( line);
 				count++;
				nextPrinter.interrupt();
			}
			
		}
		
	}
}
