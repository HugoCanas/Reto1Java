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
		
		for (int i = 1; i <= 90; i++) {
			JButton btn = new JButton(String.valueOf(i));
			numeros.add(btn);
		}
		
		JPanel control = new JPanel();
		control.setBackground(new Color(192, 192, 192));
		control.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		control.setBounds(521, 24, 351, 426);
		contentPane.add(control);
		control.setLayout(null);
		
		JButton newnumber = new JButton("Nuevo número");
		newnumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		newnumber.setBounds(62, 298, 147, 45);
		control.add(newnumber);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 37, 250, 250);
		control.add(layeredPane);
		
		JLabel label = new JLabel("90");
		label.setFont(new Font("Verdana", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(label, 1);
		label.setBounds(0, 0, 250, 239);
		layeredPane.add(label);
		label.setForeground(new Color(0, 0, 0));
		
		JLabel BolaNueva = new JLabel("");
		BolaNueva.setIcon(new ImageIcon("C:\\Users\\Dam1\\Documents\\DAM1\\Retos\\1Ev\\Reto1Java\\images\\bolaverde.png"));
		BolaNueva.setBounds(0, 0, 251, 250);
		layeredPane.add(BolaNueva);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(241, 315, 100, 100);
		control.add(layeredPane_1);
		
		JLabel label_1 = new JLabel("90");
		layeredPane_1.setLayer(label_1, 1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Verdana", Font.BOLD, 22));
		label_1.setBounds(0, 0, 100, 95);
		layeredPane_1.add(label_1);
		
		JLabel BolaAnterior = new JLabel("");
		BolaAnterior.setIcon(new ImageIcon("C:\\Users\\Dam1\\Documents\\DAM1\\Retos\\1Ev\\Reto1Java\\images\\bolamorada.png"));
		BolaAnterior.setBounds(0, 0, 100, 100);
		layeredPane_1.add(BolaAnterior);
		
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
	}
}