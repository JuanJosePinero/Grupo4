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

import Service.ClientService;
import Service.Conexion;
import models.Cliente;

public class ListViewClientes extends JFrame{
	private JPanel contentPane;
	private JTable jtableP;
	private final ClientService services = new ClientService();
	private List<Cliente> Clientes;

	public ListViewClientes() {
		setTitle("Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 410, 183);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showCliente();
		scrollPane.setViewportView(jtableP);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(165, 209, 97, 25);
		contentPane.add(btnVolver);
		
	}
	
	private void showCliente() {
		try {
			this.Clientes = this.services.getAllCliente(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "idCliente","Nombre", "Direccion","Rol","Usuario","Contasenya" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);
			for (int i = 0; i < this.Clientes.size(); i++) {
				dtm.addRow(new Object[] { this.Clientes.get(i).getIdClientes(), this.Clientes.get(i).getNombre(),
						this.Clientes.get(i).getDireccion(),this.Clientes.get(i).getRol(),
						this.Clientes.get(i).getNombreUsuario(),this.Clientes.get(i).getContrasena()});
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
