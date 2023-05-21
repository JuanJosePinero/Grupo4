package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.ClientService;
import Service.Conexion;
import models.Cliente;

public class CambiarContrasena extends JFrame {

	private JPanel contentPane;
	private JTextField UsuarioT;
	private JButton ConfirmarB, CancelarB;
	private final ClientService services = new ClientService();
	private Cliente cliente;
	private int id = ListViewClientes.getidClienteCrear();
	private JPasswordField ContP;
	private JPasswordField CContP;

	public CambiarContrasena() {
		super("Cambio de contraseña");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 253);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setBounds(63, 71, 110, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Confirmar Contraseña");
		lblNewLabel_1.setBounds(63, 101, 127, 14);
		contentPane.add(lblNewLabel_1);

		ConfirmarB = new JButton("Confirmar");
		ConfirmarB.setBounds(63, 144, 115, 36);
		contentPane.add(ConfirmarB);

		CancelarB = new JButton("Cancelar");
		CancelarB.setBounds(200, 144, 115, 36);
		contentPane.add(CancelarB);

		UsuarioT = new JTextField();
		UsuarioT.setEditable(false);
		UsuarioT.setBounds(200, 39, 145, 20);
		contentPane.add(UsuarioT);
		UsuarioT.setColumns(10);

		ContP = new JPasswordField();
		ContP.setBounds(200, 68, 145, 20);
		contentPane.add(ContP);

		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(63, 41, 63, 14);
		contentPane.add(lblNewLabel_2);

		setVisible(true);

		manejadorAction ma = new manejadorAction();
		ConfirmarB.addActionListener(ma);
		CancelarB.addActionListener(ma);

		try {
			Cliente datos = services.getClienteId(Conexion.obtener(), id);
			UsuarioT.setText(datos.getNombreUsuario());

			CContP = new JPasswordField();
			CContP.setBounds(200, 98, 145, 20);
			contentPane.add(CContP);
		} catch (ClassNotFoundException | SQLException e) {
		}
	}

	private class manejadorAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();

			if (b.equals(ConfirmarB)) {
				try {
					Cliente datos = services.getClienteId(Conexion.obtener(), id);
					char[] contC = ContP.getPassword();
					String cont = new String(contC);
					char[] ccontC = CContP.getPassword();
					String ccont = new String(ccontC);
					datos.setContrasena(cont);

					if (!cont.matches("[A-Z].*[0-9].*")) {
						JOptionPane.showMessageDialog(null, "Error");
					} else if (!cont.equals(ccont))
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Aviso",
								JOptionPane.ERROR_MESSAGE);
					else {
						services.save(Conexion.obtener(), datos);

						ListViewClientes lvc = new ListViewClientes();
						dispose();
					}

				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("selecciona una fila");
				}

			} else if (b.equals(CancelarB)) {
				JOptionPane.showMessageDialog(null, "Ha cancelado el cambio de contraseña", "Cancelar",
						JOptionPane.ERROR_MESSAGE);
				ListViewClientes lvc = new ListViewClientes();
				dispose();
			}
		}
	}
}
