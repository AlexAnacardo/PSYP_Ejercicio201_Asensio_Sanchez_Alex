package Ej02;

public class Hilo extends Thread{

	int tipo;

	public Hilo(int tipo) {
		super();
		this.tipo = tipo;
	}
	
	public void run() {
		if(tipo == 1) {
			for(int i=0; i<=30; i++) {
				System.out.println(i);
			}
		}else if(tipo == 2) {			
			char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
			
			for(char c: alfabeto) {
				System.out.println(c);
			}
		}
	}

}
