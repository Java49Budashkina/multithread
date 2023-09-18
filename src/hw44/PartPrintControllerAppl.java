package hw44;

public class PartPrintControllerAppl {
	private static final int N_THREADS = 5;
	private static final int N_NUMBERS = 100;
	private static final int N_PARTITIONS = 10;
	

	public static void main(String[] args) {
		PartPrint.setNumbers(N_NUMBERS );
		PartPrint.setPart(N_PARTITIONS);
		System.out.println("Hellow");
		
		PartPrint[] printers = new PartPrint[N_THREADS];
		printers[0] = new PartPrint(1);
		for (int i=1; i< N_THREADS; i++) {
			printers[i] = new PartPrint(i+1);
			printers[i-1].setNext(printers[i]);
			printers[i-1].start();
		}
		printers[N_THREADS-1].setNext(printers[0]);
		printers[N_THREADS-1].start();
		
		printers[0].interrupt();

	}

}
