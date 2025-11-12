import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bingo extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int NO_FIN = 0;
	public static final int LINEA = 1;
	public static final int BINGO = 2;
	private static final String RUTA_CARPETA = "\\\\\\\\ipServidor\\BingoCompartido";
	private static final String RUTA_BOMBO   = RUTA_CARPETA + "\\bombo_bingo.txt";
	private static final String RUTA_LINEA   = RUTA_CARPETA + "\\linea_estado.txt";
	private static final String RUTA_EVENTOS = RUTA_CARPETA + "\\eventos_bingo.txt";
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
	//private String tipoEventoPendiente = "";
	private boolean[] filaFallida = new boolean[5];
	private int filaActualLinea = -1; // Guardar qué fila está siendo validada
	private boolean lineaGlobalConfirmada = false; // Estado local del archivo compartido
	private String ipServidor;

	/**
	 * Launch the application.
	 */
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

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn22 = new JButton("New button");
		btn22.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn22.setBounds(151, 387, 112, 78);
		contentPane.add(btn22);

		btn23 = new JButton("New button");
		btn23.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn23.setBounds(263, 387, 112, 78);
		contentPane.add(btn23);

		btn24 = new JButton("New button");
		btn24.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn24.setBounds(376, 387, 112, 78);
		contentPane.add(btn24);

		btn25 = new JButton("New button");
		btn25.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn25.setBounds(490, 387, 112, 78);
		contentPane.add(btn25);

		btn20 = new JButton("New button");
		btn20.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn20.setBounds(490, 309, 112, 78);
		contentPane.add(btn20);

		btn15 = new JButton("New button");
		btn15.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn15.setBounds(490, 232, 112, 78);
		contentPane.add(btn15);

		btn10 = new JButton("New button");
		btn10.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn10.setBounds(490, 154, 112, 78);
		contentPane.add(btn10);

		btn5 = new JButton("New button");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn5.setBounds(490, 75, 112, 78);
		contentPane.add(btn5);

		btn19 = new JButton("New button");
		btn19.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn19.setBounds(376, 309, 112, 78);
		contentPane.add(btn19);

		btn18 = new JButton("New button");
		btn18.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn18.setBounds(263, 309, 112, 78);
		contentPane.add(btn18);

		btn17 = new JButton("New button");
		btn17.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn17.setBounds(151, 309, 112, 78);
		contentPane.add(btn17);

		btn12 = new JButton("New button");
		btn12.setForeground(new Color(0, 0, 0));
		btn12.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn12.setBounds(151, 232, 112, 78);
		contentPane.add(btn12);

		btn13 = new JButton("New button");
		btn13.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn13.setBounds(263, 232, 112, 78);
		contentPane.add(btn13);

		btn14 = new JButton("New button");
		btn14.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn14.setBounds(376, 232, 112, 78);
		contentPane.add(btn14);

		btn9 = new JButton("New button");
		btn9.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn9.setBounds(376, 154, 112, 78);
		contentPane.add(btn9);

		btn4 = new JButton("New button");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn4.setBounds(376, 75, 112, 78);
		contentPane.add(btn4);

		btn3 = new JButton("New button");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn3.setBounds(263, 75, 112, 78);
		contentPane.add(btn3);

		btn8 = new JButton("New button");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn8.setBounds(263, 154, 112, 78);
		contentPane.add(btn8);

		btn7 = new JButton("New button");
		btn7.setForeground(new Color(0, 0, 0));
		btn7.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn7.setBounds(151, 154, 112, 78);
		contentPane.add(btn7);

		btn2 = new JButton("New button");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn2.setBounds(151, 75, 112, 78);
		contentPane.add(btn2);

		btn21 = new JButton("New button");
		btn21.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn21.setBounds(39, 387, 112, 78);
		contentPane.add(btn21);

		btn16 = new JButton("New button");
		btn16.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn16.setBounds(39, 309, 112, 78);
		contentPane.add(btn16);

		btn11 = new JButton("New button");
		btn11.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn11.setBounds(39, 232, 112, 78);
		contentPane.add(btn11);

		btn6 = new JButton("New button");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn6.setBounds(39, 154, 112, 78);
		contentPane.add(btn6);

		btn1 = new JButton("New button");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn1.setBounds(39, 75, 112, 78);
		contentPane.add(btn1);

		lblNumeroActual = new JLabel("--");
		lblNumeroActual.setFont(new Font("Verdana", Font.BOLD, 75));
		lblNumeroActual.setBounds(753, 154, 120, 104);
		contentPane.add(lblNumeroActual);

		JLabel lblNewLabel_1 = new JLabel("ALMINGO");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 54));
		lblNewLabel_1.setBounds(308, 1, 311, 63);
		contentPane.add(lblNewLabel_1);
		
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        borrarNombreJugador(nombreJugador);
		    }
		});

		arrayBotones = new JButton[25];

		arrayNumeros = new int[25];
		
		
		
		pedirIPServidor();
		pedirNombreJugador();

		llenarArrayNumeros(arrayNumeros);

		llenarArrayBotones(arrayBotones);

		asignarNumerosABotones();

		clickBoton();

		iniciarMonitoreoArchivo();
		
		monitorearEstadoLinea();

	}
	
	private void pedirIPServidor() {
	    boolean valido = false;
	    while (!valido) {
	        ipServidor = JOptionPane.showInputDialog(
	            this,
	            "Introduce la IP del servidor de juego:",
	            "Conexión al servidor",
	            JOptionPane.QUESTION_MESSAGE
	        );

	        if (ipServidor == null || ipServidor.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "La IP no puede estar vacía.");
	            continue;
	        }

	        // Validación básica de formato IP (opcional)
	        if (!ipServidor.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
	            JOptionPane.showMessageDialog(null, "Formato de IP inválido.");
	            continue;
	        }

	        valido = true;
	    }
	}

    private void pedirNombreJugador() {
        boolean valido = false;
        while (!valido) {
            nombreJugador = JOptionPane.showInputDialog("Introduce tu nombre:");
            if (nombreJugador == null || nombreJugador.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                continue;
            }
            if (nombreRepetido(nombreJugador)) {
                JOptionPane.showMessageDialog(null, "Ese nombre ya está en uso.");
            } else {
                guardarNombre(nombreJugador);
                valido = true;
            }
        }
    }

    private boolean nombreRepetido(String nombre) {
        File f = new File("nombres_jugadores.txt");
        if (!f.exists()) return false;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                if (sc.nextLine().trim().equalsIgnoreCase(nombre.trim())) return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void guardarNombre(String nombre) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("nombres_jugadores.txt", true))) {
            pw.println(nombre);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void borrarNombreJugador(String nombre) {
        File archivo = new File("nombres_jugadores.txt");
        if (!archivo.exists()) return;

        File temporal = new File("nombres_jugadores_temp.txt");
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

        // Reemplazar archivo original
        if (archivo.delete()) {
            temporal.renameTo(archivo);
        }
    }

	private void llenarArrayNumeros(int[] arrayNumeros2) {
		//FUNCION QUE SE ENCARGA DE GENERAR NUMEROS CADA POSICION DEL ARRAY Y COMPRUEBA QUE NO SE REPITAN

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

	private void asignarNumerosABotones() {
		//FUNCION QUE ASIGNA LOS NUMEROS DEL ARRAY DE NUMEROS A LOS BOTONES

		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setText(String.valueOf(arrayNumeros[i]));
		}

	}


	private void llenarArrayBotones(JButton[] arrayBotones2) {
		//FUNCION QUE LLENA EL ARRAY DE BOTONES

		arrayBotones2[0]= btn1;
		arrayBotones2[1]= btn2;
		arrayBotones2[2]= btn3;
		arrayBotones2[3]= btn4;
		arrayBotones2[4]= btn5;
		arrayBotones2[5]= btn6;
		arrayBotones2[6]= btn7;
		arrayBotones2[7]= btn8;
		arrayBotones2[8]= btn9;
		arrayBotones2[9]= btn10;
		arrayBotones2[10]= btn11;
		arrayBotones2[11]= btn12;
		arrayBotones2[12]= btn13;
		arrayBotones2[13]= btn14;
		arrayBotones2[14]= btn15;
		arrayBotones2[15]= btn16;
		arrayBotones2[16]= btn17;
		arrayBotones2[17]= btn18;
		arrayBotones2[18]= btn19;
		arrayBotones2[19]= btn20;
		arrayBotones2[20]= btn21;
		arrayBotones2[21]= btn22;
		arrayBotones2[22]= btn23;
		arrayBotones2[23]= btn24;
		arrayBotones2[24]= btn25;

	}

	private void clickBoton() {
        for (JButton boton : arrayBotones) {
            boton.addActionListener(e -> {
                // Si ya está esperando validación, no hacer nada
                if (esperandoValidacion) return;
                
                boton.setBackground(new Color(150, 33, 33));
                boton.setEnabled(false);

                // Comprobar BINGO primero (tiene prioridad)
                if (!bingoEncontrado && comprobacionBingo() == BINGO) {
                    bingoEncontrado = true;
                    notificarEvento("BINGO");
                    desactivarBotones();
                } 
                // Solo comprobar LINEA si no hay bingo Y si no se ha confirmado línea globalmente
                else if (!lineaEncontrada && !bingoEncontrado && !lineaGlobalConfirmada) {
                    int resultadoLinea = comprobacionLineaConFila(); // Devuelve el número de fila
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
	    if (esperandoValidacion) return;
	    
	    // Verificar que los números realmente han salido
	    boolean valido = false;
	    
	    if (tipo.equals("LINEA")) {
	        // Verificar que todos los números de la fila detectada han salido
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

	    // Si no es válido (números no han salido), informar y desmarcar
	    if (!valido) {
	        System.out.println("[DEBUG] " + tipo + " no válida - números no han salido");
	        JOptionPane.showMessageDialog(null, 
	            "¡" + tipo + " no válida! Algunos números aún no han salido del bombo.", 
	            "Aviso", 
	            JOptionPane.WARNING_MESSAGE);
	        
	        desmarcarNumerosNoValidos();
	        
	        // IMPORTANTE: Resetear el flag para permitir intentarlo de nuevo
	        if (tipo.equals("LINEA")) {
	            lineaEncontrada = false;
	            filaActualLinea = -1;
	        } else if (tipo.equals("BINGO")) {
	            bingoEncontrado = false;
	        }
	        return;
	    }

	    // Si es válido, proceder con la pregunta
	    esperandoValidacion = true;
	    //tipoEventoPendiente = tipo;

	    // Notificar al bombo que se está comprobando
	    try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_EVENTOS))) {
	        pw.println("COMPROBANDO:" + nombreJugador + ":" + tipo);
	        System.out.println("[DEBUG] Escrito: COMPROBANDO:" + nombreJugador + ":" + tipo);
	    } catch (IOException e) {
	        System.err.println("[ERROR] No se pudo escribir el evento: " + e.getMessage());
	    }

	    // Hacer la pregunta
	    hacerPreguntaSostenibilidad(tipo);
	}
	
	private void desmarcarNumerosNoValidos() {
	    for (JButton boton : arrayBotones) {
	        if (!boton.isEnabled()) { // Está marcado
	            int num = Integer.parseInt(boton.getText());
	            if (!numeroHaSalido(num)) {
	                boton.setEnabled(true);
	                boton.setBackground(null); // O el color original
	            }
	        }
	    }
	}
	
	private void desactivarBotones() {
        for (JButton b : arrayBotones) b.setEnabled(false);
    }
	
	private void hacerPreguntaSostenibilidad(String tipo) {
	    // Pregunta de ejemplo
	    String pregunta = "¿Cuántos litros de agua se necesitan para producir 1 kg de carne de vaca?";
	    String[] opciones = {"500 L", "5.000 L", "15.000 L"};
	    int respuestaCorrecta = 2;

	    int respuesta = JOptionPane.showOptionDialog(
	        this,
	        pregunta,
	        "Pregunta de Sostenibilidad - " + tipo,
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        opciones,
	        opciones[0]
	    );

	    boolean acierto = (respuesta == respuestaCorrecta);

	    try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_EVENTOS))) {
	        if (acierto) {
	            pw.println(tipo + ":" + nombreJugador);
	            JOptionPane.showMessageDialog(null, "¡Acertaste! " + tipo + " válida.");
	            
	            // Si acertó LÍNEA, marcarla como confirmada globalmente
	            if (tipo.equals("LINEA")) {
	                setEstadoLinea("CONFIRMADA:" + nombreJugador);
	                lineaGlobalConfirmada = true;
	                System.out.println("[DEBUG] Línea confirmada globalmente por " + nombreJugador);
	            }
	            
	        } else {
	            pw.println("FALLO:" + nombreJugador + ":" + tipo);
	            
	            if (tipo.equals("LINEA")) {
	                JOptionPane.showMessageDialog(null, 
	                    "¡Respuesta incorrecta! Esta línea ya no será válida para ti, pero puedes intentar con otra.", 
	                    "Fallo", 
	                    JOptionPane.ERROR_MESSAGE);
	                
	                // CLAVE: Marcar la fila como fallida ANTES de resetear
	                if (filaActualLinea >= 0) {
	                    filaFallida[filaActualLinea] = true;
	                    System.out.println("[DEBUG] Fila " + filaActualLinea + " marcada como fallida para " + nombreJugador);
	                }
	                
	                // Resetear los flags para poder detectar OTRAS líneas
	                lineaEncontrada = false;
	                filaActualLinea = -1;
	                
	            } else if (tipo.equals("BINGO")) {
	                JOptionPane.showMessageDialog(null, 
	                    "¡Respuesta incorrecta! Has perdido la oportunidad de ganar.", 
	                    "Fallo", 
	                    JOptionPane.ERROR_MESSAGE);
	                
	                // En bingo, si falla pierde para siempre
	                // Mantener bingoEncontrado = true para evitar reintentos
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    esperandoValidacion = false;
	}

	//BINGO
	public int comprobacionBingo() {

		int activadas = 0;

		for (int i=0;i<arrayBotones.length;i++) {
			if (arrayBotones[i].isEnabled()) {
				activadas++;
			}
		}

		if (activadas == 0) {
			return BINGO;
		}

		return NO_FIN;
	}

	//LINEA
	public int comprobacionLinea() {
	    return (comprobacionLineaConFila() >= 0) ? LINEA : NO_FIN;
	}
	
	// Nuevo método que devuelve QUÉ fila es la línea
	private int comprobacionLineaConFila() {
	    for (int fila = 0; fila < 5; fila++) {
	        // Saltar filas que ya han sido falladas por ESTE jugador
	        if (filaFallida[fila]) {
	            continue;
	        }
	        
	        // Comprobar si la fila está completa
	        boolean filaCompleta = true;
	        for (int col = 0; col < 5; col++) {
	            if (arrayBotones[fila * 5 + col].isEnabled()) {
	                filaCompleta = false;
	                break;
	            }
	        }
	        
	        if (filaCompleta) {
	            System.out.println("[DEBUG] Fila " + fila + " detectada como línea");
	            return fila; // Devolver el número de fila
	        }
	    }
	    return -1; // No hay línea
	}
	
	private boolean numerosDeBingoHanSalido() {
	    for (JButton boton : arrayBotones) {
	        if (!boton.isEnabled()) {
	            int num = Integer.parseInt(boton.getText());
	            if (!numeroHaSalido(num)) return false;
	        }
	    }
	    return true;
	}

	private boolean numeroHaSalido(int num) {
	    File archivo = new File(RUTA_BOMBO);
	    if (!archivo.exists()) return false;

	    try (Scanner sc = new Scanner(archivo)) {
	        if (!sc.hasNextInt()) return false;
	        sc.nextInt(); // saltar número actual

	        if (!sc.hasNextLine()) return false;
	        sc.nextLine(); // saltar salto de línea

	        if (!sc.hasNextLine()) return false;
	        String linea = sc.nextLine(); // línea con todos los números

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
	
	private String obtenerEstadoLinea() {
	    File f = new File(RUTA_LINEA);
	    if (!f.exists()) return "PENDIENTE";
	    try (Scanner sc = new Scanner(f)) {
	        return sc.hasNextLine() ? sc.nextLine().trim() : "PENDIENTE";
	    } catch (Exception e) {
	        return "PENDIENTE";
	    }
	}
	
	private void setEstadoLinea(String estado) {
	    try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA_LINEA))) {
	        pw.println(estado);
	        System.out.println("[DEBUG] Estado de línea actualizado: " + estado);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void monitorearEstadoLinea() {
	    Timer timer = new Timer(500, e -> {
	        String estado = obtenerEstadoLinea();
	        
	        if (estado.startsWith("CONFIRMADA:") && !lineaGlobalConfirmada) {
	            lineaGlobalConfirmada = true;
	            String ganador = estado.substring(11);
	            
	            // Solo mostrar mensaje si NO es este jugador
	            if (!ganador.equals(nombreJugador)) {
	                JOptionPane.showMessageDialog(null, 
	                    "¡" + ganador + " ha conseguido LÍNEA! Ya no se pueden hacer más líneas.", 
	                    "Línea confirmada", 
	                    JOptionPane.INFORMATION_MESSAGE);
	            }
	            
	            System.out.println("[DEBUG] Línea global confirmada. Jugador: " + nombreJugador + " ya no puede hacer líneas.");
	        }
	    });
	    timer.start();
	}
	
	private void iniciarMonitoreoArchivo() {
		String rutaArchivo = RUTA_BOMBO;        
        // Timer que se ejecuta cada 1 segundo (1000 ms)
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File archivo = new File(rutaArchivo);
                
                if (archivo.exists()) {
                    long modificacion = archivo.lastModified();
                    
                    long ultimaModificacion= 0;
                    // Solo cargar si el archivo cambió
                    if (modificacion != ultimaModificacion) {
                        ultimaModificacion = modificacion;
                        cargarNumero();
                    }
                }
            }
        });
        
        timer.start(); // Iniciar el timer
    }
    
    public void cargarNumero() {
        int cont;
        
        String rutaArchivo = RUTA_BOMBO;
        
        File archivo = new File(rutaArchivo);
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
            if (!sc.hasNextInt()) return; // <-- SALVA SI ESTÁ VACÍO
            int ultimoNumero = sc.nextInt();
            lblNumeroActual.setText(Integer.toString(ultimoNumero));

            if (!sc.hasNextLine()) return; // <-- SALVA SI NO HAY MÁS
            sc.nextLine(); // consumir salto

            if (!sc.hasNextLine()) return; // <-- SALVA SI NO HAY SEGUNDA LÍNEA
            String lineaNumeros = sc.nextLine();
            String[] numerosTexto = lineaNumeros.split(",");
            
            // Reconstruir datos
            cont = numerosTexto.length;
            arrayNumeros = new int[90];
            
            for (int i = 0; i < cont; i++) {
                arrayNumeros[i] = Integer.parseInt(numerosTexto[i].trim());
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado");
            cont = 0;
        } catch (Exception e) {
            System.err.println("Error al cargar: " + e.getMessage());
            cont = 0;
        }
    }
}

