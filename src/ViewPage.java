
import java.awt.BorderLayout;
import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement; import java.util.logging.Level; import java.util.logging.Logger; 


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.directory.ModificationItem;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
public class ViewPage extends JFrame{
	String name;
	public JPanel p,p1,p2,p3,p4,p5,p6;
	public JLabel pass_lab,text;
	public JComboBox pass_cmb;
	public ArrayList ids,infos;
	public ArrayList lifeFields,carFields,hospFields;
	public JTable table,tableLife,tablehosp;
	public JButton back;
	Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	public Font f;
	public DefaultTableModel model,model2,model3;
     ViewPage(String name){
    	 setTitle("View Insurances");
  	   setVisible(true);
  	   setSize(1600,900);
  	  ids=new ArrayList();infos=new ArrayList();
  	 
  	   setDefaultCloseOperation(3);
    	 this.name=name;
    	 p=new JPanel();p1=new JPanel();
    	 p2=new JPanel(); p3=new JPanel();p4=new JPanel();p5=new JPanel();
		 p2.setBackground(java.awt.Color.decode("#d3d3d3"));
	  	  p3.setBackground(java.awt.Color.decode("#d3d3d3"));
		    p4.setBackground(java.awt.Color.decode("#d3d3d3"));
		       	 p1.setLayout(new FlowLayout());p2.setLayout(new FlowLayout());p3.setLayout(new FlowLayout());
	    	 p.setLayout(new GridLayout(4,0));p4.setLayout(new FlowLayout());p5.setLayout(new FlowLayout());
    	 p.setBackground(java.awt.Color.decode("#d3d3d3"));
  	    p1.setBackground(java.awt.Color.decode("#d3d3d3"));
  	     p5.setBackground(java.awt.Color.decode("#d3d3d3"));
  	    back=new JButton("<== Back");
  	    back.setPreferredSize(new Dimension(250,50));
  	  back.setBackground(java.awt.Color.decode("#dda0dd"));
  	    p5.add(back);
    	 pass_lab=new JLabel("Enter Client's password : ");
         f=new Font("Serif",Font.PLAIN,30);
    	 pass_lab.setFont(f);
    	 selectId();
    	 table=new JTable();
    	 tableLife=new JTable();tablehosp=new JTable();
    	 String[]entetes={"Name","Adress","Tel","Job","Birth Date"};
    	 p1.add(pass_lab);p1.add(pass_cmb);
    	 model=new DefaultTableModel(new String[]{"Name","Adress","Tel","Job","Birth Date"},0);
    	 model.addRow(new String[]{"Name","Adress","Tel","Job","Birth Date"});
    	  model2=new DefaultTableModel(new String[]{"Type","Client pass","App Number","Date","First Benificiary","Second Benificiary","Limit of Covering"},0);
    	 model2.addRow(new String[]{"Type","Client pass","App Number","Date","First Benificiary","Second Benificiary","Limit of Covering"});
    	 model3=new DefaultTableModel(new String[]{"Type","Client pass","App Number","Date","Gender","Salary","Limit of Covering"},0);
    	 model3.addRow(new String[]{"Type","Client pass","App number","Date","Gender","Salary","Limit of Covering"});
    	 back.addActionListener(new ButtonHandler());
    	 pass_cmb.addActionListener(new ActionListener(){
    		 public void actionPerformed(ActionEvent e) {
    			 
    			// table=new JTable(model);
    	          table.setModel(model);
    	          p2.add(table);
    	          text=new JLabel("All Insurances he made are listed below :))");
    		        text.setFont(f);
    		        p3.add(text);
    	          
    	          p.add(p2);
    	         // p.add(p3);
    				Long pass=(Long)pass_cmb.getSelectedItem();
    				String query="select * from clients where idClient='"+ pass + "'";
    				FillInfo(query);
    				// bado yshouf eza hayda el id mwjoud bl lifeinsurance krmel y3abe panel p4 bl table w yzida 3al p
    				if(RetrieveIdLife(pass)){
    					//3endo life insurance
    					FillLifeInsuranceInfo(pass);
    					
    				}
    		        if(RetrieveIdHosp(pass)){
    		        	
    		        	FillHospInsuranceInfo(pass);
    		        }
    		          //hon bde zid 3al p el p4 li t3abet  
    		        p.add(p4);
    		        p.add(p5);
    			}
    	 });
    	
    	
          //Add the scroll pane to this panel.
          p.add(p1);
          this.add(p);
    	  
    	 
     }
     public class ButtonHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource()==back){
				EmployePage p=new EmployePage(name);
				dispose();
				setVisible(false);
				p.setVisible(true);
			}
			
		}
    	 
     }
     public void FillInfo(String query){
    	 try
		    {
		    
		      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
		      
		      stmt = dbCon.createStatement();
		      rs = stmt.executeQuery(query);
		      while (rs.next())
		      {
		        
		        String name=rs.getString("ClientName");
		        String adr=rs.getString("Adr");
		        long tel=rs.getLong("Tel");
		        String job=rs.getString("Job");
		       String birth=rs.getString("BirthDate");
		       model.addRow(new Object[]{name,adr,tel,job,birth});
		      } 
		      dbCon.close();
		    }
		    catch (Exception ev)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ev.getMessage());
		    }
			
     }
     
     public void FillLifeInsuranceInfo(long pass){
    	// tableLife=new JTable(model2);
    	 tableLife.setModel(model2);
    	 //bade shil el ma3loumet min database lifeinsurance 3an hayda el client
    	 String query="select * from lifeinsurance where ClientId='"+ pass +"'";
    	 String type="Life Insurance";
    	 try
		    {
		    
		      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
		      
		      stmt = dbCon.createStatement();
		      rs = stmt.executeQuery(query);
		      while (rs.next())
		      {
		        
		       long app=rs.getLong("IDapp");
		        String dateIns=rs.getString("DateIns");
		        String fb=rs.getString("FBen");
		        String sb=rs.getString("SBen");
		       String lim=rs.getString("LimitCov");
		       model2.addRow(new Object[]{type,pass,app,dateIns,fb,sb,lim});
		      } 
		      dbCon.close();
		    }
		    catch (Exception ev)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ev.getMessage());
		    }
    	 p4.add(tableLife);
    	 
     }
     
     public void FillHospInsuranceInfo(long pass){
    	// tablehosp=new JTable(model3);
    	 tablehosp.setModel(model3);
    	 //bade shil el ma3loumet min database lifeinsurance 3an hayda el client
    	 String query="select * from hospinsurance where ClientIdH='"+ pass +"'";
    	 String type="Hospitalization Insurance";
    	 try
		    {
		    
		      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
		      
		      stmt = dbCon.createStatement();
		      rs = stmt.executeQuery(query);
		      while (rs.next())
		      {
		        
		       long app=rs.getLong("IDhos");
		       
		        String dateIns=rs.getString("DateHos");
		        String gender=rs.getString("Gender");
		        String sal=rs.getString("Salary");
		       String lim=rs.getString("LimitHos");
		       model3.addRow(new Object[]{type,pass,app,dateIns,gender,sal,lim});
		      } 
		      dbCon.close();
		    }
		    catch (Exception ev)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(ev.getMessage());
		    }
    	 p4.add(tablehosp);
     }
     
     public boolean RetrieveIdLife(long pass){
    	 boolean val=true;
    	 String query="select ClientId from lifeinsurance where ClientId='"+ pass + "'";
    	 try
  	    {
  	    
  	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
  	      
  	      stmt = dbCon.createStatement();
  	      rs = stmt.executeQuery(query);
  	       val=rs.next();
  	     
  	    	  
  	      dbCon.close();
  	    }
  	    catch (Exception e)
  	    {
  	      System.err.println("Got an exception! ");
  	      System.err.println(e.getMessage());
  	    }
    	 if(val)
    		 
    		 return true;
    	 else
    		 return false;
  	  
     }
     
     public boolean RetrieveIdHosp(long pass){
    	 boolean val=true;
    	 String query="select ClientIdH from hospinsurance where ClientIdH='"+ pass + "'";
    	 try
  	    {
  	    
  	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
  	      
  	      stmt = dbCon.createStatement();
  	      rs = stmt.executeQuery(query);
  	       val=rs.next();
  	     
  	    	  
  	      dbCon.close();
  	    }
  	    catch (Exception e)
  	    {
  	      System.err.println("Got an exception! ");
  	      System.err.println(e.getMessage());
  	    }
    	 if(val)
    		 
    		 return true;
    	 else
    		 return false;
  	  
     }
     
     
     public void selectId(){
     	String query="select idClient from clients";
     	ExecuteCon(query);
     }
     public void ExecuteCon(String query){

     	//ids bade 3abyon min database
     	try
 	    {
 	    
 	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
 	      
 	      stmt = dbCon.createStatement();
 	      rs = stmt.executeQuery(query);
 	      while (rs.next())
 	      {
 	        
 	        long id = rs.getLong("idClient");
 	        
 	        ids.add(id);
 	       
 	      } 
 	      dbCon.close();
 	    }
 	    catch (Exception e)
 	    {
 	      System.err.println("Got an exception! ");
 	      System.err.println(e.getMessage());
 	    }
 	  
     	 pass_cmb=new JComboBox(ids.toArray());
     
     }
    
    
     
}
