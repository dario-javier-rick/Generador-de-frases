package Logica;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Helpers.Helper;


public class Palabra {
	
	private String rutaVerbos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Verbos.txt";
	private String rutaAdjetivos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Adjetivos.txt";
	private String rutaSustantivos = "C:/Users/AlienDJR/Desktop/Estudios/Facultad UNGS/Programacion 3/Sustantivos.txt";
	
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

	private String generarVerbo() throws IOException { // Son en 3ra persona!
		return Helper.traerRegistroAleatorio(rutaVerbos);
	}

	private String generarAdjetivo(GeneroPalabra genero) {
		return Helper.traerRegistroAleatorio(rutaAdjetivos,genero);	
	}


	private String generarSustantivo(GeneroPalabra genero) {
		return Helper.traerRegistroAleatorio(rutaSustantivos,genero);
	}

	



	@Override
	public String toString() {
		return texto;
	}
	
	

}
