package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Service.Conexion;
import Service.ValoracionService;
import models.Valoracion;

public class AgregarValoracion extends JFrame {

	private JPanel contentPane;
	private List<JButton> btnEstrellaList = new ArrayList<>();
	private JButton btnEnviar, btnCancelar;
	private JButton btnEst;
	private ImageIcon icono0, icono1,icono2,icono3,icono4,icono5;
	private JLabel etiquetaImagen;
	private ValoracionService service = new ValoracionService();
	private int valoracion = 0;
	private int val = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarValoracion frame = new AgregarValoracion();
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
	public AgregarValoracion() {
		super("Agregar Valoracion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 292);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(163, 163, 165));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Agrega una valoracion para el vehículo seleccionado.");
		lblTitulo.setBounds(28, 5, 390, 21);
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 16));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitulo);

		ManejadorJButton manejador = new ManejadorJButton();
		manejadorestrella estrella=new manejadorestrella();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(163, 165, 165));
		panel.setBounds(54, 36, 341, 55);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		for (int i = 0; i < 6; i++) {
			btnEst = new JButton(String.valueOf(i));
			btnEstrellaList.add(btnEst);
			btnEst.setSize(55, 55);
			panel.add(btnEst);
			btnEst.addActionListener(estrella);
		}

		icono0 = new ImageIcon("images/estrellas/estrella0.png");
		
		etiquetaImagen = new JLabel(icono0);
		etiquetaImagen.setBounds(50, 101, 350, 100);
		contentPane.add(etiquetaImagen);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(manejador);
		btnEnviar.setBounds(103, 224, 98, 21);
		contentPane.add(btnEnviar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(manejador);
		btnCancelar.setBounds(251, 224, 98, 21);
		contentPane.add(btnCancelar);

	}

	public class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			JButton boton=(JButton) e.getSource();
			
				
			 if (o == btnEnviar) {
				Valoracion v = new Valoracion();
				v.setIdCliente(Login.getidClienteLogin());
				v.setIdVehiculo(Login.getidVehiculo());
				System.out.println(valoracion);
				v.setValoracion(valoracion);

				try {
					service.save(Conexion.obtener(), v);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "La valoracion ha sido Enviada con exito!", "Envio completado",
						JOptionPane.INFORMATION_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			} else if (o == btnCancelar) {
				JOptionPane.showMessageDialog(null, "La valoracion ha sido Cancelado!", "Cancelar valoracion",
						JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();

			} else if (o == btnEst) {
				for (int i = 1; i < 6; i++) {
					if(btnEstrellaList.get(i) == btnEst) {
					System.out.println(i);
					
					break;
					}
				}
//				int index = btnEstrellaList.indexOf(o);
//				icono.setImage(new ImageIcon("images/estrellas/estrella" + index + ".png").getImage());
//				etiquetaImagen.setIcon(icono);

			}

		}

	}
	private class manejadorestrella implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JButton boton = (JButton) e.getSource();
	        int valorEstrella = Integer.parseInt(boton.getText()); // Obtiene el valor de la estrella seleccionada
	        valoracion=valorEstrella;

	        ImageIcon nuevaImagen = new ImageIcon("images/estrellas/estrella" + valorEstrella + ".png");
	        etiquetaImagen.setIcon(nuevaImagen);
	    }
	}
}
