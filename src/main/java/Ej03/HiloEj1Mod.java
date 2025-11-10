package Ej03;

public class HiloEj1Mod extends Thread{

	String nombre;
	int repeticiones;
	
	public HiloEj1Mod(String nombre, int repeticiones) {
		super();
		this.nombre = nombre;
		this.repeticiones = repeticiones;
	}

	public void run() {
		for(int i=0; i<=repeticiones; i++) {
			System.out.printf("Hola, soy el hilo %s, con id %d, prioridad %d, y en mi grupo hay %d hilos\n", nombre, this.getId(), this.getPriority(), this.getThreadGroup().activeCount());
		}
	}

}
