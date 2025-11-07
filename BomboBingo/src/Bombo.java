import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Bombo extends JFrame {

	private static final long serialVersionUID = 1L;
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
		BolaNueva.setIcon(new ImageIcon("C:\\Users\\Dam1\\Documents\\DAM1\\Retos\\1Ev\\Reto1Java\\images\\bolaverde.png"));
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
		BolaAnterior.setIcon(new ImageIcon("C:\\Users\\Dam1\\Documents\\DAM1\\Retos\\1Ev\\Reto1Java\\images\\bolamorada.png"));
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
	
	//generar el numero nuevo que no este repetido
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

			} while(repetido==true); //se repite todo el procedimiento hasta que repetido no sea false
			
			arrayNumeros2[cont] = num; //se introduce aqui el numero al assay
			System.out.print(arrayNumeros2[cont] + " ");
			nuevoNumlabel.setText(Integer.toString(num));
			botones[num-1].setEnabled(false);
			numeroAnterior();
			cont++;
			
		}
	
		public void numeroAnterior()
		{
			if(cont > 0) {
				antNumlabel.setText(Integer.toString(arrayNumeros[cont-1]));
			}
		}
}

