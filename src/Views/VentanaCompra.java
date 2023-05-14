package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaCompra extends JFrame {

	private JPanel contentPane;
	private JButton btnComprar, btnAlquilar;
	private JTextArea textArea;
	private JTextField textModelo, textMarca, textAnyo, textFColor, textPrecioSinIVA, textPrecioIVA;
	private  JScrollPane scrollPane;
	private List<String> listaComentarios = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCompra frame = new VentanaCompra();
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
	public VentanaCompra() {
		super("Catalogo de Coches de nuestra Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ManejadorJButton manejador = new ManejadorJButton();
		
		btnComprar = new JButton("Comprar Vehiculo");
		btnComprar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		btnComprar.setBounds(146, 510, 143, 31);
		contentPane.add(btnComprar);
		
		btnAlquilar = new JButton("Alquilar Vehiculo");
		btnAlquilar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		btnAlquilar.setBounds(538, 510, 143, 31);
		contentPane.add(btnAlquilar);
		
		JPanel panel = new JPanel();
		panel.setBounds(272, 42, 338, 220);
		contentPane.add(panel);
		
		 JLabel imagenLabel = new JLabel();
	     ImageIcon imagen = new ImageIcon("images/BMW iX3.jpg"); 
	     imagenLabel.setIcon(imagen);
	     panel.add(imagenLabel);
	     
	     JButton btnSiguiente = new JButton("->");
	     btnSiguiente.setFont(new Font("Snap ITC", Font.PLAIN, 10));
	     btnSiguiente.setBounds(831, 240, 45, 48);
	     contentPane.add(btnSiguiente);
	     
	     JLabel lblModelo = new JLabel("Modelo");
	     lblModelo.setBounds(88, 289, 45, 13);
	     contentPane.add(lblModelo);
	     
	     textModelo = new JTextField();
	     textModelo.setEditable(false);
	     textModelo.setBounds(146, 286, 96, 19);
	     contentPane.add(textModelo);
	     textModelo.setColumns(10);
	     
	     JLabel lblMarca = new JLabel("Marca");
	     lblMarca.setBounds(329, 289, 45, 13);
	     contentPane.add(lblMarca);
	     
	     textMarca = new JTextField();
	     textMarca.setEditable(false);
	     textMarca.setBounds(392, 286, 96, 19);
	     contentPane.add(textMarca);
	     textMarca.setColumns(10);
	     
	     JLabel lblAnyo = new JLabel("Año del Modelo");
	     lblAnyo.setBounds(557, 289, 96, 13);
	     contentPane.add(lblAnyo);
	     
	     textAnyo = new JTextField();
	     textAnyo.setEditable(false);
	     textAnyo.setBounds(663, 286, 96, 19);
	     contentPane.add(textAnyo);
	     textAnyo.setColumns(10);
	     
	     JLabel lblColor = new JLabel("Color");
	     lblColor.setBounds(88, 339, 45, 13);
	     contentPane.add(lblColor);
	     
	     textFColor = new JTextField();
	     textFColor.setEnabled(true);
	     textFColor.setEditable(false);
	     textFColor.setText("");
	     textFColor.setBounds(146, 336, 96, 19);
	     contentPane.add(textFColor);
	     textFColor.setColumns(10);
	     
	     JLabel lblPrecioSinIVA = new JLabel("Precio sin IVA");
	     lblPrecioSinIVA.setBounds(306, 339, 83, 13);
	     contentPane.add(lblPrecioSinIVA);
	     
	     textPrecioSinIVA = new JTextField();
	     textPrecioSinIVA.setEditable(false);
	     textPrecioSinIVA.setBounds(392, 336, 96, 19);
	     contentPane.add(textPrecioSinIVA);
	     textPrecioSinIVA.setColumns(10);
	     
	     JLabel lblPrecioIVA = new JLabel("Precio con IVA");
	     lblPrecioIVA.setBounds(557, 339, 83, 13);
	     contentPane.add(lblPrecioIVA);
	     
	     textPrecioIVA = new JTextField();
	     textPrecioIVA.setEditable(false);
	     textPrecioIVA.setBounds(663, 336, 96, 19);
	     contentPane.add(textPrecioIVA);
	     textPrecioIVA.setColumns(10);
	     
	     JLabel lblCoche = new JLabel("COCHE");
	     lblCoche.setBounds(392, 10, 45, 13);
	     contentPane.add(lblCoche);
	     
	     JLabel lblComentarios = new JLabel("-----Comentarios y Valoraciones sobre nuestros coches y nuestras Ventas-----");
	     lblComentarios.setBounds(93, 383, 560, 19);
	     contentPane.add(lblComentarios);
	     
	     scrollPane = new JScrollPane();
	     scrollPane.setBounds(103, 412, 730, 65);
	     contentPane.add(scrollPane);
	     
	     listaComentarios.add("Hugo maricon");
	     listaComentarios.add("Hugo maricon 4");
	     
	     
	    
	     textArea = new JTextArea();
	     textArea.setEditable(false);
	     scrollPane.setViewportView(textArea);
	     String nombre = "";
	     for (String s : listaComentarios) {
	    	 nombre += s+"\n";
	    	 textArea.setText(nombre);
	    	 
			}
			
		}
		
	public class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if(o == btnComprar) {
				
			}else if(o == btnAlquilar) {
				
			}
			
		}	
		
	}
}
