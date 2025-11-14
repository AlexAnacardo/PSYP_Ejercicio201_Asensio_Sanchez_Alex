package Ej15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		List<CajaAutomatica> cajeros = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		Semaphore semaforo = new Semaphore(0);
		
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		cajeros.add(new CajaAutomatica(semaforo));
		
		
		for(int i=0; i<100; i++) {
			clientes.add(new Cliente(i+1, semaforo));
		}
		
		for(Cliente c: clientes) {
			c.start();
		}
		
		for(CajaAutomatica c: cajeros) {
			c.start();
		}

		for(Cliente c: clientes) {
			try {
				c.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Los clientes han terminado");
	}

}
