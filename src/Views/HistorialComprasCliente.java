package Views;

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
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HistorialComprasCliente extends JFrame{
	private JPanel contentPane;
	private JTable jtableP;
	private final VehiculoService services = new VehiculoService();
	private List<Vehiculo> vehiculo;
	
	HistorialComprasCliente(){
		super("Historial de compras");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCatalogo vc=new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
			}
		});
		BotonVolver.setBounds(165, 198, 97, 25);
		getContentPane().add(BotonVolver);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 42, 332, 143);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showVehiculosClientes();
		scrollPane.setViewportView(jtableP);
		setVisible(true);
	}
	public void showVehiculosClientes() {
	    try {
	        this.vehiculo = this.services.getAllVehiculosCliente(Conexion.obtener());
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
