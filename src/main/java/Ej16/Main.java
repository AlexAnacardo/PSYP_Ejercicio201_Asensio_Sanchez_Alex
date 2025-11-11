package Ej16;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        char[][] pista = new char[6][50];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 50; j++) {
                pista[i][j] = '-';
            }
        }


        Semaphore salida = new Semaphore(0);

        Corredor[] corredores = new Corredor[6];
        for (int i = 0; i < 6; i++) {
            corredores[i] = new Corredor(pista, i, salida);
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
