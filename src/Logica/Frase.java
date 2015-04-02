package Logica;
import java.io.IOException;
import java.util.ArrayList;


public class Frase {
	
	private TemaFrase tema;
	private int complejidad;
	private int agresividad;
	private ArrayList<Palabra> palabras;
	
	public Frase(TemaFrase tema) throws IOException {
		this.tema = tema;
		
		Palabra pronombre = new Palabra(TipoPalabra.Pronombre, GeneroPalabra.Masculino);
		Palabra sustantivo = new Palabra(TipoPalabra.Sustantivo, GeneroPalabra.Masculino);
		Palabra verbo = new Palabra(TipoPalabra.Verbo);
		Palabra adjetivo = new Palabra(TipoPalabra.Adjetivo, GeneroPalabra.Masculino);
		
		palabras.add(pronombre);
		palabras.add(sustantivo);
		palabras.add(verbo);
		palabras.add(adjetivo);
		
	}

	
	@Override
	public String toString() {
		String frase = "";
		for (int i = 0 ; i < palabras.size() ; i ++){
			frase = frase + palabras.get(i) + "";
		}
		return frase;
	}
	
	
}
