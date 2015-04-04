package Logica;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Helpers.Helper;


public class Palabra {
	
	private String rutaAdjetivos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras/Adjetivos.txt";
	private String rutaVerbos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras/Verbos.txt";
	private String rutaSustantivos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras/Sustantivos.txt";
	
	//private String rutaPredicado = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras2/predicado.txt";
	//private String rutaVerbos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras2/predicado(verbos).txt";
	//private String rutaSustantivos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Palabras2/sujeto(sustantivos).txt";
	
	private String texto;
	
	private TipoPalabra tipo;
	
	private GeneroPalabra genero;
	

	public Palabra(TipoPalabra tipo, GeneroPalabra genero) throws IOException {
		if (tipo == TipoPalabra.Pronombre){
			this.tipo = TipoPalabra.Pronombre;
			this.genero = genero;
			texto = generarPronombre(genero);
		}
		else if (tipo == TipoPalabra.Sustantivo){
			this.tipo = TipoPalabra.Sustantivo;
			this.genero = genero;
			texto = generarSustantivo(genero);
		}
		else if (tipo == TipoPalabra.Adjetivo){
			this.tipo = TipoPalabra.Adjetivo;
			this.genero = genero;
			texto = generarAdjetivo(genero);
		}
		else {
			this.tipo = TipoPalabra.Verbo;
			this.genero = genero;
			texto = generarVerbo();
		}
	}

	
	
	
	public Palabra(TipoPalabra tipo) { // para generar verbos
		// TODO Auto-generated constructor stub
	}




	private String generarPronombre(GeneroPalabra genero){
		if (genero == GeneroPalabra.Masculino){
			return "El";
		}
		else
			return "La";
	}

	/*
	 * Le agregué el género neutro para no tener que sobrecargar
	 * el método.
	 */
	
	private String generarVerbo() throws IOException { // Son en 3ra persona!
		return Helper.traerRegistroAleatorio(rutaVerbos); // Genero?
	}

	private String generarAdjetivo(GeneroPalabra genero) throws IOException{
		return Helper.traerRegistroAleatorio(rutaAdjetivos);	
	}


	private String generarSustantivo(GeneroPalabra genero) throws IOException{
		return Helper.traerRegistroAleatorio(rutaSustantivos);
	}



	
	@Override
	public String toString() {
		return texto;
	}


	
	

}

