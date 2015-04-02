package Helpers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Logica.GeneroPalabra;


public class Helper {


	public static String traerRegistroAleatorio(String ruta) throws IOException {
		String cadena = "";
		try
		{
			 FileReader f = new FileReader(ruta);
		        BufferedReader b = new BufferedReader(f);
		        while((cadena = b.readLine())!=null) {
		            System.out.println(cadena);
		        }
		        b.close();
		}
		catch (IOException e)
		{
			throw e;
		}
        return cadena;
	}

	public static String traerRegistroAleatorio(String rutaAdjetivos,
			GeneroPalabra genero) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
