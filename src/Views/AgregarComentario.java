package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Service.ComentarioService;
import Service.Conexion;
import models.Comentario;

public class AgregarComentario extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private final ComentarioService service = new ComentarioService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarComentario frame = new AgregarComentario();
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
	public AgregarComentario() {
		super("Agregar Comentario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 230);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(163, 163, 165));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agrega un comentario para el vehículo seleccionado.");
		lblTitulo.setBounds(5, 5, 390, 21);
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitulo);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 36, 343, 104);
		contentPane.add(textArea);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String comentario = textArea.getText();
				
				Comentario c = new Comentario();
				c.setIdCliente(Login.getidClienteLogin());
				System.out.println(Login.getidClienteLogin());
				c.setIdVehiculo(Login.getidVehiculo());
				c.setComentario(comentario);
				
				try {
					service.save(Conexion.obtener(), c);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "El comentario ha sido Enviado con exito!", "Envio completado", JOptionPane.INFORMATION_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnEnviar.setBounds(61, 150, 98, 33);
		contentPane.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "El comentario ha sido Cancelado!", "Cancelar comentario", JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(238, 150, 98, 33);
		contentPane.add(btnCancelar);
	}
}
