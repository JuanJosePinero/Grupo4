package Views;

import java.awt.EventQueue;
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

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private final AlquilerService service = new AlquilerService();
	private final Vehiculo vehiculo;
	private final Alquiler alquiler;
	private final Cliente cliente;
	// private final Login login;
	private JButton btnAlquiler, btnCancelar;
	private JLabel lblImagen;
	private String ruta;
	private JLabel FechaInicio, FechaFin;
	private JTextField fechaInicio;
	private JTextField fechafin;
	private JComboBox<String> fechainicio, fechaF;

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

		JLabel FechaInicio = new JLabel("Fecha Inicio");
		FechaInicio.setBounds(35, 345, 87, 13);
		contentPane.add(FechaInicio);

		JLabel FechaFin = new JLabel("Fecha Fin");
		FechaFin.setBounds(262, 345, 58, 13);
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
		fechainicio.setBounds(35, 383, 87, 21);
		fechainicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate selectedDate = parseDate(fechainicio.getSelectedItem().toString());
				updateComboBoxFin(selectedDate);
			}
		});
		contentPane.add(fechainicio);

		ManejadorJButton escuchador = new ManejadorJButton();
		fechaF = new JComboBox();
		fechaF.setBounds(262, 383, 95, 21);
		contentPane.add(fechaF);
		btnAlquiler = new JButton("Alquilar");
		btnAlquiler.setSize(87, 21);
		btnAlquiler.setLocation(50, 454);
		btnAlquiler.addActionListener(escuchador);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(87, 21);
		btnCancelar.setLocation(233, 454);
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

	private class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == btnAlquiler) {

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
					Date fechaFin=new Date(fechaUtil2.getTime());

					alquiler.setIdAlquiler(idAlquiler);
					alquiler.setIdVehiculo(idVehiculo);
					alquiler.setIdCliente(idCliente);
					alquiler.setFechaInic(fechaInc);
					alquiler.setFechFin(fechaFin);
					
					System.out.println(alquiler.getIdAlquiler());
					System.out.println(alquiler.getIdVehiculo());
					System.out.println(alquiler.getIdCliente());
					System.out.println(alquiler.getFechaInic());
					System.out.println(fechaInc);
					System.out.println(fechaFin);
					
					if(!VehiculoDisponible(idVehiculo,fechaInc,fechaFin)) {
						JOptionPane.showMessageDialog(AlquilerVehiculo.this, "No se puede alquilar el vehiculo en esta fecha");
					}else {
					services.save(Conexion.obtener(), vehiculo);
					service.save(Conexion.obtener(), alquiler);
					AlquilerVehiculo.this.dispose();
					JOptionPane.showMessageDialog(AlquilerVehiculo.this, "Se ha realizado el alquiler");
					VentanaCatalogo vc = new VentanaCatalogo();
					vc.setVisible(true);
					vc.setLocationRelativeTo(null);
					}
					
					
					
						
					
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(AlquilerVehiculo.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(AlquilerVehiculo.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ParseException e1) {
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
		
		private boolean VehiculoDisponible(Integer idVehiculo, Date fechaInc, Date fechaFin) {
			 try {
				 
			        Connection connection = Conexion.obtener();
			        String query = "SELECT * FROM alquiler WHERE idVehiculo = ? AND ((fechaInic <= ? AND fechFin >= ?) OR (fechaInic <= ? AND fechFin >= ?))";
			        PreparedStatement statement = connection.prepareStatement(query);
			        statement.setInt(1, 0);
			        statement.setDate(2, (Date) alquiler.getFechaInic());
			        statement.setDate(3, (Date) alquiler.getFechFin());
			        statement.setInt(4, alquiler.getIdCliente());
			        statement.setInt(5, alquiler.getIdVehiculo());
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
			    
			    return false;
			}
		}
	}

	

