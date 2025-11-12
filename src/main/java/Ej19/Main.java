package Ej19;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        char[][] pista = new char[6][50];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                pista[i][j] = '-';
            }
        }
        
        int[] corredoresTerminados = new int[6];
        
        Semaphore[] listaSemaforos = new Semaphore[6];
        
        for(int i=0; i<6; i++) {
        	listaSemaforos[i] = new Semaphore(1);
        }

        Corredor[] corredores = new Corredor[18];
        int posicionArray=0;
        for (int i = 0; i < 6; i++) {
        	for(int j=0; j<3; j++) {      
        		corredores[posicionArray] = new Corredor(pista, i, listaSemaforos[i], corredoresTerminados);
                corredores[posicionArray].start();
                posicionArray++;          
        	}
        }
        
        
        
        for (Corredor c : corredores) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Carrera finalizada");
    }
}
