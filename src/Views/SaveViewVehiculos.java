package Views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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

public class SaveViewVehiculos extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo, txtMarca, txtAnyo, txtColor, txtPrecio, txtIdFabricante;
	private final VehiculoService services = new VehiculoService();
	private final Vehiculo vehiculo;
	private JButton btnGuardar, btnCancelar, btnImagen;
	private JFileChooser fileChooser;
	private static String ruta;

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
		this.vehiculo = new Vehiculo();
		initComponents();
	}

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

		txtIdFabricante = new JTextField();
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

	private class ManejadorJButton implements ActionListener {

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

				vehiculo.setModelo(modelo);
				vehiculo.setMarca(marca);
				vehiculo.setAnyo(anyo);
				vehiculo.setColor(color);
				vehiculo.setPrecio(precio);
				vehiculo.setIdFabricante(idFabricante);
				vehiculo.setRuta(ruta);
				vehiculo.setNumcomentarios(0);

				try {
					services.save(Conexion.obtener(), vehiculo);
					SaveViewVehiculos.this.dispose();
					ListViewVehiculos vista = new ListViewVehiculos();
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(SaveViewVehiculos.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				} catch (ClassNotFoundException ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(SaveViewVehiculos.this,
							"Ha surgido un error y no se ha podido guardar el registro.");
				}
			} else if (o == btnCancelar) {
				dispose();
				ListViewVehiculos vista = new ListViewVehiculos();
				vista.setVisible(true);

				vista.setLocationRelativeTo(null);
			} else if (o == btnImagen) {
				JOptionPane.showInternalMessageDialog(null,
						"Importante! \nLa imagen debe tener un tamaño de 350x200 para que se vea bien!",
						"Aviso importante", JOptionPane.WARNING_MESSAGE);
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

					String extension = getFileExtension(selectedFile.getName());
					if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
						try {
							String carpetaDestino = "images/vehiculos/" + selectedFile.getName();
							Path destino = Path.of(carpetaDestino);
							Files.copy(selectedFile.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

							BufferedImage originalImage = ImageIO.read(selectedFile);
							BufferedImage resizedImage = resizeImage(originalImage, 350, 200);
							btnImagen.setIcon(new ImageIcon(resizedImage));
							ruta = carpetaDestino;

						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Error al guardar la imagen", "Aviso",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "El archivo debe ser .jpg o .png", "Aviso",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		}

	}

	private static String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
			return fileName.substring(dotIndex + 1).toLowerCase();
		}
		return "";
	}

	static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
		Graphics2D g2d = resizedImage.createGraphics();
		g2d.drawImage(originalImage, 0, 0, width, height, null);
		g2d.dispose();
		return resizedImage;
	}
}
