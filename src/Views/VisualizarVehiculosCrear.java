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
import models.Fabricante;
import models.Vehiculo;

public class VisualizarVehiculosCrear extends JFrame {

	private JPanel contentPane;
	private JTable jtableP;
	private final VehiculoService services = new VehiculoService();
	private final FabricantesService servicesF = new FabricantesService();
	private List<Vehiculo> vehiculo;
	private List <Fabricante> fabricante;

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
	
		System.out.println("El id es"+Login.getidClienteLogin());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 77, 408, 225);
		contentPane.add(scrollPane);
		
		try {
			
			Fabricante datos = servicesF.getFabricantesCliente(Conexion.obtener(), Login.getidClienteLogin());
			int id =datos.getIdCliente();
			System.out.println("EL id es"+id);
			ListViewFabricante.setidFabricanteCrear(id);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton VolverB = new JButton("Volver");
		VolverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				dispose();
			}
		});
		VolverB.setBounds(52, 321, 414, 25);
		contentPane.add(VolverB);
		
		JLabel lblNewLabel = new JLabel("Visualizacion de los Vehiculos Creados");
		lblNewLabel.setBounds(145, 53, 242, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVehiculos vista = new CrearVehiculos();
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(52, 11, 95, 23);
		contentPane.add(btnNewButton);
		setVisible(true);	
		
		jtableP = new JTable();
		showVehiculosIdFabricante();
		scrollPane.setViewportView(jtableP);
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
