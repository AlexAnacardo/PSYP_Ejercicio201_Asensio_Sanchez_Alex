package Ej08;

public class HiloResta extends Thread{
	
	Contador contador;
	
	public HiloResta(Contador contador) {
		super();
		this.contador = contador;
	}

	public void run() {
		for(int i=0; i<=10000; i++) {
			this.contador.disminuir(1);
		}		
	}
}
