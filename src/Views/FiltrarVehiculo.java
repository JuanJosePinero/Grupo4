package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Vehiculo;

public class FiltrarVehiculo extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
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
	        cargarDatosVehiculos();
	    }

	    private void initialize() {
	    	setTitle("Mejores valoraciones y mas comentarios");
	        frame = new JFrame();
	        frame.setBounds(100, 100, 450, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);
	        setLocationRelativeTo(null);
	        JPanel panel = new JPanel();
	        panel.setBounds(10, 11, 414, 239);
	        frame.getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(10, 11, 394, 184);
	        panel.add(scrollPane);

	        tableModel = new DefaultTableModel(
	                new Object[][] {},
	                new String[] { "Vehículo", "Valoración", "Comentarios" }
	        );
	        table = new JTable(tableModel);
	        scrollPane.setViewportView(table);

	        JButton btnFiltrar = new JButton("Filtrar");
	        btnFiltrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                filtrarVehiculos();
	            }
	        });
	        btnFiltrar.setBounds(163, 206, 89, 23);
	        panel.add(btnFiltrar);
	       
	        
	        setVisible(true);
	    }

	    private void cargarDatosVehiculos() {
	        

	        for (Vehiculo vehiculo : vehiculos) {
	            Object[] rowData = { vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getColor()};
	            tableModel.addRow(rowData);
	        }
	    }

	    private void filtrarVehiculos() {
	        DefaultTableModel filteredTableModel = new DefaultTableModel(
	                new Object[][] {},
	                new String[] { "Vehículo", "Valoración", "Comentarios" }
	        );
	        JTable jtableP = new JTable(filteredTableModel) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			};

	        

	        table.setModel(filteredTableModel);
	    }

}
