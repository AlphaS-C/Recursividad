package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Categoria;
import modelo.Empresa;
import modelo.Producto;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main {

	public static void main(String[] args) {

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		// creo dos productos
		Producto producto = new Producto("rojo", 8000, "producto rojo");
		Producto producto2 = new Producto("azul", 11000, "producto azul");
		// las tres categorias principales que tendrá la empresa
		Categoria categoriaP = new Categoria("Categoria Principal 1");
		Categoria categoriaP2 = new Categoria("Categoria Principal 2");
		Categoria categoriaP3 = new Categoria("Categoria Principal 3");
		// se crean 5 subcategorias
		Categoria subCat1 = new Categoria("Subcategoria 1");
		Categoria subCat2 = new Categoria("Subcategoria 2");
		Categoria subCat3 = new Categoria("Subcategoria 3");
		Categoria subCat4 = new Categoria("Subcategoria 4");
		Categoria subCat5 = new Categoria("Subcategoria 5");

		// se añade un producto a la subcategoria 3
		subCat3.getListaProductos().add(producto);
		// se añaden subcategorias dentro de otras subcategorias
		subCat4.getSubcategoria().add(subCat5);
		subCat3.getSubcategoria().add(subCat4);
		subCat2.getSubcategoria().add(subCat3);
		subCat1.getSubcategoria().add(subCat2);
		categoriaP.getSubcategoria().add(subCat1);

		categoriaP2.getSubcategoria().add(new Categoria("sub6"));
		categoriaP2.getSubcategoria().add(new Categoria("sub7"));
		categoriaP2.getSubcategoria().get(1).getSubcategoria().add(new Categoria("sub8"));

		categoriaP3.getListaProductos().add(producto2);
		
		categorias.add(categoriaP);
		categorias.add(categoriaP2);
		categorias.add(categoriaP3);


		Empresa emp1 = new Empresa("los pollos hermanos", categorias);
		System.out.println("-----------------------------------\nMetodo que dice si existe un producto rojo:");
		buscarProducto(emp1, "rojo");
		System.out.println("-----------------------------------\nMetodo que retorna los productos con precio mayor a 10000:");
		imprimirDatos(buscarPrecio(emp1,10000), 0);
		

	}

	public static void buscarProducto(Empresa empresa, String color) {
		if (buscarProducto(color, empresa.getListaCategorias(), 0, 0)) {
			System.out.println("Existe un producto de color " + color + "!");
		} else {
			System.out.println("No existe ningun producto de color " + color + "!");
		}
	}

	public static ArrayList<Producto> buscarPrecio(Empresa empresa, int precio) {
		return buscarPrecio(precio, empresa.getListaCategorias(), 0, 0, new ArrayList<Producto>());
	}
	
	public static boolean buscarProducto(String color, ArrayList<Categoria> listaCategorias, int indCat, int indProd) {
		Producto producto;
		Categoria auxCat;
		boolean flag = false;

		if (indCat < listaCategorias.size()) { // pregunto si la lista de categorias de la empresa esta vacia o si mi
												// indice es mayor al total
			auxCat = listaCategorias.get(indCat);
			flag = buscarProducto(color, listaCategorias, indCat + 1, indProd); // pongo a buscar si hay un elemento en la
																			// siguiente posicion
			if (auxCat.getSubcategoria().size() != 0) { // pregunto si la categoria actual tiene una subcategoria o si
														// esta vacia
				ArrayList<Categoria> listaCat = auxCat.getSubcategoria();
				flag = buscarProducto(color, listaCat, 0, indProd); // mando la lista de categorias de la nueva categoria como
																// parametro y reinicio el contador en 0 para que
																// empieze a bucar de nuevo
			} 
				if (indProd < auxCat.getListaProductos().size()) { // metodo que busca entre una lista de productos cada
																	// producto, es recorrer un arraylist recursivamente
					producto = auxCat.getListaProductos().get(indProd);
					flag = buscarProducto(color, listaCategorias, indCat, indProd + 1);
					if (producto.getColor() == color) {
						flag = true;
					}
					return flag;
				}
		

		}
		return flag; 

	}
	
	public static ArrayList<Producto> buscarPrecio(int precio, ArrayList<Categoria> listaCategorias, int indCat, int indProd, ArrayList<Producto> productos) {

		Categoria auxCat;

		if (indCat < listaCategorias.size()) {
			auxCat = listaCategorias.get(indCat);
			productos = buscarPrecio(precio, listaCategorias, indCat + 1, indProd, productos); 
			if (indCat < auxCat.getSubcategoria().size()) { 
				ArrayList<Categoria> listaCat = auxCat.getSubcategoria();
				productos = buscarPrecio(precio, listaCat, 0, indProd, productos);
			}
				if (indProd < auxCat.getListaProductos().size()) {
					Producto producto = auxCat.getListaProductos().get(indProd);
					buscarPrecio(precio, listaCategorias, indCat, indProd + 1, productos);
					if (producto.getPrecio() > precio) {
						productos.add(producto);
					}
				}return productos;
		}
		return productos;
	}
	
	public static void imprimirDatos(ArrayList<Producto> listaProductos, int ind) {
		Producto producto;
		if (ind < listaProductos.size()) {
			producto = listaProductos.get(ind);
			imprimirDatos(listaProductos, ind+ 1);
			System.out.println("Nombre: " + producto.getNombre() + "\nPrecio: " + producto.getPrecio() + "\nColor: " + producto.getColor());
			
		}
		
	}

}
