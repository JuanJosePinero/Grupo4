package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.ClientService;
import Service.Conexion;
import Service.FabricantesService;
import models.Cliente;
import models.Fabricante;

public class SaveViewFabricante extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPais;
	private JButton btnGuardar, btnCancelar;
	private final FabricantesService serviceF = new FabricantesService();
	private final Fabricante fabricante;
	private final ClientService servicec = new ClientService();
	private final Cliente cliente;
	private JTextField UsuarioT;
	private JTextField ContraseñaT;

	/**
	 * Create the frame.
	 */

	public SaveViewFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
		initComponents();
		txtNombre.setText(this.fabricante.getNombre());
		txtPais.setText(this.fabricante.getPais());
		this.cliente = new Cliente();
	}

	public SaveViewFabricante() {
		this.fabricante = new Fabricante();
		this.cliente = new Cliente();
		initComponents();
	}

	public void initComponents() {
		setTitle("Fabricante");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 26, 61, 16);
		contentPane.add(lblNombre);

		JLabel lblNewLabel = new JLabel("Pais:");
		lblNewLabel.setBounds(30, 62, 61, 16);
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(103, 21, 130, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtPais = new JTextField();
		txtPais.setBounds(103, 57, 130, 26);
		contentPane.add(txtPais);
		txtPais.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String pais = txtPais.getText();
				String user = UsuarioT.getText();
				String cont = ContraseñaT.getText();

				fabricante.setNombre(nombre);
				fabricante.setPais(pais);
				cliente.setNombreUsuario(user);
				cliente.setContrasena(cont);
				cliente.setActivar(1);
				cliente.setRol("Fabricante");
				try {

					servicec.save(Conexion.obtener(), cliente);
					Cliente datos = servicec.getCliente(Conexion.obtener(), user);
					Integer id = datos.getIdClientes();
					System.out.println(id);
					fabricante.setIdCliente(id);
					System.out.println(fabricante.getIdCliente());
					serviceF.save(Conexion.obtener(), fabricante);
					SaveViewFabricante.this.dispose();
					ListViewFabricante vista = new ListViewFabricante();
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(SaveViewFabricante.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(SaveViewFabricante.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				}
			}
		});
		btnGuardar.setBounds(43, 211, 117, 29);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListViewFabricante vista = new ListViewFabricante();
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
			}
		});
		btnCancelar.setBounds(209, 211, 117, 29);
		contentPane.add(btnCancelar);

		UsuarioT = new JTextField();
		UsuarioT.setBounds(103, 98, 130, 20);
		contentPane.add(UsuarioT);
		UsuarioT.setColumns(10);

		ContraseñaT = new JTextField();
		ContraseñaT.setBounds(103, 129, 130, 20);
		contentPane.add(ContraseñaT);
		ContraseñaT.setColumns(10);

		JLabel UsuarioL = new JLabel("Usuario");
		UsuarioL.setBounds(23, 101, 46, 14);
		contentPane.add(UsuarioL);

		JLabel ContraseñaL = new JLabel("Contraseña");
		ContraseñaL.setBounds(23, 132, 68, 14);
		contentPane.add(ContraseñaL);
	}
}
