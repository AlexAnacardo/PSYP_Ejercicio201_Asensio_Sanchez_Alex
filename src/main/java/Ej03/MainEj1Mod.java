package Ej03;

import java.util.ArrayList;

public class MainEj1Mod {

	public static void main(String[] args) {
		HiloEj1Mod hilo1 = new HiloEj1Mod("Hilo 1", 3);
		HiloEj1Mod hilo2 = new HiloEj1Mod("Hilo 2", 7);
		HiloEj1Mod hilo3 = new HiloEj1Mod("Hilo 3", 2);
		HiloEj1Mod hilo4 = new HiloEj1Mod("Hilo 4", 4);
		HiloEj1Mod hilo5 = new HiloEj1Mod("Hilo 5", 8);
		HiloEj1Mod hilo6 = new HiloEj1Mod("Hilo 6", 6);
		HiloEj1Mod hilo7 = new HiloEj1Mod("Hilo 7", 1);
		HiloEj1Mod hilo8 = new HiloEj1Mod("Hilo 8", 2);
		HiloEj1Mod hilo9 = new HiloEj1Mod("Hilo 9", 8);
		HiloEj1Mod hilo10 = new HiloEj1Mod("Hilo 10", 3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
		hilo9.start();
		hilo10.start();
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
			hilo6.join();
			hilo7.join();
			hilo8.join();
			hilo9.join();
			hilo10.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Los hilos han finalizado");
	}
}
