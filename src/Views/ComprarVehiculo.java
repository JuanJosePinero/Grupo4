package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.ClientService;
import Service.Conexion;
import Service.VehiculoService;
import Service.VentaService;
import models.Cliente;
import models.Vehiculo;
import models.Venta;

public class ComprarVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;
	private JLabel imagenLabel;
	private ImageIcon imagen;
	private final VehiculoService services = new VehiculoService();
	private final ClientService serviceCliente = new ClientService();
	private final VentaService servicesventa = new VentaService();
	private final Vehiculo vehiculo;
	private Vehiculo v = new Vehiculo();
	private final Venta venta;
	private final Cliente cliente;
	private JButton btnComprar, btnCancelar;
	private String ruta;
	private int numeroCompras = 0;
	private int id;

	public ComprarVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		this.venta = new Venta();
		this.cliente = new Cliente();
		initComponents();
		txtModelo.setText(vehiculo.getModelo());
		txtMarca.setText(vehiculo.getMarca());
		txtAnyo.setText(String.valueOf(vehiculo.getAnyo()));
		txtColor.setText(vehiculo.getColor());
		txtPrecio.setText(String.valueOf(vehiculo.getPrecio() + " euros"));
		txtIdFabricante.setText(String.valueOf(vehiculo.getIdFabricante()));
		id = vehiculo.getIdVehiculos();

		getRuta();
	}

	public ComprarVehiculo() {
		this.vehiculo = new Vehiculo();
		this.venta = new Venta();
		this.cliente = new Cliente();
		initComponents();
	}

	public void initComponents() {
		setTitle("Coche seleccionado Para la Compra");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 240, 734, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(30, 26, 61, 16);
		contentPane.add(lblModelo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(30, 62, 61, 16);
		contentPane.add(lblMarca);

		JLabel lbAnyo = new JLabel("Anyo:");
		lbAnyo.setBounds(30, 98, 61, 16);
		contentPane.add(lbAnyo);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(30, 134, 61, 16);
		contentPane.add(lblColor);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(30, 170, 61, 16);
		contentPane.add(lblPrecio);

		JLabel lblidFabricante = new JLabel("IdFabricante:");
		lblidFabricante.setBounds(30, 206, 80, 16);
		contentPane.add(lblidFabricante);

		txtModelo = new JTextField();
		txtModelo.setBounds(130, 26, 190, 26);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		txtModelo.setEditable(false);

		txtMarca = new JTextField();
		txtMarca.setBounds(130, 62, 190, 26);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		txtMarca.setEditable(false);

		txtAnyo = new JTextField();
		txtAnyo.setBounds(130, 98, 190, 26);
		contentPane.add(txtAnyo);
		txtAnyo.setColumns(10);
		txtAnyo.setEditable(false);

		txtColor = new JTextField();
		txtColor.setBounds(130, 134, 190, 26);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		txtColor.setEditable(false);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(130, 170, 190, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setEditable(false);

		txtIdFabricante = new JTextField();
		txtIdFabricante.setBounds(130, 206, 190, 26);
		contentPane.add(txtIdFabricante);
		txtIdFabricante.setColumns(10);
		txtIdFabricante.setEditable(false);

		ManejadorJButton manejador = new ManejadorJButton();

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(96, 253, 193, 26);
		btnComprar.addActionListener(manejador);
		contentPane.add(btnComprar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(400, 253, 193, 26);
		btnCancelar.addActionListener(manejador);
		contentPane.add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBounds(340, 26, 350, 200);
		contentPane.add(panel);

		imagenLabel = new JLabel(ruta);
		imagen = new ImageIcon(vehiculo.getRuta());
		imagenLabel.setIcon(imagen);
		panel.add(imagenLabel);
	}

	public void getRuta() {
		Vehiculo vs;
		try {
			vs = services.getVehiculo(Conexion.obtener(), id);
			String ruta = vs.getRuta();
			imagen = new ImageIcon(ruta);
			imagenLabel.setIcon(imagen);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == btnComprar) {
				try {
					Vehiculo v = services.getVehiculo(Conexion.obtener(), vehiculo.getIdVehiculos());

					if (v.getComprado() == 1) {
						JOptionPane.showMessageDialog(ComprarVehiculo.this, "este coche ya ha sido comprado");
						ComprarVehiculo.this.dispose();
						VentanaCatalogo vc = new VentanaCatalogo();
						vc.setVisible(true);
						vc.setLocationRelativeTo(null);
					} else if (v.getComprado() == 0) {
						Integer idVehiculo = vehiculo.getIdVehiculos();
						Integer idCliente = Login.getidClienteLogin();
						Calendar calendario = Calendar.getInstance();
						java.util.Date utilDate = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
						Integer idVenta = venta.getIdVenta();
						venta.setIdVenta(idVenta);
						venta.setIdVehiculo(idVehiculo);
						venta.setIdCliente(idCliente);
						venta.setFechaHora(sqlDate);
						vehiculo.setRuta(v.getRuta());
						vehiculo.setComprado(1);
						vehiculo.setAlquilado(0);

						Cliente datos = serviceCliente.getClienteId(Conexion.obtener(), Login.getidClienteLogin());

						String nom = datos.getNombre();
						String dir = datos.getDireccion();
						String rol = datos.getRol();
						String user = datos.getNombreUsuario();
						String cont = datos.getContrasena();
						int act = datos.getActivar();
						int numC = (datos.getNumCompras() + 1);
						int numA = datos.getNumAlquileres();
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

						servicesventa.save(Conexion.obtener(), venta);
						serviceCliente.save(Conexion.obtener(), cliente);

						services.save(Conexion.obtener(), vehiculo);
						ComprarVehiculo.this.dispose();
						JOptionPane.showMessageDialog(ComprarVehiculo.this, "Se ha realizado la compra");
						VentanaCatalogo vc = new VentanaCatalogo();
						vc.setVisible(true);
						vc.setLocationRelativeTo(null);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			} else if (o == btnCancelar) {
				JOptionPane.showMessageDialog(null, "La compra ha sido cancelada.", "Cancelacion",
						JOptionPane.ERROR_MESSAGE);
				dispose();
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
			}
		}
	}
}
