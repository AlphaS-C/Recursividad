package modelo;

import java.util.ArrayList;

public class Categoria {

	private String nombre;
	private ArrayList<Producto> listaProductos;
	private Categoria subcategoria;
	
	
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Categoria(String nombre, ArrayList<Producto> listaProductos, Categoria subcategoria) {
		super();
		this.nombre = nombre;
		this.listaProductos = listaProductos;
		this.subcategoria = subcategoria;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public Categoria getSubcategoria() {
		return subcategoria;
	}
	
}
