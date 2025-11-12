import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.BorderLayout;

public class Bombo extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String RUTA_CARPETA = ".\\BingoCompartido";
	private static final String RUTA_BOMBO = RUTA_CARPETA + "\\bombo_bingo.txt";
	private static final String RUTA_LINEA = RUTA_CARPETA + "\\linea_estado.txt";
	private static final String RUTA_EVENTOS = RUTA_CARPETA + "\\eventos_bingo.txt";
	private static final String RUTA_BINGO_ESTADO = RUTA_CARPETA + "\\bingo_estado.txt";
	private static final String RUTA_NOMBRES = RUTA_CARPETA + "\\nombres_jugadores.txt";
	private JDialog avisoActual;

	private JPanel contentPane;
	private JButton newnumber;
	private int[] arrayNumeros;
	private JButton[] botones;
	private JLabel nuevoNumlabel;
	private JLabel antNumlabel;
	private int cont = 0;

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
		BolaNueva.setIcon(new ImageIcon(RUTA_CARPETA + "/imagenes/bolaverde.png"));
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
		BolaAnterior.setIcon(new ImageIcon(RUTA_CARPETA + "/imagenes/bolamorada.png"));
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

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				vaciarBombo();
			}
		});

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
			new File(RUTA_BOMBO).createNewFile();
			new File(RUTA_LINEA).createNewFile();
			new File(RUTA_EVENTOS).createNewFile();
			new File(RUTA_BINGO_ESTADO).createNewFile();
			new File(RUTA_NOMBRES).createNewFile();
		} catch (IOException ex) {
			System.err.println("ERROR: Fallo al crear un archivo inicial. Detalle: " + ex.getMessage());
		}
	}

	private void guardarNumero() {
		try (PrintWriter pw = new PrintWriter(new File(RUTA_BOMBO))) {
			pw.println(cont > 0 ? arrayNumeros[cont - 1] : "0");
			for (int i = 0; i < cont; i++) {
				pw.print(arrayNumeros[i]);
				if (i < cont - 1)
					pw.print(",");
			}
			pw.println();
		} catch (FileNotFoundException ex) {
			System.err.println("ERROR: No se pudo escribir en el archivo del bombo (" + RUTA_BOMBO + "). Detalle: " + ex.getMessage());
		}
	}

	private void vaciarBombo() {
		try (PrintWriter pw = new PrintWriter(new File(RUTA_BOMBO))) {
			pw.println("--");
			pw.println("");
			System.out.println("[DEBUG] Archivo bombo_bingo.txt vaciado al cerrar.");
		} catch (FileNotFoundException ex) {
			System.err.println("ERROR: No se pudo vaciar el archivo del bombo. Detalle: " + ex.getMessage());
		}

		try (PrintWriter pw = new PrintWriter(new File(RUTA_BINGO_ESTADO))) {
			pw.print("");
			System.out.println("[DEBUG] bingo_estado.txt vaciado al cerrar.");
		} catch (FileNotFoundException ex) {
			System.err.println("ERROR: No se pudo vaciar bingo_estado.txt. Detalle: " + ex.getMessage());
		}
	}

	// GRUPO 2: LÓGICA DE BOMBO (GENERACIÓN DE NÚMEROS)

	private void registrarEventos() {
		newnumber.addActionListener(e -> {
			nuevoNumero();
			if (cont == 90)
				newnumber.setEnabled(false);
		});
	}

	private void nuevoNumero() {
		if (cont >= 90)
			return;

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
		if (cont > 0)
			antNumlabel.setText(String.valueOf(arrayNumeros[cont - 1]));
	}

	// GRUPO 3: MONITOREO DE EVENTOS DE JUGADORES

	private volatile boolean procesandoEventos = false;

	private void monitorearEventos() {
		Timer timer = new Timer(1000, e -> {
			if (procesandoEventos)
				return;

			File f = new File(RUTA_EVENTOS);
			if (!f.exists() || f.length() == 0)
				return;

			procesandoEventos = true;
			StringBuilder eventosLeidos = new StringBuilder();
			boolean hayEventos = false;

			try (Scanner sc = new Scanner(f)) {
				while (sc.hasNextLine()) {
					String linea = sc.nextLine().trim();
					if (linea.isEmpty())
						continue;
					hayEventos = true;
					eventosLeidos.append(linea).append("\n");
					System.out.println("[DEBUG BOMBO] Leyendo evento: " + linea);
				}
			} catch (FileNotFoundException ex) {
				System.err.println("ERROR: No se encontró el archivo de eventos");
				procesandoEventos = false;
				return;
			}

			if (hayEventos) {
				String[] eventos = eventosLeidos.toString().split("\n");
				for (String linea : eventos) {
					if (linea.startsWith("LINEA:")) {
						mostrarAviso("Línea", "¡" + linea.substring(6) + " ha hecho LÍNEA!");
					} else if (linea.startsWith("BINGO:")) {
						mostrarAviso("Bingo", "¡" + linea.substring(6) + " ha hecho BINGO!");
						newnumber.setEnabled(false);
						try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_BINGO_ESTADO))) {
							pw.println("CONFIRMADA:" + linea.substring(6));
						} catch (IOException ex) {
							System.err.println("ERROR: no se pudo escribir bingo_estado.txt");
						}
					} else if (linea.startsWith("COMPROBANDO:")) {
						String[] p = linea.split(":");
						if (p.length >= 3) {
							mostrarAviso("Comprobando", "¡" + p[1] + " ha hecho " + p[2] + "! Se está comprobando...");
						}
					} else if (linea.startsWith("FALLO:")) {
						String[] p = linea.split(":");
						if (p.length >= 3) {
							mostrarAviso("Fallo", "¡" + p[1] + " ha fallado la pregunta de " + p[2] + "! El juego continúa.");
						}
					} else if (linea.startsWith("BLOQUEAR_BOTON")) {
						SwingUtilities.invokeLater(() -> newnumber.setEnabled(false));
					} else if (linea.startsWith("DESBLOQUEAR_BOTON")) {
						SwingUtilities.invokeLater(() -> newnumber.setEnabled(true));
					}
					System.out.println("[DEBUG BOMBO] Evento procesado: " + linea);
				}

				Timer vaciarTimer = new Timer(300, evt -> {
					try (PrintWriter pw = new PrintWriter(RUTA_EVENTOS)) {
					} catch (Exception ex) {
						System.err.println("[ERROR] " + ex.getMessage());
					}
					System.out.println("[DEBUG BOMBO] Archivo de eventos vaciado");
					procesandoEventos = false;
				});
				vaciarTimer.setRepeats(false);
				vaciarTimer.start();
			} else {
				procesandoEventos = false;
			}
		});
		timer.start();
	}

	private javax.swing.Timer timerAviso;

	private void mostrarAviso(String titulo, String texto) {
		SwingUtilities.invokeLater(() -> {
			if (timerAviso != null) {
				timerAviso.stop();
			}
			if (avisoActual != null && avisoActual.isDisplayable()) {
				avisoActual.dispose();
			}

			avisoActual = new JDialog(this, titulo, false);
			avisoActual.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			avisoActual.add(new JLabel(texto, SwingConstants.CENTER), BorderLayout.CENTER);
			avisoActual.setSize(400, 120);
			avisoActual.setLocationRelativeTo(this);
			avisoActual.setVisible(true);

			timerAviso = new javax.swing.Timer(4000, e -> {
				if (avisoActual != null && avisoActual.isDisplayable()) {
					avisoActual.dispose();
				}
				timerAviso.stop();
			});
			timerAviso.setRepeats(false);
			timerAviso.start();
		});
	}
}