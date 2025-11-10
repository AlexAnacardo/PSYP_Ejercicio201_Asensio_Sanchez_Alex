package Ej03;


public class Ejemplo3Mod extends Thread{
	private int tiempoEscritura;
	
	public Ejemplo3Mod(int tiempoEscritura, String nombre) {
		this.tiempoEscritura=tiempoEscritura;
		setName(nombre);
	}
	
	public void run() {
		escribir();
	}
	
	public void escribir() {
		System.out.println(getName() + " ha comenzado a escribir");
		try {
			sleep(tiempoEscritura*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " ha terminado de escribir");
	}
}
