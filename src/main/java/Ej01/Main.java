package Ej01;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Hilo hilo1 = new Hilo("Hilo 1", 3);
		Hilo hilo2 = new Hilo("Hilo 2", 7);
		Hilo hilo3 = new Hilo("Hilo 3", 2);
		Hilo hilo4 = new Hilo("Hilo 4", 4);
		Hilo hilo5 = new Hilo("Hilo 5", 8);
		Hilo hilo6 = new Hilo("Hilo 6", 6);
		Hilo hilo7 = new Hilo("Hilo 7", 1);
		Hilo hilo8 = new Hilo("Hilo 8", 2);
		Hilo hilo9 = new Hilo("Hilo 9", 8);
		Hilo hilo10 = new Hilo("Hilo 10", 3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
		hilo9.start();
		hilo10.start();
	}
}
