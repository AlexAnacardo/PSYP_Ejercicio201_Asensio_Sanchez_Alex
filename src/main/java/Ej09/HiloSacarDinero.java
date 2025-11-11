package Ej09;

public class HiloSacarDinero extends Thread{
	
	Cuenta cuenta;
	
	public HiloSacarDinero(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	public void run() {
		for(int i = 0; i<4; i++) {
			cuenta.retirarDinero(getName(), 10);
			try {
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
