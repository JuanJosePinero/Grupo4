package Views;

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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Service.Conexion;
import Service.ValoracionService;
import models.Valoracion;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarValoracion.
 */
public class VisualizarValoracion extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The text area. */
	private static JTextArea textArea;

	/** The Constant service. */
	private final static ValoracionService service = new ValoracionService();

	/** The valoracion. */
	private List<Valoracion> valoracion = new ArrayList<>();

	/** The btn agregar V. */
	private JButton btnVolver, btnAgregarV;

	/**
	 * Instantiates a new visualizar valoracion.
	 */
	public VisualizarValoracion() {
		super("Bandeja de valoraciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 268);
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

		JLabel lblTitulo = new JLabel("Valoraciones de los clientes");
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 9, 414, 23);
		contentPane.add(lblTitulo);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon("images/felcha.png"));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCatalogo vc = new VentanaCatalogo();
				vc.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(385, 9, 40, 21);
		contentPane.add(btnVolver);

		btnAgregarV = new JButton("Agregar Valoracion");
		btnAgregarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarValoracion av = new AgregarValoracion();
				av.setVisible(true);
				dispose();
			}
		});
		btnAgregarV.setBounds(10, 208, 414, 21);
		contentPane.add(btnAgregarV);
	}

	/**
	 * Comentario.
	 */
	public static void Comentario() {
		try {
			List<Valoracion> datos = service.getAllValoracionId(Conexion.obtener());
			String coment = "";
			String nomUser = Login.getnombreUser();
			for (Valoracion c : datos) {
				coment += nomUser + ": Ha valorado el coche con " + c.getValoracion() + " estrellas\n";
			}
			textArea.setText(coment);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
