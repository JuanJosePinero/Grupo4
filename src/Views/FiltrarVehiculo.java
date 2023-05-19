package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
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
import models.Vehiculo;

public class FiltrarVehiculo extends JFrame {

	private JPanel contentPane;
	private final VehiculoService service=new VehiculoService();
	private final AlquilerService servicealq=new AlquilerService();
	private DefaultTableModel tableModel;
    private List<Vehiculo> vehiculos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltrarVehiculo frame = new FiltrarVehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 public FiltrarVehiculo() {
	        initialize();
	        vehiculos = new ArrayList<>();
	        showVehiculos();
	    }

	    private void initialize() {
	    	setTitle("Mejores valoraciones y mas comentarios");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

	        tableModel = new DefaultTableModel(
	                new Object[][] {},
	                new String[] { "Vehículo", "Valoración", "Comentarios" }
	        );

	        JButton btnFiltrar = new JButton("Filtrar por Valoracion");
	        btnFiltrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                MejoresValoraciones mj=new MejoresValoraciones();
	                mj.setVisible(true);
	                mj.setLocationRelativeTo(null);
	            }
	        });
	        btnFiltrar.setBounds(10, 117, 175, 23);
	        contentPane.add(btnFiltrar);
	        
	        JButton btnNewButton = new JButton("Filtrar por comentarios");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ComentariosVehiculos cv=new ComentariosVehiculos();
	        		cv.setVisible(true);
	                cv.setLocationRelativeTo(null);
	        	}
	        });
	        btnNewButton.setBounds(256, 118, 170, 21);
	        contentPane.add(btnNewButton);
	        
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		VentanaCatalogo vc=new VentanaCatalogo();
	        		vc.setVisible(true);
	        		vc.setLocationRelativeTo(null);
	        		dispose();	        	}
	        });
	        btnVolver.setBounds(178, 232, 85, 21);
	        contentPane.add(btnVolver);
	      
	        setVisible(true);
	    }

	    
	    private void showVehiculos() {
			try {
				vehiculos = service.getAllVehiculos(Conexion.obtener());
				tableModel.setRowCount(0);

				for (int i = 0; i < vehiculos.size(); i++) {
					tableModel.addRow(new Object[] { vehiculos.get(i).getModelo(),
							 });
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
