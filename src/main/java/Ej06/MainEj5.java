package Ej06;

public class MainEj5 {

	public static void main(String[] args) {
		
		EjemploHilo05 hilo = new EjemploHilo05();
		
		hilo.start();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo.pararHilo();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo.reanudarHilo();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo.matarHilo();

		
		
		/*
		 * Lo que pasa al poner una espera de 1 segundo tras 
		 * imprimir por pantalla es que este escribira 5 veces
		 * "estoy en ejecucion", otras 5 veces "estoy detenido" y
		 * otras 5 veces "estoy en el hilo"
		 */
	}

}
