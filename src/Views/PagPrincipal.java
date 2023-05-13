package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PagPrincipal {

	private JFrame frame;
	private JTextField txtConcesionariosFelix;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagPrincipal window = new PagPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PagPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Pagina Principal");
		frame.setBounds(200, 200, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		txtConcesionariosFelix = new JTextField();
		txtConcesionariosFelix.setEditable(false);
		txtConcesionariosFelix.setFont(new Font("Poor Richard", Font.BOLD, 24));
		txtConcesionariosFelix.setHorizontalAlignment(JTextField.CENTER);
		txtConcesionariosFelix.setText("CONCESIONARIOS FELIX");
		frame.getContentPane().add(txtConcesionariosFelix, BorderLayout.NORTH);
		txtConcesionariosFelix.setColumns(10);	    
	    
	    JLabel imagenLabel = new JLabel();
        ImageIcon imagen = new ImageIcon("images/fotoPagPrincipal.jpg"); // Reemplaza con la ruta a tu imagen
        imagenLabel.setIcon(imagen);

        frame.getContentPane().add(imagenLabel, BorderLayout.CENTER);
        
        btnEntrar = new JButton("Entrar");
        frame.getContentPane().add(btnEntrar, BorderLayout.SOUTH);
        btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Entrando a la página login...", "Cambio pagina", JOptionPane.INFORMATION_MESSAGE);
				Login login = new Login();
				login.setVisible(true);
				
				frame.dispose();			
			}
        	
        });
	
	}

}
