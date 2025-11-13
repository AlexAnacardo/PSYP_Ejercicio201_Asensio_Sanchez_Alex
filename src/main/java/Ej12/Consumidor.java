package Ej12;

public class Consumidor extends Thread{
	Cola cola;

	public Consumidor(Cola cola) {
		super();
		this.cola = cola;
	}
	
	public void run() {
		
		Character caracter;
		
		while((caracter = cola.get()) != null) {
			System.out.println(caracter);
		}
		
		
	}
}
