package Ej10;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Cajero> cajeros = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		cajeros.add(new Cajero("Pepe", clientes));
		cajeros.add(new Cajero("Paco", clientes));
		cajeros.add(new Cajero("Ana", clientes));
		cajeros.add(new Cajero("Maria", clientes));
		cajeros.add(new Cajero("Carlos", clientes));
		cajeros.add(new Cajero("Alex", clientes));
		cajeros.add(new Cajero("Daniel", clientes));
		cajeros.add(new Cajero("Natalia", clientes));
		cajeros.add(new Cajero("Diego", clientes));
		cajeros.add(new Cajero("Tirso", clientes));
		
		for(int i=0; i<100; i++) {
			clientes.add(new Cliente());
		}
		
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
		
		int totalAtendidos = 0;
		for (Cajero c : cajeros) {
			System.out.println("El cajero " + c.getNombre() + " atendió " + c.getClientesAtendidos() + " clientes.");
			totalAtendidos += c.getClientesAtendidos();
		}

		System.out.println("-----------------------------------");
		System.out.println("Total clientes atendidos: " + totalAtendidos);
		
		
		System.out.println("Tiempo que los cajeros han estado trabajando : "+tiempoEjecucion+ " segundos");
	}

}
