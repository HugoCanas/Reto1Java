import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
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
	// ✅ CONSTANTE CON LA RUTA BASE
	private static final String RUTA_CARPETA = "C:\\BingoCompartido";
	private static final String RUTA_BOMBO = RUTA_CARPETA + "\\bombo_bingo.txt";
	private static final String RUTA_LINEA = RUTA_CARPETA + "\\linea_estado.txt";
	private static final String RUTA_EVENTOS = RUTA_CARPETA + "\\eventos_bingo.txt";
	
	private JPanel contentPane;
	private JButton newnumber;
	private int[] arrayNumeros;
	private JButton[] botones;
	private JLabel nuevoNumlabel;
	private JLabel antNumlabel;
	private int cont=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// ✅ DEBUG: Verificar la ruta
		System.out.println("=== DEPURACIÓN DE RUTAS ===");
		System.out.println("RUTA_CARPETA definida: " + RUTA_CARPETA);
		System.out.println("RUTA_BOMBO definida: " + RUTA_BOMBO);
		
		File carpeta = new File(RUTA_CARPETA);
		System.out.println("Ruta absoluta real: " + carpeta.getAbsolutePath());
		System.out.println("¿Carpeta existe? " + carpeta.exists());
		
		boolean creada = carpeta.mkdirs();
		System.out.println("Carpeta creada o ya existía: " + creada);
		System.out.println("¿Ahora existe? " + carpeta.exists());
		System.out.println("========================\n");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bombo frame = new Bombo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		numeros.setBounds(10, 24, 492, 426);
		contentPane.add(numeros);
		numeros.setLayout(new GridLayout(9, 10, 0, 0));
		
		botones = new JButton[90];
		for (int i = 0; i < 90; i++) {  // De 0 a 89
		    JButton btn = new JButton(String.valueOf(i + 1));  // Texto del 1 al 90
		    botones[i] = btn;  // Guardamos en posición i
		    numeros.add(btn);
		}

		JPanel control = new JPanel();
		control.setBackground(new Color(192, 192, 192));
		control.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		control.setBounds(521, 24, 351, 426);
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

		arrayNumeros = new int [90];
		registrarEventos();
		monitorearEventos();
		
		// ✅ CREAR LA CARPETA Y LOS ARCHIVOS
		try {
			File carpeta = new File(RUTA_CARPETA);
			System.out.println("\n=== EN CONSTRUCTOR ===");
			System.out.println("Intentando crear carpeta en: " + carpeta.getAbsolutePath());
			
			if (!carpeta.exists()) {
				boolean creada = carpeta.mkdirs();
				System.out.println("Carpeta creada: " + creada);
			} else {
				System.out.println("Carpeta ya existe");
			}
			
			// Crear/resetear bombo_bingo.txt
			File archivoBombo = new File(RUTA_BOMBO);
			System.out.println("Creando archivo bombo en: " + archivoBombo.getAbsolutePath());
			try (PrintWriter pw = new PrintWriter(archivoBombo)) {
				pw.println("0"); // Número inicial
				pw.println(""); // Lista vacía de números
				System.out.println("✓ Archivo bombo_bingo.txt creado exitosamente");
			}
			
			// Resetear estado de línea
			File archivoLinea = new File(RUTA_LINEA);
			System.out.println("Creando archivo línea en: " + archivoLinea.getAbsolutePath());
			try (PrintWriter pw = new PrintWriter(archivoLinea)) {
				pw.println("PENDIENTE");
				System.out.println("✓ Archivo linea_estado.txt creado exitosamente");
			}
			
			// Crear archivo de eventos si no existe
			File archivoEventos = new File(RUTA_EVENTOS);
			System.out.println("Creando archivo eventos en: " + archivoEventos.getAbsolutePath());
			if (!archivoEventos.exists()) {
				archivoEventos.createNewFile();
				System.out.println("✓ Archivo eventos_bingo.txt creado exitosamente");
			} else {
				System.out.println("✓ Archivo eventos_bingo.txt ya existe");
			}
			System.out.println("======================\n");
			
		} catch (IOException e) {
			System.err.println("❌ ERROR al crear archivos: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
				"Error al crear archivos en C:/BingoCompartido\n" +
				"Verifica los permisos o ejecuta como administrador", 
				"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void registrarEventos() {
		newnumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nuevoNumero(arrayNumeros);
				if(cont==90)
				{
					newnumber.setEnabled(false);
				}
			}
		});
	}
	
	public void nuevoNumero(int[] arrayNumeros2) {
		int num;
		boolean repetido;

			do {
				num = (int)(Math.random() * 90) + 1; 
				repetido = false;

				for(int j=0; j<cont;j++) {
					if(arrayNumeros2[j] == num) {
						repetido = true;
					}
				}

			} while(repetido==true);
			
			arrayNumeros2[cont] = num;
			System.out.print(arrayNumeros2[cont] + " ");
			nuevoNumlabel.setText(Integer.toString(num));
			botones[num-1].setEnabled(false);
			numeroAnterior();
			cont++;
			guardarNumero();
			
		}
	
	
		public void numeroAnterior()
		{
			if(cont > 0) {
				antNumlabel.setText(Integer.toString(arrayNumeros[cont-1]));
			}
		}
		
		public void guardarNumero() {
		    // ✅ DEPURACIÓN COMPLETA
		    System.out.println("\n=== GUARDANDO NÚMERO ===");
		    System.out.println("RUTA_BOMBO constante: " + RUTA_BOMBO);
		    
		    File archivo = new File(RUTA_BOMBO);
		    System.out.println("Ruta absoluta del archivo: " + archivo.getAbsolutePath());
		    System.out.println("Directorio padre: " + archivo.getParent());
		    
		    try (PrintWriter pw = new PrintWriter(archivo)) {
		        // Primera línea: número actual (el último que salió)
		        if (cont > 0) {
		            pw.println(arrayNumeros[cont - 1]);
		        } else {
		            pw.println("0");
		        }

		        // Segunda línea: todos los números que han salido (separados por comas)
		        for (int i = 0; i < cont; i++) {
		            pw.print(arrayNumeros[i]);
		            if (i < cont - 1) {
		                pw.print(",");
		            }
		        }

		        System.out.println("✓ Estado guardado correctamente");
		        System.out.println("=======================\n");

		    } catch (FileNotFoundException e) {
		        System.err.println("❌ Error al guardar: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
		
		private void monitorearEventos() {
		    Timer timer = new Timer(500, e -> {
		        File f = new File(RUTA_EVENTOS);
		        if (!f.exists()) {
		            try {
		                f.createNewFile();
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }

		        try (Scanner scanner = new Scanner(f)) {
		            boolean leido = false;
		            while (scanner.hasNextLine()) {
		                String linea = scanner.nextLine();
		                System.out.println("[DEBUG] Leído de eventos_bingo.txt: " + linea);
		                if (linea.startsWith("LINEA:")) {
		                    leido = true;
		                    String jugador = linea.substring(6);
		                    JOptionPane.showMessageDialog(null, "¡" + jugador + " ha hecho LÍNEA!");
		                } else if (linea.startsWith("BINGO:")) {
		                    leido = true;
		                    String jugador = linea.substring(6);
		                    JOptionPane.showMessageDialog(null, "¡" + jugador + " ha hecho BINGO!");
		                } else if (linea.startsWith("COMPROBANDO:")) {
		                    leido = true;
		                    String[] partes = linea.split(":");
		                    String jugador = partes[1];
		                    String tipo = partes[2];
		                    JOptionPane.showMessageDialog(null, "¡" + jugador + " ha hecho " + tipo + "! Se está comprobando...");
		                } else if (linea.startsWith("FALLO:")) {
		                    leido = true;
		                    String[] partes = linea.split(":");
		                    String jugador = partes[1];
		                    String tipo = partes[2];
		                    JOptionPane.showMessageDialog(null, "¡" + jugador + " ha fallado la pregunta! El juego continúa.");
		                }
		            }

		            //Solo borra si se ha leído y procesado al menos un evento válido
		            if (leido) {
		                try (PrintWriter pw = new PrintWriter(RUTA_EVENTOS)) {
		                    // Vaciar archivo
		                } catch (FileNotFoundException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		        }
		    });
		    timer.start();
		}
}
