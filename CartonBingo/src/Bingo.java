import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;

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
	private boolean estado=true;
	private boolean lineaEncontrada=false;


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

		JLabel lblNewLabel = new JLabel("67");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 75));
		lblNewLabel.setBounds(734, 197, 120, 104);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ALMINGO");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 54));
		lblNewLabel_1.setBounds(308, 1, 311, 63);
		contentPane.add(lblNewLabel_1);

		arrayBotones = new JButton [25];

		arrayNumeros = new int [25];

		llenarArrayNumeros(arrayNumeros);

		llenarArrayBotones(arrayBotones);

		asignarNumerosABotones();

		estadoBotones(estado);

		clickBoton();


	}

	private void llenarArrayNumeros(int[] arrayNumeros2) {

		//FUNCION QUE SE ENCARGA DE GENERAR NUMEROS CADA POSICION DEL ARRAY Y COMPRUEBA QUE NO SE REPITAN

		int num;
		boolean repetido;

		for(int i=0; i<arrayNumeros2.length;i++) {

			do {
				num = (int)(Math.random() * 90) + 1; 
				repetido = false;

				for(int j=0; j<i;j++) {
					if(arrayNumeros2[j] == num) {
						repetido = true;
					}
				}

			} while(repetido==true); //se repite todo el procedimiento hasta que repetido no sea false

			arrayNumeros2[i] = num; //se introduce aqui el numero al assay

		}
	}

	private void asignarNumerosABotones() {

		//FUNCION QUE ASIGNA LOS NUMEROS DEL ARRAY DE NUMEROS A LOS BOTONES

		for(int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setText(String.valueOf(arrayNumeros[i]));
		}

	}


	private void llenarArrayBotones(JButton[] arrayBotones2) {
		// TODO Auto-generated method stub

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



	private void estadoBotones(boolean estado) {

		for(int i=0;i<arrayBotones.length;i++) {
			arrayBotones[i].setEnabled(estado);
		}

	}

	public void clickBoton() {
		/*ARRAY DE BOTONES*/

		for(JButton boton : arrayBotones ){ //For Each

			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					//METER UNICAMENTE LA LOGICA QUE AFECTA AL HACER CLICK EL BOTON
					boton.setBackground(new java.awt.Color(150,33,33));
					UIManager.put("Button.disabledText", Color.WHITE);;
					boton.setEnabled(false);

					comprobacionBingo();

					if (lineaEncontrada==false) {
						comprobacionLinea();
					}
					
				}
			});	
		}
	}



	//BINGO
	public int comprobacionBingo() {

		// 1º: COMPROBAR SI HAY BINGO COMPLETO (todos los botones deshabilitados)
		int activadas = 0;

		for(int i = 0; i < arrayBotones.length; i++) {
			if(arrayBotones[i].isEnabled()) {
				activadas++;
			}
		}

		if(activadas == 0) {
			System.out.println("¡BINGO!");
			return BINGO;
		}
		return NO_FIN;
	}

	public int comprobacionLinea() {

		//LINEA

		for(int fila = 0; fila < 5; fila++) {
			if(!arrayBotones[fila*5+0].isEnabled() && 
					!arrayBotones[fila*5+1].isEnabled() && 
					!arrayBotones[fila*5+2].isEnabled() && 
					!arrayBotones[fila*5+3].isEnabled() && 
					!arrayBotones[fila*5+4].isEnabled()) {
				System.out.println("¡LÍNEA!");
				lineaEncontrada=true;
				return LINEA;
			}
		}

		return NO_FIN;
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
}
