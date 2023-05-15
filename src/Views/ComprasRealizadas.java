package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ComprasRealizadas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprasRealizadas frame = new ComprasRealizadas();
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
	public ComprasRealizadas() {
		super("Compras Realizadas por el Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel1 = new JLabel("Elija la opción que desea realizar");
		lblLabel1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblLabel1.setBounds(83, 10, 321, 21);
		contentPane.add(lblLabel1);
		
		JButton btnVerAlquileres = new JButton("Ver Alquileres");
		btnVerAlquileres.setBounds(36, 68, 120, 27);
		contentPane.add(btnVerAlquileres);
		
		JButton btnVerCompras = new JButton("Ver Compras");
		btnVerCompras.setBounds(257, 71, 120, 27);
		contentPane.add(btnVerCompras);
	}

}
