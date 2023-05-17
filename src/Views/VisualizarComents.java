package Views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VisualizarComents extends JFrame {

	private JPanel contentPane;
	private JButton ComentarioB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarComents frame = new VisualizarComents();
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
	public VisualizarComents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 414, 145);
		contentPane.add(textArea);
		
		ComentarioB = new JButton("Agregar Comentario");
		ComentarioB.setBounds(10, 173, 414, 23);
		contentPane.add(ComentarioB);
		ManejadorAction ma = new ManejadorAction();
		ComentarioB.addActionListener(ma);
	}
	
	private class ManejadorAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			if(j.equals(ComentarioB)) {
				AgregarComentario ac = new AgregarComentario();
				ac.setVisible(true);
				dispose();
				
			}
		}
		
	}
}
