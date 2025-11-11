package Ej06;

public class EjemploHilo05 extends Thread{
	
	boolean hiloDetenido = false;
	boolean hiloFinalizado = false;
	
	public void run() {
		while(!hiloFinalizado) {
			if(hiloDetenido) {
				System.out.println("Estoy detenido");
			}else {
				System.out.println("Hilo en ejecucion");
			}
			
			try {
				sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void matarHilo() {
		hiloFinalizado = true;
	}
	
	public void pararHilo() {
		hiloDetenido = true;
	}
	
	public void reanudarHilo() {
		hiloDetenido = false;
	}
}
