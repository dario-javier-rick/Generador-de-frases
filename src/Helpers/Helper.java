package Helpers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Logica.GeneroPalabra;


public class Helper {


	
    /*
	 * La modifique para que lea el block de notas, guarde
	 * las palabras en una lista y en la parte
	 * de abajo genera la palabra aleatoria de eso. Funciona!
	 * pero no es tan coherente como deberia...
	 */
	public static String traerRegistroAleatorio(String ruta,
			GeneroPalabra genero)throws IOException  {
		ArrayList<String>palabras = new ArrayList<String>();
		
		String cadena = "";
		try
		{
			 FileReader f = new FileReader(ruta);
		        BufferedReader b = new BufferedReader(f);
		        while((cadena = b.readLine())!=null) {
		        	palabras.add(cadena);       
		            System.out.println(cadena);
		        }
		        b.close();
		}
		catch (IOException e)
		{
			throw e;
		}
		
		return generarPalabraAleatoria(palabras);
		
	}
	
	
	//devuelve una palabra aleatoria de un conjunto de palabras.
	private static String generarPalabraAleatoria(ArrayList<String> p){
		Random rnd = new Random();
		int indice = rnd.nextInt(p.size());
        return p.get(indice);
	}
		
}
