package modelo;

import java.util.ArrayList;

public class Empresa {

	private String nombre;
	private ArrayList<Categoria> listaCategorias;
	
	public Empresa(String nombre, ArrayList<Categoria> listaCategorias) {
		super();
		this.nombre = nombre;
		this.listaCategorias = listaCategorias;
	}
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	
}
