package Ej17;

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
        
        CyclicBarrier barrera20Metros = new CyclicBarrier(6);
        CyclicBarrier barrera40Metros = new CyclicBarrier(6);


        Semaphore salida = new Semaphore(0);

        Corredor[] corredores = new Corredor[6];
        for (int i = 0; i < 6; i++) {
            corredores[i] = new Corredor(pista, i, salida, barrera20Metros, barrera40Metros);
            corredores[i].start();
        }

        salida.release(6);

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
