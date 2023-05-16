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
import Service.FabricantesService;
import models.Fabricante;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ListViewFabricante extends JFrame {

	private JPanel contentPane;
	private JTable jtableP;
	private final FabricantesService services = new FabricantesService();
	private List<Fabricante> fabricante;

	public ListViewFabricante() {
		setTitle("Fabricante");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon("images/crear.png"));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListViewFabricante.this.dispose();
				SaveViewFabricante vista = new SaveViewFabricante();
				vista.setVisible(true);
				vista.setLocationRelativeTo(null);
			}
		});
		btnCreate.setBounds(65, 24, 50, 50);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon("images/update.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila_seleccionada = jtableP.getSelectedRow();
				if (fila_seleccionada >= 0) {
					ListViewFabricante.this.dispose();
					SaveViewFabricante vista = new SaveViewFabricante(fabricante.get(fila_seleccionada));
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(ListViewFabricante.this, "Por favor seleccione una fila.");
				}
			}
		});
		btnUpdate.setBounds(149, 24, 50, 50);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("images/eliminar.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila_seleccionada = jtableP.getSelectedRow();
				if (fila_seleccionada >= 0) {
					int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar este producto?",
							"Advertencia", JOptionPane.YES_NO_OPTION);
					if (decision == 0) {
						try {
							services.remove(Conexion.obtener(), fabricante.get(fila_seleccionada));
							showFabricante();
						} catch (SQLException ex) {
							System.out.println(ex.getMessage());
							JOptionPane.showMessageDialog(ListViewFabricante.this, "Ha surgido un error y no se ha podido eliminar el registro.");
						} catch (ClassNotFoundException ex) {
							System.out.println(ex);
							JOptionPane.showMessageDialog(ListViewFabricante.this, "Ha surgido un error y no se ha podido eliminar el registro.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(ListViewFabricante.this, "Por favor seleccione una fila.");
				}
			}
		});
		btnDelete.setBounds(244, 24, 50, 50);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 86, 287, 146);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showFabricante();
		scrollPane.setViewportView(jtableP);
		
		JButton VolverB = new JButton("Volver");
		VolverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAdmin ca = new ControlAdmin();
				dispose();
			}
		});
		VolverB.setBounds(181, 238, 89, 23);
		contentPane.add(VolverB);
		
		JButton btnVer = new JButton("");
		btnVer.setIcon(new ImageIcon("images/visualizar.png"));
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarVehiculos vv = new VisualizarVehiculos();
				
			}
		});
		btnVer.setBounds(335, 27, 50, 50);
		contentPane.add(btnVer);
		
		JLabel lblNewLabel = new JLabel("Crear");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(65, 11, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Actualizar");
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_1.setBounds(138, 11, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Borrar");
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2.setBounds(244, 11, 50, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ver");
		lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_3.setBounds(339, 11, 50, 14);
		contentPane.add(lblNewLabel_3);
		
	}
	
	private void showFabricante() {
		try {
			this.fabricante = this.services.getAllProducts(Conexion.obtener());
			jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "idFabricante","Nombre", "Pais" }));
			DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
			dtm.setRowCount(0);
			
			jtableP = new JTable(dtm) {
		          @Override
		          public boolean isCellEditable(int row, int column) {
		            return false;
		          }
		        };
		        
			for (int i = 0; i < this.fabricante.size(); i++) {
				dtm.addRow(new Object[] { this.fabricante.get(i).getIdFabricante(), this.fabricante.get(i).getNombre(), this.fabricante.get(i).getPais()});
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
