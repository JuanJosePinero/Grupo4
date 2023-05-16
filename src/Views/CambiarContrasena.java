package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CambiarContrasena extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton ConfirmarB,CancelarB;



	
	public CambiarContrasena() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setBounds(105, 124, 110, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(253, 121, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(253, 149, 145, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmar Contraseña");
		lblNewLabel_1.setBounds(79, 149, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		ConfirmarB = new JButton("Confirmar");
		ConfirmarB.setBounds(105, 227, 89, 23);
		contentPane.add(ConfirmarB);
		
		CancelarB = new JButton("Cancelar");
		CancelarB.setBounds(254, 227, 89, 23);
		contentPane.add(CancelarB);
		
		textField_2 = new JTextField();
		textField_2.setBounds(253, 69, 145, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(111, 72, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
		
		manejadorAction ma = new manejadorAction();
		ConfirmarB.addActionListener(ma);
		CancelarB.addActionListener(ma);
		
		
		
	}
	private class manejadorAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			if(b.equals(ConfirmarB)) {
				
			}else if(b.equals(CancelarB)) {
				ListViewClientes lvc = new ListViewClientes();
				dispose();
				
			}
			
		}
		
	}
}
