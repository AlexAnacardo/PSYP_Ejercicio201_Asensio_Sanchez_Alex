package Ej08;

public class HiloSuma extends Thread{
	
	Contador contador;
	
	public HiloSuma(Contador contador) {
		super();
		this.contador = contador;
	}

	public void run() {
		for(int i=0; i<=10000; i++) {
			this.contador.incrementar(1);
		}		
	}
}
