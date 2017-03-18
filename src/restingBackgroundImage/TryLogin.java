package restingBackgroundImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.event.*;

import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BackgroundJPanel extends JPanel{
	private BufferedImage img;
    BackgroundJPanel(){
	try {
        img = ImageIO.read(new File("C:\\Users\\toshiba\\Documents\\workspace\\JAVA_WORKSPACE\\restingBackgroundImage\\src\\pink.png"));
    } catch(IOException e) {
        e.printStackTrace();
    }
    }
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

public class TryLogin extends JFrame{
	public JPanel p, p1,p2;
	public JPanel head,right,left,foot;
	 TryLogin(){
		BackgroundJPanel panel=new BackgroundJPanel();
		this.add(panel);
		p=new JPanel();p1=new JPanel();p2=new JPanel();
		p.setLayout(new GridLayout(2,0));
		p1.setLayout(new GridLayout(2,2));
		p1.add(new JLabel("Name : "));
		p1.add(new JTextField(15));
		p1.add(new JLabel("Name : "));
		p1.add(new JTextField(15));
		p1.setOpaque(false);
		p2.add(new JButton("Login"));
		p2.setOpaque(false);
		p.add(p1);p.add(p2);
		p.setOpaque(false);
		head=new JPanel();foot=new JPanel();left=new JPanel();right=new JPanel();
		left.setBackground(java.awt.Color.decode("#ff6055"));
		right.setBackground(java.awt.Color.decode("#ff6055"));
		foot.setBackground(java.awt.Color.decode("#ff6055"));
		head.setBackground(java.awt.Color.decode("#ff6055"));
		panel.add(head,BorderLayout.NORTH);
		panel.add(foot,BorderLayout.SOUTH);
		panel.add(right,BorderLayout.EAST);
		panel.add(left,BorderLayout.WEST);
		panel.add(p,BorderLayout.CENTER);
		
	 }

	public static void main(String[] args) {
		 
       TryLogin t=new TryLogin();
       t.setVisible(true);
       t.setDefaultCloseOperation(3);
       t.setSize(1600,900);
	}

}
