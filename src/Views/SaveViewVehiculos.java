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

import Service.Conexion;
import Service.VehiculoService;
import models.Vehiculo;

public class SaveViewVehiculos extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;
	private final VehiculoService services = new VehiculoService();
	private final Vehiculo vehiculo;

	/**
	 * Create the frame.
	 */
	
	public SaveViewVehiculos(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		initComponents();
		txtModelo.setText(this.vehiculo.getModelo());
		txtMarca.setText(this.vehiculo.getMarca());
		txtAnyo.setText(String.valueOf(this.vehiculo.getAnyo()));
		txtColor.setText(this.vehiculo.getColor());
		txtPrecio.setText(String.valueOf(this.vehiculo.getPrecio()));
	}
	public SaveViewVehiculos() {
		this.vehiculo=new Vehiculo();
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Vehiculos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 290);
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
		
		JLabel lblidFabricante = new JLabel("ID del Fabricante:");
		lblPrecio.setBounds(30, 206, 61, 16);
		contentPane.add(lblPrecio);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(103, 26, 190, 26);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(103, 62, 190, 26);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtAnyo = new JTextField();
		txtAnyo.setBounds(103, 98, 190, 26);
		contentPane.add(txtAnyo);
		txtAnyo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(103, 134, 190, 26);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(103, 170, 190, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		txtIdFabricante = new JTextField();
		txtIdFabricante.setBounds(103, 206, 190, 26);
		contentPane.add(txtIdFabricante);
		txtIdFabricante.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modelo = txtModelo.getText();
				String marca = txtMarca.getText();
				int anyo = Integer.parseInt(txtAnyo.getText());
				String color = txtColor.getText();
				float precio = Float.parseFloat(txtPrecio.getText());
				int idFabricante = Integer.parseInt(txtIdFabricante.getText());
				
				vehiculo.setModelo(modelo);
				vehiculo.setMarca(marca);
				vehiculo.setAnyo(anyo);
				vehiculo.setColor(color);
				vehiculo.setPrecio(precio);
				vehiculo.setIdFabricante(idFabricante);
				
				
				try {
					services.save(Conexion.obtener(), vehiculo);
					SaveViewVehiculos.this.dispose();
					ListViewVehiculos vista = new ListViewVehiculos();
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(SaveViewVehiculos.this, "Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(SaveViewVehiculos.this, "Ha surgido un error y no se ha podido guardar el registro.");
				}
			}
		});
		btnGuardar.setBounds(46, 220, 117, 29);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListViewVehiculos vista = new ListViewVehiculos();
				vista.setVisible(true);
				
				vista.setLocationRelativeTo(null);
			}
		});
		btnCancelar.setBounds(208, 220, 117, 29);
		contentPane.add(btnCancelar);
	}
}
