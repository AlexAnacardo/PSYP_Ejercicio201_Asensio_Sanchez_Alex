package Ej04;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Hilo> hilos = new ArrayList<>();
		
		for(int i=0; i<=4; i++) {
			hilos.add(new Hilo("Hilo"+(i+1), 5));
		}
		
		for(Hilo h: hilos) {			
			h.start();		
		}
		
		for(Hilo h: hilos) {			
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
		System.out.println("Programa finalizado");
	}

}
