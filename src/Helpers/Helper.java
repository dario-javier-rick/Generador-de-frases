package Helpers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
* Esta clase contiene métodos de ayuda que se pueden utilizar de manera transversal a lo largo de todo el proyecto
* @author: Karen Perez y Darío Rick
*/


public class Helper {
	
	
    /** Genera un número aleatorio
    */
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	/** Cuenta las líneas de un archivo dado
	 * @throws IOException 
	*/
	public static int contarLineas(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		}
		finally {
			is.close();
		}
	}

	/** Dado un número de línea, trae un registro de un archivo .txt dado
	* @throws IOException 
	*/
	private static String traerRegistro(String ruta, int numeroLinea)
			throws IOException {
		// Si el número de linea es válido, la devuelve. Sino, devuelve null.
		try {
			BufferedReader in = new BufferedReader(new FileReader(ruta));
			int contador = 0;
			String linea;
			while ((linea = in.readLine()) != null) {
				if (contador == numeroLinea) {
					in.close();
					return linea;
				}
				contador++;
			}
			in.close();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}

	/** Dado un archivo .txt, trae un registro aleatorio del mismo
	 * @throws IOException 
	*/
	public static String traerRegistroAleatorio(String ruta) throws IOException {
		int random = randInt(0,contarLineas(ruta));
		try {
			return traerRegistro(ruta, random);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ruta;
		}
	
	
	
	
	
	//------------------
	//Métodos viejos

	/*
	 * La modifique para que lea el block de notas, guarde las palabras en una
	 * lista y en la parte de abajo genera la palabra aleatoria de eso.
	 * Funciona! pero no es tan coherente como deberia...
	 */	
	
	
	/*
	
	public static String traerRegistroAleatorio(String ruta,
			GeneroPalabra genero) throws IOException {
		ArrayList<String> palabras = new ArrayList<String>();
		String cadena = "";

		try {
			FileReader f = new FileReader(ruta);
			BufferedReader b = new BufferedReader(f);
			while ((cadena = b.readLine()) != null) {
				palabras.add(cadena);
				System.out.println(cadena);
			}
			b.close();
		} catch (IOException e) {
			throw e;
		}

		return generarPalabraAleatoria(palabras);

	}

	// devuelve una palabra aleatoria de un conjunto de palabras.
	private static String generarPalabraAleatoria(ArrayList<String> p) {
		Random rnd = new Random();
		int indice = rnd.nextInt(p.size());
		return p.get(indice);
	}
 */	
	
}
