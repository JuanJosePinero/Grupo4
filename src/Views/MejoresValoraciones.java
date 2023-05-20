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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.Conexion;
import Service.MejoresValoracionesService;
import models.Comentario;
import models.Valoracion;
import models.Vehiculo;
import models.VehiculoConComentarios;
import models.VehiculoMejoresValoraciones;

public class MejoresValoraciones extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textFieldNombre;
	private JTextField textFieldValoracion;
	private final MejoresValoracionesService service = new MejoresValoracionesService();
	private List<VehiculoMejoresValoraciones> vehiculosval;

	private JTextArea txtcoments;

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

		txtcoments = new JTextArea();
		txtcoments.setEditable(false);
		scrollPane.setViewportView(txtcoments);

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
		showVehiculosrating();

		setVisible(true);
	}

	private void showVehiculosrating() {

		try {
			vehiculosval = service.getVehiculosMejoresValoraciones(Conexion.obtener());
			String coments = "";
			for (VehiculoMejoresValoraciones veh : vehiculosval) {
				coments += "----------\n \"" + veh.getVehiculo().getMarca() + " " + veh.getVehiculo().getModelo()
						+ "\" \n " + "valoraciones: \n";
				List<Valoracion> valoraciones = veh.getValoraciones();
				if (valoraciones.isEmpty()) {
					coments += "No hay valoraciones disponibles.\n";
				} else {
					for (Valoracion vl : valoraciones) {
						coments += "\n" + vl.getValoracion() + "\n";
					}
				}
				txtcoments.setText(coments);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
