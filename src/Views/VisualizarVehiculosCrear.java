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

import Service.Conexion;
import Service.VehiculoService;
import models.Vehiculo;
import javax.swing.JLabel;

public class VisualizarVehiculosCrear extends JFrame {

	private JPanel contentPane;
	private JTable jtableP;
	private final VehiculoService services = new VehiculoService();
	private List<Vehiculo> vehiculo;

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
		scrollPane.setBounds(52, 77, 408, 225);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showVehiculosIdFabricante();
		scrollPane.setViewportView(jtableP);
		
		JButton VolverB = new JButton("Volver");
		VolverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		VolverB.setBounds(52, 321, 414, 25);
		contentPane.add(VolverB);
		
		JLabel lblNewLabel = new JLabel("Visualizacion de los Vehiculos Creados");
		lblNewLabel.setBounds(145, 53, 242, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(208, 19, 89, 23);
		contentPane.add(btnNewButton);
		setVisible(true);		
	}
	
	public void showVehiculos() {
	    try {
	        this.vehiculo = this.services.getAllVehiculos(Conexion.obtener());
	        jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

	        }, new String[] { "idVehiculos", "Modelo", "Marca", "Anyo", "Color", "Precio", "idFabricante" }));
	        DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
	        dtm.setRowCount(0);
	        
	        jtableP = new JTable(dtm) {
	          @Override
	          public boolean isCellEditable(int row, int column) {
	            return false;
	          }
	        };
	        
	        for (int i = 0; i < this.vehiculo.size(); i++) {
	            dtm.addRow(new Object[] {this.vehiculo.get(i).getIdVehiculos(), this.vehiculo.get(i).getModelo(), this.vehiculo.get(i).getMarca(), this.vehiculo.get(i).getAnyo(),
	                    this.vehiculo.get(i).getColor(), this.vehiculo.get(i).getPrecio(), this.vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
	}
	
	public void showVehiculosIdFabricante() {
	    try {
	        this.vehiculo = this.services.getAllVehiculosFabric(Conexion.obtener());
	        jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

	        }, new String[] { "idVehiculos", "Modelo", "Marca", "Anyo", "Color", "Precio", "idFabricante" }));
	        DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
	        dtm.setRowCount(0);
	        
	        jtableP = new JTable(dtm) {
	          @Override
	          public boolean isCellEditable(int row, int column) {
	            return false;
	          }
	        };
	        
	        for (int i = 0; i < this.vehiculo.size(); i++) {
	            dtm.addRow(new Object[] {this.vehiculo.get(i).getIdVehiculos(), this.vehiculo.get(i).getModelo(), this.vehiculo.get(i).getMarca(), this.vehiculo.get(i).getAnyo(),
	                    this.vehiculo.get(i).getColor(), this.vehiculo.get(i).getPrecio(), this.vehiculo.get(i).getIdFabricante() });
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