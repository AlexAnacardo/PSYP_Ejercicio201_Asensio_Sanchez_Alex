package Ej13;

public class Cola {
 
    private boolean disponible = false;
    
    Cliente cliente;

    public synchronized void put(Cliente c) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cliente = c;
        disponible = true;
        notifyAll();
    }

    public synchronized Cliente get() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false;
        notifyAll();
        return cliente;
    }
}