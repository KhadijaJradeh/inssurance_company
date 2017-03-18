package restingBackgroundImage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundClass extends JFrame{
	public MyPanel panel;
	private BufferedImage img;
      public BackgroundClass() {
		setVisible(true);
		setDefaultCloseOperation(3);
		setSize(1600,900);
		
		try {
            img = ImageIO.read(new File("C:\\Users\\toshiba\\Documents\\workspace\\JAVA_WORKSPACE\\restingBackgroundImage\\src\\blue.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        panel= new MyPanel();
        add(panel);
        
	}
      private class MyPanel extends JPanel{
    	  
          protected void paintComponent(Graphics g) {
              super.paintComponent(g);
              g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
          }
      }
 
}
/*
 * public class Main exends JFrame{
    MyPanel panel;
    

    public Main(){
        try {
            img = ImageIO.read(new File("C:\\Users\\Ryan T\\Desktop\\wNSE6p7.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        panel= new MyPanel();
        add(panel);
    }    

    private class MyPanel extends JPanel{
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
} 
 * */
 


