package Views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class PagPrincipal.
 */
public class PagPrincipal extends JFrame {

	/** The frame. */
	private JFrame frame;

	/** The txt concesionarios felix. */
	private JTextField txtConcesionariosFelix;

	/** The btn entrar. */
	private JButton btnEntrar;

	/**
	 * Instantiates a new pag principal.
	 */
	public PagPrincipal() {
		initialize();
	}

	/**
	 * Initialize.
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
		ImageIcon imagen = new ImageIcon("images/fotoPagPrincipal.jpg");
		imagenLabel.setIcon(imagen);

		frame.getContentPane().add(imagenLabel, BorderLayout.CENTER);

		btnEntrar = new JButton("Entrar");
		frame.getContentPane().add(btnEntrar, BorderLayout.SOUTH);
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Entrando a la página login...", "Cambio pagina",
						JOptionPane.INFORMATION_MESSAGE);
				Login login = new Login();
				login.setVisible(true);

				frame.dispose();
			}

		});
		frame.setVisible(true);

	}

}
