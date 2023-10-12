import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class formAgregar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTable tabla_Nuevo;

	
	/**modelo 1*/
	DefaultTableModel modelo1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formAgregar frame = new formAgregar();
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
	public formAgregar() {

		formComprar tabla_Productos= new formComprar();
		tabla_Productos.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTítulo = new JLabel("Agregar Productos");
		lblTítulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTítulo.setBounds(152, 29, 174, 35);
		contentPane.add(lblTítulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(48, 103, 57, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(48, 152, 57, 14);
		contentPane.add(lblPrecio);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 101, 145, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(114, 150, 145, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String nombre=txtNombre.getText();
				String precio=(txtPrecio.getText());
				String Datos[]= {nombre,precio};
				modelo1.addRow(Datos);
			}

			
			
		});
		btnAgregar.setBackground(new Color(237, 188, 222));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregar.setBounds(343, 124, 89, 23);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 201, 470, 127);
		contentPane.add(scrollPane);
		
		tabla_Nuevo = new JTable();
		scrollPane.setViewportView(tabla_Nuevo);
		
		modelo1=new DefaultTableModel();
		modelo1.addColumn("Nombre del producto");
		modelo1.addColumn("Precio (Q)");
		tabla_Nuevo.setModel(modelo1);

		
		JButton btnFila = new JButton("Agregar fila");
		btnFila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int FilaSeleccionada=tabla_Nuevo.getSelectedRow();
				
				if(FilaSeleccionada>=0) {
					String Datos[]=new String[2];
					
					Datos[0]=tabla_Nuevo.getValueAt(FilaSeleccionada, 0).toString();
					Datos[1]=tabla_Nuevo.getValueAt(FilaSeleccionada, 1).toString();
					
					formComprar.modelo2.addRow(Datos);
					modelo1.removeRow(FilaSeleccionada);
					
			}
			
		
		}
			
		});
		btnFila.setBackground(new Color(237, 188, 222));
		btnFila.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFila.setBounds(38, 343, 115, 23);
		contentPane.add(btnFila);
		
		JButton btnTodo = new JButton("Agregar Todo");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for (int i=0; i<tabla_Nuevo.getRowCount(); i++) {
					String Datos[]=new String [2];
					Datos[0]=tabla_Nuevo.getValueAt(i, 0).toString();
					Datos[1]=tabla_Nuevo.getValueAt(i, 1).toString();
					
					formComprar.modelo2.addRow(Datos);
			}
			
			
				nuevatabla();
			}
		});
		btnTodo.setBackground(new Color(237, 188, 222));
		btnTodo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTodo.setBounds(315, 343, 128, 23);
		contentPane.add(btnTodo);
		
		JButton btnHistorial = new JButton("Historial de pedidos");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnHistorial.setBackground(new Color(176, 224, 129));
		btnHistorial.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHistorial.setBounds(152, 427, 174, 23);
		contentPane.add(btnHistorial);
	}
	
	public void nuevatabla () {
		
		modelo1= new DefaultTableModel();
		tabla_Nuevo.setModel(modelo1);
	}

}
