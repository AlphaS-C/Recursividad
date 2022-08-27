package modelo;

import java.util.ArrayList;

public class Categoria {

	private String nombre;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Categoria> subCategoria;
	
	
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
		listaProductos = new ArrayList<Producto>();
		subCategoria = new ArrayList<Categoria>();
	}
	
	public Categoria(String nombre, ArrayList<Producto> listaProductos, ArrayList<Categoria> subcategoria) {
		super();
		this.nombre = nombre;
		this.listaProductos = listaProductos;
		this.subCategoria = subcategoria;
	}

	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public ArrayList<Categoria> getSubcategoria() {
		return subCategoria;
	}
	
}
