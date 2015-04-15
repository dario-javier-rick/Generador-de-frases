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
			this.genero = genero;
		}
		else if (tipo == TipoPalabra.Sustantivo){
			texto = generarSustantivo(genero, tema);
			this.genero = genero;
		}
		else if (tipo == TipoPalabra.Adjetivo){
			texto = generarAdjetivo(genero, tema);
			this.genero = genero;
		}
		else {
			texto = generarVerbo(tema);
		}
	}

	/** Genera un pronombre */
	private String generarPronombre(GeneroPalabra genero){
		if (genero.equals(GeneroPalabra.Masculino) ){
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
		String ruta = directorio + tema + "/Adjetivos.txt";
		int lineas = Helper.contarLineas(ruta);
		ArrayList<String> registrosPorGenero = new ArrayList<String>(); 
		
		for (int i = 0; i < lineas; i++)
		{
			String registro = (Helper.traerRegistro(ruta, i));
			String[] split = registro.split(";");
			if (genero == GeneroPalabra.Masculino){
				if (split[1].equals("m")){
					registrosPorGenero.add(split[0]);
				}
			}
			else if (genero == GeneroPalabra.Femenino){
				if (split[1].equals("f")){
					registrosPorGenero.add(split[0]);
				}
			}
		}
		
		int index = Helper.randInt(0, registrosPorGenero.size()-1);
		return registrosPorGenero.get(index);
	
	}

	/** Genera un sustantivo aleatorio */
	private String generarSustantivo(GeneroPalabra genero, TemaFrase tema) throws IOException{
		String ruta = directorio + tema + "/Sustantivos.txt";
		int lineas = Helper.contarLineas(ruta);
		ArrayList<String> registrosPorGenero = new ArrayList<String>(); 
		
		for (int i = 0; i < lineas; i++)
		{
			String registro = (Helper.traerRegistro(ruta, i));
			String[] split = registro.split(";");
			if (genero == GeneroPalabra.Masculino){
				if (split[1].equals("m")){
					registrosPorGenero.add(split[0]);
				}
			}
			else if (genero == GeneroPalabra.Femenino){
				if (split[1].equals("f")){
					registrosPorGenero.add(split[0]);
				}
			}
		}
		
		int index = Helper.randInt(0, registrosPorGenero.size()-1);
		return registrosPorGenero.get(index);
	
	}

	@Override
	public String toString() {
		return texto;
	}

}

