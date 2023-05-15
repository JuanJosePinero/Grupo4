package Views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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
import Service.VehiculoService;
import models.Vehiculo;

public class VentanaCatalogo extends JFrame {

	private JPanel contentPane;
	private JButton btnComprar, btnAlquilar, btnVerCompras, btnSalir;
	private JTextArea textAreaComentarios;
	private JScrollPane scrollPane;
	private JLabel lblCoche;
	private List<String> listaComentarios = new ArrayList<>();
	private final String tabla = "vehiculo";
	private final VehiculoService services = new VehiculoService();
	private List<Vehiculo> vehiculo;
	private JTable jtableP;
	private JComboBox filtro;
	private DefaultTableModel dtm;
	
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
		
		JPanel panel = new JPanel();
		panel.setBounds(486, 79, 370, 251);
		contentPane.add(panel);
		
		JLabel imagenLabel = new JLabel();
	    ImageIcon imagen = new ImageIcon("images/BMW iX3.jpg"); 
	    imagenLabel.setIcon(imagen);
	    panel.add(imagenLabel);
	     
	    lblCoche = new JLabel("Catalogo de Coches Disponibles");
	    lblCoche.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
	    lblCoche.setBounds(300, 16, 334, 32);
	    contentPane.add(lblCoche);
	     
	    JLabel lblComentarios = new JLabel("Comentarios sobre nuestros coches y nuestras Ventas");
	    lblComentarios.setBounds(49, 340, 376, 22);
	    contentPane.add(lblComentarios);
	     
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(49, 369, 376, 109);
	    contentPane.add(scrollPane);
	     
	    listaComentarios.add("Comentario 1");
	    listaComentarios.add("Comentario 2");
	    listaComentarios.add("Comentario 3");
	    listaComentarios.add("Comentario 4");
	    
	    textAreaComentarios = new JTextArea();
	    textAreaComentarios.setEditable(false);
	    scrollPane.setViewportView(textAreaComentarios);
	    String[] filtros= {"--","Marca","Modelo","Anyo","Color","Precio","idFabricante"};
	    
	    filtro = new JComboBox(filtros);
	    filtro.setBounds(49, 43, 124, 22);
	    contentPane.add(filtro);
	    manejadorcombo mancombo=new manejadorcombo();
	    filtro.addItemListener(mancombo);
	    
	    JLabel lblFiltrosBusqueda = new JLabel("Filtros de Busqueda");
	    lblFiltrosBusqueda.setBounds(49, 23, 135, 19);
	    contentPane.add(lblFiltrosBusqueda);
	    
	   
	    String nombre = "";
	    for (String s : listaComentarios) {
	    	nombre += s+"\n";
	    	textAreaComentarios.setText(nombre);
	    	 
			}
	    
