package Ej12;

public class Main {

	public static void main(String[] args) {
		
		Cola cola = new Cola();
		
		Productor productor = new Productor("ej12.txt", cola);
		Consumidor consumidor = new Consumidor(cola);
		
		productor.start();
		consumidor.start();
		
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Programa finalizado");
	}

}
