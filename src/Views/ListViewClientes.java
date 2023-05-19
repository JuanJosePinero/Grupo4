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

public class ListViewClientes extends JFrame {
	private JPanel contentPane;
	private JTable jtableP;
	private final ClientService services = new ClientService();
	private List<Cliente> Clientes;
	private JButton ActivarB, CambiarB, btnVolver;
	private static Integer idCliente;
	private JComboBox filtro;

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
		
		String[] filtros = { "--", "Compras", "Alquileres", "Comentarios", "Valoraciones"};		
		filtro = new JComboBox(filtros);
		filtro.setBounds(10, 14, 103, 22);
		contentPane.add(filtro);
		manejadorcombo mancombo = new manejadorcombo();
		filtro.addItemListener(mancombo);

	}

	private class ManejadorActionB implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int filaS = jtableP.getSelectedRow();
			String nombreCliente = jtableP.getValueAt(filaS, 0).toString();

			Cliente c = Clientes.get(filaS);
			
			System.out.println(c.getActivar());
			if (b.equals(ActivarB)) {
				String nombre = c.getNombreUsuario();
				if(c.getRol().equals("Cliente")) {
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
				}else if(c.getRol().equals("Fabricante")) {
					
				}
			} else if (b.equals(CambiarB)) {
				String nombre = c.getNombreUsuario();
				try {
					Cliente datos = services.getCliente(Conexion.obtener(), nombre);
					int id =datos.getIdClientes();
					setidClienteCrear(id);
					CambiarContrasena cc = new CambiarContrasena();
					dispose();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		}

	}
	
	private void refrescarTabla(String fil) {
		try {
			if (fil.equalsIgnoreCase("--")) {

			} else if (fil.equalsIgnoreCase("Compras")) {

			} else if (fil.equalsIgnoreCase("Alquileres")) {

			} else if (fil.equalsIgnoreCase("Comentarios")) {

			} else if (fil.equalsIgnoreCase("Valoraciones")) {

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al actualizar la tabla");
		}

	}
	
	private class manejadorcombo implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox combo = (JComboBox) e.getSource();
			String filtroSeleccionado = String.valueOf(combo.getSelectedItem());
			refrescarTabla(filtroSeleccionado);
		}

	}

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
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}
	
//	private void showComprasCliente() {
//		try {
//			this.Clientes = this.services.getAllRolCliente(Conexion.obtener());
//
//			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
//
//			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar" }));
//			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
//			dtm.setRowCount(0);
//
//			for (int i = 0; i < this.Clientes.size(); i++) {
//			
//				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
//						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
//						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
//						this.Clientes.get(i).getActivar() });
//				
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		} catch (ClassNotFoundException ex) {
//			System.out.println(ex);
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		}
//	}
//	
//	private void showAlquileresCliente() {
//		try {
//			this.Clientes = this.services.getAllRolCliente(Conexion.obtener());
//
//			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
//
//			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar" }));
//			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
//			dtm.setRowCount(0);
//
//			for (int i = 0; i < this.Clientes.size(); i++) {
//			
//				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
//						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
//						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
//						this.Clientes.get(i).getActivar() });
//				
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		} catch (ClassNotFoundException ex) {
//			System.out.println(ex);
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		}
//	}
//	
//	private void showComentariosCliente() {
//		try {
//			this.Clientes = this.services.getAllRolCliente(Conexion.obtener());
//
//			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
//
//			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar" }));
//			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
//			dtm.setRowCount(0);
//
//			for (int i = 0; i < this.Clientes.size(); i++) {
//			
//				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
//						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
//						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
//						this.Clientes.get(i).getActivar() });
//				
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		} catch (ClassNotFoundException ex) {
//			System.out.println(ex);
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		}
//	}	
	
//	private void showValoracionesCliente() {
//		try {
//			this.Clientes = this.services.getAllRolCliente(Conexion.obtener());
//
//			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
//
//			}, new String[] { "id", "Nombre", "Direccion", "Rol", "Usuario", "Contasenya", "Activar" }));
//			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
//			dtm.setRowCount(0);
//
//			for (int i = 0; i < this.Clientes.size(); i++) {
//			
//				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
//						this.Clientes.get(i).getDireccion(), this.Clientes.get(i).getRol(),
//						this.Clientes.get(i).getNombreUsuario(), this.Clientes.get(i).getContrasena(),
//						this.Clientes.get(i).getActivar() });
//				
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		} catch (ClassNotFoundException ex) {
//			System.out.println(ex);
//			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
//		}
//	}	
	
	public static void setidClienteCrear(Integer id) {
		idCliente=id;
	}
	public static Integer getidClienteCrear() {
		return idCliente;
	}
}