	    JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 91, 376, 174);
		contentPane.add(scrollPane);
		
		dtm = new DefaultTableModel(new Object[][] {}, new String[] { "idVehiculos", "Modelo", "Marca", "Anyo", "Color", "Precio", "idFabricante" });
		jtableP = new JTable(dtm) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		scrollPane.setViewportView(jtableP);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon("images/salir.png"));
		btnSalir.setBounds(795, 19, 50, 50);
		btnSalir.addActionListener(manejador);
		contentPane.add(btnSalir);
		
		JLabel lblValoraciones = new JLabel("Valoraciones sobre nuestros coches y nuestras Ventas");
		lblValoraciones.setBounds(486, 340, 376, 22);
		contentPane.add(lblValoraciones);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(486, 375, 370, 107);
		contentPane.add(scrollPane_1);
		
		JTextArea textAreaValoraciones = new JTextArea();
		scrollPane_1.setViewportView(textAreaValoraciones);
		textAreaValoraciones.setEditable(false);
		
			
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


	
	public class ManejadorJButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if(o == btnComprar) {
				JOptionPane.showMessageDialog(null, "Seguro quieres comprar este coche?", "Aviso", JOptionPane.QUESTION_MESSAGE);
				int fila_seleccionada = jtableP.getSelectedRow();
				if (fila_seleccionada >= 0) {
					VentanaCatalogo.this.dispose();
					ComprarVehiculo cv = new ComprarVehiculo(vehiculo.get(fila_seleccionada));
					cv.setVisible(true);
					cv.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(VentanaCatalogo.this, "Por favor seleccione una fila.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
						
				
			}else if(o == btnAlquilar) {
				JOptionPane.showMessageDialog(null, "Seguro quieres alquilar este coche?", "Aviso", JOptionPane.QUESTION_MESSAGE);
				
				int fila_seleccionada = jtableP.getSelectedRow();
				if (fila_seleccionada >= 0) {
					VentanaCatalogo.this.dispose();
					AlquilerVehiculo av = new AlquilerVehiculo(vehiculo.get(fila_seleccionada));
					av.setVisible(true);
					av.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(VentanaCatalogo.this, "Por favor seleccione una fila.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else if(o == btnVerCompras) {
				ComprasRealizadas cr = new ComprasRealizadas();
				cr.setVisible(true);
				dispose();
			}else if(o == btnSalir) {
				JOptionPane.showMessageDialog(null, "Cerrando Sesion...", "Cerrar", JOptionPane.ERROR_MESSAGE);
				dispose();
				Login l = new Login();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
			}
			
		}	
		
	}
	private void refrescarTabla(String fil){
		    try {
		        if (fil.equalsIgnoreCase("--")) {
		            showVehiculos();  
		        } else if (fil.equalsIgnoreCase("Marca")) {
		            showVehiculosMarca();  
		        } else if (fil.equalsIgnoreCase("Modelo")) {
		        	showVehiculosModelo();
		        } else if (fil.equalsIgnoreCase("Anyo")) {
		        	showVehiculosAnyo();
		        } else if (fil.equalsIgnoreCase("Color")) {
		        	showVehiculosColor();
		        } else if (fil.equalsIgnoreCase("Precio")) {
		        	showVehiculosPrecio();
		        } else if (fil.equalsIgnoreCase("idFabricante")) {
		        	showVehiculosidFabricante();
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(this, "Error al actualizar la tabla");
		    }
		
	}
	private void showVehiculosidFabricante() {
		try {
	        vehiculo = services.getAllVehiculosidFabricante(Conexion.obtener());
	        dtm.setRowCount(0);  

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
		
	}

	private void showVehiculosPrecio() {
		try {
	        vehiculo = services.getAllVehiculosPrecio(Conexion.obtener());
	        dtm.setRowCount(0);  

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
		
	}

	private void showVehiculosColor() {
		try {
	        vehiculo = services.getAllVehiculosColor(Conexion.obtener());
	        dtm.setRowCount(0);  

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
		
	}

	private void showVehiculosAnyo() {
		try {
	        vehiculo = services.getAllVehiculosAnyo(Conexion.obtener());
	        dtm.setRowCount(0);  

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
		
	}

	private void showVehiculosModelo() {
		try {
	        vehiculo = services.getAllVehiculosModelo(Conexion.obtener());
	        dtm.setRowCount(0);

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
		
	}
	private void showVehiculos() {
		try {
	        vehiculo = services.getAllVehiculos(Conexion.obtener());
	        dtm.setRowCount(0);  

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
	}
	private void showVehiculosMarca() {
		try {
	        vehiculo = services.getAllVehiculosMarca(Conexion.obtener());
	        dtm.setRowCount(0);  

	        for (int i = 0; i < vehiculo.size(); i++) {
	            dtm.addRow(new Object[] { vehiculo.get(i).getIdVehiculos(), vehiculo.get(i).getModelo(), vehiculo.get(i).getMarca(),
	                    vehiculo.get(i).getAnyo(), vehiculo.get(i).getColor(), vehiculo.get(i).getPrecio(),
	                    vehiculo.get(i).getIdFabricante() });
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	        JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
	    }
	}
	private class manejadorcombo implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox combo = (JComboBox) e.getSource();
	        String filtroSeleccionado = String.valueOf(combo.getSelectedItem());
	        refrescarTabla(filtroSeleccionado);
		}
			
		
	}
}
