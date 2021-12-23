package practicas;

import java.awt.Graphics;
import java.awt.Graphics.*;
import java.awt.Graphics2D;
import java.awt.Graphics2D.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.BorderLayout;

public class P1MarcoVentanasDeDialogosApp extends JFrame{
	public P1MarcoVentanasDeDialogosApp () {
		setTitle("Prueba Dialogos");
		setBounds(500,300,600,450);
		setLayout(new BorderLayout());
		JPanel laminaCuadricula=new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2,3));
		String [] primero  = {"Mensaje","Confirmar","Opcion","Entrada"};
		
		lamina_tipo = new P1LaminaVentanasDeDialogosApp("Tipo", primero);
		lamina_tipo_mensajes = new P1LaminaVentanasDeDialogosApp("Tipo de Mensaje", new String[] {"ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"});
		lamina_mensaje = new P1LaminaVentanasDeDialogosApp("Mensaje", new String[] {"Cadena","Icono","Componente","Otros","Object[]"});
		lamina_tipo_opcion = new P1LaminaVentanasDeDialogosApp("Confirmar", new String [] {"DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"});
		lamina_opciones = new P1LaminaVentanasDeDialogosApp("Opcion", new String[] {"String[]","Icon[]","Object[]"});
		lamina_entrada = new P1LaminaVentanasDeDialogosApp("Entrada", new String[] {"Campo de texto","Combo"});
		
		laminaCuadricula.add(lamina_tipo);
		laminaCuadricula.add(lamina_tipo_mensajes);
		laminaCuadricula.add(lamina_mensaje);
		laminaCuadricula.add(lamina_tipo_opcion);
		laminaCuadricula.add(lamina_opciones);
		laminaCuadricula.add(lamina_entrada);
		
		JPanel lamina_mostrar = new JPanel();
		JButton boton_mostrar = new JButton("Mostrar");
		boton_mostrar.addActionListener(new AccionMostrar());
		
		lamina_mostrar.add(boton_mostrar);
		add(lamina_mostrar,BorderLayout.SOUTH);
		add(laminaCuadricula,BorderLayout.CENTER);
		
	}
	
	// Devuelve el Mensaje
	
	public Object dameMensaje() {
		String s= lamina_mensaje.dameSeleccion();
		if (s.equals("Cadena")) return (Object)cadenaMensaje;
		else if (s.equals("Icono")) return iconoMensaje;
		else if (s.equals("Componente")) return componenteMensaje;
		else if (s.equals("Otros")) return objetoMensaje;
		else if (s.equals("Object[]")) return (new Object[] {cadenaMensaje,
				iconoMensaje,
				componenteMensaje,
				objetoMensaje
				});
		else return null;
		}
	
	// Devuelve tipo Icono
	public int dameIcono() {
		String s= lamina_tipo_mensajes.dameSeleccion();
		if (s.equals("ERROR_MESSAGE")) return 0;
		else if (s.equals("INFORMATION_MESSAGE")) return 1;
		else if (s.equals("WARNING_MESSAGE")) return 2;
		else if (s.equals("QUESTION_MESSAGE")) return 3;
		else if (s.equals("PLAIN_MESSAGE")) return -1;
		else return 0;
		}
	
	// Devuelve tipo Confirmar
	public int dameConfirmar() {
		String s= lamina_tipo_opcion.dameSeleccion();
		if (s.equals("DEFAULT_OPTION")) return -1;
		else if (s.equals("YES_NO_OPTION")) return 0;
		else if (s.equals("YES_NO_CANCEL_OPTION")) return 1;
		else if (s.equals("OK_CANCEL_OPTION")) return 2;
		else return 0;
		}
	
	// Devuelve tipo Opcion
	public Object[] dameOpcion() {
		String s= lamina_opciones.dameSeleccion();
		if (s.equals("String[]")) return new String[] {"Boton1","Boton2","Boton3"};
		else if (s.equals("Icon[]")) return new ImageIcon[] {new ImageIcon ("src/practicas/azul.png"),new ImageIcon ("src/practicas/naranja.png"),new ImageIcon ("src/practicas/rosa.png")};
		else if (s.equals("Object[]")) return new Object[] {
				cadenaMensaje,
				iconoMensaje,
				componenteMensaje,
				objetoMensaje
				};
		else return null;
		}
	
	class AccionMostrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		// Menu Tipo de Mensaje
			if (lamina_tipo.dameSeleccion().equals("Mensaje")) {
				JOptionPane.showMessageDialog(P1MarcoVentanasDeDialogosApp.this,dameMensaje(), "Titulo",dameIcono());
			}  else if (lamina_tipo.dameSeleccion().equals("Confirmar")) {
				JOptionPane.showConfirmDialog(P1MarcoVentanasDeDialogosApp.this,dameMensaje(), "Titulo",dameConfirmar(),dameIcono());
			} else if (lamina_tipo.dameSeleccion().equals("Opcion")) {
				JOptionPane.showOptionDialog(P1MarcoVentanasDeDialogosApp.this,dameMensaje(), "Titulo",1,dameIcono(),null,dameOpcion(),dameOpcion()[0]);
			} else {
				if(lamina_entrada.dameSeleccion().equals("Campo de texto")) {
					JOptionPane.showInputDialog(P1MarcoVentanasDeDialogosApp.this,dameMensaje(), "Titulo",dameIcono());
				} else {
					JOptionPane.showInputDialog(P1MarcoVentanasDeDialogosApp.this,dameMensaje(), "Titulo",dameIcono(),null,new String[] {"1","2","3"},"1");
				}
			}
		
		}
	}
	
	private P1LaminaVentanasDeDialogosApp lamina_tipo,lamina_tipo_mensajes,lamina_mensaje,lamina_tipo_opcion,lamina_opciones,lamina_entrada;
	private String cadenaMensaje="Mensaje";
	private Icon iconoMensaje= new ImageIcon("src/practicas/icono.jpg");
	private Object objetoMensaje = new Date();
	private Component componenteMensaje = new Lamina_Ejemplo();
}


class Lamina_Ejemplo extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(0,0,getWidth(),getHeight());
		g2.setPaint(Color.YELLOW);
		g2.fill(rectangulo);
	}
	
}
