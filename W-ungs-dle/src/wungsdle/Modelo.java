package wungsdle;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Modelo {
	private List<String> listaPalabras = Arrays.asList("feliz", "dedos", "carta", "perro", "gatos");
	private String palabraSecreta;
	private int intentosRestantes;
	
	
	public void iniciarJuego() {
		Random randomPalabra = new Random();
		palabraSecreta = listaPalabras.get(randomPalabra.nextInt(listaPalabras.size()));
		intentosRestantes = 5;
	}
	public String[] verificarPalabra(String palabra) {
		String[] resultado = new String[palabra.length()];
		char[] pSecreta = palabraSecreta.toCharArray();
		intentosRestantes--;
		
		//RECORRE LA PALABRA Y VERIFICA SI LAS LETRAS ESTAN EN LA POSICION CORRECTA
		for(int indice = 0; indice < palabra.length(); indice++) {
			if(palabra.charAt(indice) == pSecreta[indice]) {
				resultado[indice] = "verde"; 	//SI LA LETRA ESTA EN LA POSICION CORRECTA
			}
		}
		for(int indice = 0; indice < palabra.length(); indice++) {
			if(resultado[indice] == null) {
				if(palabraSecreta.contains(String.valueOf(palabra.charAt(indice)))) {
					resultado[indice] = "amarillo";	//SI LA LETRA ES CORRECTA PERO ESTA EN LA POSICION ERRONEA
				}else {
					resultado[indice] = "gris";	//SI LA LETRA NO PERTENECE A LA PALABRA
				}
			}
		}
		return resultado;
	}
	
	public boolean juegoTerminado() {
		return intentosRestantes <= 0;
	}
	public int getIntentosRestantes() {
		return intentosRestantes;
	}
	public String getPalabraSecreta() {
		return palabraSecreta;
	}
}
