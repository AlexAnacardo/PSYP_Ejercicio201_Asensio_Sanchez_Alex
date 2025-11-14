package Ej11;

public class Main {

	public static void main(String[] args) {
		
		Object objetoControlador = new Object();
		Turno turno = new Turno();
		
		HiloPing hiloPing = new HiloPing(objetoControlador, turno);
		HiloPong hiloPong = new HiloPong(objetoControlador, turno);

        
		hiloPing.start();
		hiloPong.start();
	}

}
