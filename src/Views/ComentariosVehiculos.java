package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Service.Conexion;
import Service.VehiculoComentarioService;
import models.Comentario;
import models.VehiculoConComentarios;

public class ComentariosVehiculos extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
    private JTextArea txtcoments;
    private JButton btnFiltrar;
    private final VehiculoComentarioService service=new VehiculoComentarioService();
    private List<VehiculoConComentarios> vehiculos;
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
    	setTitle("Comentarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
		ManejadorJButton manejador = new ManejadorJButton();
		
		btnFiltrar = new JButton("Volver");
        btnFiltrar.addActionListener(manejador);
        btnFiltrar.setBounds(175, 230, 89, 23);
        contentPane.add(btnFiltrar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(48, 35, 333, 185);
        contentPane.add(scrollPane);
        
        txtcoments = new JTextArea();
        txtcoments.setEditable(false);
        scrollPane.setViewportView(txtcoments);
        
        JLabel lblNewLabel = new JLabel("LISTA VEHICULOS CON COMENTARIOS");
        lblNewLabel.setBounds(117, 10, 246, 13);
        contentPane.add(lblNewLabel);
        showVehiculoscoment();
      
        setVisible(true);
    } 
    
    private class ManejadorJButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Volviendo...", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    		dispose();	
		}
    }
    
    private void showVehiculoscoment() {
            try {
				vehiculos = service.getVehiculosConComentarios(Conexion.obtener());
				String coments="";
				for (VehiculoConComentarios veh : vehiculos) {
					coments+="----------------------------------------------------------------------------\n \""+veh.getVehiculo().getMarca()+" "+veh.getVehiculo().getModelo()+"\" \n "+"comentarios: \n";
					for (Comentario com : veh.getComentarios()) {
						coments+="\n"+com.getComentario()+"\n";
						txtcoments.setText(coments);
					}
				}	
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    }
}
