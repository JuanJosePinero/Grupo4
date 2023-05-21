package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.AlquilerService;
import Service.ClientService;
import Service.Conexion;
import Service.VehiculoService;
import models.Alquiler;
import models.Cliente;
import models.Vehiculo;

public class AlquilerVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;
	private final VehiculoService services = new VehiculoService();
	private final AlquilerService service = new AlquilerService();
	private final ClientService serviceCliente = new ClientService();
	private final Vehiculo vehiculo;
	private final Alquiler alquiler;
	private final Cliente cliente;
	private JButton btnAlquiler, btnCancelar;
	private JLabel imagenLabel;
	private ImageIcon imagen;
	private String ruta;
	private JLabel FechaInicio, FechaFin;
	private JTextField fechaInicio;
	private JTextField fechafin;
	private JComboBox<String> fechainicio, fechaF;
	private static int estaAlquilado;
	private int numeroAlquileres = 0;
	private int id;

	public AlquilerVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		this.alquiler = new Alquiler();
		this.cliente = new Cliente();
		initComponents();
		txtModelo.setText(this.vehiculo.getModelo());
		txtMarca.setText(this.vehiculo.getMarca());
		txtAnyo.setText(String.valueOf(this.vehiculo.getAnyo()));
		txtColor.setText(this.vehiculo.getColor());
		txtPrecio.setText(String.valueOf(this.vehiculo.getPrecio()));
		txtIdFabricante.setText(String.valueOf(this.vehiculo.getIdFabricante()));
		id = vehiculo.getIdVehiculos();

		getRuta();
	}

	/**
	 * Create the frame.
	 */
	public AlquilerVehiculo() {
		this.vehiculo = new Vehiculo();
		this.alquiler = new Alquiler();
		this.cliente = new Cliente();
		initComponents();

	}

	public void initComponents() {
		setTitle("Coche seleccionado para el alquiler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 240, 727, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(30, 18, 61, 16);
		contentPane.add(lblModelo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(30, 54, 61, 16);
		contentPane.add(lblMarca);

		JLabel lbAnyo = new JLabel("Anyo:");
		lbAnyo.setBounds(30, 90, 61, 16);
		contentPane.add(lbAnyo);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(30, 126, 61, 16);
		contentPane.add(lblColor);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(30, 162, 61, 16);
		contentPane.add(lblPrecio);

		JLabel lblidFabricante = new JLabel("IdFabricante:");
		lblidFabricante.setBounds(30, 198, 80, 16);
		contentPane.add(lblidFabricante);

		txtModelo = new JTextField();
		txtModelo.setBounds(130, 14, 190, 26);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		txtModelo.setEditable(false);

		txtMarca = new JTextField();
		txtMarca.setBounds(130, 50, 190, 26);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		txtMarca.setEditable(false);

		txtAnyo = new JTextField();
		txtAnyo.setBounds(130, 86, 190, 26);
		contentPane.add(txtAnyo);
		txtAnyo.setColumns(10);
		txtAnyo.setEditable(false);

		txtColor = new JTextField();
		txtColor.setBounds(130, 122, 190, 26);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		txtColor.setEditable(false);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(130, 158, 190, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setEditable(false);

		txtIdFabricante = new JTextField();
		txtIdFabricante.setBounds(130, 194, 190, 26);
		contentPane.add(txtIdFabricante);
		txtIdFabricante.setColumns(10);
		txtIdFabricante.setEditable(false);

		JLabel FechaInicio = new JLabel("Fecha Inicio");
		FechaInicio.setBounds(30, 230, 87, 13);
		contentPane.add(FechaInicio);

		JLabel FechaFin = new JLabel("Fecha Fin");
		FechaFin.setBounds(195, 230, 58, 13);
		contentPane.add(FechaFin);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		String[] dates = new String[366];
		dates[0] = currentDate.format(formatter);
		for (int i = 1; i <= 365; i++) {
			currentDate = currentDate.plusDays(1);
			dates[i] = currentDate.format(formatter);
		}

		fechainicio = new JComboBox(dates);
		fechainicio.setBounds(30, 243, 87, 21);
		fechainicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate selectedDate = parseDate(fechainicio.getSelectedItem().toString());
				updateComboBoxFin(selectedDate);
			}
		});
		contentPane.add(fechainicio);

		JPanel panel = new JPanel();
		panel.setBounds(341, 43, 350, 200);
		contentPane.add(panel);

		imagenLabel = new JLabel(ruta);
		imagen = new ImageIcon(vehiculo.getRuta());
		imagenLabel.setIcon(imagen);
		panel.add(imagenLabel);

		ManejadorJButton escuchador = new ManejadorJButton();
		fechaF = new JComboBox();
		fechaF.setBounds(195, 243, 95, 21);
		contentPane.add(fechaF);
		btnAlquiler = new JButton("Alquilar");
		btnAlquiler.setSize(193, 30);
		btnAlquiler.setLocation(130, 291);
		btnAlquiler.addActionListener(escuchador);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(193, 30);
		btnCancelar.setLocation(398, 291);
		btnCancelar.addActionListener(escuchador);
		contentPane.add(btnAlquiler);
		contentPane.add(btnCancelar);

		setVisible(true);
	}

	private void updateComboBoxFin(LocalDate selectedDate) {
		fechaF.removeAllItems();
		fechaF.addItem(selectedDate.toString());
		for (int i = fechainicio.getSelectedIndex() + 1; i < fechainicio.getItemCount(); i++) {
			LocalDate date = parseDate(fechainicio.getItemAt(i));
			fechaF.addItem(date.toString());
		}
	}

	private LocalDate parseDate(String dateStr) {
		return LocalDate.parse(dateStr);
	}

	public void getRuta() {
		Vehiculo vs;
		try {
			vs = services.getVehiculo(Conexion.obtener(), id);
			String ruta = vs.getRuta();
			imagen = new ImageIcon(ruta);
			imagenLabel.setIcon(imagen);
			System.out.println(ruta);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == btnAlquiler) {
				try {
					Vehiculo v = services.getVehiculo(Conexion.obtener(), vehiculo.getIdVehiculos());
//					if(v.getAlquilado()==1) {
//						JOptionPane.showMessageDialog(AlquilerVehiculo.this, "Este coche ya ha sido alquilado", "Aviso", JOptionPane.ERROR_MESSAGE);
//						AlquilerVehiculo.this.dispose();
//						VentanaCatalogo vc = new VentanaCatalogo();
//						vc.setVisible(true);
//						vc.setLocationRelativeTo(null);
//					}else 
					if (v.getAlquilado() >= 0) {
						updateAlquiler();
						updateVehiculo();
						updateCliente();
						

						AlquilerVehiculo.this.dispose();
						JOptionPane.showMessageDialog(AlquilerVehiculo.this, "Se ha realizado el alquiler", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
						VentanaCatalogo vc = new VentanaCatalogo();
						vc.setVisible(true);
						vc.setLocationRelativeTo(null);
					}
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				}

			} else if (o == btnCancelar) {
				JOptionPane.showMessageDialog(null, "El alquiler ha sido cancelada.", "Cancelacion",
						JOptionPane.ERROR_MESSAGE);
				dispose();
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
			}
		}
		public void updateAlquiler() {
			
			try {
				Integer idAlquiler = alquiler.getIdAlquiler();
				Integer idVehiculo = vehiculo.getIdVehiculos();
				Integer idCliente = Login.getidClienteLogin();

				String fechaIncstr = (String) fechainicio.getSelectedItem();
				String fechaFinstr = (String) fechaF.getSelectedItem();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date fechaUtil = formatter.parse(fechaIncstr);
				java.util.Date fechaUtil2 = formatter.parse(fechaFinstr);
				Date fechaInc = new Date(fechaUtil.getTime());
				Date fechaFin = new Date(fechaUtil2.getTime());

				alquiler.setIdAlquiler(idAlquiler);
				alquiler.setIdVehiculo(idVehiculo);
				alquiler.setIdCliente(idCliente);
				alquiler.setFechaInic(fechaInc);
				alquiler.setFechFin(fechaFin);
				
				if (!VehiculoDisponible(idVehiculo, fechaInc, fechaFin)) {
					JOptionPane.showMessageDialog(AlquilerVehiculo.this,
							"No se puede alquilar el vehiculo en esta fecha", "Aviso",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				service.save(Conexion.obtener(), alquiler);
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void updateVehiculo() {
			Vehiculo v;
			try {
				v = services.getVehiculo(Conexion.obtener(), vehiculo.getIdVehiculos());
				vehiculo.setRuta(v.getRuta());
				vehiculo.setAlquilado(1);
				vehiculo.setComprado(0);
				services.save(Conexion.obtener(), vehiculo);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		public void updateCliente() {

			Cliente datos;
			try {
				datos = serviceCliente.getClienteId(Conexion.obtener(), Login.getidClienteLogin());
				
				String nom = datos.getNombre();
				String dir = datos.getDireccion();
				String rol = datos.getRol();
				String user = datos.getNombreUsuario();
				String cont = datos.getContrasena();
				int act = datos.getActivar();
				int numC = (datos.getNumCompras());
				int numA = (datos.getNumAlquileres() + 1);
				int numCO = datos.getNumComentarios();
				int numV = datos.getNumValoraciones();
				cliente.setIdClientes(Login.getidClienteLogin());
				cliente.setNombre(nom);
				cliente.setDireccion(dir);
				cliente.setRol(rol);
				cliente.setNombreUsuario(user);
				cliente.setContrasena(cont);
				cliente.setActivar(act);
				cliente.setNumCompras(numC);
				cliente.setNumAlquileres(numA);
				
				serviceCliente.save(Conexion.obtener(), cliente);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		

		private boolean VehiculoDisponible(Integer idVehiculo, Date fechaInc, Date fechaFin) {
			try {
				Connection connection = Conexion.obtener();
				String query = "SELECT * FROM alquiler WHERE idVehiculo = ? AND ((fechaInic <= ?  AND fechaFin >= ? ) OR (fechaInic <= ?  AND fechaFin >= ? ))";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, idVehiculo);
				statement.setDate(2, fechaInc);
				statement.setDate(3, fechaInc);
				statement.setDate(4, fechaFin);
				statement.setDate(5, fechaFin);
				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {
					int count = resultSet.getInt(1);
					return count == 0;
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex);
			}
			return true;
		}
	}

	public static void setestaAlquilado(int alquilado) {
		estaAlquilado = alquilado;
	}

	public static Integer getestaAlquilado() {
		return estaAlquilado;
	}
	
	
	
	
}