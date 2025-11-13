package Ej13;

public class ProductorClientes extends Thread{
	
	Cola cola;

	public ProductorClientes(Cola cola) {
		super();
		this.cola=cola;
	}
	
	
	public void run() {
		for(int i=0; i<100; i++) {
			try {
				sleep(100);
				cola.put(new Cliente());
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}
		for(int i=0; i<10; i++) {
			cola.put(null);
		}
		
	}
	
}
