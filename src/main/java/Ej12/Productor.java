package Ej12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread{

	String nombreArchivo;
	Cola cola;
	
	public Productor(String nombreArchivo, Cola cola) {
		super();
		this.nombreArchivo = nombreArchivo;
		this.cola=cola;
	}

	public void run() {
		File archivo = new File(nombreArchivo);
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
			
			char caracter;
			int caracterLeido=br.read();
			
			while(caracterLeido != -1) {
				caracter = (char)caracterLeido;
				cola.put(caracter);
				caracterLeido=br.read();
			}
			cola.put(null);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
