package Ej05;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Cajero> cajeros = new ArrayList<>();
		
		
		cajeros.add(new Cajero("Pepe"));
		cajeros.add(new Cajero("Paco"));
		cajeros.add(new Cajero("Ana"));
		cajeros.add(new Cajero("Maria"));
		cajeros.add(new Cajero("Carlos"));
		cajeros.add(new Cajero("Alex"));
		cajeros.add(new Cajero("Daniel"));
		cajeros.add(new Cajero("Natalia"));
		cajeros.add(new Cajero("Diego"));
		cajeros.add(new Cajero("Tirso"));
		
		Long tiempoInicio = System.nanoTime();
		
		for(Cajero c: cajeros) {
			c.start();
		}

		for(Cajero c: cajeros) {
			try {
				c.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Long tiempoFin = System.nanoTime();
		
		double tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
		System.out.println("Tiempo que los cajeros han estado trabajando : "+tiempoEjecucion+ " segundos");
	}

}
