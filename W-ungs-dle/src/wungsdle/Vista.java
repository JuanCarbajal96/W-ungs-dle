package wungsdle;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Vista {

	private JFrame frame;
	private JTextField letra1;
	private JTextField letra2;
	private JTextField letra3;
	private JTextField letra4;
	private JTextField letra5;
	private JLabel lblMostrarMensaje;
	 private JButton btnConfirmarPalabra;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		letra1 = new JTextField();
		letra1.setBounds(43, 57, 31, 27);
		frame.getContentPane().add(letra1);
		limitarAUnaLetraPorCasilla(letra1);
		
		JLabel lblNewLabel = new JLabel("Ingrese una palabra de 5 letras");
		lblNewLabel.setBounds(79, 11, 209, 14);
		frame.getContentPane().add(lblNewLabel);
		
		letra2 = new JTextField();
		letra2.setColumns(10);
		letra2.setBounds(83, 57, 31, 27);
		frame.getContentPane().add(letra2);
		limitarAUnaLetraPorCasilla(letra2);
		
		letra3 = new JTextField();
		letra3.setColumns(10);
		letra3.setBounds(124, 57, 31, 27);
		frame.getContentPane().add(letra3);
		limitarAUnaLetraPorCasilla(letra3);
		
		letra4 = new JTextField();
		letra4.setColumns(10);
		letra4.setBounds(165, 57, 31, 27);
		frame.getContentPane().add(letra4);
		limitarAUnaLetraPorCasilla(letra4);
		
		letra5 = new JTextField();
		letra5.setColumns(10);
		letra5.setBounds(206, 57, 31, 27);
		frame.getContentPane().add(letra5);
		limitarAUnaLetraPorCasilla(letra5);
		
		btnConfirmarPalabra = new JButton("Confirmar");
		btnConfirmarPalabra.setBounds(95, 121, 112, 23);
		frame.getContentPane().add(btnConfirmarPalabra);
		
		lblMostrarMensaje = new JLabel("");
		lblMostrarMensaje.setBounds(22, 155, 268, 14);
		frame.getContentPane().add(lblMostrarMensaje);
	}
	
	//METODO QUE HACE QUE SOLO PUEDAS INGRESAR UNA LETRA A LA CASILLA
	private void limitarAUnaLetraPorCasilla(JTextField casillas) {
		casillas.setColumns(1);
		casillas.setHorizontalAlignment(JTextField.CENTER);
		casillas.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() + str.length() <= 1) {
                    super.insertString(offs, str.toLowerCase(), a); 
                }
            }
        });
	}
	
	//JUNTA LAS LETRAS Y OBTIENE LA PALABRA INGRESADA POR EL USUARIO EN LAS CASILLAS
	public String getPalabra() {
		   return letra1.getText() +
	               letra2.getText() +
	               letra3.getText() +
	               letra4.getText() +
	               letra5.getText();
	}
	
	//METODO QUE CAMBIA DE COLOR EL FONDO DE LA CASILLA
	public void mostrarResultado(String[] resultado) {
		   JTextField[] campos = {letra1, letra2, letra3, letra4, letra5};
	        for (int i = 0; i < resultado.length; i++) {
	            switch (resultado[i]) {
	                case "verde":
	                    campos[i].setBackground(Color.GREEN);
	                    break;
	                case "amarillo":
	                    campos[i].setBackground(Color.YELLOW);
	                    break;
	                default:
	                    campos[i].setBackground(Color.LIGHT_GRAY);
	                    break;
	            }
	        }
	}
	 public JFrame getFrame() {
	        return frame;
	    }
	 
	     //PARA QUE LAS CASILLAS QUEDEN COMO CONJUNTO  
	    public JTextField[] getCasillasIntento() {
	        return new JTextField[]{letra1, letra2, letra3, letra4, letra5};
	    }
	//MODIFICA EL JLABEL PARA MOSTRAR EL MENSAJE DEPENDIENDO SI GANASTE O PERDISTE
	public void mostrarMensaje(String mensaje) {
		 lblMostrarMensaje.setText(mensaje);				
		 }	
	public JButton getBotonConfirmar() {
		return btnConfirmarPalabra;
	}
	}
