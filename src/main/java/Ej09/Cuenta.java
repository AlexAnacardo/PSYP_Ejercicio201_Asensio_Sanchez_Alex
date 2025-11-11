package Ej09;

public class Cuenta {
	
	float dinero;
	
	
	
	public Cuenta() {
		super();
		this.dinero = 40f;
	}



	public void retirarDinero(String nombre, int cantidad) {
		if(this.dinero<cantidad) {
			try {
				Thread.sleep((int) (Math.random() * 1000));
				System.out.println(nombre+" no puede retirar, la cuenta solo dispone de "+dinero+"€");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}else {
			this.dinero-=cantidad;
			System.out.println(nombre+" ha retirado "+cantidad+"€, "+"saldo antiguo: "+(cantidad+dinero)+", saldo actual: "+dinero);
		}
		
	}
}
