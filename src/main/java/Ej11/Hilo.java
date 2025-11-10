package Ej11;

public class Hilo extends Thread{
	
	String salida;
	
	private Hilo pareja;

	public Hilo(String salida) {
		super();
		this.salida = salida;
	}
	
	public void setPareja(Hilo pareja) {
        this.pareja = pareja;
    }
	
	public void run() {
		for (int i = 0; i < 10; i++) {
            synchronized (this) {
                try {
                    this.wait();
                    
                    System.out.println(salida);

                    synchronized (pareja) {
                        pareja.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            
        }
	}
}
