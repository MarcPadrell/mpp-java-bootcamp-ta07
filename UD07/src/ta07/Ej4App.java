package ta07;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * TA07 - Aplicación con interfaz para gestionar el STOK i la venta de productos.
 * @author marcp
 *
 */
public class Ej4App {

	public static void main(String[] args) {

		ArrayList<String> lista = productsList();
		Hashtable<String, Double> productos_precio = hashPrice();
		Hashtable<String, Integer> productos_cantidad = hashQuantity();

		addArticles(lista);
		addQuantitiyArticle(productos_cantidad);
		showInfoQuantity(productos_cantidad);
		showInfoPrice(productos_precio);
		showInfoList(lista, 30.0, listSum(lista, productos_precio), priceIva(listSum(lista, productos_precio), 0.21));

	}

	public static ArrayList<String> productsList() {
		ArrayList<String> lista_productos = new ArrayList<>();

		// Añadimos los productos a la compra realizada
		lista_productos.add("manzana");
		lista_productos.add("platano");
		lista_productos.add("pera");
		lista_productos.add("jamon");
		lista_productos.add("atun");

		return lista_productos;
	}

	public static Hashtable<String, Double> hashPrice() {
		Hashtable<String, Double> productos_precio = new Hashtable<String, Double>();

		// Añadimos el IVA aplicado a la Hashtable de productos
		productos_precio.put("IVA", 21.0);

		// Añadimos los productos a la Hashtable
		productos_precio.put("manzana", 2.5);
		productos_precio.put("platano", 1.5);
		productos_precio.put("agua", 1.0);
		productos_precio.put("pan", 1.25);
		productos_precio.put("kiwi", 3.25);
		productos_precio.put("pera", 4.0);
		productos_precio.put("jamon", 3.6);
		productos_precio.put("bombones", 5.9);
		productos_precio.put("cerezas", 4.6);
		productos_precio.put("atun", 4.0);

		return productos_precio;
	}

	public static Hashtable<String, Integer> hashQuantity() {
		Hashtable<String, Integer> productos_cantidad = new Hashtable<String, Integer>();

		// Añadimos los productos a la Hashtable
		productos_cantidad.put("manzana", 2);
		productos_cantidad.put("platano", 1);
		productos_cantidad.put("agua", 1);
		productos_cantidad.put("pan", 4);
		productos_cantidad.put("kiwi", 3);
		productos_cantidad.put("pera", 4);
		productos_cantidad.put("jamon", 3);
		productos_cantidad.put("bombones", 5);
		productos_cantidad.put("cerezas", 8);
		productos_cantidad.put("atun", 9);

		return productos_cantidad;
	}

	/**
	 * Funcion para calcular la media de una lista de productos comprados
	 * 
	 * @param list_name
	 * @param hash_price
	 * @return
	 */
	public static double listSum(ArrayList<String> list_name, Hashtable<String, Double> hash_price) {

		Iterator<String> it = list_name.iterator();
		String prod;
		double suma = 0.0;
		while (it.hasNext()) {
			prod = it.next();
			suma = suma + hash_price.get(prod);
		}

		return suma;

	}

	/**
	 * Funcion para añadir articulos (ej: manzana, platano...) a la lista de
	 * productos comprados
	 * 
	 * @param list_name
	 * @param article
	 */
	public static void addArticles(ArrayList<String> list_name) {

		int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea añadir algún artículo a su compra?");

		while (JOptionPane.OK_OPTION == confirmado) {

			String article = JOptionPane.showInputDialog(null, "Nombre del artículo a añadir: ");
			list_name.add(article);

			confirmado = JOptionPane.showConfirmDialog(null, "¿Desea añadir otro artículo a la compra?");

		}

	}

	/**
	 * Funcion para mostrar el precio con IVA
	 * 
	 * @param price
	 * @param iva
	 * @return
	 */
	public static double priceIva(double price, double iva) {
		return price + (price * (iva));
	}

	/**
	 * Funcion para añadir un artículo con su cantidad al STOCK
	 * 
	 * @param productos_cantidad
	 */
	public static void addQuantitiyArticle(Hashtable<String, Integer> productos_cantidad) {

		int confirmado = JOptionPane.showConfirmDialog(null, "¿Desea añadir algún artículo con su cantidad para el STOCK?");

		while (JOptionPane.OK_OPTION == confirmado) {

			String seleccion = JOptionPane.showInputDialog(null, "Nombre del artículo a añadir: ");
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad del artículo: "));

			productos_cantidad.put(seleccion, cantidad);

			confirmado = JOptionPane.showConfirmDialog(null, "¿Desea añadir otro artículo?");

		}

	}

	/**
	 * Funcion para consultar la informacion de algun artículo en cuanto a CANTIDAD
	 * 
	 * @param productos_cantidad
	 */
	public static void showInfoQuantity(Hashtable<String, Integer> productos_cantidad) {

		int listar_info = JOptionPane.showConfirmDialog(null, "¿Desea consultar la cantidad de un producto sobre algún artículo?");

		while (JOptionPane.OK_OPTION == listar_info) {

			String articulo_info = JOptionPane.showInputDialog(null, "Nombre del artículo a mostrar la información: ");
			System.out.println("Artículo " + articulo_info + ". Cantidad: " + productos_cantidad.get(articulo_info)
					+ " unidades.");

			listar_info = JOptionPane.showConfirmDialog(null, "¿Desea consultar más información sobre otro artículo?");

		}

	}

	/**
	 * Funcion para consultar la informacion de algun artículo en cuanto a CANTIDAD
	 * 
	 * @param productos_cantidad
	 */
	public static void showInfoPrice(Hashtable<String, Double> productos_precio) {

		int listar_info = JOptionPane.showConfirmDialog(null, "¿Desea consultar el precio sobre algún artículo?");

		while (JOptionPane.OK_OPTION == listar_info) {

			String articulo_info = JOptionPane.showInputDialog(null, "Nombre del artículo a mostrar el precio: ");
			System.out
					.println("Artículo " + articulo_info + ". Precio: " + productos_precio.get(articulo_info) + " €.");

			listar_info = JOptionPane.showConfirmDialog(null, "¿Desea consultar el precio sobre otro artículo?");

		}

	}

	public static void showInfoList(ArrayList<String> list_products, double payed_quantity, double price_no_iva,
			double price_iva) {

		System.out.println("Precio bruto: " + price_no_iva + " €. Precio más IVA: " + price_iva + " €");
		System.out.println("Número de artículos comprados: " + list_products.size() + ".");
		System.out.println("Cantidad pagada: " + payed_quantity + " €.");
		System.out.println("Cambio a devolver: " + (payed_quantity - price_iva) + " €.");

	}

}
