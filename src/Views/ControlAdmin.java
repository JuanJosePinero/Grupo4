package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class ControlAdmin extends JFrame {

	private JPanel contentPane;
	private JButton Cliente,Fabricante,Vehiculos;
	private JButton VolverB;


	public ControlAdmin() {
		super("Control Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Cliente = new JButton("");
		Cliente.setIcon(new ImageIcon("images/iconcliente.png"));
		Cliente.setBounds(37, 76, 100, 100);
		contentPane.add(Cliente);
		
		Fabricante = new JButton("");
		Fabricante.setIcon(new ImageIcon("images/iconllave.png"));
		Fabricante.setBounds(177, 76, 100, 100);
		contentPane.add(Fabricante);
		
		Vehiculos = new JButton("");
		Vehiculos.setIcon(new ImageIcon("images/iconcoche.png"));
		Vehiculos.setBounds(312, 76, 100, 100);
		contentPane.add(Vehiculos);
		
		VolverB = new JButton("Cerrar Sesion");
		VolverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cerrando Sesion...", "Cerrado", JOptionPane.ERROR_MESSAGE);
				Login l = new Login();
				dispose();
			}
		});
		VolverB.setBounds(0, 238, 434, 23);
		contentPane.add(VolverB);
		
		JLabel lblTitulo = new JLabel("Clientes");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTitulo.setBounds(37, 31, 100, 13);
		contentPane.add(lblTitulo);
		
		JLabel lblFabricantes = new JLabel("Fabricantes");
		lblFabricantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFabricantes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblFabricantes.setBounds(177, 33, 100, 13);
		contentPane.add(lblFabricantes);
		
		JLabel lblTitulo_1_1 = new JLabel("Vehiculos");
		lblTitulo_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTitulo_1_1.setBounds(312, 33, 100, 13);
		contentPane.add(lblTitulo_1_1);
		setVisible(true);
		manejadorAction ma = new manejadorAction();
		Cliente.addActionListener(ma);
		Fabricante.addActionListener(ma);
		Vehiculos.addActionListener(ma);
			
		
	}
	
	private class manejadorAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			if(j.equals(Cliente)) {
				ListViewClientes lvc = new ListViewClientes();
				dispose();
			}else if(j.equals(Fabricante)) {
				ListViewFabricante lvf = new ListViewFabricante();
				lvf.setVisible(true);
				lvf.setLocationRelativeTo(null);
				dispose();
			}else if(j.equals(Vehiculos)) {
				ListViewVehiculos lvv = new ListViewVehiculos();
				lvv.setLocationRelativeTo(null);
				lvv.setVisible(true);
				dispose();
			}
			
			
			
		}
		
		
	}
}
