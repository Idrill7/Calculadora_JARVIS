package vista;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ManejadorEventos;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 983573885998619107L;
	private JLabel etiqueta1, etiqueta2, etiqueta3,etiqueta4,etiqueta5,etiqueta6;
	private JTextField cajaTexto1, cajaTexto2;
	private JButton bSumar, bRestar, bMultiplicar, bDividir,bRaiz2,bRaiz3;
	private TextPrompt placeholder;
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem limpiar,redondear;

	public VentanaPrincipal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("../img/IRON_ICON_WINDOWS.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(410,600);
		setResizable(false);
		setLayout(null);
		setTitle("J.A.R.V.I.S");
		inicializarComponentes();
		setVisible(true);
		establecerSonidoInicial();
	}

	private void inicializarComponentes() {

		getContentPane().setBackground(new Color(159, 12, 11));
		
		
		barra = new JMenuBar();
		setJMenuBar(barra);
		menu = new JMenu("Opciones");
		barra.add(menu);
		
		
		limpiar = new JMenuItem("Resetear todo");
		redondear = new JMenuItem("Redondear resultado");
		menu.add(limpiar);
		menu.add(redondear);
	
		Image imgIcon = new ImageIcon("img/CALCULADORA_LOGO_JARVIS2.png").getImage();
		etiqueta1 = new JLabel(new ImageIcon(imgIcon.getScaledInstance(360, 149,Image.SCALE_SMOOTH)));
		etiqueta1.setBounds(30, 21, 360, 149);
		etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
		
		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(60, 170, 290, 30);
		cajaTexto1.setBorder(null);
		cajaTexto1.setFont(new Font("Dialog", Font.BOLD, 15));
		TextComponentLimit.addTo(cajaTexto1, 7);
		placeholder = new TextPrompt("Inserte numero 1", cajaTexto1);
		placeholder.changeAlpha(0.55f);
	    placeholder.changeStyle(Font.ITALIC);
	    
	    
	    Image imgLogo = new ImageIcon("img/HAZ_LUZ_IRON.png").getImage();
		etiqueta2 = new JLabel(new ImageIcon(imgLogo.getScaledInstance(360, 149,Image.SCALE_SMOOTH)));
		etiqueta2.setBounds(20, 145, 360, 149);
		etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
		
		cajaTexto2 = new JTextField();
		cajaTexto2.setBounds(60, 240, 290, 30);
		cajaTexto2.setBorder(null);
		cajaTexto2.setFont(new Font("Dialog", Font.BOLD, 15));
		TextComponentLimit.addTo(cajaTexto2, 7);
		placeholder = new TextPrompt("Inserte numero 2", cajaTexto2);
		placeholder.changeAlpha(0.55f);
	    placeholder.changeStyle(Font.ITALIC);
		
	    Image imgSumar = new ImageIcon("img/BOTON_SUMAR.png").getImage();
		bSumar = new JButton(new ImageIcon(imgSumar.getScaledInstance(60, 60,Image.SCALE_SMOOTH)));
		bSumar.setBounds(100, 300, 60, 60);
		bSumar.setBackground(null);
		bSumar.setBorder(null);
		bSumar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bSumar.setContentAreaFilled(false);
		
		Image imgRestar = new ImageIcon("img/BOTON_RESTAR.png").getImage();
		bRestar = new JButton(new ImageIcon(imgRestar.getScaledInstance(60, 60,Image.SCALE_SMOOTH)));
		bRestar.setBounds(180, 300, 60, 60);
		bRestar.setBackground(null);
		bRestar.setBorder(null);
		bRestar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bRestar.setContentAreaFilled(false);
		
		Image imgRaiz2= new ImageIcon("img/BOTON_RAIZ2.png").getImage();
		bRaiz2 = new JButton(new ImageIcon(imgRaiz2.getScaledInstance(60, 60,Image.SCALE_SMOOTH)));
		bRaiz2.setBounds(260, 300, 60, 60);
		bRaiz2.setBackground(null);
		bRaiz2.setBorder(null);
		bRaiz2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bRaiz2.setContentAreaFilled(false);
		
		Image imgMultiplicar= new ImageIcon("img/BOTON_MULTIPLICAR.png").getImage();
		bMultiplicar = new JButton(new ImageIcon(imgMultiplicar.getScaledInstance(60, 60,Image.SCALE_SMOOTH)));
		bMultiplicar.setBounds(100, 370, 60, 60);
		bMultiplicar.setBackground(null);
		bMultiplicar.setBorder(null);
		bMultiplicar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bMultiplicar.setContentAreaFilled(false);
		
		Image imgDividir= new ImageIcon("img/BOTON_DIVIDIR.png").getImage();
		bDividir = new JButton(new ImageIcon(imgDividir.getScaledInstance(60, 60,Image.SCALE_SMOOTH)));
		bDividir.setBounds(180, 370, 60, 60);
		bDividir.setBackground(null);
		bDividir.setBorder(null);
		bDividir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bDividir.setContentAreaFilled(false);
		
		Image imgRaiz3= new ImageIcon("img/BOTON_RAIZ3.png").getImage();
		bRaiz3 = new JButton(new ImageIcon(imgRaiz3.getScaledInstance(60, 60,Image.SCALE_SMOOTH)));
		bRaiz3.setBounds(260, 370, 60, 60);
		bRaiz3.setBackground(null);
		bRaiz3.setBorder(null);
		bRaiz3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bRaiz3.setContentAreaFilled(false);
		
		Image imgResultado= new ImageIcon("img/RESULTADO_TEXTO.png").getImage();
		etiqueta3 = new JLabel(new ImageIcon(imgResultado.getScaledInstance(140, 35,Image.SCALE_SMOOTH)));
		etiqueta3.setBounds(123, 430, 150, 50);
		etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta3.setVisible(false);
		
		
		//try {
			//Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("AMERICAN CAPTAIN.ttf"));
			
			etiqueta4 = new JLabel();
			etiqueta4.setBounds(44, 490, 300, 30);
			etiqueta4.setFont(new Font("Dialog", Font.BOLD, 20));
			//etiqueta4.setFont(font.deriveFont(Font.PLAIN, 30));
			etiqueta4.setHorizontalAlignment(SwingConstants.CENTER);
			etiqueta4.setForeground(new Color(255, 172, 76));

			etiqueta5 = new JLabel();
			etiqueta5.setBounds(120, 510, 300, 30);
			etiqueta5.setFont(new Font("Dialog", Font.BOLD, 20));
			//etiqueta5.setFont(font.deriveFont(Font.PLAIN, 20));
			etiqueta5.setForeground(new Color(255, 172, 76));
			
		//} catch (FontFormatException e) {
			
			//e.printStackTrace();
		//} catch (IOException e) {
			
			//e.printStackTrace();
		//}
		
		Image imgEasterEgg= new ImageIcon("img/EASTER_EGG.png").getImage();
		etiqueta6 = new JLabel(new ImageIcon(imgEasterEgg.getScaledInstance(166, 123,Image.SCALE_SMOOTH)));
		etiqueta6.setBounds(250, 425, 166, 123);
		etiqueta6.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta6.setVisible(false);
		
		add(etiqueta1);
		add(cajaTexto1);
		add(cajaTexto2);
		add(etiqueta2);
		add(bSumar);
		add(bRestar);
		add(bMultiplicar);
		add(bDividir);
		add(bRaiz2);
		add(bRaiz3);
		add(etiqueta3);
		add(etiqueta4);
		add(etiqueta5);
		add(etiqueta6);
	}
	
	public void establecerSonidoInicial() {
		URL url = VentanaPrincipal.class.getResource("InicioCalculadora.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
		
	}
	
	public void establecerManejador(ManejadorEventos manejador) {
		bSumar.addActionListener(manejador);
		bRestar.addActionListener(manejador);
		bMultiplicar.addActionListener(manejador);
		bDividir.addActionListener(manejador);
		bRaiz2.addActionListener(manejador);
		bRaiz3.addActionListener(manejador);
		bSumar.addMouseListener(manejador);
		bRestar.addMouseListener(manejador);
		bMultiplicar.addMouseListener(manejador);
		bDividir.addMouseListener(manejador);
		bRaiz2.addMouseListener(manejador);
		bRaiz3.addMouseListener(manejador);
		// Ponemos a la escucha las opciones del menu y le pasamos por parametro el manejador de eventos
		redondear.addActionListener(manejador);
		limpiar.addActionListener(manejador);
		
		
	}

	public JLabel getEtiqueta1() {
		return etiqueta1;
	}
	public JLabel getEtiqueta3() {
		return etiqueta3;
	}
	public JLabel getEtiqueta4() {
		return etiqueta4;
	}
	
	public JLabel getEtiqueta5() {
		return etiqueta5;
	}
	public JLabel getEtiqueta6() {
		return etiqueta6;
	}
	
	public JTextField getCajaTexto1() {
		return cajaTexto1;
	}

	public JTextField getCajaTexto2() {
		return cajaTexto2;
	}

	public JButton getbSumar() {
		return bSumar;
	}

	public JButton getbRestar() {
		return bRestar;
	}

	public JButton getbMultiplicar() {
		return bMultiplicar;
	}

	public JButton getbDividir() {
		return bDividir;
	}

	public JButton getbRaiz2() {
		return bRaiz2;
	}

	public JButton getbRaiz3() {
		return bRaiz3;
	}

	public JMenuItem getLimpiar() {
		return limpiar;
	}
	public JMenuItem getRedondear() {
		return redondear;
	}
}
