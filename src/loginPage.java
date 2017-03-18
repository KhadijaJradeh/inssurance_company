import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.event.*;

import java.awt.event.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BgPanel extends JPanel{
	Image bg = new ImageIcon("login.png").getImage();
	public void paintComponent(Graphics g){
		g.drawImage(bg,0,0,getWidth(),getHeight(),this);
	}
}

public class loginPage extends JFrame{
    public JLabel name_lab,pass_lab,TypeUser_lab,ShowPass_lab;
    public JTextField name_TF;
    public JPasswordField pass_TF;
    public JComboBox users_comb;
    public JCheckBox showPass_check;
    public JButton login_but,reset_but;
    public JPanel p1,p2,p3,p4,p44,p5,p6;
    public JLabel Description_lab,img1_lab;
    public ImageIcon image;
    public JPanel bgPanel;
    Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	public loginPage() {
		
	setTitle("Login Page ");	
	setSize(900,900);
	setVisible(true);
	String[]arr=new String[2];
	bgPanel=new BgPanel();
	bgPanel.setLayout(new BorderLayout());
	p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();p5=new JPanel();p6=new JPanel();
	this.setLayout(new BorderLayout());
	p1.setLayout(new FlowLayout());
	Description_lab=new JLabel("LOGIN PLEASE");
	p1.setPreferredSize(new Dimension(160,140));
	Description_lab.setFont(new java.awt.Font("Tahoma", 0, 22));
	
	p1.add(Description_lab,SwingConstants.CENTER);
	this.add(p1,BorderLayout.NORTH);
	p1.setBackground(java.awt.Color.decode("#a0a0a0"));
	
	name_lab=new JLabel("Enter your name : ");
	name_TF=new JTextField(15);
	pass_lab=new JLabel("Enter your password : ");
	pass_TF=new JPasswordField(15);
	//ShowPass_lab=new JLabel("Show Password");
	showPass_check=new JCheckBox("Show Password");
	TypeUser_lab=new JLabel("Select the user :");
	arr[0]="Employe";arr[1]="Customer";
	users_comb=new JComboBox(arr);
	p2.setLayout(new FlowLayout());
	p3.setLayout(new GridLayout(3,2));//tnen fadyin krmel el shakl
	p4.setLayout(new FlowLayout());
	login_but=new JButton("Login");
	login_but.setPreferredSize(new Dimension(160,50));
	reset_but=new JButton("Reset");
	reset_but.setPreferredSize(new Dimension(160,50));
	p3.add(name_lab);p3.add(name_TF);p3.add(pass_lab);p3.add(pass_TF);
	p3.setBackground(java.awt.Color.decode("#cce5ff"));
	p4.add(showPass_check);
	//p4.add(ShowPass_lab);
	p3.add(TypeUser_lab);p3.add(users_comb);
	p4.setBackground(java.awt.Color.decode("#cce5ff"));
	p2.add(p3);
	
    
	p2.add(p4);
	p2.setPreferredSize(new Dimension(200,200));
	Box box = new Box(BoxLayout.Y_AXIS);
	box.setBackground(java.awt.Color.decode("#cce5ff"));
	p2.setBackground(java.awt.Color.decode("#cce5ff"));
    box.add(Box.createVerticalGlue());
    box.add(p2);   
    box.add(Box.createVerticalGlue());
   

   
   
	

	this.add(box);
	
	
	//this.add(p2);
	
	
	
	p5.setLayout(new FlowLayout());
	
	p5.add(login_but);
	p5.add(reset_but);
	
	p5.setBackground(java.awt.Color.decode("#a0a0a0"));
	p5.setPreferredSize(new Dimension(160,140));
	this.add(p5,BorderLayout.SOUTH);
	
    showPass_check.addItemListener(new checkboxListener());
    login_but.addActionListener(new ButtonHandler());
    reset_but.addActionListener(new ButtonHandler());
	} //fin class login
	
	public class checkboxListener implements ItemListener{

		
		 public void itemStateChanged(ItemEvent e) {
		       if( showPass_check.isSelected()){
		 
		    	   pass_TF.setEchoChar((char)0);
		      }
			
		}
			
		
		
	} // fin class checkboxlistener
	
	public class ButtonHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent ev) {
			//si j'ai presse login button
			if(ev.getSource()==login_but){
				//iza houwe employe ma bshil esmo min el database 
				if(users_comb.getSelectedItem().equals("Employe")){
					if(name_TF.getText().equals("Maysa")||name_TF.getText().equals("Kadi")){
						if(pass_TF.getText().equals("swing")){
							EmployePage emp=new EmployePage(name_TF.getText());
							//emp.show();
							emp.display();
							setVisible(false);
						}
						else { // pass 8alat
							JOptionPane.showMessageDialog(null,"You entered an invalid name or password !");
						}
					}//esm 
					else
						JOptionPane.showMessageDialog(null,"You entered an invalid name or password !");
				}
				//eza houwe customer bade shoufo bl database
				else if(users_comb.getSelectedItem().equals("Customer")){
					//fetch in the database , in the table of customers
					if(Registered(name_TF.getText(),pass_TF.getText()))
					{
						ClientPage c=new ClientPage(name_TF.getText());
						setVisible(false);
					}
					else 
						JOptionPane.showMessageDialog(null,"You entered an invalid name or password , Please try again!");
				}
			}
			
			else 
				//if j'ai presse reset button 
				if(ev.getSource()==reset_but){
					name_TF.setText("");
					pass_TF.setText("");
					
				}
			
		}
		
	}

    
	       public boolean Registered(String name,String pass){
	    	   int x=0;
	    	   try
	   	    {
	   	    
	   	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
	   	      
	   	      stmt = dbCon.createStatement();
	   	      String query="select idClient,ClientName from clients";
	   	      long passs=Long.parseLong(pass);
	   	      rs = stmt.executeQuery(query);
	   	      while (rs.next())
	   	      {
	   	        
	   	        long p = rs.getLong("idClient");
	   	        String nomC=rs.getString("ClientName");
	   	        if((nomC.equals(name))&&(p==passs) ){
	   	        	x=1;
	   	        }
	   	        
	   	       
	   	      } 
	   	   dbCon.close();
	   	     
	   	      
	   	    }
	   	    catch (Exception e)
	   	    {
	   	      System.err.println("Got an exception! ");
	   	      System.err.println(e.getMessage());
	   	    }
	   	  
	    	   if(x==0)
		   	    	  return false;
		   	      else 
		   	    	 return true;
	       }
}// fin grande classe 
