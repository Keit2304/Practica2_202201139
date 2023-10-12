import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class formHistorial extends JFrame {

	private JPanel contentPane;
	private JTable tabla_Historial;

	
	DefaultTableModel modelo5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formHistorial frame = new formHistorial();
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
	public formHistorial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Historial");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(244, 22, 75, 22);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 566, 224);
		contentPane.add(scrollPane);
		
		tabla_Historial = new JTable();
		scrollPane.setViewportView(tabla_Historial);
		
		modelo5=new DefaultTableModel();
		modelo5.addColumn("Vehículo");
		modelo5.addColumn("Distancia");
		modelo5.addColumn("Monto");
		modelo5.addColumn("Fecha Inicio");
		modelo5.addColumn("Fecha Fin");
		tabla_Historial.setModel(modelo5);
	}
}
