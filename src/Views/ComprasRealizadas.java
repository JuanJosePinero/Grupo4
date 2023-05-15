package Views;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ComprasRealizadas extends JFrame {

	private JPanel contentPane;
	private JButton btnVerAlquileres,btnVerCompras;
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
		setBounds(100, 100, 437, 175);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel1 = new JLabel("Elija la opción que desea realizar");
		lblLabel1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblLabel1.setBounds(83, 10, 321, 21);
		contentPane.add(lblLabel1);
		
		
		
		btnVerAlquileres = new JButton("Ver Alquileres");
		btnVerAlquileres.setBounds(36, 68, 120, 27);
		contentPane.add(btnVerAlquileres);
		
		
		btnVerCompras = new JButton("Ver Compras");
		btnVerCompras.setBounds(257, 71, 120, 27);
		contentPane.add(btnVerCompras);
	
		
	
	}
	
	

}
