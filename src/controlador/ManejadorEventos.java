 package controlador;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.VentanaPrincipal;

public class ManejadorEventos implements ActionListener, MouseListener {

	private VentanaPrincipal ventana;
	private Image img;
	private JLabel imagenResultado;
	private JLabel etiquetaResultado;
	private JLabel etiquetaResto;
	private JLabel imagenEasterEgg;
	private String cajaNumero1;
	private String cajaNumero2;
	private String texto;
	
	public ManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 imagenResultado = ventana.getEtiqueta3();
		etiquetaResultado = ventana.getEtiqueta4();
		etiquetaResto = ventana.getEtiqueta5();
		imagenEasterEgg = ventana.getEtiqueta6();
		cajaNumero1 = ventana.getCajaTexto1().getText();
		cajaNumero2 = ventana.getCajaTexto2().getText();

		if (e.getSource() == ventana.getLimpiar()) {
			sonidoLimpiar();
			ventana.getCajaTexto1().setText("");
			ventana.getCajaTexto2().setText("");
			etiquetaResultado.setText("");
			etiquetaResto.setText("");
			imagenResultado.setVisible(false);
			imagenEasterEgg.setVisible(false);
			// Si pulsamos el boton de raiz cuadrada, nos saldra una ventana modal con el
			// error
		} else if (e.getSource() == ventana.getbRaiz2()) {
			texto = "Funcionalidad no disponible";
			JOptionPane.showMessageDialog(null, texto, "ERROR:R2", JOptionPane.ERROR_MESSAGE);
			/**
			 * Si pulsamos el boton de raiz cubica, nos pedira una contrasena, sin la
			 * acertamos podremos insertar un numero y hacer la raiz cubica, si cancelamos o
			 * no acertamos la contrasena, no se puede acceder a la opcion
			 */
		} else if (e.getSource() == ventana.getbRaiz3()) {
			texto = "Introduce contrasena";
			String password = JOptionPane.showInputDialog(null, texto, "Raiz cubica", JOptionPane.QUESTION_MESSAGE);
			// Si pulsamos 'Cancelar' de la ventana modal, nos devuelve nulo, por lo que
			// para controlar la excepcion, he metido dentro
			// de este "si es distinto a null" la comprobacion de la contrasena.
			if (password != null) {

				if (password.equals("TonyStark")) {
					// Introducimos un try/catch para capturar la excepcion de introducion de
					// caracteres no numericos en la caja del input de la ventana modal
					try {
						String numeroRaiz3 = 
								JOptionPane.showInputDialog("¿A qué número quieres hacer la raiz cubica?");
						// Usamos el metodo prevenirCasteo() del texto introducido en el input
						// si este no se da(devuelve false), se hace la raiz cubica
						if (!prevenirCasteo(numeroRaiz3)) {
							// Hacemos la raiz cubica mediante el metodo cbrt() de la clase Math
							// parseamos a double el numeroRaiz3 que es el String que ha recibido como input de la ventana modal
						double resultado = Math.cbrt(Double.parseDouble(numeroRaiz3));
						
						// Establecemos las cajas de texto a 0, para que asi si se quiere redondear el
						// numero resultante de la raiz, no salte la comprobacion de que hay cajas de texto vacias
						ventana.getCajaTexto1().setText("0.0");
						ventana.getCajaTexto2().setText("0.0");
						etiquetaResultado.setText(String.valueOf(resultado));
						imagenResultado.setVisible(true);
						imagenEasterEgg.setVisible(false);
						etiquetaResto.setText("");
						}

					} catch (NumberFormatException nf) {
						etiquetaResultado.setText("NUMERO NO VALIDO");
						ventana.getCajaTexto1().setText("");
						ventana.getCajaTexto2().setText("");
						imagenResultado.setVisible(false);
						imagenEasterEgg.setVisible(false);
					}
					// Si no acierta la contrasena, se imprime y se lanza una ventana modal con el error
					// Tambien se inicia el sonido que se establece en la funcion sonidoContrasenaIncorrecta()
				} else {
					texto = "Contrasena incorrecta. ¿Eres Tony Stark?";
					sonidoContrasenaIncorrecta();
					JOptionPane.showMessageDialog(null, texto, "ERROR:PASS", JOptionPane.ERROR_MESSAGE);
				}
				// Si es nulo, quiere decir que no se ha introducido nada y se ha hecho click en
				// "Cancelar", por lo que saltara aqui e indicara que no se ha introducido una contrasena
			} else {
				etiquetaResultado.setText("Contrasena no introducida");
				ventana.getCajaTexto1().setText("0.0");
				ventana.getCajaTexto2().setText("0.0");
				imagenResultado.setVisible(false);
				imagenEasterEgg.setVisible(false);
				etiquetaResto.setText("");
			}

		} else if (cajaNumero1.isEmpty() && (cajaNumero2.isEmpty())) {
			imagenEasterEgg.setVisible(false);
			imagenResultado.setVisible(false);
			texto = "Faltan ambos numeros";
			etiquetaResultado.setText("");
			etiquetaResto.setText("");
			JOptionPane.showMessageDialog(null, texto, "ERROR:3", JOptionPane.ERROR_MESSAGE);

		} else if (cajaNumero1.isEmpty()) {
			imagenEasterEgg.setVisible(false);
			imagenResultado.setVisible(false);
			texto = "Falta el numero 1";
			etiquetaResultado.setText("");
			etiquetaResto.setText("");
			JOptionPane.showMessageDialog(null, texto, "ERROR:1", JOptionPane.ERROR_MESSAGE);
			ventana.getCajaTexto1().requestFocus();

		} else if (cajaNumero2.isEmpty()) {
			imagenEasterEgg.setVisible(false);
			imagenResultado.setVisible(false);
			texto = "Falta el numero 2";
			etiquetaResultado.setText("");
			etiquetaResto.setText("");
			JOptionPane.showMessageDialog(null, texto, "ERROR:2", JOptionPane.ERROR_MESSAGE);
			ventana.getCajaTexto2().requestFocus();
		} else {

			try {

				float resultado = 0, resto;
				float numero1 = Float.parseFloat(ventana.getCajaTexto1().getText());
				float numero2 = Float.parseFloat(ventana.getCajaTexto2().getText());

				if (e.getSource() == ventana.getbSumar()) {
					resultado = numero1 + numero2;
					etiquetaResto.setText("");
					imagenEasterEgg.setVisible(false);
					etiquetaResultado.setText(String.valueOf(resultado));
				}

				if (e.getSource() == ventana.getbRestar()) {
					resultado = numero1 - numero2;
					etiquetaResto.setText("");
					imagenEasterEgg.setVisible(false);
					etiquetaResultado.setText(String.valueOf(resultado));
				}
				if (e.getSource() == ventana.getbMultiplicar()) {
					resultado = numero1 * numero2;
					etiquetaResto.setText("");
					imagenEasterEgg.setVisible(false);
					etiquetaResultado.setText(String.valueOf(resultado));
				}
				if (e.getSource() == ventana.getbDividir()) {
					resultado = numero1 / numero2;
					resto = numero1 % numero2;
					etiquetaResto.setText("Resto = " + resto);
					imagenEasterEgg.setVisible(false);
					etiquetaResultado.setText(String.valueOf(resultado));

					if (Float.isInfinite(resultado) == true) {
						etiquetaResto.setText("");
						imagenEasterEgg.setVisible(true);
						etiquetaResultado.setText("ERROR: DIVISION  ENTRE 0");
					}

					if (Float.isNaN(resultado) == true) {
						etiquetaResto.setText("");
						imagenEasterEgg.setVisible(true);
						etiquetaResultado.setText("ERROR: DIVISION 0 ENTRE 0");
					}

				}

				if (!etiquetaResultado.getText().isEmpty() && e.getSource() == ventana.getRedondear()) {
					float redondeo = Float.parseFloat(etiquetaResultado.getText());
					resultado = Math.round(redondeo);
					etiquetaResultado.setText(String.valueOf(((resultado))));
				} else if (etiquetaResultado.getText().isEmpty() && e.getSource() == ventana.getRedondear()) {
					etiquetaResultado.setText("No hay resultado");
					etiquetaResultado.setBounds(50, 490, 300, 30);
				}

				imagenResultado.setVisible(true);
				ventana.getCajaTexto1().requestFocus();
				// Usamos el metodo prevenirCasteo() para ambas caja de texto
				// pasando el String que devuelven las mismas por parametro
				prevenirCasteo(ventana.getCajaTexto1().getText());
				prevenirCasteo(ventana.getCajaTexto2().getText());
				
			} catch (NumberFormatException nfe) {
				imagenEasterEgg.setVisible(false);
				etiquetaResto.setText("");
				etiquetaResultado.setText("NUMEROS NO VALIDOS");
				etiquetaResultado.setForeground(new Color(255, 172, 76));
				imagenResultado.setVisible(false);
				ventana.getCajaTexto1().requestFocus();
			}
		}
	}
