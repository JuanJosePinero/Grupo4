package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.Conexion;
import Service.MejoresValoracionesService;
import Service.VehiculoService;
import models.Comentario;
import models.Valoracion;
import models.Vehiculo;
import models.VehiculoConComentarios;
import models.VehiculoMejoresValoraciones;

public class MejoresValoraciones extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private DefaultTableModel tableModel;
	private JTextField textFieldNombre;
	private JTextField textFieldValoracion;
	private final MejoresValoracionesService service = new MejoresValoracionesService();
	private List<VehiculoMejoresValoraciones> vehiculosval;
	private DefaultTableModel dtm;
	private final VehiculoService services = new VehiculoService();
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MejoresValoraciones window = new MejoresValoraciones();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MejoresValoraciones() {
		initialize();
		vehiculosval = new ArrayList<>();
	}

	private void initialize() {
		setTitle("Mejores valoraciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 34, 371, 181);
		contentPane.add(scrollPane);
		dtm = new DefaultTableModel(new Object[][] {}, new String[] { "Marca", "Modelo", "media" });
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		scrollPane.setViewportView(table);

		JButton btnFiltrar = new JButton("Volver");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnFiltrar.setBounds(162, 230, 89, 23);
		contentPane.add(btnFiltrar);

		JLabel lblNewLabel = new JLabel("LISTA VALORACIONES");
		lblNewLabel.setBounds(165, 10, 246, 13);
		contentPane.add(lblNewLabel);
		showVehiculosmejorvaloracion();

		setVisible(true);
	}

	private void showVehiculosmejorvaloracion() {
		try {
			vehiculosval = service.getVehiculosMejoresValoraciones(Conexion.obtener());
			dtm.setRowCount(0);

			for (int i = 0; i < vehiculosval.size(); i++) {
				float suma = 0;
				float numvals = 0;
				for (Valoracion v : vehiculosval.get(i).getValoraciones()) {
					suma += v.getValoracion();
					numvals++;
				}

				double media = 0;
				if (numvals > 0) {
					media = suma / numvals;
				}

				String formattedMedia;
				if (media % 1 == 0) {
					formattedMedia = String.format("%.0f", media);
				} else {
					formattedMedia = String.format("%.2f", media);
				}

				dtm.addRow(new Object[] { vehiculosval.get(i).getVehiculo().getModelo(),
						vehiculosval.get(i).getVehiculo().getMarca(), formattedMedia + " / 5" });
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
		}
	}

}
