package modelo;

public class Producto {

	private String color;
	private int precio;
	private String nombre;
	
	
	public Producto(String color, int precio, String nombre) {
		super();
		this.color = color;
		this.precio = precio;
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public int getPrecio() {
		return precio;
	}
	public String getNombre() {
		return nombre;
	}
	
}
