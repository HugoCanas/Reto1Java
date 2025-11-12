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
	private String ipServidor;
	private String ruta_Carpeta;
	private String ruta_Bombo;
	private String ruta_Linea;
	private String ruta_Eventos;
	private long ultimaModificacionBombo = 0L; 

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
	            JOptionPane.QUESTION_MESSAGE
	        );

	        if (ipServidor == null || ipServidor.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "La IP no puede estar vacía.");
	            continue;
	        }
	        if (!ipServidor.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
	            JOptionPane.showMessageDialog(null, "Formato de IP inválido.");
	            continue;
	        }

	        valido = true;
	    }
	    ruta_Carpeta = "\\\\\\\\"+ ipServidor +"\\BingoCompartido";
		ruta_Bombo   = ruta_Carpeta + "\\bombo_bingo.txt";
		ruta_Linea   = ruta_Carpeta + "\\linea_estado.txt";
		ruta_Eventos = ruta_Carpeta + "\\eventos_bingo.txt";
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
 
	private void asignarNumerosABotones() {
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setText(String.valueOf(arrayNumeros[i]));
		}
	}

	// GRUPO 2: LÓGICA DE JUEGO (EVENTOS DE CLICK)
	
	private void clickBoton() {
     for (JButton boton : arrayBotones) {
         boton.addActionListener(e -> {
             if (esperandoValidacion) return;
             
             boton.setBackground(new Color(150, 33, 33));
             boton.setEnabled(false);

             if (!bingoEncontrado && comprobacionBingo() == BINGO) {
                 bingoEncontrado = true;
                 notificarEvento("BINGO");
             } 
             else if (!lineaEncontrada && !bingoEncontrado && !lineaGlobalConfirmada) {
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
	    if (esperandoValidacion) return;
	    
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
	        JOptionPane.showMessageDialog(null, 
	            "¡" + tipo + " no válida! Algunos números aún no han salido del bombo.", 
	            "Aviso", 
	            JOptionPane.WARNING_MESSAGE);
	        
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

	    try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Eventos))) {
	        pw.println("COMPROBANDO:" + nombreJugador + ":" + tipo);
	        System.out.println("[DEBUG] Escrito: COMPROBANDO:" + nombreJugador + ":" + tipo);
	    } catch (IOException e) {
	        System.err.println("[ERROR] No se pudo escribir el evento: " + e.getMessage());
	    }

	    hacerPreguntaSostenibilidad(tipo);
	}
	
	private void hacerPreguntaSostenibilidad(String tipo) {
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

	    try (PrintWriter pw = new PrintWriter(new FileWriter(ruta_Eventos))) {
	        if (acierto) {
	            pw.println(tipo + ":" + nombreJugador);
	            JOptionPane.showMessageDialog(null, "¡Acertaste! " + tipo + " válida.");
	            
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
	                
	                if (filaActualLinea >= 0) {
	                    filaFallida[filaActualLinea] = true;
	                    System.out.println("[DEBUG] Fila " + filaActualLinea + " marcada como fallida para " + nombreJugador);
	                }
	                lineaEncontrada = false;
	                filaActualLinea = -1;
	                
	            } else if (tipo.equals("BINGO")) {
	                JOptionPane.showMessageDialog(null, 
	                    "¡Respuesta incorrecta! Has perdido la oportunidad de ganar.", 
	                    "Fallo", 
	                    JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    esperandoValidacion = false;
	}

	private void desmarcarNumerosNoValidos() {
	    for (JButton boton : arrayBotones) {
	        if (!boton.isEnabled()) {
	            int num = Integer.parseInt(boton.getText());
	            if (!numeroHaSalido(num)) {
	                boton.setEnabled(true);
	                boton.setBackground(null);
	            }
	        }
	    }
	}
	
	private void desactivarBotones() {
     for (JButton b : arrayBotones) b.setEnabled(false);
 }


	// GRUPO 3: COMPROBACIONES DE ESTADO DEL JUEGO

	public int comprobacionBingo() {
		for (int i=0; i < arrayBotones.length; i++) {
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
	        if (filaFallida[fila]) {
	            continue;
	        }
	        
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
	            if (!numeroHaSalido(num)) return false;
	        }
	    }
	    return true;
	}

	private boolean numeroHaSalido(int num) {
	    File archivo = new File(ruta_Bombo);
	    if (!archivo.exists()) return false;

	    try (Scanner sc = new Scanner(archivo)) {
	        if (!sc.hasNextInt()) return false;
	        sc.nextInt(); // saltar número actual

	        if (!sc.hasNextLine()) return false;
	        sc.nextLine();

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
         if (!sc.hasNextInt()) return; // Archivo vacío o mal formado
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

	private String obtenerEstadoLinea() {
	    File f = new File(ruta_Linea);
	    if (!f.exists()) return "PENDIENTE";
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
}