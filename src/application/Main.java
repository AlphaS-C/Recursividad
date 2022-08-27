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

		Producto producto = new Producto("rojo", 6, "producto rojo");

		Categoria categoriaP = new Categoria("Categoria Principal 1");
		Categoria categoriaP2 = new Categoria("Categoria Principal 2");
		Categoria categoriaP3 = new Categoria("Categoria Principal 3");

		Categoria subCat1 = new Categoria("Subcategoria 1");
		Categoria subCat2 = new Categoria("Subcategoria 2");
		Categoria subCat3 = new Categoria("Subcategoria 3");
		Categoria subCat4 = new Categoria("Subcategoria 4");
		Categoria subCat5 = new Categoria("Subcategoria 5");

		subCat5.getListaProductos().add(producto);
		subCat4.getSubcategoria().add(subCat5);
		subCat3.getSubcategoria().add(subCat4);
		subCat2.getSubcategoria().add(subCat3);
		subCat1.getSubcategoria().add(subCat2);
		categoriaP.getSubcategoria().add(subCat1);

		categoriaP2.getSubcategoria().add(new Categoria("sub6"));
		categoriaP2.getSubcategoria().add(new Categoria("sub7"));
		categoriaP2.getSubcategoria().get(1).getSubcategoria().add(new Categoria("sub8"));

		categorias.add(categoriaP);
		categorias.add(categoriaP2);
		categorias.add(categoriaP3);

		Empresa emp1 = new Empresa("los pollos hermanos", categorias);
		buscarProducto(emp1, "rojo");

	}

	public static void buscarProducto(Empresa empresa, String color) {
		buscarProducto(color, empresa.getListaCategorias(), 0, 0);

	}

	public static void buscarProducto(String color, ArrayList<Categoria> listaCategorias, int indCat, int indProd) {
		Producto producto;
		Categoria auxCat;

		if (indCat < listaCategorias.size()) { // pregunto si la lista de categorias de la empresa esta vacia o si mi
												// indice es mayor al total
			auxCat = listaCategorias.get(indCat);
			buscarProducto(color, listaCategorias, indCat + 1, indProd); // pongo a buscar si hay un elemento en la
																			// siguiente posicion
			if (auxCat.getSubcategoria().size() != 0) { // pregunto si la categoria actual tiene una subcategoria o si
														// esta vacia
				ArrayList<Categoria> listaCat = auxCat.getSubcategoria();
				buscarProducto(color, listaCat, 0, indProd); // mando la lista de categorias de la nueva categoria como
																// parametro y reinicio el contador en 0 para que
																// empieze a bucar de nuevo
			} else {
				if (indProd < auxCat.getListaProductos().size()) { // metodo que busca entre una lista de productos cada
																	// producto, es recorrer un arraylist recursivamente
					producto = auxCat.getListaProductos().get(indProd);
					buscarProducto(color, listaCategorias, indCat, indProd + 1);
					if (producto.getColor() == color) {
						System.out.println("Existe un producto de color rojo." + "\nNombre: " + producto.getNombre()
								+ "\nPrecio: " + producto.getPrecio());
					}

				}
			}

		}

	}

}
