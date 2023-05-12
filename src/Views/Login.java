package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField UsuarioT;
	private JButton btnIniciarSesion,btnCrearUsuario;
	private JPasswordField ContraseñaP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		panel_2.add(btnIniciarSesion);
		
		btnCrearUsuario = new JButton("Crear Usuario");
		panel_2.add(btnCrearUsuario);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel Center = new JPanel();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.setLayout(null);
		
		JLabel UsuarioL = new JLabel("Usuario");
		UsuarioL.setBounds(170, 33, 46, 14);
		Center.add(UsuarioL);
		
		UsuarioT = new JTextField();
		UsuarioT.setBounds(131, 58, 129, 20);
		Center.add(UsuarioT);
		UsuarioT.setColumns(10);
		
		JLabel ContraseñaL = new JLabel("Contraseña");
		ContraseñaL.setBounds(160, 117, 73, 14);
		Center.add(ContraseñaL);
		
		ContraseñaP = new JPasswordField();
		ContraseñaP.setBounds(131, 144, 129, 20);
		Center.add(ContraseñaP);
		
		setVisible(true);
		
		manejadorAction ma= new manejadorAction();
		
		btnIniciarSesion.addActionListener(ma);
		btnCrearUsuario.addActionListener(ma);
		
	}
	
	private class manejadorAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton o = (JButton) e.getSource();
		
			if(o.equals(btnIniciarSesion)) {
				if(UsuarioT.)
				
			}else if(o.equals(btnCrearUsuario)) {
				CreacionUsuario cu = new CreacionUsuario();
				dispose();
				
			}
			
			
		}
		
	}
}
