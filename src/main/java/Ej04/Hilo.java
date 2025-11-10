package Ej04;

import java.util.Random;

public class Hilo extends Thread{
	
	String nombre;
	int repeticiones;
	Random random;
	
	public Hilo(String nombre, int repeticiones) {
		super();
		this.nombre = nombre;
		this.repeticiones = repeticiones;
		random = new Random();
	}
	
	public void run() {
		
		
		
		
		try {
			for(int i=0; i<=repeticiones; i++) {
				if(this.getThreadGroup().activeCount()>2) {
					System.out.println("Soy: "+nombre);
					sleep(random.nextInt(4000)+1);
				}
				else {
					System.out.println(nombre+": Soy el último superviviente");
					sleep(random.nextInt(4000)+1);
				}
				
			}			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
