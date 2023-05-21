package Views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Service.ClientService;
import Service.Conexion;
import Service.ValoracionService;
import Service.VehiculoService;
import models.Cliente;
import models.Valoracion;
import models.Vehiculo;

public class AgregarValoracion extends JFrame {

	private JPanel contentPane;
	private List<JButton> btnEstrellaList = new ArrayList<>();
	private JButton btnEnviar, btnCancelar;
	private JButton btnEst;
	private ImageIcon icono0, icono1, icono2, icono3, icono4, icono5;
	private JLabel etiquetaImagen;
	private ValoracionService service = new ValoracionService();
	private final VehiculoService serviceveh = new VehiculoService();
	private final ClientService servicec = new ClientService();
	private Cliente cliente;
	private Vehiculo vehiculo;
	private int valoracion = 0;
	private int val = 0;

	public AgregarValoracion() {
		super("Agregar Valoracion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 292);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(163, 163, 165));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Agrega una valoracion para el vehículo seleccionado.");
		lblTitulo.setBounds(28, 5, 390, 21);
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitulo);

		ManejadorJButton manejador = new ManejadorJButton();
		manejadorestrella estrella = new manejadorestrella();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(163, 165, 165));
		panel.setBounds(54, 36, 341, 55);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		for (int i = 0; i < 6; i++) {
			btnEst = new JButton(String.valueOf(i) + "★");
			btnEstrellaList.add(btnEst);
			btnEst.setSize(55, 55);
			panel.add(btnEst);
			btnEst.addActionListener(estrella);
		}

		icono0 = new ImageIcon("images/estrellas/estrella0.png");

		etiquetaImagen = new JLabel(icono0);
		etiquetaImagen.setBounds(50, 101, 350, 100);
		contentPane.add(etiquetaImagen);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(manejador);
		btnEnviar.setBounds(103, 224, 98, 21);
		contentPane.add(btnEnviar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(manejador);
		btnCancelar.setBounds(251, 224, 98, 21);
		contentPane.add(btnCancelar);
	}

	public class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			JButton boton = (JButton) e.getSource();

			if (o == btnEnviar) {
				updateValoracion();
				updateVehiculo();
				updateCliente();

				JOptionPane.showMessageDialog(null, "La valoracion ha sido Enviada con exito!", "Envio completado",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();

			} else if (o == btnCancelar) {
				JOptionPane.showMessageDialog(null, "La valoracion ha sido Cancelado!", "Cancelar valoracion",
						JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();

			} else if (o == btnEst) {
				for (int i = 1; i < 6; i++) {
					if (btnEstrellaList.get(i) == btnEst) {
						break;
					}
				}
			}
		}
	}

	private class manejadorestrella implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource();
			String textoBoton = boton.getText();
			String[] partes = textoBoton.split("★");
			int valorEstrella = Integer.parseInt(partes[0]);
			valoracion = valorEstrella;

			ImageIcon nuevaImagen = new ImageIcon("images/estrellas/estrella" + valorEstrella + ".png");
			etiquetaImagen.setIcon(nuevaImagen);
		}
	}

	public void updateValoracion() {
		try {
			Valoracion v = new Valoracion();
			v.setIdCliente(Login.getidClienteLogin());
			v.setIdVehiculo(Login.getidVehiculo());
			v.setValoracion(valoracion);
			service.save(Conexion.obtener(), v);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateVehiculo() {
		try {
			vehiculo = serviceveh.getVehiculo(Conexion.obtener(), Login.getidVehiculo());
			String mod = vehiculo.getModelo();
			String mar = vehiculo.getMarca();
			int anyo = vehiculo.getAnyo();
			String color = vehiculo.getColor();
			float precio = vehiculo.getPrecio();
			int idF = vehiculo.getIdFabricante();
			String rut = vehiculo.getRuta();
			int comp = vehiculo.getComprado();
			int alqui = vehiculo.getAlquilado();
			int numC = (vehiculo.getNumcomentarios());
			int numVa = (vehiculo.getNumvaloraciones() + 1);

			vehiculo.setIdVehiculos(Login.getidVehiculo());
			vehiculo.setModelo(mod);
			vehiculo.setMarca(mar);
			vehiculo.setAnyo(anyo);
			vehiculo.setColor(color);
			vehiculo.setPrecio(precio);
			vehiculo.setIdFabricante(idF);
			vehiculo.setRuta(rut);
			vehiculo.setComprado(comp);
			vehiculo.setAlquilado(alqui);
			vehiculo.setNumcomentarios(numC);
			vehiculo.setNumvaloraciones(numVa);
			serviceveh.save(Conexion.obtener(), vehiculo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCliente() {
		try {
			cliente = servicec.getClienteId(Conexion.obtener(), Login.getidClienteLogin());
			Integer id = Login.getidClienteLogin();
			String nom = cliente.getNombre();
			String dir = cliente.getDireccion();
			String rol = cliente.getRol();
			String user = cliente.getNombreUsuario();
			String cont = cliente.getContrasena();
			int act = cliente.getActivar();
			int numCP = (cliente.getNumCompras());
			int numA = cliente.getNumAlquileres();
			int numCO = (cliente.getNumComentarios());

			int numV = (cliente.getNumValoraciones() + 1);
			cliente.setIdClientes(id);
			cliente.setNombre(nom);
			cliente.setDireccion(dir);
			cliente.setRol(rol);
			cliente.setNombreUsuario(user);
			cliente.setContrasena(cont);
			cliente.setActivar(act);
			cliente.setNumCompras(numCP);
			cliente.setNumAlquileres(numA);
			cliente.setNumComentarios(numCO);
			cliente.setNumValoracion(numV);

			servicec.save(Conexion.obtener(), cliente);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
