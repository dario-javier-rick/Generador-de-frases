package Logica;
import java.io.IOException;
import Helpers.Helper;

public class Palabra {
	
	private String directorio  = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras/";
	
	private String texto;
	
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

	
	private String generarPronombre(GeneroPalabra genero){
		if (genero == GeneroPalabra.Masculino){
			return "El";
		}
		else
			return "La";
	}
	
	private String generarVerbo(TemaFrase tema) throws IOException { // Son en 3ra persona!
		return Helper.traerRegistroAleatorio(directorio + tema + "/Verbos.txt"); // Genero?
	}

	private String generarAdjetivo(GeneroPalabra genero, TemaFrase tema) throws IOException{
		return Helper.traerRegistroAleatorio(directorio + tema + "/Adjetivos.txt");	 // Manejar genero!!
	}


	private String generarSustantivo(GeneroPalabra genero, TemaFrase tema) throws IOException{
		return Helper.traerRegistroAleatorio(directorio + tema + "/Sustantivos.txt"); // Manejar genero!!
	}

	@Override
	public String toString() {
		return texto;
	}

}

