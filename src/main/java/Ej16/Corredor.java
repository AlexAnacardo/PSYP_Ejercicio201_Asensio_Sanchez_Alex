package Ej16;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread {

    private int velocidad;
    private int calle;
    private char[][] pista;
    private Semaphore salida;

    public Corredor(char[][] pista, int calle, Semaphore salida) {
        this.pista = pista;
        this.calle = calle;
        this.salida = salida;
        this.velocidad = (int) (Math.random() * 1500) + 500;
    }

    @Override
    public void run() {
        try {

            salida.acquire();

            for (int i = 0; i < 50; i++) {
                Thread.sleep(velocidad);

                synchronized (pista) {
                    pista[calle][i] = 'O';
                    if(i>0) {
                    	pista[calle][i-1]='-';
                    }
                    
                    imprimirPista();
                }
            }

            System.out.println("Corredor " + (calle + 1) + " ha llegado a la meta");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void imprimirPista() {
        for (int i = 0; i < pista.length; i++) {
        	System.out.print("Calle "+(i+1)+": ");
            for (int j = 0; j < pista[i].length; j++) {
                System.out.print(pista[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
