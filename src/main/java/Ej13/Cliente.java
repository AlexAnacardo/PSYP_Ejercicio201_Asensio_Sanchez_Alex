package Ej13;

public class Cliente {
	int productos;

	public Cliente() {
		super();
		this.productos = ((int)(Math.random()*19))+1;
	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}
	
}
