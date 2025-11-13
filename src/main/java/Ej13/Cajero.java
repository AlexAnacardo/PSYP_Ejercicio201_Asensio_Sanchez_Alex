package Ej13;

import java.time.Duration;
import java.time.Instant;

public class Cajero extends Thread{
	
	private Long tiempoInicio;
	private String nombre;
	private Cola cola;
	
	
	

	public Cajero(String nombre, Cola cola) {
		super();
		this.nombre = nombre;
		this.tiempoInicio = System.nanoTime();
		this.cola=cola;
	}



	public void run() {
		Long tiempoFin;
		double tiempoEjecucion;
		Cliente cliente;
		int contadorClientes = 0;
		
		while((cliente = cola.get()) != null) {
			tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			System.out.println("Hola, soy el cajero "+nombre+", he atendido a "+contadorClientes+" clientes y llevo trabajando "+tiempoEjecucion+" segundos");
			
			atenderCliente(cliente);
			
			tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			
			contadorClientes++;
			System.out.println("Adios, soy el cajero "+nombre+", he atendido a "+contadorClientes+" clientes y llevo trabajando "+tiempoEjecucion+" segundos");			
		}
		
		tiempoFin = System.nanoTime();
		tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
		
		System.out.println("Soy el cajero "+nombre+", he atendido a "+contadorClientes+" clientes y he trabajado "+tiempoEjecucion+" segundos");
		
	}
	
	private void atenderCliente(Cliente cliente) {
		
		int productos = cliente.getProductos();
		try {
			for(int i=0; i<productos; i++) {
				sleep((int)(Math.random() * 200)+100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
