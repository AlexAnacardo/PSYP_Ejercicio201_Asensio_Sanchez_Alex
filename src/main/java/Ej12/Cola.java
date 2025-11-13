package Ej12;

public class Cola {
    private Character caracter;
    private boolean disponible = false;

    public synchronized void put(Character c) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        caracter = c;
        disponible = true;
        notifyAll();
    }

    public synchronized Character get() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false;
        notifyAll();
        return caracter;
    }
}
