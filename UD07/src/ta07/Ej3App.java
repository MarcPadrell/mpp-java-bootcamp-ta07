package ta07;

import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 * TA07 - Aplicaci�n con peque�a interfaz gr�fica para a�adir y visualizar los art�culos que deseemos.
 * @author marcp
 *
 */
public class Ej3App {

	public static void main(String[] args) {

		Hashtable<String, Integer> productos = new Hashtable<String, Integer>();

		// A�adimos los productos a la Hashtable
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

		int confirmado = JOptionPane.showConfirmDialog(null, "�Desea a�adir alg�n art�culo?");

		while (JOptionPane.OK_OPTION == confirmado) {

			String seleccion = JOptionPane.showInputDialog(null, "Nombre del art�culo a a�adir: ");
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad del art�culo: "));

			productos.put(seleccion, cantidad);

			confirmado = JOptionPane.showConfirmDialog(null, "�Desea a�adir otro art�culo?");

		}

		int listar_info = JOptionPane.showConfirmDialog(null, "�Desea consultar informaci�n sobre alg�n art�culo?");

		while (JOptionPane.OK_OPTION == listar_info) {

			String articulo_info = JOptionPane.showInputDialog(null, "Nombre del art�culo a mostrar la informaci�n: ");
			System.out.println(
					"Art�culo " + articulo_info + ". Cantidad: " + productos.get(articulo_info) + " unidades.");

			listar_info = JOptionPane.showConfirmDialog(null, "�Desea consultar m�s informaci�n sobre otro art�culo?");

		}

	}

}