/*PARA LAS PREGUNTAS DE SOSTENIBILIDAD SIRVE TANTO UN POPUP COMO UNA NUEVA CLASE, YA SE BARAJEARA QUE USAR, 
 * ADEMAS YO HARIA QUE MIENTRAS SE LE ESTA HACIENDO LA PREGUNTA A UN USUARIO QUE EL RESTO NO PUEDA CLIKAR LOS BOTONES PARA QUE
 *  NO SE PUEDA INTERRUMPIR EL FLUJO DE LA PREGUNTA CON QUE ALGUIEN HA GANADO.
 *  
 *  ADEMAS, SI DOS PERSONAS A LA VEZ HACEN LINEA O BINGO, HACER QUE A LOS DOS SE LES MUESTRE LA PREGUNTA PERO QUE SOLO UNO DE ELLOS PUEDA CONSEGUIR LA LINEA, ES DECIR,
 *  QUE LOS DOS TENGAN LA OPORTUNIDAD DE RESPONDER Y SOLO SE LLEVE LA PREGUNTA EL QUE MAS RAPIDO HAYA CONTESTADO, PORQUE SINO,SI LE SACO LA PREGUNTA A SOLO UNO Y 
 *  FALLA,EL OTRO SE HA QUEDADO SIN DERECHO DE PODER RESPONDER Y NADIE HA HECHO BINGO.
 *  
 *  PREGUNTA, SI ALGUIEN HACE BINGO Y FALLA LA PREGUNTA DE SOSTENIBILIDAD QUE HAGO? NO LE DOY BINGO? ENTONCES YA HA PERDIDO LA OPORTUNIDAD DE GANAR PARA SIEMPRE. (SI)
 */

/*HAY QUE HACER QUE EL USUARIO META SU NOMBRE ASI LUEGO AL GANAR O HACER LINEA SE PUEDE MOSTRAR EL NOMBRE DE USUARIO EN LA PANTALLA DEL RESTO.
 * 
 */

/*COSAS PENDIENTES
* 1. CERRAR LA VENTANA DE ESPERANDO Y MOSTRAR A LOS DEMAS EL JUGADOR QUE HA HECHO LINEA O BINGO
* 2. AÑADIR LAS PREGUNTAS Y SUS RESPECTIVAS FOTOS
* 3. REVISAR REDUNDANCIAS Y CORREGIR CODIGO
*/