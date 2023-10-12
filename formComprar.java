import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Hilos.fomEnvio;


public class formComprar extends JFrame {

	private JPanel contentPane;
	private JTable tabla_Productos;
	private JTable tabla_Pedido;
	private JTextField txtDistancia;
	
	
	public static DefaultTableModel modelo2;
	public static DefaultTableModel modelo3;
	private JTextField txtTotal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formComprar frame = new formComprar();
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
	public formComprar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(75, 43, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pedido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(326, 43, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 235, 212);
		contentPane.add(scrollPane);
		
		tabla_Productos = new JTable();
		scrollPane.setViewportView(tabla_Productos);
		
		modelo2=new DefaultTableModel();
		modelo2.addColumn("Nombre del producto");
		modelo2.addColumn("Precio (Q)");
		tabla_Productos.setModel(modelo2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(252, 83, 228, 212);
		contentPane.add(scrollPane_1);
		
		tabla_Pedido = new JTable();
		scrollPane_1.setViewportView(tabla_Pedido);
		modelo3=new DefaultTableModel();
		modelo3.addColumn("Nombre del producto");
		modelo3.addColumn("Precio (Q)");
		tabla_Pedido.setModel(modelo3);
		
		JLabel lblNewLabel_2 = new JLabel("Distancia a recorrer:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(34, 402, 142, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Vehículo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(34, 367, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		txtDistancia = new JTextField();
		txtDistancia.setBounds(156, 400, 46, 20);
		contentPane.add(txtDistancia);
		txtDistancia.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Km.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(212, 403, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Motocicleta 1", "Motocicleta 2", "Motocicleta 3"}));
		comboBox.setBounds(92, 364, 110, 22);
		contentPane.add(comboBox);
		
		JButton btnConfirmar = new JButton("Confirmar Pedidos");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String distancia = txtDistancia.getText();
				confirmarPedido();
				
				fomEnvio motos=new fomEnvio();
				motos.setVisible(true);
				
			}
			
		});
		btnConfirmar.setBackground(new Color(176, 224, 129));
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirmar.setBounds(307, 475, 160, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnAgPedido = new JButton("Agregar a mi pedido");
		btnAgPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TableModel modelo3=tabla_Productos.getModel();
				int[]filas=tabla_Productos.getSelectedRows();
				Object []row= new Object[2];
				
				DefaultTableModel modelo4=(DefaultTableModel)tabla_Pedido.getModel();
				
				
				for (int i=0; i<filas.length;i++) {
					row[0]=modelo3.getValueAt(filas[i], 0);
					row[1]=modelo3.getValueAt(filas[i], 1);
					
					modelo4.addRow(row);
				}
				// Llamar a la función para actualizar el monto total
		        actualizarMontoTotal();
			}
			
		});
		btnAgPedido.setBackground(new Color(237, 188, 222));
		btnAgPedido.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgPedido.setBounds(51, 318, 169, 23);
		contentPane.add(btnAgPedido);
		
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(314, 323, 35, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(361, 320, 69, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarPedido();
			}
		});
		btnListo.setBackground(new Color(176, 224, 129));
		btnListo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListo.setBounds(350, 415, 89, 23);
		contentPane.add(btnListo);
		}
	
	private void actualizarMontoTotal() {
	    DefaultTableModel modeloPedidos = (DefaultTableModel) tabla_Pedido.getModel();
	    int rowCount = modeloPedidos.getRowCount();
	    double total = 0;

	    for (int i = 0; i < rowCount; i++) {
	        String precioProducto = modeloPedidos.getValueAt(i, 1).toString();
	        try {
	            double precio = Double.parseDouble(precioProducto);
	            total += precio;
	        } catch (NumberFormatException e) {
	            // Manejo de error en caso de que el valor no sea un número válido
	            // Aquí puedes mostrar un mensaje de error o tomar alguna otra acción apropiada.
	        }
	    }

	    txtTotal.setText(String.valueOf(total));
	 }
	
	private void confirmarPedido() {
        DefaultTableModel model = (DefaultTableModel) tabla_Pedido.getModel();
        model.setRowCount(0); // Establece el número de filas en 0 para eliminar todas las filas
    }
	}

