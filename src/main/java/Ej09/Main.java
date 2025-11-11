package Ej09;

public class Main {

	public static void main(String[] args) {
		
		Cuenta cuenta = new Cuenta();
		
		HiloSacarDinero hilo1 = new HiloSacarDinero(cuenta);
		HiloSacarDinero hilo2 = new HiloSacarDinero(cuenta);

		hilo1.start();
		hilo2.start();
	}

	/*El problema radica en que, al acceder a la misma variable sin estar 
	 * sincronizada, y al tener pausas aleatorias, es posible que entre 
	 * que hilo1 lea el saldo total y reste la cantidad, hilo2 tambien acceda
	 * y lea el saldo total, para los dos hilos el saldo total es el mismo,
	 * pero solo es real para uno de los hilos
	 * 
	 * por ejemplo, hilo 1 comprueba el saldo total y ve que es 40, justo antes
	 * de restar, hilo2 tambien lo comprueba y ve que es 40, hilo1 resta y deja
	 * el valor en 30, y hilo 2 resta otros 10 y queda en 20
	 * 
	 * Esto puede llevar a que un hilo pueda restar una cantidad mayor al saldo
	 * total, debido a un falso valor de saldo total
	 */
}
