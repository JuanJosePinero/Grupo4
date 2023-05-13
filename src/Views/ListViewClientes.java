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
	private JButton ActivarB,BajaB;

	public ListViewClientes() {
		setTitle("Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 410, 183);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showCliente();
		scrollPane.setViewportView(jtableP);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(167, 236, 97, 25);
		contentPane.add(btnVolver);
		
		ActivarB = new JButton("Activar/Desactivar");
		ActivarB.setBounds(26, 12, 144, 23);
		contentPane.add(ActivarB);
		
		BajaB = new JButton("Dar de baja");
		BajaB.setBounds(190, 12, 97, 23);
		contentPane.add(BajaB);
		
		setVisible(true);
		ManejadorActionB mab= new ManejadorActionB();
		ActivarB.addActionListener(mab);
		
	}
	private class ManejadorActionB implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int filaS = jtableP.getSelectedRow();
			String nombreCliente = (String) jtableP.getValueAt(filaS, 0);
	
			Cliente c = (Cliente) jtableP.getValueAt(filaS, 0);
			
			if(b.equals(ActivarB)) {
				if(c.isActivar()){
					c.setActivar(false);
					System.out.println("Desactivado");
					System.out.println(c.isActivar());
				}
				else {
					c.setActivar(true);
					System.out.println("Activado");
				}
			}
			
		}
		
		
	}
	
	private void showCliente() {
		try {
			this.Clientes = this.services.getAllCliente(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] {"Nombre", "Direccion","Rol","Usuario","Contasenya" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);
			for (int i = 0; i < this.Clientes.size(); i++) {
				dtm.addRow(new Object[] {this.Clientes.get(i).getNombre(),
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
