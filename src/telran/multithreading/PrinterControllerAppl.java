package telran.multithreading;

public class PrinterControllerAppl {
	public static void main(String[] args ) throws InterruptedException {
		Printer printer1 = new Printer('#', 100, "Printer1");
		Printer printer2 = new Printer('*', 100, "Printer2");
		/*for(int i=0; i<3; i++)
			printer1.run();*/
		printer1.start();
		printer2.start();
		printer1.join() ;// main thread is waiting printer1
		printer2.join() ;
	}
}
