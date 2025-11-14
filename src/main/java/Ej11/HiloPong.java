package Ej11;

public class HiloPong extends Thread{

	Object objetoControlador;
	Turno turno;
	
	public HiloPong(Object objetoControlador, Turno turno) {
		super();
		this.objetoControlador=objetoControlador;
		this.turno=turno;
	}
	
	public void run() {
		synchronized(objetoControlador) {
			for(int i=0; i<10; i++) {
				try {
					if(turno.getTurno()!=2) {
						objetoControlador.wait();
					}					
					System.out.println("PONG\n");
					turno.setTurno(1);
					objetoControlador.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				objetoControlador.notify();
			}
		}		
	}
	
}
