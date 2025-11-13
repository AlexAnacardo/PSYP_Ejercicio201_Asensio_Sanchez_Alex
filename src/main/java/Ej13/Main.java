package Ej13;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;



public class Main {

	public static void main(String[] args) {
		
		List<Cajero> cajeros = new ArrayList<>();
		Cola cola = new Cola();
		
		cajeros.add(new Cajero("Pepe", cola));
		cajeros.add(new Cajero("Paco", cola));
		cajeros.add(new Cajero("Ana", cola));

		cajeros.add(new Cajero("Maria", cola));
		cajeros.add(new Cajero("Carlos", cola));
		cajeros.add(new Cajero("Alex", cola));
		cajeros.add(new Cajero("Daniel", cola));
		cajeros.add(new Cajero("Natalia", cola));
		cajeros.add(new Cajero("Diego", cola));
		cajeros.add(new Cajero("Tirso", cola));
		
		
		Long tiempoInicio = System.nanoTime();
		
		ProductorClientes productor = new ProductorClientes(cola);
        productor.start();
        
        
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
