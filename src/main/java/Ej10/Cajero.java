package Ej10;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Cajero extends Thread{
	
	private int clientesAtendidos;
	private Long tiempoInicio;
	private String nombre;
	List<Cliente> clientes;
	
	

	public Cajero(String nombre, List<Cliente> clientes) {
		super();
		this.nombre = nombre;
		this.tiempoInicio = System.nanoTime();
		this.clientes = clientes;
	}



	public int getClientesAtendidos() {
		return clientesAtendidos;
	}


	public String getNombre() {
		return nombre;
	}


	public void run() {
		Long tiempoFin;
		double tiempoEjecucion;

		while (true) {
			Cliente cliente = null;

			synchronized (clientes) {
				if (!clientes.isEmpty()) {
					cliente = clientes.remove(0);
				} else {
					break; 
				}
			}

			tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			System.out.println("Hola, soy el cajero " + nombre + 
					", he atendido a " + clientesAtendidos + 
					" clientes y llevo trabajando " + tiempoEjecucion + " segundos");

			atenderCliente(cliente);

			clientesAtendidos++;

			tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			System.out.println("Adios, soy el cajero " + nombre + 
					", he atendido a " + clientesAtendidos + 
					" clientes y llevo trabajando " + tiempoEjecucion + " segundos");
		}

		tiempoFin = System.nanoTime();
		double tiempoEjecucionTotal = (tiempoFin - tiempoInicio) / 1e9;
		System.out.println("Soy el cajero " + nombre + 
				", he atendido a " + clientesAtendidos + 
				" clientes y he trabajado " + tiempoEjecucionTotal + " segundos");
	}
	
	private void atenderCliente(Cliente cliente) {
		
		try {
			for(int i=0; i<cliente.getProductos(); i++) {
				sleep((int)(Math.random() * 200)+100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
