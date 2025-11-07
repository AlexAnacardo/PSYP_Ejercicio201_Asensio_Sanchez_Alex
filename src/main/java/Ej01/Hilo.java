package Ej01;

public class Hilo extends Thread{

	String nombre;
	int repeticiones;
	
	public Hilo(String nombre, int repeticiones) {
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
