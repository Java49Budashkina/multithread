package telran.multithreading;

public class Printer extends Thread {
	public Printer(char symbol, int nSymbols, String name) {
		
		this.symbol = symbol;
		this.nSymbols = nSymbols;
		this.name = name;
	}
	private char symbol;
	private int nSymbols;
	private String name;
	
	@Override
	public void run() {
		System.out.printf(name + " : ");
		for(int i=0; i < nSymbols; i++) {
			System.out.print(symbol);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				
			}
		}
		System.out.printf("\n");
		
	}
	
}
