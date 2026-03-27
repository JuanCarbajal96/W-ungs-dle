package wungsdle;

public class MVC {
	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		
		vista.getFrame().setVisible(true);
	}
}
