import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Bingo extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int NO_FIN = 0;
	public static final int LINEA = 1;
	public static final int BINGO = 2;
	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JButton btn15;
	private JButton btn16;
	private JButton btn17;
	private JButton btn18;
	private JButton btn19;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private JButton btn23;
	private JButton btn24;
	private JButton btn25;
	private JButton[] arrayBotones;
	private int[] arrayNumeros;
	private boolean lineaEncontrada = false;
	private boolean bingoEncontrado = false;
	private JLabel lblNumeroActual;
	private String nombreJugador;
	private boolean esperandoValidacion = false;
	private boolean[] filaFallida = new boolean[5];
	private int filaActualLinea = -1;
	private boolean lineaGlobalConfirmada = false;
	private boolean bingoGlobalConfirmado = false;
	private String ipServidor;
	private String ruta_Carpeta;
	private String ruta_Bombo;
	private String ruta_Linea;
	private String ruta_Eventos;
	private String ruta_Nombres;
	private long ultimaModificacionBombo = 0L;
	private JPanel panel_1;
	private Color colorOriginal;
	private JDialog avisoActual;
	private String[][] preguntasRespuestas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bingo frame = new Bingo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bingo() {
		setTitle("Carton");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ALMINGO");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 54));
		lblNewLabel_1.setBounds(10, 0, 311, 63);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 60, 619, 407);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));

		btn1 = new JButton("New button");
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		colorOriginal = btn1.getBackground();

		btn2 = new JButton("New button");
		panel.add(btn2);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn3 = new JButton("New button");
		panel.add(btn3);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn4 = new JButton("New button");
		panel.add(btn4);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn5 = new JButton("New button");
		panel.add(btn5);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn6 = new JButton("New button");
		panel.add(btn6);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn7 = new JButton("New button");
		panel.add(btn7);
		btn7.setForeground(new Color(0, 0, 0));
		btn7.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn8 = new JButton("New button");
		panel.add(btn8);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn9 = new JButton("New button");
		panel.add(btn9);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn10 = new JButton("New button");
		panel.add(btn10);
		btn10.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn11 = new JButton("New button");
		panel.add(btn11);
		btn11.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn12 = new JButton("New button");
		panel.add(btn12);
		btn12.setForeground(new Color(0, 0, 0));
		btn12.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn13 = new JButton("New button");
		panel.add(btn13);
		btn13.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn14 = new JButton("New button");
		panel.add(btn14);
		btn14.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn15 = new JButton("New button");
		panel.add(btn15);
		btn15.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn16 = new JButton("New button");
		panel.add(btn16);
		btn16.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn17 = new JButton("New button");
		panel.add(btn17);
		btn17.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn18 = new JButton("New button");
		panel.add(btn18);
		btn18.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn19 = new JButton("New button");
		panel.add(btn19);
		btn19.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn20 = new JButton("New button");
		panel.add(btn20);
		btn20.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn21 = new JButton("New button");
		panel.add(btn21);
		btn21.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn22 = new JButton("New button");
		panel.add(btn22);
		btn22.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn23 = new JButton("New button");
		panel.add(btn23);
		btn23.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn24 = new JButton("New button");
		panel.add(btn24);
		btn24.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn25 = new JButton("New button");
		panel.add(btn25);
		btn25.setFont(new Font("Tahoma", Font.BOLD, 20));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(639, 11, 285, 456);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblNumeroActual = new JLabel("--");
		lblNumeroActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroActual.setBounds(10, 85, 246, 229);
		panel_1.add(lblNumeroActual);
		lblNumeroActual.setFont(new Font("Verdana", Font.BOLD, 50));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				borrarNombreJugador(nombreJugador);
			}
		});

		arrayBotones = new JButton[25];
		arrayNumeros = new int[25];

		pedirIPServidor();

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ruta_Carpeta + "/imagenes/bolaverde.png"));
		lblNewLabel.setBounds(10, 85, 265, 250);
		panel_1.add(lblNewLabel);

		pedirNombreJugador();
		cargarPreguntas();

		llenarArrayNumeros(arrayNumeros);
		llenarArrayBotones(arrayBotones);
		asignarNumerosABotones();

		clickBoton();

		iniciarMonitoreoArchivo();
		monitorearEstadoLinea();
		monitorearEstadoBingo();
		monitorearEventosGlobales();
		setEstadoLinea("PENDIENTE");
	}

	// GRUPO 1: CONFIGURACIÓN INICIAL Y GESTIÓN DE JUGADOR

	private void pedirIPServidor() {
		boolean valido = false;
		while (!valido) {
			ipServidor = JOptionPane.showInputDialog(
					this,
					"Introduce la IP del servidor de juego:",
					"Conexión al servidor",
					JOptionPane.QUESTION_MESSAGE);

			if (ipServidor == null || ipServidor.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "La IP no puede estar vacía.");
				continue;
			}
			if (!ipServidor.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
				JOptionPane.showMessageDialog(this, "Formato de IP inválido.");
				continue;
			}

			valido = true;
		}
		ruta_Carpeta = "\\\\" + ipServidor + "\\BingoCompartido";
		ruta_Bombo = ruta_Carpeta + "\\bombo_bingo.txt";
		ruta_Linea = ruta_Carpeta + "\\linea_estado.txt";
		ruta_Eventos = ruta_Carpeta + "\\eventos_bingo.txt";
		ruta_Nombres = ruta_Carpeta + "\\nombres_jugadores.txt";
	}

	private void pedirNombreJugador() {
		boolean valido = false;
		while (!valido) {
			nombreJugador = JOptionPane.showInputDialog("Introduce tu nombre:");
			if (nombreJugador == null || nombreJugador.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
				continue;
			}
			if (nombreRepetido(nombreJugador)) {
				JOptionPane.showMessageDialog(this, "Ese nombre ya está en uso.");
			} else {
				guardarNombre(nombreJugador);
				valido = true;
			}
		}
	}

	private boolean nombreRepetido(String nombre) {
		File f = new File(ruta_Nombres);
		if (!f.exists())
			return false;
		try (Scanner sc = new Scanner(f)) {
			while (sc.hasNextLine()) {
				if (sc.nextLine().trim().equalsIgnoreCase(nombre.trim()))
					return true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void guardarNombre(String nombre) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Nombres, true))) {
			pw.println(nombre);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void borrarNombreJugador(String nombre) {
		File archivo = new File(ruta_Nombres);
		if (!archivo.exists())
			return;

		File temporal = new File(ruta_Carpeta + "\\nombres_jugadores_temp.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(archivo));
				PrintWriter pw = new PrintWriter(new FileWriter(temporal))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				if (!linea.trim().equalsIgnoreCase(nombre.trim())) {
					pw.println(linea);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (archivo.delete()) {
			temporal.renameTo(archivo);
		}
	}

	private void llenarArrayNumeros(int[] arrayNumeros2) {
		int num;
		boolean repetido;

		for (int i = 0; i < arrayNumeros2.length; i++) {
			do {
				num = (int) (Math.random() * 90) + 1;
				repetido = false;
				for (int j = 0; j < i; j++) {
					if (arrayNumeros2[j] == num) {
						repetido = true;
					}
				}
			} while (repetido == true);
			arrayNumeros2[i] = num;
		}
	}

	private void llenarArrayBotones(JButton[] arrayBotones2) {
		arrayBotones2[0] = btn1;
		arrayBotones2[1] = btn2;
		arrayBotones2[2] = btn3;
		arrayBotones2[3] = btn4;
		arrayBotones2[4] = btn5;
		arrayBotones2[5] = btn6;
		arrayBotones2[6] = btn7;
		arrayBotones2[7] = btn8;
		arrayBotones2[8] = btn9;
		arrayBotones2[9] = btn10;
		arrayBotones2[10] = btn11;
		arrayBotones2[11] = btn12;
		arrayBotones2[12] = btn13;
		arrayBotones2[13] = btn14;
		arrayBotones2[14] = btn15;
		arrayBotones2[15] = btn16;
		arrayBotones2[16] = btn17;
		arrayBotones2[17] = btn18;
		arrayBotones2[18] = btn19;
		arrayBotones2[19] = btn20;
		arrayBotones2[20] = btn21;
		arrayBotones2[21] = btn22;
		arrayBotones2[22] = btn23;
		arrayBotones2[23] = btn24;
		arrayBotones2[24] = btn25;
	}

	private void asignarNumerosABotones() {
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setText(String.valueOf(arrayNumeros[i]));
		}
	}

	// GRUPO 2: LÓGICA DE JUEGO (EVENTOS DE CLICK)

	private void clickBoton() {
		for (JButton boton : arrayBotones) {
			boton.addActionListener(e -> {
				if (esperandoValidacion)
					return;

				boton.setBackground(new Color(150, 33, 33));
				boton.setEnabled(false);

				if (!bingoEncontrado && comprobacionBingo() == BINGO) {
					bingoEncontrado = true;
					notificarEvento("BINGO");
				} else if (!lineaEncontrada && !bingoEncontrado && !lineaGlobalConfirmada) {
					int resultadoLinea = comprobacionLineaConFila();
					if (resultadoLinea >= 0) {
						filaActualLinea = resultadoLinea;
						lineaEncontrada = true;
						notificarEvento("LINEA");
					}
				}
			});
		}
	}

	private void notificarEvento(String tipo) {
		if (esperandoValidacion)
			return;

		boolean valido = false;

		if (tipo.equals("LINEA")) {
			if (filaActualLinea >= 0) {
				valido = true;
				for (int col = 0; col < 5; col++) {
					int num = Integer.parseInt(arrayBotones[filaActualLinea * 5 + col].getText());
					if (!numeroHaSalido(num)) {
						valido = false;
						break;
					}
				}
			}
		} else if (tipo.equals("BINGO")) {
			valido = numerosDeBingoHanSalido();
		}

		if (!valido) {
			System.out.println("[DEBUG] " + tipo + " no válida - números no han salido");
			mostrarAviso(tipo + " no válida",
					"¡" + tipo + " no válida! Algunos números aún no han salido del bombo.");
			desmarcarNumerosNoValidos();

			if (tipo.equals("LINEA")) {
				lineaEncontrada = false;
				filaActualLinea = -1;
			} else if (tipo.equals("BINGO")) {
				bingoEncontrado = false;
			}
			return;
		}

		if (tipo.equals("BINGO")) {
			desactivarBotones();
		}

		esperandoValidacion = true;

		try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Eventos, true))) {
			pw.println("COMPROBANDO:" + nombreJugador + ":" + tipo);
			System.out.println("[DEBUG] Escrito: COMPROBANDO:" + nombreJugador + ":" + tipo);
		} catch (IOException e) {
			System.err.println("[ERROR] No se pudo escribir el evento: " + e.getMessage());
		}

		hacerPreguntaSostenibilidad(tipo);
	}

	private void hacerPreguntaSostenibilidad(String tipo) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Eventos, true))) {
			pw.println("BLOQUEAR_BOTON");
			pw.flush();
		} catch (IOException ex) {
			System.err.println("[ERROR] al escribir BLOQUEAR_BOTON: " + ex.getMessage());
		}

		int indice = (int) (Math.random() * preguntasRespuestas.length);
		String pregunta = preguntasRespuestas[indice][0];

		String[] opts = new String[4];
		int n = 0;
		for (int i = 1; i <= 4; i++)
			if (preguntasRespuestas[indice][i] != null && !preguntasRespuestas[indice][i].isEmpty())
				opts[n++] = preguntasRespuestas[indice][i];
		opts = java.util.Arrays.copyOf(opts, n);

		int correcta = Integer.parseInt(preguntasRespuestas[indice][5]);
		barajarArray(opts);
		int nuevaCorrecta = java.util.Arrays.asList(opts).indexOf(preguntasRespuestas[indice][correcta + 1]);

		String foto = preguntasRespuestas[indice][6];
		JLabel lblFoto = null;
		if (foto != null && !foto.isEmpty()) {
			String rutaFoto = ruta_Carpeta + "\\imagenes\\" + foto;
			ImageIcon icono = new ImageIcon(rutaFoto);
			Image img = icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			lblFoto = new JLabel(new ImageIcon(img));
		}

		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		ButtonGroup grupo = new ButtonGroup();
		JRadioButton[] radios = new JRadioButton[opts.length];

		for (int i = 0; i < opts.length; i++) {
			radios[i] = new JRadioButton(opts[i]);
			grupo.add(radios[i]);
			panelOpciones.add(radios[i]);
		}
		radios[0].setSelected(true);

		JPanel total = new JPanel(new BorderLayout());
		if (lblFoto != null)
			total.add(lblFoto, BorderLayout.NORTH);
		total.add(new JLabel(pregunta), BorderLayout.CENTER);
		total.add(panelOpciones, BorderLayout.SOUTH);

		int resultado = JOptionPane.showConfirmDialog(this, total, "Pregunta - " + tipo,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		int resp = -1;
		for (int i = 0; i < radios.length; i++) {
			if (radios[i].isSelected()) {
				resp = i;
				break;
			}
		}
		if (resultado != JOptionPane.OK_OPTION)
			resp = -1;

		boolean acierto = (resp == nuevaCorrecta);

		try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Eventos, true))) {
			if (acierto) {
				pw.println(tipo + ":" + nombreJugador);
				pw.flush();

				if (tipo.equals("LINEA")) {
					setEstadoLinea("CONFIRMADA:" + nombreJugador);
					lineaGlobalConfirmada = true;
					mostrarAviso("Línea validada", "¡Acertaste! LÍNEA válida.");
					System.out.println("[DEBUG] Línea confirmada globalmente por " + nombreJugador);
				} else if (tipo.equals("BINGO")) {
					mostrarAviso("¡BINGO GANADOR!", "¡Felicidades! Has ganado el BINGO.");
					desactivarBotones();
					System.out.println("[DEBUG] Bingo confirmado globalmente por " + nombreJugador);
				}
			} else {
				pw.println("FALLO:" + nombreJugador + ":" + tipo);
				pw.flush();

				if (tipo.equals("LINEA")) {
					mostrarAviso("Fallo en LÍNEA",
							"¡Respuesta incorrecta! Esta línea ya no es válida, intenta con otra.");
					if (filaActualLinea >= 0) {
						filaFallida[filaActualLinea] = true;
						System.out.println("[DEBUG] Fila " + filaActualLinea + " marcada como fallida para " + nombreJugador);
					}
					lineaEncontrada = false;
					filaActualLinea = -1;
				} else if (tipo.equals("BINGO")) {
					mostrarAviso("Fallo en BINGO", "¡Respuesta incorrecta! Has perdido la oportunidad de ganar.");
					desactivarBotones();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (PrintWriter pwr = new PrintWriter(new FileWriter(ruta_Eventos, true))) {
			pwr.println("DESBLOQUEAR_BOTON");
			pwr.flush();
		} catch (IOException ex) {
			System.err.println("[ERROR] al escribir DESBLOQUEAR_BOTON: " + ex.getMessage());
		}

		esperandoValidacion = false;
	}

	private void desmarcarNumerosNoValidos() {
		for (JButton boton : arrayBotones) {
			if (!boton.isEnabled()) {
				int num = Integer.parseInt(boton.getText());
				if (!numeroHaSalido(num)) {
					boton.setEnabled(true);
					boton.setBackground(colorOriginal);
				}
			}
		}
	}

	private void desactivarBotones() {
		for (JButton b : arrayBotones)
			b.setEnabled(false);
	}

	// GRUPO 3: COMPROBACIONES DE ESTADO DEL JUEGO

	public int comprobacionBingo() {
		for (int i = 0; i < arrayBotones.length; i++) {
			if (arrayBotones[i].isEnabled()) {
				return NO_FIN;
			}
		}
		return BINGO;
	}

	public int comprobacionLinea() {
		return (comprobacionLineaConFila() >= 0) ? LINEA : NO_FIN;
	}

	private int comprobacionLineaConFila() {
		for (int fila = 0; fila < 5; fila++) {
			if (filaFallida[fila])
				continue;

			boolean filaCompleta = true;
			for (int col = 0; col < 5; col++) {
				if (arrayBotones[fila * 5 + col].isEnabled()) {
					filaCompleta = false;
					break;
				}
			}

			if (filaCompleta) {
				System.out.println("[DEBUG] Fila " + fila + " detectada como línea");
				return fila;
			}
		}
		return -1;
	}

	private boolean numerosDeBingoHanSalido() {
		for (JButton boton : arrayBotones) {
			if (!boton.isEnabled()) {
				int num = Integer.parseInt(boton.getText());
				if (!numeroHaSalido(num))
					return false;
			}
		}
		return true;
	}

	private boolean numeroHaSalido(int num) {
		File archivo = new File(ruta_Bombo);
		if (!archivo.exists())
			return false;

		try (Scanner sc = new Scanner(archivo)) {
			if (!sc.hasNextInt())
				return false;
			sc.nextInt();

			if (!sc.hasNextLine())
				return false;
			sc.nextLine();

			if (!sc.hasNextLine())
				return false;
			String linea = sc.nextLine();

			String[] numeros = linea.split(",");
			for (String n : numeros) {
				String str = n.trim();
				if (!str.isEmpty() && Integer.parseInt(str) == num) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// GRUPO 4: MONITOREO DE ARCHIVOS (TIMERS Y RED)

	private void iniciarMonitoreoArchivo() {
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File archivo = new File(ruta_Bombo);

				if (archivo.exists()) {
					long modificacion = archivo.lastModified();

					if (modificacion != ultimaModificacionBombo) {
						ultimaModificacionBombo = modificacion;
						cargarNumero();
					}
				}
			}
		});

		timer.start();
	}

	public void cargarNumero() {
		File archivo = new File(ruta_Bombo);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
					pw.println("0");
					pw.print("");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (Scanner sc = new Scanner(archivo)) {
			if (!sc.hasNextInt())
				return;
			int ultimoNumero = sc.nextInt();
			lblNumeroActual.setText(Integer.toString(ultimoNumero));

		} catch (Exception e) {
			System.err.println("Error al cargar número: " + e.getMessage());
		}
	}

	private void monitorearEstadoLinea() {
		Timer timer = new Timer(500, e -> {
			String estado = obtenerEstadoLinea();

			if (estado.startsWith("CONFIRMADA:") && !lineaGlobalConfirmada) {
				lineaGlobalConfirmada = true;
				String ganador = estado.substring(11);

				if (!ganador.equalsIgnoreCase(nombreJugador)) {
					mostrarAviso("Línea confirmada",
							"¡" + ganador + " ha conseguido LÍNEA!\nYa no se pueden hacer más líneas.");
				}

				System.out.println("[DEBUG] Línea global confirmada. Jugador: " + nombreJugador + " ya no puede hacer líneas.");
			}
		});
		timer.start();
	}

	private void monitorearEstadoBingo() {
		Timer timer = new Timer(500, e -> {
			String estado = obtenerEstadoBingo();
			if (estado.startsWith("CONFIRMADA:") && !bingoGlobalConfirmado) {
				bingoGlobalConfirmado = true;
				String ganador = estado.substring(11);
				if (!ganador.equalsIgnoreCase(nombreJugador)) {
					mostrarAviso("Bingo confirmado",
							"¡" + ganador + " ha hecho BINGO!\nEl juego ha finalizado.");
				}
				desactivarBotones();
				System.out.println("[DEBUG] Bingo global confirmado. Jugador: " + nombreJugador);
			}
		});
		timer.start();
	}

	private String obtenerEstadoBingo() {
		File f = new File(ruta_Carpeta + "\\bingo_estado.txt");
		if (!f.exists())
			return "PENDIENTE";
		try (Scanner sc = new Scanner(f)) {
			return sc.hasNextLine() ? sc.nextLine().trim() : "PENDIENTE";
		} catch (Exception e) {
			return "PENDIENTE";
		}
	}

	private void monitorearEventosGlobales() {
		Timer timer = new Timer(800, e -> {
			File f = new File(ruta_Eventos);
			if (!f.exists() || f.length() == 0)
				return;

			try (Scanner sc = new Scanner(f)) {
				while (sc.hasNextLine()) {
					String linea = sc.nextLine().trim();
					if (linea.isEmpty())
						continue;

					System.out.println("[DEBUG] " + nombreJugador + " leyó: " + linea);

					if (linea.startsWith("COMPROBANDO:")) {
						String[] p = linea.split(":");
						if (p.length >= 3) {
							String jugador = p[1];
							String tipo = p[2];

							if (!jugador.equalsIgnoreCase(nombreJugador)) {
								mostrarAviso("Comprobando " + tipo,
										"¡" + jugador + " ha hecho " + tipo + "!\nSe está comprobando...");
							}
						}
					} else if (linea.startsWith("FALLO:")) {
						String[] p = linea.split(":");
						if (p.length >= 3) {
							String jugador = p[1];
							String tipo = p[2];

							if (!jugador.equalsIgnoreCase(nombreJugador)) {
								mostrarAviso("Fallo en " + tipo,
										"¡" + jugador + " ha fallado la pregunta de " + tipo + "!");
							}
						}
					} else if (linea.startsWith("LINEA:")) {
						String[] p = linea.split(":");
						if (p.length >= 2) {
							String jugador = p[1];
							if (!jugador.equalsIgnoreCase(nombreJugador)) {
								mostrarAviso("Línea confirmada", "¡" + jugador + " ha hecho LÍNEA!");
							}
						}
					} else if (linea.startsWith("BINGO:")) {
						String[] p = linea.split(":");
						if (p.length >= 2) {
							String jugador = p[1];
							if (!jugador.equalsIgnoreCase(nombreJugador)) {
								mostrarAviso("Bingo confirmado", "¡" + jugador + " ha hecho BINGO!");
							}
						}
					}
				}
			} catch (Exception ex) {
				System.err.println("[ERROR] monitorearEventosGlobales: " + ex.getMessage());
			}
		});
		timer.start();
	}

	private String obtenerEstadoLinea() {
		File f = new File(ruta_Linea);
		if (!f.exists())
			return "PENDIENTE";
		try (Scanner sc = new Scanner(f)) {
			return sc.hasNextLine() ? sc.nextLine().trim() : "PENDIENTE";
		} catch (Exception e) {
			return "PENDIENTE";
		}
	}

	private void setEstadoLinea(String estado) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Linea))) {
			pw.println(estado);
			System.out.println("[DEBUG] Estado de línea actualizado: " + estado);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	private void cargarPreguntas() {
		preguntasRespuestas = new String[20][7];

		preguntasRespuestas[0][0] = "Los stakeholders influyen en las decisiones de sostenibilidad de una empresa.";
		preguntasRespuestas[0][1] = "Verdadero";
		preguntasRespuestas[0][2] = "Falso";
		preguntasRespuestas[0][3] = null;
		preguntasRespuestas[0][4] = null;
		preguntasRespuestas[0][5] = "0";
		preguntasRespuestas[0][6] = null;

		preguntasRespuestas[1][0] = "Los criterios ambientales evalúan el impacto de la actividad empresarial en el medioambiente y la gestión de recursos naturales.";
		preguntasRespuestas[1][1] = "Verdadero";
		preguntasRespuestas[1][2] = "Falso";
		preguntasRespuestas[1][3] = null;
		preguntasRespuestas[1][4] = null;
		preguntasRespuestas[1][5] = "0";
		preguntasRespuestas[1][6] = null;

		preguntasRespuestas[2][0] = "Un solo correo electrónico o un mensaje en la nube no genera ninguna huella de carbono, ya que no se imprime en papel.";
		preguntasRespuestas[2][1] = "Falso";
		preguntasRespuestas[2][2] = "Verdadero";
		preguntasRespuestas[2][3] = null;
		preguntasRespuestas[2][4] = null;
		preguntasRespuestas[2][5] = "0";
		preguntasRespuestas[2][6] = null;

		preguntasRespuestas[3][0] = "Mantener muchas aplicaciones abiertas en segundo plano puede provocar más consumo de energía.";
		preguntasRespuestas[3][1] = "Verdadero";
		preguntasRespuestas[3][2] = "Falso";
		preguntasRespuestas[3][3] = null;
		preguntasRespuestas[3][4] = null;
		preguntasRespuestas[3][5] = "0";
		preguntasRespuestas[3][6] = null;

		preguntasRespuestas[4][0] = "La sostenibilidad empresarial es un proyecto puntual y finito que se ejecuta una vez y se termina, no es un proceso continuo.";
		preguntasRespuestas[4][1] = "Falso";
		preguntasRespuestas[4][2] = "Verdadero";
		preguntasRespuestas[4][3] = null;
		preguntasRespuestas[4][4] = null;
		preguntasRespuestas[4][5] = "0";
		preguntasRespuestas[4][6] = null;

		preguntasRespuestas[5][0] = "¿Cuántos Objetivos de Desarrollo Sostenible (ODS) establece la Agenda 2030?";
		preguntasRespuestas[5][1] = "17";
		preguntasRespuestas[5][2] = "15";
		preguntasRespuestas[5][3] = "20";
		preguntasRespuestas[5][4] = "25";
		preguntasRespuestas[5][5] = "0";
		preguntasRespuestas[5][6] = null;

		preguntasRespuestas[6][0] = "¿Quiénes son los stakeholders?";
		preguntasRespuestas[6][1] = "Todas las personas o grupos afectados por la actividad de una empresa";
		preguntasRespuestas[6][2] = "Los empleados que trabajan en una empresa";
		preguntasRespuestas[6][3] = "La competencia de una empresa";
		preguntasRespuestas[6][4] = "Los clientes de una empresa";
		preguntasRespuestas[6][5] = "0";
		preguntasRespuestas[6][6] = null;

		preguntasRespuestas[7][0] = "¿Qué práctica ayuda a disminuir el consumo eléctrico de un ordenador?";
		preguntasRespuestas[7][1] = "Ajustar el Ahorro de energía y gestionar del brillo";
		preguntasRespuestas[7][2] = "Aumentar la potencia del procesador constantemente";
		preguntasRespuestas[7][3] = "Mantener encendido el equipo todo el día";
		preguntasRespuestas[7][4] = "Utilizar siempre la máxima velocidad del ventilador";
		preguntasRespuestas[7][5] = "0";
		preguntasRespuestas[7][6] = null;

		preguntasRespuestas[8][0] = "¿Qué acción contribuye directamente a reducir los RAEE (Residuos de Aparatos Eléctricos y Electrónicos)?";
		preguntasRespuestas[8][1] = "Reparar y actualizar componentes de dispositivos existentes para extender su vida útil";
		preguntasRespuestas[8][2] = "Comprar nuevos dispositivos cada 12 meses para permanecer actualizado en tecnología";
		preguntasRespuestas[8][3] = "Desechar dispositivos electrónicos en la basura común cuando ya no funcionan";
		preguntasRespuestas[8][4] = "Acumular dispositivos electrónicos viejos en casa sin uso";
		preguntasRespuestas[8][5] = "0";
		preguntasRespuestas[8][6] = null;

		preguntasRespuestas[9][0] = "Cuando un equipo informático se recicla correctamente, ¿cuál es el beneficio principal?";
		preguntasRespuestas[9][1] = "Recuperar materiales útiles y reducir la contaminación";
		preguntasRespuestas[9][2] = "Aumentar la cantidad de residuos generados para su tratamiento";
		preguntasRespuestas[9][3] = "Garantizar que todos los componentes se destruyan por completo";
		preguntasRespuestas[9][4] = "Evitar que el equipo pueda ser reutilizado de cualquier forma";
		preguntasRespuestas[9][5] = "0";
		preguntasRespuestas[9][6] = null;

		preguntasRespuestas[10][0] = "Cuando hablamos de criterios ASG…";
		preguntasRespuestas[10][1] = "Nos referimos a criterios ambientales, sociales y de gobernanza";
		preguntasRespuestas[10][2] = "Las empresas los suelen poner en práctica de forma independiente";
		preguntasRespuestas[10][3] = "Las decisiones que se tomen al aplicarnos solo tienen un efecto local";
		preguntasRespuestas[10][4] = "Todas las respuestas son correctas";
		preguntasRespuestas[10][5] = "0";
		preguntasRespuestas[10][6] = null;

		preguntasRespuestas[11][0] = "¿Cuáles son las 5 'P' (pilares) del desarrollo sostenible?";
		preguntasRespuestas[11][1] = "Personas, Planeta, Prosperidad, Paz y Participación";
		preguntasRespuestas[11][2] = "Política, Productividad, Personas, Paz y Planificación";
		preguntasRespuestas[11][3] = "Planeta, Petróleo, Personas, Producción y Política";
		preguntasRespuestas[11][4] = "Personas, Promoción, Prosperidad, Planos y Planificación";
		preguntasRespuestas[11][5] = "0";
		preguntasRespuestas[11][6] = null;

		preguntasRespuestas[12][0] = "¿A cuál de las siguientes ODS pertenece esta imagen?";
		preguntasRespuestas[12][1] = "Acción por el clima";
		preguntasRespuestas[12][2] = "Vida de Ecosistemas Terrestres";
		preguntasRespuestas[12][3] = "Salud y Bienestar";
		preguntasRespuestas[12][4] = "Ciudades y Comunidades Sostenibles";
		preguntasRespuestas[12][5] = "0";
		preguntasRespuestas[12][6] = "IconoVerde.png";

		preguntasRespuestas[13][0] = "¿A cuál de las siguientes ODS pertenece esta imagen?";
		preguntasRespuestas[13][1] = "Agua Limpia y Saneamiento";
		preguntasRespuestas[13][2] = "Vida Submarina";
		preguntasRespuestas[13][3] = "Salud y Bienestar";
		preguntasRespuestas[13][4] = "Producción y consumo responsable";
		preguntasRespuestas[13][5] = "0";
		preguntasRespuestas[13][6] = "IconoAzul.png";

		preguntasRespuestas[14][0] = "¿Por qué es relevante la eficiencia del código en proyectos grandes?";
		preguntasRespuestas[14][1] = "Una mayor eficiencia reduce el consumo de recursos en miles de dispositivos";
		preguntasRespuestas[14][2] = "La eficiencia solo afecta la legibilidad del código";
		preguntasRespuestas[14][3] = "El desempeño no influye en el impacto ambiental";
		preguntasRespuestas[14][4] = "Los recursos consumidos por el software son siempre los mismos, optimizado o no";
		preguntasRespuestas[14][5] = "0";
		preguntasRespuestas[14][6] = null;

		preguntasRespuestas[15][0] = "¿Qué stakeholders son los que aportan capital para financiar la empresa esperando una rentabilidad futura?";
		preguntasRespuestas[15][1] = "Inversores";
		preguntasRespuestas[15][2] = "Clientes";
		preguntasRespuestas[15][3] = "Medios de comunicación";
		preguntasRespuestas[15][4] = "Empleados";
		preguntasRespuestas[15][5] = "0";
		preguntasRespuestas[15][6] = null;

		preguntasRespuestas[16][0] = "¿Qué ventaja ecológica se atribuye a la computación en la nube?";
		preguntasRespuestas[16][1] = "Aprovecha mejor los recursos mediante infraestructura compartida";
		preguntasRespuestas[16][2] = "Reduce por completo la necesidad de servidores físicos";
		preguntasRespuestas[16][3] = "Elimina la necesidad de mantenimiento energético";
		preguntasRespuestas[16][4] = "Disminuye automáticamente la huella de carbono a cero";
		preguntasRespuestas[16][5] = "0";
		preguntasRespuestas[16][6] = null;

		preguntasRespuestas[17][0] = "¿Qué contribuye a que los centros de datos sean más sostenibles?";
		preguntasRespuestas[17][1] = "Mejorar sistemas de refrigeración y gestión térmica";
		preguntasRespuestas[17][2] = "Instalar más servidores para evitar saturación";
		preguntasRespuestas[17][3] = "Mantener temperaturas elevadas para ahorrar energía";
		preguntasRespuestas[17][4] = "Apagar servidores de forma aleatoria";
		preguntasRespuestas[17][5] = "0";
		preguntasRespuestas[17][6] = null;

		preguntasRespuestas[18][0] = "¿Qué papel tienen las certificaciones energéticas en dispositivos?";
		preguntasRespuestas[18][1] = "Indican que el equipo consume menos energía en condiciones normales";
		preguntasRespuestas[18][2] = "Garantizan que el dispositivo es más potente";
		preguntasRespuestas[18][3] = "Aseguran que el dispositivo tiene mayor vida útil";
		preguntasRespuestas[18][4] = "Determinan el costo del dispositivo en el mercado";
		preguntasRespuestas[18][5] = "0";
		preguntasRespuestas[18][6] = null;

		preguntasRespuestas[19][0] = "¿Cómo puede una empresa reducir el consumo energético durante las compilaciones de software?";
		preguntasRespuestas[19][1] = "Programando compilaciones solo cuando se detecten cambios relevantes";
		preguntasRespuestas[19][2] = "Compilando el proyecto completo cada hora";
		preguntasRespuestas[19][3] = "Ejecutando compilaciones automáticas 24/7";
		preguntasRespuestas[19][4] = "Creando múltiples servidores dedicados solo a compilar";
		preguntasRespuestas[19][5] = "0";
		preguntasRespuestas[19][6] = null;
	}

	private static void barajarArray(String[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			String tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
}