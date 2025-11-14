package Ej11;

public class HiloPing extends Thread{

	Object objetoControlador;
	Turno turno;
	
	public HiloPing(Object objetoControlador, Turno turno) {
		super();
		this.objetoControlador=objetoControlador;
		this.turno=turno;
	}
	
	public void run() {
		synchronized(objetoControlador) {
			for(int i=0; i<10; i++) {
				try {
					if(turno.getTurno()!=1) {
						objetoControlador.wait();
					}
					System.out.println("PING ");
					turno.setTurno(2);
					objetoControlador.notify();			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
