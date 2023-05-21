package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.AlquilerService;
import Service.Conexion;
import Service.VehiculoService;
import models.Alquiler;
import models.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class HistorialAlquileresCliente.
 */
public class HistorialAlquileresCliente extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The jtable P. */
	private JTable jtableP;

	/** The Boton volver. */
	private JButton BotonVolver;

	/** The servicealq. */
	private final AlquilerService servicealq = new AlquilerService();

	/** The services. */
	private final VehiculoService services = new VehiculoService();

	/** The alquiler. */
	private List<Alquiler> alquiler;

	/**
	 * Instantiates a new historial alquileres cliente.
	 */
	public HistorialAlquileresCliente() {
		super("Historial de alquileres");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Volviendo a la ventana del catalogo", "Aviso",
						JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				dispose();
			}
		});
		BotonVolver.setBounds(165, 198, 97, 25);
		getContentPane().add(BotonVolver);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 42, 369, 143);
		contentPane.add(scrollPane);

		jtableP = new JTable();
		showAlquileres();
		scrollPane.setViewportView(jtableP);
		setVisible(true);
	}

	/**
	 * Show alquileres.
	 */
	public void showAlquileres() {
		try {
			this.alquiler = this.servicealq.getAllAlquileres(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "idAlquiler", "Fechainicio", "FechaFin", "idVehiculo" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);

			jtableP = new JTable(dtm) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			for (int i = 0; i < this.alquiler.size(); i++) {
				dtm.addRow(new Object[] { this.alquiler.get(i).getIdAlquiler(), this.alquiler.get(i).getFechaInic(),
						this.alquiler.get(i).getFechFin(), this.alquiler.get(i).getIdVehiculo() });
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}
}