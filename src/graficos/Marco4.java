package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;//para clase Graphics 
import java.awt.*;//y Graphics2D 
import java.awt.geom.*;//Para Rectangle2D
import java.awt.Toolkit;
import java.awt.Dimension;


//Dibujar en Marco

public class Marco4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M4 MiMarco = new M4();
		MiMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class M4 extends JFrame{

	public M4() {
		setVisible(true);
		setTitle("Dibujar en Marco");
		setBounds(200,200,600,400);
		P4 MiPanel = new P4();
		//Cambia el color de fondo del marco
		MiPanel.setBackground(Color.GRAY);
		//Cambia el color de fondo del marco por el del por defecto del sistema.
		MiPanel.setBackground(SystemColor.window);
		add(MiPanel);
	}
}

class P4 extends JPanel{
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
		
		//Dibujar figuras geometricas con libreria 2d
		//Primero rfundicion del objeto Graphics
		Graphics2D g2 =(Graphics2D)g;
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
	
	}
}
