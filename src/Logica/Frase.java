package Logica;
import java.io.IOException;
import java.util.ArrayList;



public class Frase {
	
	private TemaFrase tema;
	
	private int complejidad;
	private int agresividad;
	
	private ArrayList<Palabra> palabras= new ArrayList<Palabra>();
	
	public Frase(TemaFrase tema) throws IOException {
		setTema(tema);
		
		Palabra sustantivo = new Palabra(TipoPalabra.Sustantivo, GeneroPalabra.values()[(int)(Math.random()*GeneroPalabra.values().length)], tema);
		Palabra pronombre = new Palabra(TipoPalabra.Pronombre, sustantivo.genero, null);
		Palabra verbo = new Palabra(TipoPalabra.Verbo, null, tema);
		Palabra adjetivo = new Palabra(TipoPalabra.Adjetivo, sustantivo.genero, tema);
		
		palabras.add(pronombre);
		palabras.add(sustantivo);
		palabras.add(verbo);
		palabras.add(adjetivo);

	}
		

	@Override
	public String toString() {
		String frase = "";
		for (int i = 0 ; i < palabras.size() ; i ++){
			frase = frase + palabras.get(i) + " ";
		}
		return frase;
	}


	private void setTema(TemaFrase tema) {
		this.tema = tema;		
	}

	public TemaFrase getTema() {
		return tema;
	}

	public int getComplejidad() {
		return complejidad;
	}
	
	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}
	
	public int getAgresividad() {
		return agresividad;
	}

	public void setAgresividad(int agresividad) {
		this.agresividad = agresividad;
	}

	
}
