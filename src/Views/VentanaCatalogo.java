package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Service.Conexion;
import models.Vehiculo;

public class VentanaCatalogo extends JFrame {

	private JPanel contentPane;
	private JButton btnComprar, btnAlquilar, btnSiguiente, btnMostrar;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel lblCoche;
	private List<Vehiculo> listaVehiculos = new ArrayList<>();
	private List<String> listaComentarios = new ArrayList<>();
	private final String tabla = "vehiculo";
	private Vehiculo vehiculo;
	private JButton btnVerCompras;
	private JTable jtableP;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCatalogo frame = new VentanaCatalogo();
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
	public VentanaCatalogo() {
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
		btnComprar.setBounds(100, 510, 143, 31);
		btnComprar.addActionListener(manejador);
		contentPane.add(btnComprar);

		
		btnAlquilar = new JButton("Alquilar Vehiculo");
		btnAlquilar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		btnAlquilar.setBounds(378, 510, 143, 31);
		btnAlquilar.addActionListener(manejador);
		contentPane.add(btnAlquilar);
		
		btnVerCompras = new JButton("Ver Compras Realizadas");
		btnVerCompras.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		btnVerCompras.setBounds(624, 510, 183, 31);
		btnVerCompras.addActionListener(manejador);
		contentPane.add(btnVerCompras);
		
		btnMostrar = new JButton("Mostrar Vehiculos");
		btnMostrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		btnMostrar.setBounds(663, 123, 143, 31);
		btnMostrar.addActionListener(manejador);
		contentPane.add(btnMostrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(272, 42, 338, 220);
		contentPane.add(panel);
		
		JLabel imagenLabel = new JLabel();
	    ImageIcon imagen = new ImageIcon("images/BMW iX3.jpg"); 
	    imagenLabel.setIcon(imagen);
	    panel.add(imagenLabel);
	     
	    btnSiguiente = new JButton("->");
	    btnSiguiente.setFont(new Font("Snap ITC", Font.PLAIN, 10));
	    btnSiguiente.setBounds(831, 240, 45, 48);
	    contentPane.add(btnSiguiente);
	     
	    lblCoche = new JLabel("COCHE");
	    lblCoche.setFont(new Font("Arial Black", Font.BOLD, 10));
	    lblCoche.setBounds(392, 10, 96, 22);
	    contentPane.add(lblCoche);
	     
	    JLabel lblComentarios = new JLabel("-----Comentarios y Valoraciones sobre nuestros coches y nuestras Ventas-----");
	    lblComentarios.setBounds(93, 383, 560, 19);
	    contentPane.add(lblComentarios);
	     
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(103, 412, 695, 65);
	    contentPane.add(scrollPane);
	     
	    listaComentarios.add("Comentario 1");
	    listaComentarios.add("Comentario 2");
	    listaComentarios.add("Comentario 3");
	    listaComentarios.add("Comentario 4");
	    
	    textArea = new JTextArea();
	    textArea.setEditable(false);
	    scrollPane.setViewportView(textArea);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(31, 42, 124, 22);
	    contentPane.add(comboBox);
	    
	    JLabel lblFiltrosBusqueda = new JLabel("Filtros de Busqueda");
	    lblFiltrosBusqueda.setBounds(31, 23, 135, 19);
	    contentPane.add(lblFiltrosBusqueda);
	    
//	    panel_1
	    
	   
	    String nombre = "";
	    for (String s : listaComentarios) {
	    	nombre += s+"\n";
	    	textArea.setText(nombre);
	    	 
			}
	    
	    JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(272, 272, 338, 102);
		contentPane.add(scrollPane);
		
		jtableP = new JTable();
		showVehiculos();
		scrollPane.setViewportView(jtableP);
			
		}
	
	public Vehiculo getVehiculo(Connection conexion) throws SQLException {
		   Vehiculo vehiculo = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante"
	                 + " FROM " + this.tabla + " WHERE idVehiculos = ?" );
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 vehiculo = new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"), resultado.getString("marca"), 
	                    resultado.getInt("anyo"), resultado.getString("color"), resultado.getFloat("precio"), resultado.getInt("idFabricante"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return vehiculo;
	   }
	
	public List<Vehiculo> getAllVehiculos(Connection conexion) throws SQLException {
	    List<Vehiculo> listaVehiculos = new ArrayList<>();
	    try {
	        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
	                + " FROM " + this.tabla);
	        ResultSet resultado = consulta.executeQuery();
	        while (resultado.next()) {
	            listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"), resultado.getString("marca"), 
	                    resultado.getInt("anyo"), resultado.getString("color"), resultado.getFloat("precio"), resultado.getInt("idFabricante")));
	        }
	    } catch (SQLException ex) {
	        throw new SQLException(ex);
	    }
	    return listaVehiculos;
	}

private void showVehiculos() {
    try {
        this.vehiculo = (Vehiculo) this.getAllVehiculos(Conexion.obtener());
        jtableP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        }, new String[] { "idVehiculos", "Modelo", "Marca", "Anyo", "Color", "Precio", "idFabricante" }));
        DefaultTableModel dtm = (DefaultTableModel) jtableP.getModel();
        dtm.setRowCount(0);
        
        jtableP = new JTable(dtm) {
          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        };
        
        for (int i = 0; i < this.listaVehiculos.size(); i++) {
            dtm.addRow(new Object[] {this.listaVehiculos.get(i).getIdVehiculos(), this.listaVehiculos.get(i).getModelo(), this.listaVehiculos.get(i).getMarca(), this.listaVehiculos.get(i).getAnyo(),
                    this.listaVehiculos.get(i).getColor(), this.listaVehiculos.get(i).getPrecio(), this.listaVehiculos.get(i).getIdFabricante() });
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
    } catch (ClassNotFoundException ex) {
        System.out.println(ex);
        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
    }
}
	
	public class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if(o == btnComprar) {
				JOptionPane.showMessageDialog(null, "Seguro quieres comprar este coche?");
				
				
			}else if(o == btnAlquilar) {
				JOptionPane.showMessageDialog(null, "Seguro quieres alquilar este coche?");
				
				
			}else if(o == btnSiguiente) {
				
			}else if(o == btnMostrar) {
				lblCoche.setText("Coche 1");
				String modelo = vehiculo.getModelo();
				String marca = vehiculo.getMarca();
				int anyo = vehiculo.getAnyo();
				String color = vehiculo.getColor();
				float precioSinIVA = vehiculo.getPrecio();
				float precioConIVA = (float) (vehiculo.getPrecio()*0.21);

//				textModelo.setText(modelo);
//				vehiculo.setModelo(modelo);
//				vehiculo.setMarca(marca);
//				vehiculo.setAnyo(anyo);
//				vehiculo.setColor(color);
//				vehiculo.setPrecio(precioSinIVA);
//				vehiculo.setPrecio(precioConIVA);
			}else if(o == btnVerCompras) {
				ComprasRealizadas cr = new ComprasRealizadas();
				cr.setVisible(true);
				dispose();
			}
			
		}	
		
	}
}
