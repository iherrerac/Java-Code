package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;//para clase Graphics 
import java.awt.*;//y Graphics2D 
import java.awt.geom.*;//Para Rectangle2D
import java.awt.Toolkit;
import java.awt.Dimension;


//Dibujar en Marco

public class Marco3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M1 MiMarco = new M1();
		MiMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class M1 extends JFrame{

	public M1() {
		setVisible(true);
		setTitle("Dibujar en Marco");
		setBounds(200,200,600,400);
		P1 MiPanel = new P1();
		add(MiPanel);
	}
}

class P1 extends JPanel{
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
		//Llamamos al metodo draw de nuestro objeto Graphics2D los parametros del rectangulo
		g2.draw(Rectangulo);
		
		//Dibuja Una ELipse a partir de un rectangulo 
		Ellipse2D Elipse = new Ellipse2D.Double();
		Elipse.setFrame(Rectangulo);
		g2.draw(Elipse);
		//Dibujar una linea, la vamos a instanciar directamente
		g2.draw(new Line2D.Double(100,100,300,250));
		
		//Dibujar Circulo partiendo del centro
		double  centroEnX= Rectangulo.getCenterX(); 
		double  centroEnY= Rectangulo.getCenterY();
		double radio = 150;
		Ellipse2D Circulo = new Ellipse2D.Double();
		Circulo.setFrameFromCenter(centroEnX,centroEnY,centroEnX+radio,centroEnY+radio);
		g2.draw(Circulo);
	
	}
}