/**
 * Cuando llamamos a este metodo, suena un AudioClip 
 */
	private void sonidoContrasenaIncorrecta() {
		URL urlPassErr = ManejadorEventos.class.getResource("ContrasenaIncorrecta.wav");
		AudioClip clipPassErr = Applet.newAudioClip(urlPassErr);
		clipPassErr.play();

	}

	private void sonidoLimpiar() {
		URL urlReset = ManejadorEventos.class.getResource("Reset.wav");
		AudioClip clipReset = Applet.newAudioClip(urlReset);
		clipReset.play();
	}
	/**
	 * El metodo prevenirCasteo previene que se introduzca una "f" o "d" al final del numero
	 * y este sea calculado debido a que lo entiende como "float" o "double"
	 * Con el metodo contains() comprobamos si el String que se recibe por parametro
	 *  contenga  una de ambas letras,  si es asi devuelve true, y si no devuelve false 
     *
     *Con toLoweCase() prevenimos que da igual que contenga una f o d mayuscula
	 */
	private boolean prevenirCasteo(String valor) {
	
		if (valor.toLowerCase().contains("f") ||
				valor.toLowerCase().contains("d")){
			etiquetaResultado.setText("INSERTE NUMEROS VALIDOS");
			etiquetaResto.setText("");
			imagenEasterEgg.setVisible(false);
			imagenResultado.setVisible(false);
			return true;
		}
		return false;	
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == ventana.getbSumar()) {
			img = new ImageIcon("img/BOTON_SUMAR_CLICK.png").getImage();
			ventana.getbSumar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbRestar()) {
			img = new ImageIcon("img/BOTON_RESTAR_CLICK.png").getImage();
			ventana.getbRestar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbMultiplicar()) {
			img = new ImageIcon("img/BOTON_MULTIPLICAR_CLICK.png").getImage();
			ventana.getbMultiplicar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbDividir()) {
			img = new ImageIcon("img/BOTON_DIVIDIR_CLICK.png").getImage();
			ventana.getbDividir().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbDividir()) {
			img = new ImageIcon("img/BOTON_DIVIDIR_CLICK.png").getImage();
			ventana.getbDividir().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbRaiz2()) {
			img = new ImageIcon("img/BOTON_RAIZ2_CLICK.png").getImage();
			ventana.getbRaiz2().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbRaiz3()) {
			img = new ImageIcon("img/BOTON_RAIZ3_CLICK.png").getImage();
			ventana.getbRaiz3().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		Image imgLogo = new ImageIcon("img/CALCULADORA_LOGO_JARVIS_HOVER.png").getImage();
		ventana.getEtiqueta1().setIcon((new ImageIcon(imgLogo.getScaledInstance(360, 149, Image.SCALE_SMOOTH))));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ventana.getbSumar()) {
			img = new ImageIcon("img/BOTON_SUMAR.png").getImage();
			ventana.getbSumar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbRestar()) {
			img = new ImageIcon("img/BOTON_RESTAR.png").getImage();
			ventana.getbRestar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbMultiplicar()) {
			img = new ImageIcon("img/BOTON_MULTIPLICAR.png").getImage();
			ventana.getbMultiplicar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbDividir()) {
			img = new ImageIcon("img/BOTON_DIVIDIR.png").getImage();
			ventana.getbDividir().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbRaiz2()) {
			img = new ImageIcon("img/BOTON_RAIZ2.png").getImage();
			ventana.getbRaiz2().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbRaiz3()) {
			img = new ImageIcon("img/BOTON_RAIZ3.png").getImage();
			ventana.getbRaiz3().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		Image imgLogo = new ImageIcon("img/CALCULADORA_LOGO_JARVIS2.png").getImage();
		ventana.getEtiqueta1().setIcon((new ImageIcon(imgLogo.getScaledInstance(360, 149, Image.SCALE_SMOOTH))));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Este metodo no es usado
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == ventana.getbSumar()) {
			img = new ImageIcon("img/BOTON_SUMAR.png").getImage();
			ventana.getbSumar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbRestar()) {
			img = new ImageIcon("img/BOTON_RESTAR.png").getImage();
			ventana.getbRestar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbMultiplicar()) {
			img = new ImageIcon("img/BOTON_MULTIPLICAR.png").getImage();
			ventana.getbMultiplicar().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));

		}
		if (e.getSource() == ventana.getbDividir()) {
			img = new ImageIcon("img/BOTON_DIVIDIR.png").getImage();
			ventana.getbDividir().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbRaiz2()) {
			img = new ImageIcon("img/BOTON_RAIZ2.png").getImage();
			ventana.getbRaiz2().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		if (e.getSource() == ventana.getbRaiz3()) {
			img = new ImageIcon("img/BOTON_RAIZ3.png").getImage();
			ventana.getbRaiz3().setIcon((new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		}
		Image imgLogo = new ImageIcon("img/CALCULADORA_LOGO_JARVIS2.png").getImage();
		ventana.getEtiqueta1().setIcon((new ImageIcon(imgLogo.getScaledInstance(360, 149, Image.SCALE_SMOOTH))));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Este metodo no es usado

	}
}
