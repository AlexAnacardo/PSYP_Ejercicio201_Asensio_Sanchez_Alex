package Ej11;

public class Main {

	public static void main(String[] args) {
		
		Hilo hiloPing = new Hilo("PING");
		Hilo hiloPong = new Hilo("PONG");

		
		hiloPing.setPareja(hiloPong);
        hiloPong.setPareja(hiloPing);
        
        
		hiloPing.start();
		hiloPong.start();
		
		synchronized (hiloPing) {
            hiloPing.notify();
        }
	}

}
