

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ProblemNBody extends JPanel {

	private int x = 220;
	private int xSun, xEarth;
	private int ySun, yEarth;
	private double angleSun, angleEarth;
	private final Image sun,earth,bck;
	private Timer redrawTimer;
	 
	 ProblemNBody(){
		 bck = new ImageIcon(Objects.requireNonNull(getClass().getResource("./bck.gif"))).getImage();
		 sun = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sun.png"))).getImage();
		 earth = new ImageIcon(Objects.requireNonNull(getClass().getResource("/earth.gif"))).getImage();
		 setVisible(true);
		 reepaint();
	 }

	    public void reepaint(){
	        redrawTimer = new Timer(1, (ActionEvent e)-> repaint());
	        redrawTimer.start();
	    }

	public void moverplaneta() {
		double width = getWidth() / 3; // double para flotante
		double height = getHeight() / 3;

		//calculo de elipse planeta Sol
		angleSun -= 0.04;
		if (angleSun > (2 * Math.PI))
			angleSun = 0.0;
		repaint();

		xSun = (int) (Math.cos(angleSun) * (width / 300) + (width / 1.1));
		ySun = (int) (Math.sin(angleSun) * (height / 300) + (height / 2));
		

		// calculo de elipse planeta tierra
		angleEarth -= 0.04;
		if (angleEarth > (Math.PI))
			angleEarth = 0.0;
		repaint();
		
		xEarth = (int) (Math.cos(angleEarth) * (width / 1.9) + (width / 2));
		yEarth = (int) (Math.sin(angleEarth) * (height / 2.9) + (height / 2));


	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bck,0,0,1400,700,null);
        
		extracted(g);

    }

	private void extracted(Graphics g) {
		// Dibulo el Sol
		g.drawImage(sun, xSun + 70, ySun + 190, 100, 100,null);
		
		// dibujo la orbita de la tierra
		g.setColor(Color.white);
		g.drawOval(x, 285, 270, 170);
		
		g.setColor(Color.WHITE);
		g.drawString("Sol", 350, 370); 

		// dibujo planeta tierra 
		g.drawImage(earth,xEarth + x , yEarth + 238, 20, 20,null);
		
		g.setColor(Color.white);
		g.setFont(new Font("impact", Font.PLAIN, 50));
		g.setColor(Color.white);
		g.drawString("MODELO CUERPOS CELESTES", 100, 60);
	}
    



}
