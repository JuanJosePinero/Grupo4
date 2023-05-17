package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.AlquilerService;
import Service.Conexion;
import Service.VehiculoService;
import models.Alquiler;
import models.Cliente;
import models.Vehiculo;


public class AlquilerVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;
	private final VehiculoService services = new VehiculoService();
	private final AlquilerService service=new AlquilerService();
	private final Vehiculo vehiculo;
	private final Alquiler alquiler;
	private final Cliente cliente;
	private final Login login;
	private JButton btnAlquiler, btnCancelar;
	private JLabel lblImagen;
	private String ruta;
	private JLabel FechaInicio,FechaFin;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlquilerVehiculo frame = new AlquilerVehiculo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AlquilerVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		initComponents();
		txtModelo.setText(this.vehiculo.getModelo());
		txtMarca.setText(this.vehiculo.getMarca());
		txtAnyo.setText(String.valueOf(this.vehiculo.getAnyo()));
		txtColor.setText(this.vehiculo.getColor());
		txtPrecio.setText(String.valueOf(this.vehiculo.getPrecio()));
		txtIdFabricante.setText(String.valueOf(this.vehiculo.getIdFabricante()));
		ruta = this.vehiculo.getRuta();
		this.alquiler = new Alquiler();
		this.cliente = new Cliente();
		this.login = new Login();
	}
	
	/**
	 * Create the frame.
	 */
	public AlquilerVehiculo() {
		this.vehiculo=new Vehiculo();
		this.alquiler = new Alquiler();
		this.cliente = new Cliente();
		this.login = new Login();
		initComponents();
		
	}


	public void initComponents() {
		setTitle("Coche seleccionado para el alquiler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 240, 402, 536);
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
		
		JLabel lbAnyo = new JLabel("Año:");
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
		
		btnAlquiler = new JButton("Alquilar");
		btnAlquiler.setBounds(35, 436, 117, 29);
		btnAlquiler.addActionListener(manejador);
		contentPane.add(btnAlquiler);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(240, 436, 117, 29);
		btnCancelar.addActionListener(manejador);
		contentPane.add(btnCancelar);
		
		lblImagen = new JLabel("Imagen:");
		lblImagen.setBounds(30, 247, 80, 16);
		contentPane.add(lblImagen);
		
		JPanel panel = new JPanel();
		panel.setBounds(130, 242, 190, 92);
		contentPane.add(panel);
		
		JLabel imagenLabel = new JLabel();
	    ImageIcon imagen = new ImageIcon(ruta); 
	    imagenLabel.setIcon(imagen);
	    panel.add(imagenLabel);
	    
	    FechaInicio = new JLabel("Fecha Inicio");
	    FechaInicio.setBounds(35, 345, 87, 13);
	    contentPane.add(FechaInicio);
	    
	    FechaFin = new JLabel("Fecha Fin");
	    FechaFin.setBounds(262, 345, 58, 13);
	    contentPane.add(FechaFin);
	    
	    
	    
	   setVisible(true);
		
	}
	
	private class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if(o == btnAlquiler) {
				
				int idAlquiler = alquiler.getIdAlquiler();
				int idVehiculo = alquiler.getIdVehiculo();
				int idCliente = login.idClienteLogin;
				Date fechaInc=(Date) alquiler.getFechaInic();
				Date fechaFin=(Date) alquiler.getFechFin();
				
				alquiler.setIdAlquiler(idAlquiler);
				alquiler.setIdVehiculo(idVehiculo);
				alquiler.setIdCliente(idCliente);
				alquiler.setFechaInic(fechaInc);
				alquiler.setFechFin(fechaFin);
				
				
				
				try {
					service.save(Conexion.obtener(), alquiler);
					AlquilerVehiculo.this.dispose();
					ListViewVehiculos vista = new ListViewVehiculos();
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(AlquilerVehiculo.this, "Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(AlquilerVehiculo.this, "Ha surgido un error y no se ha podido guardar el registro.");
				}
			}else if(o == btnCancelar) {
				JOptionPane.showMessageDialog(null, "La compra ha sido cancelada.", "Cancelacion", JOptionPane.ERROR_MESSAGE);
				dispose();
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
			}			
		}
	}
}
