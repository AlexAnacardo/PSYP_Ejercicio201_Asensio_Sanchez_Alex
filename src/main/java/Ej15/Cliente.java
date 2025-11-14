package Ej15;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
	int productos;
	Semaphore semaforo;
	int numCliente;

	public Cliente(int numCliente, Semaphore semaforo) {
		super();
		this.productos = (int) (Math.random() * 10) + 1;
		this.semaforo = semaforo;
		this.numCliente = numCliente;
	}

	public void run() {
		try {

			semaforo.acquire();

			Long tiempoInicio = System.nanoTime();
			double tiempoEjecucion;

			for (int i = 0; i < productos; i++) {
				sleep((int) (Math.random() * 200) + 100);
			}

			Long tiempoFin = System.nanoTime();
			tiempoEjecucion = (tiempoFin - tiempoInicio) / 1e9;
			System.out.println(
					"Soy el cliente " + numCliente + " y he tardado en cobrarme " + tiempoEjecucion + " segundos");
			
			semaforo.release(1);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}
}
