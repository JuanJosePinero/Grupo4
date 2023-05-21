package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VerComentsYValorac extends JFrame {

	private JPanel contentPane;
	private JButton btnVerComentarios, btnVerValoraciones, btnCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerComentsYValorac frame = new VerComentsYValorac();
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
	public VerComentsYValorac() {
		super("Comentarios y Valoraciones de los Vehiculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 202);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLabel1 = new JLabel("Elija la opción que desea realizar");
		lblLabel1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblLabel1.setBounds(83, 10, 321, 21);
		contentPane.add(lblLabel1);

		ManejadorJButton manejador = new ManejadorJButton();

		btnVerComentarios = new JButton("Ver Comentarios");
		btnVerComentarios.setBounds(36, 68, 137, 41);
		contentPane.add(btnVerComentarios);

		btnVerValoraciones = new JButton("Ver Valoraciones");
		btnVerValoraciones.setBounds(257, 71, 137, 38);
		contentPane.add(btnVerValoraciones);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Calcelando...", "Aviso", JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(171, 134, 90, 21);
		contentPane.add(btnCancelar);

		ManejadorJButton mb = new ManejadorJButton();
		btnVerComentarios.addActionListener(mb);
		btnVerValoraciones.addActionListener(mb);
	}

	public class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == btnVerComentarios) {
				VisualizarComents vc = new VisualizarComents();
				vc.setVisible(true);
				dispose();

			} else if (o == btnVerValoraciones) {
				VisualizarValoracion vv = new VisualizarValoracion();
				vv.setVisible(true);
				dispose();
			}
		}
	}
}
