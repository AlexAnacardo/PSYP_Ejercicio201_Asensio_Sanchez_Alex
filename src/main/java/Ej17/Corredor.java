package Ej17;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Corredor extends Thread {

    private int velocidad;
    private int calle;
    private char[][] pista;
    private Semaphore salida;
    
    CyclicBarrier barrera20Metros;
    CyclicBarrier barrera40Metros;

    public Corredor(char[][] pista, int calle, Semaphore salida, CyclicBarrier barrera20Metros, CyclicBarrier barrera40Metros) {
        this.pista = pista;
        this.calle = calle;
        this.salida = salida;
        this.velocidad = (int) (Math.random() * 1500) + 500;
        this.barrera20Metros = barrera20Metros;
        this.barrera40Metros = barrera40Metros;
    }

    @Override
    public void run() {
        try {

            salida.acquire();

            for (int i = 0; i < 50; i++) {
            	
            	if(i==20) {
            		barrera20Metros.await();
            	}else if(i==40) {
            		barrera40Metros.await();
            	}
            	
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
        } catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void imprimirPista() {
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                System.out.print(pista[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
