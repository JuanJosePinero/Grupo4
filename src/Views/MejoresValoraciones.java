package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Valoracion;
import models.Vehiculo;

public class MejoresValoraciones extends JFrame {

		private JPanel contentPane;
	 	private JFrame frame;
	    private JTable table;
	    private DefaultTableModel tableModel;
	    private JTextField textFieldNombre;
	    private JTextField textFieldValoracion;
	    private Vehiculo vehiculo;
	    private List<Vehiculo> vehiculos;
	    private Valoracion valoracion;
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    MejoresValoraciones window = new MejoresValoraciones();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public MejoresValoraciones() {
	        initialize();
	        vehiculos = new ArrayList<>();
	    }

	    private void initialize() {
	    	setTitle("Mejores valoraciones");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 34, 371, 181);
			contentPane.add(scrollPane);

	        tableModel = new DefaultTableModel(
	                new Object[][] {},
	                new String[] { "Vehículo", "Valoración"}
	        );
	        table = new JTable(tableModel);
	        scrollPane.setViewportView(table);

	        JButton btnFiltrar = new JButton("Volver");
	        btnFiltrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	VentanaCatalogo vc=new VentanaCatalogo();
	        		vc.setVisible(true);
	        		vc.setLocationRelativeTo(null);
	        		dispose();
	            }
	        });
	        btnFiltrar.setBounds(162, 230, 89, 23);
	        contentPane.add(btnFiltrar);
	      
	        setVisible(true);
	    }}

	
	


