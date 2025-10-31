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
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton boton10;
	private JButton boton11;
	private JButton boton12;
	private JButton boton13;
	private JButton boton14;
	private JButton boton15;
	private JButton boton16;
	private JButton boton17;
	private JButton boton18;
	private JButton boton19;
	private JButton boton20;
	private JButton boton21;
	private JButton boton22;
	private JButton boton23;
	private JButton boton24;
	private JButton boton25;
	private JButton[] arrayBotones;

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

		boton22 = new JButton("New button");
		boton22.setBounds(151, 387, 112, 78);
		contentPane.add(boton22);

		boton23 = new JButton("New button");
		boton23.setBounds(263, 387, 112, 78);
		contentPane.add(boton23);

		boton24 = new JButton("New button");
		boton24.setBounds(376, 387, 112, 78);
		contentPane.add(boton24);

		boton25 = new JButton("New button");
		boton25.setBounds(490, 387, 112, 78);
		contentPane.add(boton25);

		boton20 = new JButton("New button");
		boton20.setBounds(490, 309, 112, 78);
		contentPane.add(boton20);

		boton15 = new JButton("New button");
		boton15.setBounds(490, 232, 112, 78);
		contentPane.add(boton15);

		boton10 = new JButton("New button");
		boton10.setBounds(490, 154, 112, 78);
		contentPane.add(boton10);

		boton5 = new JButton("New button");
		boton5.setBounds(490, 75, 112, 78);
		contentPane.add(boton5);

		boton19 = new JButton("New button");
		boton19.setBounds(376, 309, 112, 78);
		contentPane.add(boton19);

		boton18 = new JButton("New button");
		boton18.setBounds(263, 309, 112, 78);
		contentPane.add(boton18);

		boton17 = new JButton("New button");
		boton17.setBounds(151, 309, 112, 78);
		contentPane.add(boton17);

		boton12 = new JButton("New button");
		boton12.setBounds(151, 232, 112, 78);
		contentPane.add(boton12);

		boton13 = new JButton("New button");
		boton13.setBounds(263, 232, 112, 78);
		contentPane.add(boton13);

		boton14 = new JButton("New button");
		boton14.setBounds(376, 232, 112, 78);
		contentPane.add(boton14);

		boton9 = new JButton("New button");
		boton9.setBounds(376, 154, 112, 78);
		contentPane.add(boton9);

		boton4 = new JButton("New button");
		boton4.setBounds(376, 75, 112, 78);
		contentPane.add(boton4);

		boton3 = new JButton("New button");
		boton3.setBounds(263, 75, 112, 78);
		contentPane.add(boton3);

		boton8 = new JButton("New button");
		boton8.setBounds(263, 154, 112, 78);
		contentPane.add(boton8);

		boton7 = new JButton("New button");
		boton7.setBounds(151, 154, 112, 78);
		contentPane.add(boton7);

		boton2 = new JButton("New button");
		boton2.setBounds(151, 75, 112, 78);
		contentPane.add(boton2);

		boton21 = new JButton("New button");
		boton21.setBounds(39, 387, 112, 78);
		contentPane.add(boton21);

		boton16 = new JButton("New button");
		boton16.setBounds(39, 309, 112, 78);
		contentPane.add(boton16);

		boton11 = new JButton("New button");
		boton11.setBounds(39, 232, 112, 78);
		contentPane.add(boton11);

		boton6 = new JButton("New button");
		boton6.setBounds(39, 154, 112, 78);
		contentPane.add(boton6);

		boton1 = new JButton("New button");
		boton1.setBounds(39, 75, 112, 78);
		contentPane.add(boton1);

		JLabel lblNewLabel = new JLabel("67");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 75));
		lblNewLabel.setBounds(753, 154, 120, 104);
		contentPane.add(lblNewLabel);

	}

	public void interaccionBoton(JButton boton) {
		
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
