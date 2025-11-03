import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bingo extends JFrame {

	private static final long serialVersionUID = 1L;
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
	private boolean estado=true;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn22 = new JButton("New button");
		btn22.setBounds(151, 387, 112, 78);
		contentPane.add(btn22);

		btn23 = new JButton("New button");
		btn23.setBounds(263, 387, 112, 78);
		contentPane.add(btn23);

		btn24 = new JButton("New button");
		btn24.setBounds(376, 387, 112, 78);
		contentPane.add(btn24);

		btn25 = new JButton("New button");
		btn25.setBounds(490, 387, 112, 78);
		contentPane.add(btn25);

		btn20 = new JButton("New button");
		btn20.setBounds(490, 309, 112, 78);
		contentPane.add(btn20);

		btn15 = new JButton("New button");
		btn15.setBounds(490, 232, 112, 78);
		contentPane.add(btn15);

		btn10 = new JButton("New button");
		btn10.setBounds(490, 154, 112, 78);
		contentPane.add(btn10);

		btn5 = new JButton("New button");
		btn5.setBounds(490, 75, 112, 78);
		contentPane.add(btn5);

		btn19 = new JButton("New button");
		btn19.setBounds(376, 309, 112, 78);
		contentPane.add(btn19);

		btn18 = new JButton("New button");
		btn18.setBounds(263, 309, 112, 78);
		contentPane.add(btn18);

		btn17 = new JButton("New button");
		btn17.setBounds(151, 309, 112, 78);
		contentPane.add(btn17);

		btn12 = new JButton("New button");
		btn12.setBounds(151, 232, 112, 78);
		contentPane.add(btn12);

		btn13 = new JButton("New button");
		btn13.setBounds(263, 232, 112, 78);
		contentPane.add(btn13);

		btn14 = new JButton("New button");
		btn14.setBounds(376, 232, 112, 78);
		contentPane.add(btn14);

		btn9 = new JButton("New button");
		btn9.setBounds(376, 154, 112, 78);
		contentPane.add(btn9);

		btn4 = new JButton("New button");
		btn4.setBounds(376, 75, 112, 78);
		contentPane.add(btn4);

		btn3 = new JButton("New button");
		btn3.setBounds(263, 75, 112, 78);
		contentPane.add(btn3);

		btn8 = new JButton("New button");
		btn8.setBounds(263, 154, 112, 78);
		contentPane.add(btn8);

		btn7 = new JButton("New button");
		btn7.setBounds(151, 154, 112, 78);
		contentPane.add(btn7);

		btn2 = new JButton("New button");
		btn2.setBounds(151, 75, 112, 78);
		contentPane.add(btn2);

		btn21 = new JButton("New button");
		btn21.setBounds(39, 387, 112, 78);
		contentPane.add(btn21);

		btn16 = new JButton("New button");
		btn16.setBounds(39, 309, 112, 78);
		contentPane.add(btn16);

		btn11 = new JButton("New button");
		btn11.setBounds(39, 232, 112, 78);
		contentPane.add(btn11);

		btn6 = new JButton("New button");
		btn6.setBounds(39, 154, 112, 78);
		contentPane.add(btn6);

		btn1 = new JButton("New button");
		btn1.setBounds(39, 75, 112, 78);
		contentPane.add(btn1);

		JLabel lblNewLabel = new JLabel("67");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 75));
		lblNewLabel.setBounds(753, 154, 120, 104);
		contentPane.add(lblNewLabel);

		arrayBotones = new JButton [25];
		
		llenarArray(arrayBotones);
		
		
		estadoBotones(estado);
	}
	
	private void llenarArray(JButton[] arrayBotones2) {
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

	public void interaccionBoton(JButton boton) {
		
		boton.addActionListener(null);
		
	}

	public void generarNumeros() {
		/*ARRAY DE BOTONES*/

		for(JButton boton : arrayBotones ){ //For Each

			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					
					
					
					/*Hacer funcion para todos los botones y llamarla aqui*/

					interaccionBoton(boton);
					
					
					
				}
			});

		}

	}
}
