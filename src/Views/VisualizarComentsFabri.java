package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Service.ComentarioService;
import Service.Conexion;
import models.Comentario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarComentsFabri.
 */
public class VisualizarComentsFabri extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The text area. */
	private static JTextArea textArea;

	/** The Constant service. */
	private final static ComentarioService service = new ComentarioService();

	/** The comentarios. */
	private List<Comentario> comentarios = new ArrayList<>();

	/** The btn volver. */
	private JButton btnVolver;

	/**
	 * Instantiates a new visualizar coments fabri.
	 */
	public VisualizarComentsFabri() {
		super("Bandeja de comentarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		textArea.setEditable(false);
		textArea.setBounds(10, 34, 414, 162);
		contentPane.add(textArea);
		Comentario();

		JLabel lblTitulo = new JLabel("Comentarios de los clientes");
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 9, 414, 23);
		contentPane.add(lblTitulo);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon("images/felcha.png"));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarVehiculosCrear vv = new VisualizarVehiculosCrear();
				vv.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(385, 9, 40, 21);
		contentPane.add(btnVolver);
	}

	/**
	 * Comentario.
	 */
	public static void Comentario() {
		try {
			List<Comentario> datos = service.getAllComentarioId(Conexion.obtener());
			String coment = "";

			for (Comentario c : datos) {
				coment += c.getComentario() + "\n";

			}
			textArea.setText(coment);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
