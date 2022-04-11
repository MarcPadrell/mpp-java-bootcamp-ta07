package ta07;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * TA07 - Aplicación para calcular el precio total de la compra
 * @author marcp
 *
 */
public class Ej2App {

	public static void main(String[] args) {
		
		ArrayList<String> lista_productos = new ArrayList<>();
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
		
		// Añadimos los productos a la compra realizada
		lista_productos.add("manzana");
		lista_productos.add("platano");
		lista_productos.add("pera");
		lista_productos.add("jamon");
		lista_productos.add("atun");

		double cantidad_pagada = 30.0;
		
		System.out.println("IVA aplicado: "+productos_precio.get("IVA")+" %");
		
		Iterator<String> it = lista_productos.iterator();
		String prod;
		double suma = 0.0;
		while (it.hasNext()) {
			prod = it.next();
			suma = suma + productos_precio.get(prod);
		}
		
		double precio_iva = suma+(suma*(productos_precio.get("IVA")/100));
		
		System.out.println("Precio bruto: "+suma+" €. Precio más IVA: "+precio_iva+" €");
		System.out.println("Número de artículos comprados: "+lista_productos.size()+".");
		System.out.println("Cantidad pagada: "+cantidad_pagada+" €.");
		System.out.println("Cambio a devolver: "+(cantidad_pagada-precio_iva)+" €.");
		
	}

}
