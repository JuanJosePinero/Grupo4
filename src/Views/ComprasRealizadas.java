package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ComprasRealizadas extends JFrame {

	private JPanel contentPane;
	private JButton btnVerAlquileres,btnVerCompras;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprasRealizadas frame = new ComprasRealizadas();
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
	public ComprasRealizadas() {
		super("Compras Realizadas por el Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 175);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel1 = new JLabel("Elija la opción que desea realizar");
		lblLabel1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblLabel1.setBounds(83, 10, 321, 21);
		contentPane.add(lblLabel1);
		
		
		
		btnVerAlquileres = new JButton("Ver Alquileres");
		btnVerAlquileres.setBounds(32, 56, 120, 27);
		contentPane.add(btnVerAlquileres);
		
		
		btnVerCompras = new JButton("Ver Compras");
		btnVerCompras.setBounds(262, 56, 120, 27);
		contentPane.add(btnVerCompras);
		manejadorboton man=new manejadorboton();
		btnVerCompras.addActionListener(man);
		btnVerAlquileres.addActionListener(man);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCatalogo vc=new VentanaCatalogo();
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCancelar.setBounds(159, 98, 97, 25);
		contentPane.add(btnCancelar);
		
		
		
	
	}
	private class manejadorboton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton=(JButton) e.getSource();
			if(boton.equals(btnVerCompras)) {
				HistorialComprasCliente hcc=new HistorialComprasCliente();
				dispose();
			}else if(boton.equals(btnVerAlquileres)) {
				HistorialAlquileresCliente hac=new HistorialAlquileresCliente();
				dispose();
			}
		}
		
	}
}
