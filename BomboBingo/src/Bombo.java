import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Font;

public class Bombo extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String RUTA_CARPETA = ".\\BingoCompartido";
	private static final String RUTA_BOMBO   = RUTA_CARPETA + "\\bombo_bingo.txt";
	private static final String RUTA_LINEA   = RUTA_CARPETA + "\\linea_estado.txt";
	private static final String RUTA_EVENTOS = RUTA_CARPETA + "\\eventos_bingo.txt";

	private JPanel contentPane;
	private JButton newnumber;
	private int[] arrayNumeros; // Números ya salidos
	private JButton[] botones; // Botones del cartón del bombo (1-90)
	private JLabel nuevoNumlabel;
	private JLabel antNumlabel;
	private int cont = 0; // Contador de números sacados

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Bombo frame = new Bombo();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Bombo() {
		setResizable(false);
		setTitle("Bombo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel numeros = new JPanel();
		numeros.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		numeros.setBackground(new Color(192, 192, 192));
		numeros.setBounds(10, 63, 492, 387);
		contentPane.add(numeros);
		numeros.setLayout(new GridLayout(9, 10, 0, 0));

		botones = new JButton[90];
		for (int i = 0; i < 90; i++) {
			JButton btn = new JButton(String.valueOf(i + 1));
			botones[i] = btn;
			numeros.add(btn);
		}

		JPanel control = new JPanel();
		control.setBackground(new Color(192, 192, 192));
		control.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		control.setBounds(521, 11, 351, 439);
		contentPane.add(control);
		control.setLayout(null);

		newnumber = new JButton("Nuevo número");
		newnumber.setFont(new Font("Tahoma", Font.PLAIN, 10));
		newnumber.setBounds(62, 298, 147, 45);
		control.add(newnumber);

		JLayeredPane NuevaPane = new JLayeredPane();
		NuevaPane.setBounds(10, 37, 250, 250);
		control.add(NuevaPane);

		nuevoNumlabel = new JLabel("");
		nuevoNumlabel.setFont(new Font("Verdana", Font.BOLD, 50));
		nuevoNumlabel.setHorizontalAlignment(SwingConstants.CENTER);
		NuevaPane.setLayer(nuevoNumlabel, 1);
		nuevoNumlabel.setBounds(0, 0, 250, 239);
		NuevaPane.add(nuevoNumlabel);
		nuevoNumlabel.setForeground(new Color(0, 0, 0));

		JLabel BolaNueva = new JLabel("");
		BolaNueva.setIcon(new ImageIcon(getClass().getResource("/images/bolaverde.png")));
		BolaNueva.setBounds(0, 0, 251, 250);
		NuevaPane.add(BolaNueva);

		JLayeredPane AnteriorPane = new JLayeredPane();
		AnteriorPane.setBounds(241, 315, 100, 100);
		control.add(AnteriorPane);

		antNumlabel = new JLabel("");
		AnteriorPane.setLayer(antNumlabel, 1);
		antNumlabel.setHorizontalAlignment(SwingConstants.CENTER);
		antNumlabel.setForeground(Color.BLACK);
		antNumlabel.setFont(new Font("Verdana", Font.BOLD, 22));
		antNumlabel.setBounds(0, 0, 100, 95);
		AnteriorPane.add(antNumlabel);

		JLabel BolaAnterior = new JLabel("");
		BolaAnterior.setIcon(new ImageIcon(getClass().getResource("/images/bolamorada.png")));
		BolaAnterior.setBounds(0, 0, 100, 100);
		AnteriorPane.add(BolaAnterior);

		JLabel lblNewLabel = new JLabel("Bola Nueva");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 250, 24);
		control.add(lblNewLabel);

		JLabel lblBolaAnterior = new JLabel("Bola Anterior");
		lblBolaAnterior.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBolaAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblBolaAnterior.setBounds(241, 298, 100, 14);
		control.add(lblBolaAnterior);
		
		JLabel lblNewLabel_1 = new JLabel("ALMINGO");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 54));
		lblNewLabel_1.setBounds(10, 11, 311, 63);
		contentPane.add(lblNewLabel_1);

		arrayNumeros = new int[90];
		
		crearEstructuraArchivos(); 
		
		registrarEventos();
		monitorearEventos();
	}


	// GRUPO 1: LÓGICA DE ARCHIVOS

	private void crearEstructuraArchivos() {
		File carpeta = new File(RUTA_CARPETA);
        if (!carpeta.exists()) {
            if (!carpeta.mkdirs()) {
				System.err.println("ERROR: No se pudo crear la carpeta compartida: " + RUTA_CARPETA);
				return;
			}
        }

		try {
            if (new File(RUTA_BOMBO).createNewFile()) {}
            if (new File(RUTA_LINEA).createNewFile()) {}
            if (new File(RUTA_EVENTOS).createNewFile()) {}
        } catch (IOException ex) { 
			System.err.println("ERROR: Fallo al crear un archivo inicial. Detalle: " + ex.getMessage());
        }
	}

	private void guardarNumero() {
		try (PrintWriter pw = new PrintWriter(new File(RUTA_BOMBO))) {
			//Último número sacado
			pw.println(cont > 0 ? arrayNumeros[cont - 1] : "0"); 
			
			//Lista de todos los números sacados separados por comas
			for (int i = 0; i < cont; i++) {
				pw.print(arrayNumeros[i]);
				if (i < cont - 1) pw.print(",");
			}
			pw.println(); 
		} catch (FileNotFoundException ex) {
			System.err.println("ERROR: No se pudo escribir en el archivo del bombo (" + RUTA_BOMBO + "). Detalle: " + ex.getMessage());
		}
	}
	
	// GRUPO 2: LÓGICA DE BOMBO (GENERACIÓN DE NÚMEROS)
	
	private void registrarEventos() {
		newnumber.addActionListener(e -> {
			nuevoNumero(); 
			if (cont == 90) newnumber.setEnabled(false);
		});
	}

	private void nuevoNumero() {
		if (cont >= 90) return; 

		int num;
		boolean repetido;
		do {
			num = (int) (Math.random() * 90) + 1;
			repetido = false;
			for (int j = 0; j < cont; j++) { 
				if (arrayNumeros[j] == num) {
					repetido = true;
					break;
				}
			}
		} while (repetido);

		arrayNumeros[cont] = num;
		nuevoNumlabel.setText(String.valueOf(num));
		botones[num - 1].setEnabled(false);
		numeroAnterior();
		cont++;
		guardarNumero();
	}

	private void numeroAnterior() {
		if (cont > 0) antNumlabel.setText(String.valueOf(arrayNumeros[cont - 1]));
	}

	// GRUPO 3: MONITOREO DE EVENTOS DE JUGADORES

	private void monitorearEventos() {
		Timer timer = new Timer(500, e -> {
			File f = new File(RUTA_EVENTOS);

			boolean leido = false;
			try (Scanner sc = new Scanner(f)) {
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					if (linea.startsWith("LINEA:")) {
						leido = true;
						JOptionPane.showMessageDialog(null, "¡" + linea.substring(6) + " ha hecho LÍNEA!");
					} else if (linea.startsWith("BINGO:")) {
						leido = true;
						JOptionPane.showMessageDialog(null, "¡" + linea.substring(6) + " ha hecho BINGO!");
						newnumber.setEnabled(false);
					} else if (linea.startsWith("COMPROBANDO:")) {
						leido = true;
						String[] p = linea.split(":");
						JOptionPane.showMessageDialog(null, "¡" + p[1] + " ha hecho " + p[2] + "! Se está comprobando...");
					} else if (linea.startsWith("FALLO:")) {
						leido = true;
						String[] p = linea.split(":");
						JOptionPane.showMessageDialog(null, "¡" + p[1] + " ha fallado la pregunta! El juego continúa.");
					}
				}
			} catch (FileNotFoundException ex) { 
                System.err.println("ERROR: No se encontró el archivo de eventos (" + RUTA_EVENTOS + ") para leer. Detalle: " + ex.getMessage());
            }

			// Si se ha leído algo, se vacía el archivo.
			if (leido) {
				try (PrintWriter pw = new PrintWriter(RUTA_EVENTOS)) { /* vaciar */ }
				catch (FileNotFoundException ex) { 
                    System.err.println("ERROR: No se pudo vaciar el archivo de eventos. Detalle: " + ex.getMessage());
                }
			}
		});
		timer.start();
	}
}