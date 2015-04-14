package Logica;
import java.io.IOException;
import java.util.ArrayList;

import Helpers.Helper;

public class Palabra {
	
	private String directorio  = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras/";
	
	private String texto;
	GeneroPalabra genero;
	
	
	public Palabra(TipoPalabra tipo, GeneroPalabra genero, TemaFrase tema) throws IOException {
		if (tipo == TipoPalabra.Pronombre){
			texto = generarPronombre(genero);
		}
		else if (tipo == TipoPalabra.Sustantivo){
			texto = generarSustantivo(genero, tema);
		}
		else if (tipo == TipoPalabra.Adjetivo){
			texto = generarAdjetivo(genero, tema);
		}
		else {
			texto = generarVerbo(tema);
		}
	}

	/** Genera un pronombre */
	private String generarPronombre(GeneroPalabra genero){
		if (genero == GeneroPalabra.Masculino){
			return "El";
		}
		else
			return "La";
	}
	
	/** Genera un verbo aleatorio */
	private String generarVerbo(TemaFrase tema) throws IOException { // Son en 3ra persona!
		return Helper.traerRegistroAleatorio(directorio + tema + "/Verbos.txt"); // Genero?
	}

	/** Genera un adjetivo aleatorio */
	private String generarAdjetivo(GeneroPalabra genero, TemaFrase tema) throws IOException{
		String s =  Helper.traerRegistroAleatorio(directorio + tema + "/Adjetivos.txt");	 
		String[] split = s.split(";");
		if (split[1]=="m"){
			this.genero = GeneroPalabra.Masculino;
		}
		else if (split[1]=="f"){
			this.genero = GeneroPalabra.Femenino;
		}
		return split[0];
	}

	/** Genera un sustantivo aleatorio */
	private String generarSustantivo(GeneroPalabra genero, TemaFrase tema) throws IOException{
		String ruta = directorio + tema + "/Sustantivos.txt";
		int lineas = Helper.contarLineas(ruta);
		ArrayList<String> registros = null; 
		for (int i = 0; i < lineas; i++)
		{
			String registro = (Helper.traerRegistro(ruta, i));
			String[] split = registro.split(";");
			if (genero == GeneroPalabra.Masculino){
				if (split[1]=="m"){
					registros.add(split[0]);
				}
			}
			else if (genero == GeneroPalabra.Femenino){
				if (split[1]=="f"){
					registros.add(split[0]);
				}
			}
		}
		
		int index = Helper.randInt(0, registros.size());
		return registros.get(index);
	
	}

	@Override
	public String toString() {
		return texto;
	}

}

