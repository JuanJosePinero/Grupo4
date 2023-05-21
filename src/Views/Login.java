package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
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
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The Usuario T. */
	private JTextField UsuarioT;

	/** The btn crear usuario. */
	private JButton btnIniciarSesion, btnCrearUsuario;

	/** The Contraseña P. */
	private JPasswordField ContraseñaP;

	/** The services. */
	private final ClientService services = new ClientService();

	/** The id cliente login. */
	public static Integer idClienteLogin;

	/** The id fabricante. */
	public static Integer idFabricante;

	/** The id vehiculo. */
	public static Integer idVehiculo;

	/** The nom user. */
	public static String nomUser;

	/**
	 * Instantiates a new login.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel_2.add(btnIniciarSesion);

		btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		panel_2.add(btnCrearUsuario);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);

		JPanel Center = new JPanel();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.setLayout(null);

		JLabel UsuarioL = new JLabel("Usuario");
		UsuarioL.setHorizontalAlignment(SwingConstants.CENTER);
		UsuarioL.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		UsuarioL.setBounds(131, 33, 129, 20);
		Center.add(UsuarioL);

		UsuarioT = new JTextField();
		UsuarioT.setBounds(131, 58, 129, 20);
		Center.add(UsuarioT);
		UsuarioT.setColumns(10);

		JLabel imagenLabel = new JLabel();
		ImageIcon imagen = new ImageIcon("images/Usuario.png");
		imagenLabel.setIcon(imagen);
		Center.add(imagenLabel);
		imagenLabel.setBounds(130, 20, 40, 40);

		JLabel ContraseñaL = new JLabel("Contraseña");
		ContraseñaL.setHorizontalAlignment(SwingConstants.CENTER);
		ContraseñaL.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		ContraseñaL.setBounds(131, 117, 129, 17);
		Center.add(ContraseñaL);

		ContraseñaP = new JPasswordField();
		ContraseñaP.setBounds(131, 144, 129, 20);
		Center.add(ContraseñaP);

		JLabel imagenLabel1 = new JLabel();
		ImageIcon imagen1 = new ImageIcon("images/contrasenya.jpg");
		imagenLabel1.setIcon(imagen1);
		Center.add(imagenLabel1);
		imagenLabel1.setBounds(131, 105, 50, 40);

		setVisible(true);

		manejadorAction ma = new manejadorAction();

		btnIniciarSesion.addActionListener(ma);
		btnCrearUsuario.addActionListener(ma);
	}

	/**
	 * The Class manejadorAction.
	 */
	private class manejadorAction implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton o = (JButton) e.getSource();

			if (o.equals(btnIniciarSesion)) {
				try {
					Cliente datos = services.getCliente(Conexion.obtener(), UsuarioT.getText());

					if (datos != null) {

						int activar = datos.getActivar();

						String userB = datos.getNombreUsuario();
						String contB = datos.getContrasena();
						String user = UsuarioT.getText();
						char[] contrasenaC = ContraseñaP.getPassword();
						String cont = new String(contrasenaC);

						if (userB.equals(user) && contB.equals(cont)) {
							if (datos.getRol().equals("Administrador")) {
								ControlAdmin ca = new ControlAdmin();
								ca.setVisible(true);
								dispose();
							} else if (datos.getRol().equals("Cliente")) {
								if (activar == 1) {
									setnombreUser(datos.getNombreUsuario());
									setidClienteLogin(datos.getIdClientes());

									VentanaCatalogo vc = new VentanaCatalogo();
									vc.setVisible(true);
									dispose();

								} else
									JOptionPane.showMessageDialog(Login.this,
											datos.getNombre() + ", tu cuenta ha sido supendida");
							} else if (datos.getRol().equals("Fabricante")) {
								setidClienteLogin(datos.getIdClientes());
								VisualizarVehiculosCrear vv = new VisualizarVehiculosCrear();
								datos.getIdClientes();
								vv.setVisible(true);
								dispose();
							}
						} else
							JOptionPane.showMessageDialog(Login.this, "Usuario o Contraseña Incorrecta", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(Login.this, "Introduce Usuario y Contraseña", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);

				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			} else if (o.equals(btnCrearUsuario)) {
				CreacionUsuario cu = new CreacionUsuario();
				dispose();
			}
		}
	}

	/**
	 * Sets the id cliente login.
	 *
	 * @param id the new id cliente login
	 */
	public static void setidClienteLogin(Integer id) {
		idClienteLogin = id;
	}

	/**
	 * Gets the id cliente login.
	 *
	 * @return the id cliente login
	 */
	public static Integer getidClienteLogin() {
		return idClienteLogin;
	}

	/**
	 * Sets the id fabricante.
	 *
	 * @param id the new id fabricante
	 */
	public static void setidFabricante(Integer id) {
		idFabricante = id;
	}

	/**
	 * Gets the id fabricante.
	 *
	 * @return the id fabricante
	 */
	public static Integer getidFabricante() {
		return idFabricante;
	}

	/**
	 * Sets the id vehiculo.
	 *
	 * @param id the new id vehiculo
	 */
	public static void setidVehiculo(Integer id) {
		idVehiculo = id;
	}

	/**
	 * Gets the id vehiculo.
	 *
	 * @return the id vehiculo
	 */
	public static Integer getidVehiculo() {
		return idVehiculo;
	}

	/**
	 * Sets the nombre user.
	 *
	 * @param nom the new nombre user
	 */
	public static void setnombreUser(String nom) {
		nomUser = nom;
	}

	/**
	 * Gets the nombre user.
	 *
	 * @return the nombre user
	 */
	public static String getnombreUser() {
		return nomUser;
	}
}
