package wungsdle;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		modelo.iniciarJuego();
		System.out.println("Palabra secreta: " + modelo.getPalabraSecreta()); //SOLO PARA PRUEBA PARA VER RAPIDO CUAL ES LA PALABRA SECRETA
		
		 vista.getBotonConfirmar().addActionListener(e -> procesarPalabra());	//HACE QUE AL PRESIONAR EL BOTON "CONFIRMAR" SE PROCESE Y VERIFIQUE LA PALABRA INGRESADA
	}

	//METODO PARA MOSTRAR UN CARTEL DE SI HACERTASTE O NO LA PALABRA SECRETA
	private void procesarPalabra() {
		
		String palabra = vista.getPalabra();	//TOMA LA PALABRA INGRESADA POR EL USUARIO
		String[] resultado = modelo.verificarPalabra(palabra); //VERIFICA SI LA PALABRA INGRESADA ES CORRECTA O NO
		
		vista.mostrarResultado(resultado); //MUESTRA EL COLOR CORRESPONDIENTE SEGUN SI ESTAN BIEN POSICIONADAS LAS LETRAS
	
		if(palabra.equals(modelo.getPalabraSecreta())) {
			vista.mostrarMensaje("Ganaste");
		}else if(modelo.juegoTerminado()) {
			vista.mostrarMensaje("Perdiste, la palabra era: " + modelo.getPalabraSecreta());
		}
	}
}	
