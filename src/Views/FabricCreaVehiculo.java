package Views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.Conexion;
import Service.VehiculoService;
import models.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class FabricCreaVehiculo.
 */
public class FabricCreaVehiculo extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The txt id fabricante. */
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;

	/** The services. */
	private final VehiculoService services = new VehiculoService();

	/** The vehiculo. */
	private final Vehiculo vehiculo;

	/** The btn imagen. */
	private JButton btnGuardar, btnCancelar, btnImagen;

	/** The file chooser. */
	private JFileChooser fileChooser;

	/** The ruta. */
	private String ruta;

	/**
	 * Instantiates a new fabric crea vehiculo.
	 *
	 * @param vehiculo the vehiculo
	 */
	public FabricCreaVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		initComponents();
		txtModelo.setText(this.vehiculo.getModelo());
		txtMarca.setText(this.vehiculo.getMarca());
		txtAnyo.setText(String.valueOf(this.vehiculo.getAnyo()));
		txtColor.setText(this.vehiculo.getColor());
		txtPrecio.setText(String.valueOf(this.vehiculo.getPrecio()));

	}

	/**
	 * Instantiates a new fabric crea vehiculo.
	 */
	public FabricCreaVehiculo() {
		this.vehiculo = new Vehiculo();
		initComponents();
	}

	/**
	 * Inits the components.
	 */
	public void initComponents() {
		setTitle("Vehiculos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 130, 374, 415);
		setLocationRelativeTo(null);
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

		txtMarca = new JTextField();
		txtMarca.setBounds(130, 62, 190, 26);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		txtAnyo = new JTextField();
		txtAnyo.setBounds(130, 98, 190, 26);
		contentPane.add(txtAnyo);
		txtAnyo.setColumns(10);

		txtColor = new JTextField();
		txtColor.setBounds(130, 134, 190, 26);
		contentPane.add(txtColor);
		txtColor.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(130, 170, 190, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtIdFabricante = new JTextField("Id febricante iniciado");
		txtIdFabricante.setBounds(130, 206, 190, 26);
		contentPane.add(txtIdFabricante);
		txtIdFabricante.setColumns(10);

		ManejadorJButton manejador = new ManejadorJButton();

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(48, 339, 117, 29);
		btnGuardar.addActionListener(manejador);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(203, 339, 117, 29);
		btnCancelar.addActionListener(manejador);
		contentPane.add(btnCancelar);

		JLabel lblImagen = new JLabel("Establecer Imagen");
		lblImagen.setBounds(30, 272, 117, 16);
		contentPane.add(lblImagen);

		btnImagen = new JButton("");
		btnImagen.setIcon(new ImageIcon("images/AgregarImagen.png"));
		btnImagen.setBounds(170, 242, 94, 74);
		btnImagen.addActionListener(manejador);
		contentPane.add(btnImagen);
	}

	/**
	 * Seleccionar imagen.
	 */
	private void seleccionarImagen() {
		JFileChooser fileChooser = new JFileChooser();
		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = fileChooser.getSelectedFile();
			String rutaImagen = archivo.getAbsolutePath();
			ImageIcon imagenIcon = new ImageIcon(rutaImagen);
			Image imagen = imagenIcon.getImage().getScaledInstance(btnImagen.getWidth(), btnImagen.getHeight(),
					Image.SCALE_SMOOTH);
			imagenIcon.setImage(imagen);
			btnImagen.setIcon(imagenIcon);
		}
	}

	/**
	 * The Class ManejadorJButton.
	 */
	private class ManejadorJButton implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == btnGuardar) {
				String modelo = txtModelo.getText();
				String marca = txtMarca.getText();
				int anyo = Integer.parseInt(txtAnyo.getText());
				String color = txtColor.getText();
				float precio = Float.parseFloat(txtPrecio.getText());
				int idFabricante = Integer.parseInt(txtIdFabricante.getText());
				String ruta = "";

				vehiculo.setModelo(modelo);
				vehiculo.setMarca(marca);
				vehiculo.setAnyo(anyo);
				vehiculo.setColor(color);
				vehiculo.setPrecio(precio);
				vehiculo.setIdFabricante(idFabricante);
				vehiculo.setRuta(ruta);

				try {
					services.save(Conexion.obtener(), vehiculo);
					FabricCreaVehiculo.this.dispose();
					ListViewVehiculos vista = new ListViewVehiculos();
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(FabricCreaVehiculo.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(FabricCreaVehiculo.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				}
			} else if (o == btnCancelar) {
				dispose();
				ListViewVehiculos vista = new ListViewVehiculos();
				vista.setVisible(true);

				vista.setLocationRelativeTo(null);
			} else if (o == btnImagen) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".png")
								|| f.isDirectory();
					}

					public String getDescription() {
						return "Imagenes (.jpg, .png)";
					}
				});

				int result = fileChooser.showOpenDialog(contentPane);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();

					Image img;
					try {
						img = ImageIO.read(selectedFile);
						btnImagen.setIcon(new ImageIcon(img));
						ruta = selectedFile.getAbsolutePath();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
