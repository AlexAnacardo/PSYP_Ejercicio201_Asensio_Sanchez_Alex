package Ej15;

import java.util.List;
import java.util.concurrent.Semaphore;

public class CajaAutomatica extends Thread{
	
	Semaphore semaforo;

	public CajaAutomatica (Semaphore semaforo) {
		super();		
		this.semaforo=semaforo;
	}



	public void run() {
		semaforo.release(1);
	}
	
}
