package Ej10;

public class Cliente extends Thread{
	int productos;

	public Cliente() {
		super();
		this.productos = (int)(Math.random() * 10)+1;
	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}
	
	
}
