package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.Conexion;
import Service.FabricantesService;
import Service.VehiculoService;
import models.Cliente;
import models.Fabricante;
import models.Vehiculo;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarVehiculosCrear.
 */
public class VisualizarVehiculosCrear extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The jtable P. */
	private JTable jtableP;

	/** The services. */
	private final VehiculoService services = new VehiculoService();

	/** The services F. */
	private final FabricantesService servicesF = new FabricantesService();

	/** The vehiculo. */
	private List<Vehiculo> vehiculo;

	/** The fabricante. */
	private List<Fabricante> fabricante;

	/** The btn crear. */
	private JButton btnComentarios, btnValoraciones, btnCrear;

	/**
	 * Instantiates a new visualizar vehiculos crear.
	 */
	public VisualizarVehiculosCrear() {
		setTitle("Vehiculos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 396);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 94, 408, 225);
		contentPane.add(scrollPane);

		try {

			Fabricante datos = servicesF.getFabricantesCliente(Conexion.obtener(), Login.getidClienteLogin());
			int id = datos.getIdCliente();

			ListViewFabricante.setidFabricanteCrear(id);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

		JButton VolverB = new JButton("Cerrar Sesion");
		VolverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				dispose();
			}
		});
		VolverB.setBounds(0, 332, 531, 25);
		contentPane.add(VolverB);

		JLabel lblNewLabel = new JLabel("Visualizacion de los Vehiculos Creados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 70, 408, 13);
		contentPane.add(lblNewLabel);

		btnCrear = new JButton("");
		btnCrear.setIcon(new ImageIcon("images/crear.png"));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVehiculos vista = new CrearVehiculos();
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCrear.setBounds(81, 11, 50, 50);
		contentPane.add(btnCrear);
		setVisible(true);

		jtableP = new JTable();
		showVehiculosIdFabricante();
		scrollPane.setViewportView(jtableP);

		btnComentarios = new JButton("");
		btnComentarios.setIcon(new ImageIcon("images/iconoComent.png"));
		btnComentarios.setBounds(225, 9, 50, 50);
		contentPane.add(btnComentarios);

		btnValoraciones = new JButton("");
		btnValoraciones.setIcon(new ImageIcon("images/iconoValo.png"));
		btnValoraciones.setBounds(348, 9, 50, 50);
		contentPane.add(btnValoraciones);
		manejadorAction ma = new manejadorAction();
		btnComentarios.addActionListener(ma);
		btnValoraciones.addActionListener(ma);
	}

	/**
	 * Show vehiculos id fabricante.
	 */
	public void showVehiculosIdFabricante() {
		try {
			this.vehiculo = this.services.getAllVehiculosFabric(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "idVehiculos", "Modelo", "Marca", "Anyo", "Color", "Precio" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			jtableP = new JTable(dtm) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			for (int i = 0; i < this.vehiculo.size(); i++) {
				dtm.addRow(new Object[] { this.vehiculo.get(i).getIdVehiculos(), this.vehiculo.get(i).getModelo(),
						this.vehiculo.get(i).getMarca(), this.vehiculo.get(i).getAnyo(),
						this.vehiculo.get(i).getColor(), this.vehiculo.get(i).getPrecio(),
						this.vehiculo.get(i).getIdFabricante() });
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

	/**
	 * The Class manejadorAction.
	 */
	private class manejadorAction implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			int filaS = jtableP.getSelectedRow();

			try {
				String nombreCliente = jtableP.getValueAt(filaS, 0).toString();

				Vehiculo v = vehiculo.get(filaS);
				int id = v.getIdVehiculos();
				if (j.equals(btnComentarios)) {
					Login.setidVehiculo(id);

					VisualizarComentsFabri vcf = new VisualizarComentsFabri();
					vcf.setVisible(true);
					dispose();

				} else if (j.equals(btnValoraciones)) {
					Login.setidVehiculo(id);
					VisualizarValoranFabri vcf = new VisualizarValoranFabri();
					vcf.setVisible(true);
					dispose();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Seleccione una fila", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}
}
