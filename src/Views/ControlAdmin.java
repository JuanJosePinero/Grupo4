package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ControlAdmin extends JFrame {

	private JPanel contentPane;
	private JButton Cliente,Fabricante,Vehiculos;


	public ControlAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 Cliente = new JButton("New button");
		Cliente.setIcon(new ImageIcon("images/iconcliente.png"));
		Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		;
		Cliente.setBounds(37, 76, 100, 100);
		contentPane.add(Cliente);
		
		 Fabricante = new JButton("New button");
		Fabricante.setIcon(new ImageIcon("images/iconllave.png"));
		Fabricante.setBounds(177, 76, 100, 89);
		contentPane.add(Fabricante);
		
		 Vehiculos = new JButton("New button");
		Vehiculos.setIcon(new ImageIcon("images/iconcoche.png"));
		Vehiculos.setBounds(312, 76, 100, 89);
		contentPane.add(Vehiculos);
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
				dispose();
			}else if(j.equals(Vehiculos)) {
				ListViewVehiculos lvv = new ListViewVehiculos();
				lvv.setVisible(true);
			}
			
			
			
		}
		
		
	}
}
