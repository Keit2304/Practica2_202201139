package Hilos;

import javax.swing.JLabel;

public class HiloMotos extends Thread{
	
	JLabel label;
	int tiempo;
	int xInicio;
	int xFin;
	int yInicio;
	int yFin;
	int tamaño;
	int xInicioOriginal;
	int yInicioOriginal;
	boolean avanzando; 


	public HiloMotos (JLabel label, int tiempo, int xInicio, int xFin, int yInicio, int yFin, int tamaño) {
		this.label= label;
		this.tiempo= tiempo;
		this.xInicio= xInicio;
		this.xFin= xFin;
		this.yInicio= yInicio;
		this.yFin= yFin;
		this.tamaño= tamaño;
		this.xInicioOriginal=xInicio;
		this.yInicioOriginal=yInicio;
		this.avanzando = true; // Inicialmente, la moto está avanzando
	}
	
	
	@Override
	
	public void run () {
		while (true) {
			mover();
		}
	}
	
	private void mover() {
		try {
			Thread.sleep(tiempo);
			
			if (avanzando) {
                if (xInicio < xFin) {
                    label.setBounds(xInicio, yInicio, label.getWidth(), label.getHeight());
                    xInicio += 2;
                }
                if (yInicio < yFin) {
                    label.setBounds(xInicio, yInicio, label.getWidth(), label.getHeight());
                    yInicio += 2;
                }
                if (xInicio >= xFin && yInicio >= yFin) {
                    avanzando = false; // Cuando llega al punto de llegada, retrocedemos
                }
            } else {
                if (xInicio > xInicioOriginal) {
                    label.setBounds(xInicio, yInicio, label.getWidth(), label.getHeight());
                    xInicio -= 2;
                }
                if (yInicio > yInicioOriginal) {
                    label.setBounds(xInicio, yInicio, label.getWidth(), label.getHeight());
                    yInicio -= 2;
                }
                if (xInicio == xInicioOriginal && yInicio == yInicioOriginal) {
                	this.stop(); // Cuando regresa al punto de inicio, avanzamos de nuevo
                }
            }
		}catch (InterruptedException e) {
			System.out.println(e);
			
		}
		
		
	}
}
