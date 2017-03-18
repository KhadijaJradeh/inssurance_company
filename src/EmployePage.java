import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EmployePage extends JFrame{
	public String name;
	public JPanel p1,p2,p3,p4,p5;
	public JLabel welc_lab,img1_lab;
	public ImageIcon image;
	public JButton Life_but,Car_but,Hosp_btn,View_btn,Check_btn,logout_btn;
	
	public EmployePage(String name){
		setTitle("Employe Page");
		setDefaultCloseOperation(3);
		setVisible(true);
		setSize(1600,900);
		this.name=name;
		p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();p5=new JPanel();
		welc_lab=new JLabel();
		p1.add(welc_lab);
		//5e0231
		p1.setBackground(java.awt.Color.decode("#ffffff"));// bade 7ot soura
		p1.setPreferredSize(new Dimension(120,120));
		this.add(p1,BorderLayout.NORTH);
		/*image=new ImageIcon(getClass().getResource("insurancee.jpg"));
	    img1_lab=new JLabel(image);
	    
	    p2.add(img1_lab);
		this.add(p2,BorderLayout.EAST);
		*/
		p2.setBackground(java.awt.Color.decode("#ffffff"));// bade 7ot soura
		p2.setPreferredSize(new Dimension(120,120));
		p3.setBackground(java.awt.Color.decode("#ffffff"));
		p3.setPreferredSize(new Dimension(120,120));
		p4.setBackground(java.awt.Color.decode("#ffffff"));
		p4.setPreferredSize(new Dimension(120,120));
		this.add(p2,BorderLayout.WEST);
		this.add(p3,BorderLayout.EAST);
		this.add(p4,BorderLayout.SOUTH);
		p5.setLayout(new GridLayout(2,3,50,50));
		p5.setBackground(java.awt.Color.decode("#ffffff"));
		ImageIcon LifeIns = new ImageIcon(getClass().getResource("l.jpg"));
		ImageIcon HospIns = new ImageIcon(getClass().getResource("hh.jpg"));
		ImageIcon CarIns = new ImageIcon(getClass().getResource("carr.jpg"));
		ImageIcon ViewIns = new ImageIcon(getClass().getResource("view.png"));
		ImageIcon CheckIns = new ImageIcon(getClass().getResource("clie.jpg"));
		ImageIcon LogoutIns = new ImageIcon(getClass().getResource("log.png"));
		Life_but=new JButton("",LifeIns);// ba3tiha hon el image
		Car_but=new  JButton("",CarIns);
		Hosp_btn=new JButton("",HospIns);// ba3tiha hon el image
		View_btn=new  JButton("",ViewIns);
		Check_btn=new JButton("",CheckIns); // bzid mina client 
		logout_btn=new JButton("",LogoutIns);
		p5.add(Life_but);p5.add(Car_but);p5.add(Hosp_btn);p5.add(View_btn);p5.add(Check_btn);p5.add(logout_btn);
		this.add(p5,BorderLayout.CENTER);
		Life_but.addActionListener(new ButtonHandler());
		Car_but.addActionListener(new ButtonHandler());
		Hosp_btn.addActionListener(new ButtonHandler());
		View_btn.addActionListener(new ButtonHandler());
		Check_btn.addActionListener(new ButtonHandler());
		logout_btn.addActionListener(new ButtonHandler());
	}
	
	public void display(){
		name="WELCOME "+name;
		welc_lab.setFont(new Font("Calibri",Font.BOLD,70));
		welc_lab.setForeground(Color.gray);
		welc_lab.setText(name);
	}
	
	public class ButtonHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource()==Life_but){
				//bade eb3at ma3o el app number
				
				LifeInsurance life=new LifeInsurance(name);
				setVisible(false);
				
			}
			if(ev.getSource()==logout_btn){
				String[]ars=new String[2];
				ars[0]="b";ars[1]="c";
				try {
					CustomApp.main(ars);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				dispose();
			}
			
			if(ev.getSource()==Hosp_btn){

				HospInsurance hosp=new HospInsurance(name);
				setVisible(false);
			}
			if(ev.getSource()==Car_but){

				CarInsurance hosp=new CarInsurance(name);
				setVisible(false);
			}
			if(ev.getSource()==View_btn){

				ViewPage v=new ViewPage(name);
				setVisible(false);
			}
			if(ev.getSource()==Check_btn){

				ClientAdd c=new ClientAdd(name);
				setVisible(false);
			}
			
		}
		
	}
}
