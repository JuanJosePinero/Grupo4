package Views;

import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Service.ComentarioService;
import Service.Conexion;
import models.Comentario;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarComents.
 */
public class VisualizarComents extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The Comentario B. */
	private JButton ComentarioB;

	/** The text area. */
	private static JTextArea textArea;

	/** The Constant service. */
	private final static ComentarioService service = new ComentarioService();

	/** The comentario. */
	private List<Comentario> comentario = new ArrayList<>();

	/**
	 * Instantiates a new visualizar coments.
	 */
	public VisualizarComents() {
		super("Bandeja de valoraciones");
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
		textArea.setBounds(10, 34, 414, 121);
		contentPane.add(textArea);
		Comentario();

		ComentarioB = new JButton("Agregar Comentario");
		ComentarioB.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		ComentarioB.setBounds(40, 166, 175, 23);
		contentPane.add(ComentarioB);

		JLabel lblTitulo = new JLabel("Comentarios de los clientes");
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 9, 414, 23);
		contentPane.add(lblTitulo);

		JButton btnCalcelar = new JButton("Volver Atrás");
		btnCalcelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Volviendo a la ventana del catalogo", "Aviso",
						JOptionPane.ERROR_MESSAGE);
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnCalcelar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		btnCalcelar.setBounds(233, 166, 175, 23);
		contentPane.add(btnCalcelar);
		ManejadorAction ma = new ManejadorAction();
		ComentarioB.addActionListener(ma);
	}

	/**
	 * The Class ManejadorAction.
	 */
	private class ManejadorAction implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			if (j.equals(ComentarioB)) {
				AgregarComentario ac = new AgregarComentario();
				ac.setVisible(true);
				dispose();
			}
		}

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
