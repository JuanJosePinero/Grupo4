package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.ClientService;
import Service.Conexion;
import models.Cliente;

// TODO: Auto-generated Javadoc
/**
 * The Class ListViewClientes.
 */
public class ListViewClientes extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The jtable P. */
	private JTable jtableP;

	/** The services. */
	private final ClientService services = new ClientService();

	/** The Clientes. */
	private List<Cliente> Clientes;

	/** The btn volver. */
	private JButton ActivarB, CambiarB, btnVolver;

	/** The id cliente. */
	private static Integer idCliente;

	/** The filtro. */
	private JComboBox filtro;

	/**
	 * Instantiates a new list view clientes.
	 */
	public ListViewClientes() {
		setTitle("Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 410, 183);
		contentPane.add(scrollPane);

		jtableP = new JTable();
		showCliente();
		scrollPane.setViewportView(jtableP);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAdmin ca = new ControlAdmin();
				dispose();
			}
		});
		btnVolver.setBounds(167, 236, 97, 25);
		contentPane.add(btnVolver);

		ActivarB = new JButton("Activar/Desactivar");
		ActivarB.setBounds(123, 12, 141, 25);
		contentPane.add(ActivarB);

		CambiarB = new JButton("Restablecer Contraseña");
		CambiarB.setBounds(279, 12, 141, 25);
		contentPane.add(CambiarB);

		setVisible(true);
		ManejadorActionB mab = new ManejadorActionB();
		ActivarB.addActionListener(mab);
		CambiarB.addActionListener(mab);

		String[] filtros = { "--", "Compras", "Alquileres", "Comentarios", "Valoraciones" };
		filtro = new JComboBox(filtros);
		filtro.setBounds(10, 14, 103, 22);
		contentPane.add(filtro);
		manejadorcombo mancombo = new manejadorcombo();
		filtro.addItemListener(mancombo);

	}

	/**
	 * The Class ManejadorActionB.
	 */
	private class ManejadorActionB implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int filaS = jtableP.getSelectedRow();
			try {
				String nombreCliente = jtableP.getValueAt(filaS, 0).toString();

				Cliente c = Clientes.get(filaS);

				if (b.equals(ActivarB)) {
					String nombre = c.getNombreUsuario();
					if (c.getRol().equals("Cliente")) {
						if (filaS >= 0) {
							if (c.getActivar() == 1) {

								try {
									Cliente datos = services.getCliente(Conexion.obtener(), nombre);
									String nom = c.getNombreUsuario();
									String dir = datos.getDireccion();
									String rol = datos.getRol();
									String user = datos.getNombreUsuario();
									String cont = datos.getContrasena();
									Integer id = datos.getIdClientes();
									int act = 0;
									int coments = datos.getNumComentarios();
									int valorac = datos.getNumValoraciones();

									datos.setIdClientes(id);
									datos.setNombre(nom);
									datos.setDireccion(dir);
									datos.setRol(rol);
									datos.setNombreUsuario(user);
									datos.setContrasena(cont);
									datos.setActivar(act);
									datos.setNumComentarios(coments);
									datos.setNumValoracion(valorac);

									services.save(Conexion.obtener(), datos);
									dispose();
									ListViewClientes lvc = new ListViewClientes();

								} catch (ClassNotFoundException | SQLException e1) {
								}
							} else {
								nombre = c.getNombreUsuario();
								try {
									Cliente datos = services.getCliente(Conexion.obtener(), nombre);
									String nom = datos.getNombre();
									String dir = datos.getDireccion();
									String rol = datos.getRol();
									String user = datos.getNombreUsuario();
									String cont = datos.getContrasena();
									Integer id = datos.getIdClientes();
									int act = 1;

									datos.setIdClientes(id);
									datos.setNombre(nom);
									datos.setDireccion(dir);
									datos.setRol(rol);
									datos.setNombreUsuario(user);
									datos.setContrasena(cont);
									datos.setActivar(act);

									services.save(Conexion.obtener(), datos);

									dispose();
									ListViewClientes lvc = new ListViewClientes();

								} catch (ClassNotFoundException | SQLException e1) {

									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Por favor seleccione una fila.", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else if (c.getRol().equals("Fabricante")) {

					}
				} else if (b.equals(CambiarB)) {
					String nombre = c.getNombreUsuario();
					try {
						Cliente datos = services.getCliente(Conexion.obtener(), nombre);
						int id = datos.getIdClientes();
						setidClienteCrear(id);
						CambiarContrasena cc = new CambiarContrasena();
						dispose();

					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Por favor seleccione una fila.", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
			} catch (Exception a) {
				JOptionPane.showMessageDialog(null, "Por favor seleccione una fila.", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	/**
	 * Refrescar tabla.
	 *
	 * @param fil the fil
	 */
	private void refrescarTabla(String fil) {
		try {
			if (fil.equalsIgnoreCase("--")) {
				showCliente();
			} else if (fil.equalsIgnoreCase("Compras")) {
				showComprasCliente();
			} else if (fil.equalsIgnoreCase("Alquileres")) {
				showAlquileresCliente();
			} else if (fil.equalsIgnoreCase("Comentarios")) {
				showComentariosCliente();
			} else if (fil.equalsIgnoreCase("Valoraciones")) {
				showValoracionesCliente();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al actualizar la tabla");
		}

	}

	/**
	 * The Class manejadorcombo.
	 */
	private class manejadorcombo implements ItemListener {

		/**
		 * Item state changed.
		 *
		 * @param e the e
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox combo = (JComboBox) e.getSource();
			String filtroSeleccionado = String.valueOf(combo.getSelectedItem());
			refrescarTabla(filtroSeleccionado);
		}

	}

	/**
	 * Show cliente.
	 */
	private void showCliente() {
		try {
			this.Clientes = this.services.getAllRolCliente(Conexion.obtener());

			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			for (int i = 0; i < this.Clientes.size(); i++) {

				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
						this.Clientes.get(i).getActivar() });
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * Show compras cliente.
	 */
	private void showComprasCliente() {
		try {
			this.Clientes = this.services.getComprasCliente(Conexion.obtener());

			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar", "NºCompras" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			for (int i = 0; i < this.Clientes.size(); i++) {

				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
						this.Clientes.get(i).getActivar(), this.Clientes.get(i).getNumCompras() });
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * Show alquileres cliente.
	 */
	private void showAlquileresCliente() {
		try {
			this.Clientes = this.services.getAlquileresCliente(Conexion.obtener());

			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar",
					"NºAlquileres" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			for (int i = 0; i < this.Clientes.size(); i++) {

				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
						this.Clientes.get(i).getActivar(), this.Clientes.get(i).getNumAlquileres() });
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {

			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * Show valoraciones cliente.
	 */
	private void showValoracionesCliente() {
		try {
			this.Clientes = this.services.getValoracionesCliente(Conexion.obtener());

			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "id", "Nombre", "Direccion", "Usuario", "Contasenya" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			for (int i = 0; i < this.Clientes.size(); i++) {

				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getNombreUsuario(),
						this.Clientes.get(i).getContrasena() });
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * Show comentarios cliente.
	 */
	private void showComentariosCliente() {
		try {
			this.Clientes = this.services.getComentariosCliente(Conexion.obtener());

			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "id", "Nombre", "Direccion", "Usuario", "Contasenya" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			for (int i = 0; i < this.Clientes.size(); i++) {

				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getNombreUsuario(),
						this.Clientes.get(i).getContrasena() });
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * Sets the id cliente crear.
	 *
	 * @param id the new id cliente crear
	 */
	public static void setidClienteCrear(Integer id) {
		idCliente = id;
	}

	/**
	 * Gets the id cliente crear.
	 *
	 * @return the id cliente crear
	 */
	public static Integer getidClienteCrear() {
		return idCliente;
	}
}
