package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Vehiculo;

public class ComentariosVehiculos extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField textFieldComment;
    private List<Vehiculo> vehiculos;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComentariosVehiculos window = new ComentariosVehiculos();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ComentariosVehiculos() {
        initialize();
        vehiculos = new ArrayList<>();
    }

    private void initialize() {
    	setTitle("Coches mas comentados Comentarios");
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
                new String[] { "Vehículo", "Usuario","Comentarios"}
        );
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        JButton btnFiltrar = new JButton("Volver");
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                FiltrarVehiculo fv=new FiltrarVehiculo();
                fv.setVisible(true);
                fv.setLocationRelativeTo(null);
            }
        });
        btnFiltrar.setBounds(162, 230, 89, 23);
        contentPane.add(btnFiltrar);
      
        setVisible(true);
    } 
	/**
	 * Launch the application.
	 */
	

}
