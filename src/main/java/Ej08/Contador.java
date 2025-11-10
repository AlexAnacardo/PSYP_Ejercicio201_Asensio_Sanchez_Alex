package Ej08;

public class Contador {
	int valor;

	public Contador(int valor) {
		super();
		this.valor = valor;
	}
	
	public void incrementar(int cantidad) {
		this.valor+=cantidad;
	}
	
	public void disminuir(int cantidad) {
		this.valor-=cantidad;
	}
	
	public int getValor() {
		return this.valor;
	}
}
