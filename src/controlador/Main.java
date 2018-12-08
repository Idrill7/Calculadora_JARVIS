package controlador;

import vista.VentanaPrincipal;
/**
 * 
 * @author Alejandro Gonzalez Casado
 *	@version 1.0
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal miVentana = new VentanaPrincipal();
		ManejadorEventos manejador = new ManejadorEventos(miVentana);
		miVentana.establecerManejador(manejador);
	}

}
