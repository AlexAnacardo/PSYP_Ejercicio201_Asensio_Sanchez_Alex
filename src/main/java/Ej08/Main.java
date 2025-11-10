package Ej08;

public class Main {

	public static void main(String[] args) {
		
		Contador contador = new Contador(20000);
		
		HiloSuma hiloSuma = new HiloSuma(contador);
		HiloResta hiloResta = new HiloResta(contador);
		
		hiloSuma.start();
		hiloResta.start();
		
		try {
			hiloSuma.join();
			hiloResta.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Valor final: "+contador.getValor());
		
		//Lo que pasa es lo siguiente:
		//1-Un hilo Lee el valor actual de "valor"
		//2-Suma/Resta cantidad
		//3-Escribe el nuevo valor
		//Si otro hilo modifica valor entre los pasos 1 y 3, 
		//uno de los cambios se pierde, por lo que el valor final no sera 
		//20000 en la enormisima mayoria de los casos
		
	}

}
