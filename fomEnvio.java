package Hilos;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import Hilos.HiloMotos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class fomEnvio extends JFrame {

	private JPanel contentPane;
	private JLabel lblMensajero3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fomEnvio frame = new fomEnvio();
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
	public fomEnvio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Visualización de Trayectorias");
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltitulo.setBounds(233, 23, 261, 31);
		contentPane.add(lbltitulo);
		
		JLabel lblMoto1 = new JLabel("Motocicleta 1");
		lblMoto1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMoto1.setBounds(25, 135, 90, 14);
		contentPane.add(lblMoto1);
		
		JLabel lblMensajero2 = new JLabel("");
		lblMensajero2.setIcon(new ImageIcon(fomEnvio.class.getResource("/Imágenes/Mensajeria (1).jpg")));
		lblMensajero2.setBounds(109, 222, 113, 105);
		contentPane.add(lblMensajero2);
		
		JLabel lblMoto2 = new JLabel("Motocicleta 2");
		lblMoto2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMoto2.setBounds(25, 255, 90, 14);
		contentPane.add(lblMoto2);
		
		JButton btnEnviar2 = new JButton("Enviar");
		btnEnviar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hilos.HiloMotos hilo2=new HiloMotos(lblMensajero2,10,lblMensajero2.getX(),550,lblMensajero2.getY(),lblMensajero2.getY(),60);
				hilo2.start();
				
			}
		});
		btnEnviar2.setBackground(new Color(237, 188, 222));
		btnEnviar2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviar2.setBounds(25, 280, 81, 23);
		contentPane.add(btnEnviar2);
		
		lblMensajero3 = new JLabel("");
		lblMensajero3.setIcon(new ImageIcon(fomEnvio.class.getResource("/Imágenes/Mensajeria (1).jpg")));
		lblMensajero3.setBounds(109, 339, 113, 110);
		contentPane.add(lblMensajero3);
		
		JButton btnEnviar3 = new JButton("Enviar");
		btnEnviar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hilos.HiloMotos hilo3=new HiloMotos(lblMensajero3,25,lblMensajero3.getX(),550,lblMensajero3.getY(),lblMensajero3.getY(),60);
				hilo3.start();
			}
		});
		btnEnviar3.setBackground(new Color(237, 188, 222));
		btnEnviar3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviar3.setBounds(25, 404, 82, 23);
		contentPane.add(btnEnviar3);
		
		JLabel lblMensajero1 = new JLabel("JLabel1");
		lblMensajero1.setIcon(new ImageIcon(fomEnvio.class.getResource("/Imágenes/Mensajeria (1).jpg")));
		lblMensajero1.setBounds(109, 106, 113, 105);
		contentPane.add(lblMensajero1);
		
		JLabel lblMoto3 = new JLabel("Motocicleta 3");
		lblMoto3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMoto3.setBounds(25, 379, 90, 14);
		contentPane.add(lblMoto3);
		
		JButton btnTodo = new JButton("Enviar todos");
		btnTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hilos.HiloMotos hilo=new HiloMotos(lblMensajero1,50,lblMensajero1.getX(),550,lblMensajero1.getY(),lblMensajero1.getY(),60);
				hilo.start();
				
				Hilos.HiloMotos hilo2=new HiloMotos(lblMensajero2,10,lblMensajero2.getX(),550,lblMensajero2.getY(),lblMensajero2.getY(),60);
				hilo2.start();
				
				Hilos.HiloMotos hilo3=new HiloMotos(lblMensajero3,25,lblMensajero3.getX(),550,lblMensajero3.getY(),lblMensajero3.getY(),60);
				hilo3.start();
				
				
				
			}
		});
		btnTodo.setBackground(new Color(176, 224, 129));
		btnTodo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTodo.setBounds(568, 60, 125, 23);
		contentPane.add(btnTodo);
		
		JButton btnEnviar1 = new JButton("Enviar");
		btnEnviar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hilos.HiloMotos hilo=new HiloMotos(lblMensajero1,50,lblMensajero1.getX(),550,lblMensajero1.getY(),lblMensajero1.getY(),60);
				hilo.start();
				
				
				
				
			}
		});
		btnEnviar1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnviar1.setBackground(new Color(237, 188, 222));
		btnEnviar1.setBounds(25, 160, 81, 23);
		contentPane.add(btnEnviar1);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
