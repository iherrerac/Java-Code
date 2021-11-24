package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Font;


public class MiMarco {

	public static void main(String[] args) {
		// Instanciamos Marco y establecemos acción close
		Marco MiMarco10 = new Marco();
		MiMarco10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}	


class Marco extends JFrame{
	public Marco() {
	//Visible, titulo y posicion y tamaño
	setVisible(true);
	setTitle("Paquete Swing: Marcos y Paneles");
	setBounds(200,200,400,400);
	
	//Instanciamos el panel
	Paneles MiPanel1 = new Paneles();
	
	//Establecemos fondo y color del trazo-fuente
	MiPanel1.setBackground(Color.WHITE);
	//Cambia el color de fondo del marco por el del por defecto del sistema.
	MiPanel1.setBackground(SystemColor.window);
	MiPanel1.setForeground(Color.GRAY);
	add(MiPanel1);
	}
}


class Paneles extends JPanel{
	public void paintComponent(Graphics g) {
		//Llamada al metodo Padre para hacer lo que sea que este programado
		super.paintComponent(g);
//		//Estos metodos estan desfasados, hay una libreria 2D que te permite mas opciones.
//		//Dibuja un cuadrado. (x,y,width,Heigth)
//		g.drawRect(50,50,200,200);
//		//Dibujar una linea (punto final punto final)
//		g.drawLine(100,100,300,200);
//		//Dibujar un arco
//		g.drawArc(50,100,100,200,120,150);
		

		//Casting del objeto Graphics a Graphics2D
		Graphics2D g2 = (Graphics2D)g;
		
		//Dibujar figuras geometricas con libreria 2d
		//Dibuja Rectangulo especificando coordenadas (x,y,width,Heigth)
		Rectangle2D Rectangulo = new Rectangle2D.Double(100,100,200,150);
		//Color del trazo: Constante estatica de la clase Color
		g2.setPaint(Color.RED);
		//Llamamos al metodo fill para que pinte  nuestro rectangulo relleno de color
		g2.fill(Rectangulo);
		
		//Dibuja Una ELipse a partir de un rectangulo 
		Ellipse2D Elipse = new Ellipse2D.Double();
		Elipse.setFrame(Rectangulo);
		//Color del trazo. Instanciamos un objeto de clase Color con metodo RGB
		g2.setPaint(new Color(0,140,200));
		//Color del trazo brighter para dar mas brillo, se puede aplicar varias veces
		g2.setPaint(new Color(0,140,200).brighter().brighter());
		//Color del trazo brighter para dar mas oscuro, se puede aplicar varias veces
		g2.setPaint(new Color(0,140,200).darker());
		g2.fill(Elipse);
		//Dibujar una linea, la vamos a instanciar directamente
		g2.draw(new Line2D.Double(100,100,300,250));
		
		//Dibujar Circulo partiendo del centro
		double  centroEnX= Rectangulo.getCenterX(); 
		double  centroEnY= Rectangulo.getCenterY();
		double radio = 150;
		Ellipse2D Circulo = new Ellipse2D.Double();
		//Otra forma de establecer el color, instanciando un objeto clase Color
		Color MiColor4 = new Color (0,150,50);
		g2.setPaint(MiColor4);
		Circulo.setFrameFromCenter(centroEnX,centroEnY,centroEnX+radio,centroEnY+radio);
		g2.draw(Circulo);
		
		//Fuente NombreFuente-TipoLetra-Tamaño
		Font MiFuente1 = new Font("Arial",Font.BOLD,16);
		g2.setFont(MiFuente1);
		g2.drawString("Practicando Swing Básico",100,100);
		
		//Otra fuente, declarada en el setFont
		g2.setFont(new Font("Arial",Font.ITALIC,16));
		g2.setColor(Color.RED);
		g2.drawString("Otro ejemplo de fuente",120,180);
	}
}

	

