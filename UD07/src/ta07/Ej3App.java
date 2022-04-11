package ta07;

import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * TA07 - Aplicación con pequeña interfaz gráfica para añadir y visualizar los artículos que deseemos.
 * @author marcp
 *
 */
public class Ej3App {

	public static void main(String[] args) {

		Hashtable<String, Integer> productos = new Hashtable<String, Integer>();

		// Añadimos los productos a la Hashtable
		productos.put("manzana", 2);
		productos.put("platano", 1);
		productos.put("agua", 1);
		productos.put("pan", 4);
		productos.put("kiwi", 3);
		productos.put("pera", 4);
		productos.put("jamon", 3);
		productos.put("bombones", 5);
		productos.put("cerezas", 8);
		productos.put("atun", 9);

		int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea añadir algún artículo?");

		while (JOptionPane.OK_OPTION == confirmado) {

			String seleccion = JOptionPane.showInputDialog(null, "Nombre del artículo a añadir: ");
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad del artículo: "));

			productos.put(seleccion, cantidad);

			confirmado = JOptionPane.showConfirmDialog(null, "¿Desea añadir otro artículo?");

		}

		int listar_info = JOptionPane.showConfirmDialog(null, "¿Desea consultar información sobre algún artículo?");

		while (JOptionPane.OK_OPTION == listar_info) {

			String articulo_info = JOptionPane.showInputDialog(null, "Nombre del artículo a mostrar la información: ");
			System.out.println(
					"Artículo " + articulo_info + ". Cantidad: " + productos.get(articulo_info) + " unidades.");

			listar_info = JOptionPane.showConfirmDialog(null, "¿Desea consultar más información sobre otro artículo?");

		}

	}

}
