package Ej07;

public class Hilo extends Thread {

    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (this.getThreadGroup().activeCount() > 2) {
                try {
                    System.out.println("Soy: " + nombre);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    interrupt();
                }
            } else {
                System.out.println(nombre + ": Soy el último superviviente");
                break;
            }
        }
    }
}
