package Ej05;

import java.time.Duration;
import java.time.Instant;

public class Cajero extends Thread{
	
	private int clientesAAtender;
	private Long tiempoInicio;
	private String nombre;
	
	
	

	public Cajero(String nombre) {
		super();
		this.nombre = nombre;
		this.clientesAAtender = 5 + (int)(Math.random() * 6);
		this.tiempoInicio = System.nanoTime();
	}



	public void run() {
		Long tiempoFin;
		double tiempoEjecucion;
		
		for(int i=0; i<clientesAAtender; i++) {
			tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			System.out.println("Hola, soy el cajero "+nombre+", he atendido a "+i+" clientes y llevo trabajando "+tiempoEjecucion+" segundos");
			
			atenderCliente((int)(Math.random() * 10)+1);
			
			tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			System.out.println("Adios, soy el cajero "+nombre+", he atendido a "+i+" clientes y llevo trabajando "+tiempoEjecucion+" segundos");
		}
		
		tiempoFin = System.nanoTime();
		tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
		
		System.out.println("Soy el cajero "+nombre+", he atendido a "+clientesAAtender+" clientes y he trabajado "+tiempoEjecucion+" segundos");
		
	}
	
	private void atenderCliente(int productos) {
		try {
			for(int i=0; i<productos; i++) {
				sleep((int)(Math.random() * 200)+100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
