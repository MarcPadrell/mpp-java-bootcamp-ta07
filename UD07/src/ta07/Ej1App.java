package ta07;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ej1App {

	public static void main(String[] args) {

		int num_alumnos = Integer
				.parseInt(JOptionPane.showInputDialog("Cuantos alumnos estan haciendo el  curso de programación?: "));
		Hashtable<String, Double> hash_alumnos_notas = new Hashtable<String, Double>();
		ArrayList<Double> lista_notas = new ArrayList<>();

		for (int i = 0; i < num_alumnos; i++) {
			lista_notas.add(Double.parseDouble(JOptionPane.showInputDialog("Nota alumno " + (i + 1) + " de HTML: ")));
			lista_notas
					.add(Double.parseDouble(JOptionPane.showInputDialog("Nota alumno " + (i + 1) + " de MongoDB: ")));
			lista_notas.add(Double.parseDouble(JOptionPane.showInputDialog("Nota alumno " + (i + 1) + " de Java: ")));

			Iterator<Double> it = lista_notas.iterator();
			double nota = 0.0;
			double suma = 0.0;
			while (it.hasNext()) {
				nota = it.next();
				suma = suma + nota;
			}

			hash_alumnos_notas.put("Alumno " + (i + 1), suma / 3);
			lista_notas.clear();

		}

		Enumeration<Double> enumeration = hash_alumnos_notas.elements();
		Enumeration<String> keys = hash_alumnos_notas.keys();

		while (enumeration.hasMoreElements() && keys.hasMoreElements()) {
			System.out.println("Media: " + enumeration.nextElement() + ". Key: " + keys.nextElement());

		}

	}

}
