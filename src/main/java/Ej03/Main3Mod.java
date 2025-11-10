package Ej03;

import java.util.ArrayList;
import java.util.List;

public class Main3Mod {
	public static void main(String[] args) {
		List<Ejemplo3Mod> escritores = new ArrayList<Ejemplo3Mod>();
		escritores.add(new Ejemplo3Mod(8, "Luis"));
		escritores.add(new Ejemplo3Mod(5, "Juan"));
		escritores.add(new Ejemplo3Mod(10, "Gloria"));
		escritores.add(new Ejemplo3Mod(9, "Maria"));
		escritores.add(new Ejemplo3Mod(7, "Alex"));
		
		for(Ejemplo3Mod escritor: escritores) {			
			escritor.start();			
		}
		
		for(Ejemplo3Mod escritor: escritores) {			
			try {
				escritor.join();			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Los hilos han finalizado");
	}
}
