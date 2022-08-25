package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Categoria;
import modelo.Empresa;
import modelo.Producto;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main /*extends Application */ {
	/*
	 
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} */
	
	public static void main(String[] args) {
	
		Empresa emp1 = new Empresa("los pollos hermanos", categoriaFactory(5));
		emp1.getListaCategorias().get(0).setListaProductos(productoFactory(5));
		
	}
	
	public void buscarProducto(Empresa empresa, String color) {
		Producto producto;
		if (empresa.getListaCategorias().size() > 0) {
		} else {
			
		}
		
	}
	
	public static ArrayList<Categoria> categoriaFactory(int n) {
		ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>(); 
		for (int i = 0; i >= n; i++) {
			listaCategoria.add(new Categoria("" + i));
		}
		return listaCategoria;
	}
	
	public static ArrayList<Producto> productoFactory(int n) {
		ArrayList<Producto> listaProducto = new ArrayList<Producto>(); 
		for (int i = 0; i >= n; i++) {
			if (i%2 == 0) {
				listaProducto.add(new Producto("azul", 5000, "" + i));	
			} else {
				listaProducto.add(new Producto("rojo", 10000, "" + i));
			}
			
		}
		return listaProducto;
	}
	
	
	
}
