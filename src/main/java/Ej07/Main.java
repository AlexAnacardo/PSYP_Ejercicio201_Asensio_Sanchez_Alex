package Ej07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {		
		
		List<Hilo> hilos = new ArrayList<Hilo>();
		Random random = new Random();
		int eliminados=0;
		boolean hiloEliminadoTrigger=false;
		
		for(int i=0; i<=9; i++) {
			hilos.add(new Hilo("Hilo"+(i+1)));
		}
		
		for(Hilo h: hilos) {
			h.start();
		}
		
		while(eliminados<9) {
			try {
				Thread.sleep(1000);
				
				while(!hiloEliminadoTrigger) {
					Hilo hilo = hilos.get(random.nextInt(10));
					if(hilo.isAlive()) {					
						hilo.interrupt();
						hiloEliminadoTrigger=true;
						eliminados++;
					}
				}
				hiloEliminadoTrigger=false;	
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
		for (Hilo h : hilos) {
		    try {
		        h.join();
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
		System.out.println("Todos los hilos han muerto");
	}

}
