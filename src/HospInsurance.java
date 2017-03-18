import javax.swing.JComboBox;
import javax.swing.JFrame;


import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement; import java.util.logging.Level; import java.util.logging.Logger; 


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.directory.ModificationItem;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;


public class HospInsurance extends JFrame{
	
	String nom;
	public JMenuBar bar;
	public JMenu AddIns;
	public JMenu ModifyIns;
	public JMenu DisplayIns;
	public Calendar cal;
	public CardLayout c1;
	Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	String formatted;
	 public JPanel pAdd,pModify,pDisplay,cards; // cards el kbire w el be2e hine li taba 3kl menu 
	 public JPanel p1Add,p2Add,p3Add,p4Add;
	 public JPanel p1Modify,p2Modify,p3Modify,p4Modify;
	 public JPanel p1Display,p2Display,p3Display,p4Display;
	 public JLabel Apass_lab,Agend_lab,ASal_lab,AVal_lab; // labels tba3 el add menu
	 public JComboBox Apass_cmb,AGend_cmb,AValid_cmb;
	 public JTextField ASal_tf,MSal_tf;
	 public JButton save,back1,edit,back2,back3;
	 public JLabel Mpass_lab,MGend_lab,MSal_lab,MVal_lab;
	 public JComboBox Mpass_cmb,MGend_cmb,MValid_cmbs;
	 public JLabel Dpass_lab,Dapp_lab,Ddate_lab,Dname_lab,Djob_lab,Dlim_lab;
	 public JLabel Dapp_tf,Ddate_tf,Dname_tf,Djob_tf,Dlim_tf,DGender_lab,DGender_tf,DSal_lab,DSal_tf;
	 public JComboBox Dpass_comb;
	
	 public JLabel DFather_lab,DMother_lab,DAdr_lab,DTel_lab,DFB_lab,DSB_lab,DState_lab,DnbChild_lab,Dlimit_lab;
		
		public JLabel DFather_tf,DMother_tf,DAdr_tf,DTel_tf,DFB_tf,DSB_tf,DState_tf,DnbChild_Tf,Dlimit_tf;
		public JLabel birthDate_lab,birthPlace_lab,birthDate_tf,birthPlace_tf;
	public ArrayList ids,pass;
	
		HospInsurance(String name){   // constructeur 
			
			setTitle("Hospitalization Insurance");
			setVisible(true);
			setSize(600,600);
			this.nom=name;
			setDefaultCloseOperation(3);
			
			// 3am zid el menus 3al menu bar
			ids=new ArrayList();
			pass=new ArrayList();
			bar=new JMenuBar();
			   AddIns=new JMenu("Add Insurance");
			   ModifyIns=new JMenu("Modify Insurance");
			   DisplayIns=new JMenu("Display Insurance");
			   AddIns.setPreferredSize(new Dimension(200,50));
			   AddIns.setFont(new Font("Calibri",Font.BOLD,20));
			   ModifyIns.setPreferredSize(new Dimension(200,50));
			   ModifyIns.setFont(new Font("Calibri",Font.BOLD,20));
			   DisplayIns.setPreferredSize(new Dimension(200,50));
			   DisplayIns.setFont(new Font("Calibri",Font.BOLD,20));
			   // 3am el2at el date taba3 el yom bishakl m3ayan
			   cal = Calendar.getInstance();
		       SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
		        formatted = format1.format(cal.getTime());
		        //be5la2 el shakl 
		        pAdd=new JPanel();pModify=new JPanel();pDisplay=new JPanel();
			 	cards=new JPanel(); // hayde el panel el bay w wleda hina li kl ma ekbos menu jdide bibayn wa7ad minoon
			 	
		       // /////////////////////////////////////Padd menu 
			 	
			 	p1Add=new JPanel();p2Add=new JPanel();p3Add=new JPanel();p4Add=new JPanel();
			 	Font f=new Font("Serif",Font.PLAIN,30);
		        Apass_lab=new JLabel("Enter Client's password : ");Apass_lab.setFont(f);
		        selectId();
		        Apass_cmb.setPreferredSize(new Dimension(100,30));
		        Agend_lab=new JLabel("Gender :");
		        Agend_lab.setFont(f);
		        String[]gender=new String[2];
		        gender[0]="Male";gender[1]="Female";
		        AGend_cmb=new JComboBox(gender);
		        AGend_cmb.setPreferredSize(new Dimension(100,40));
		        ASal_lab=new JLabel("Salary : ");
		        ASal_lab.setFont(f);
		        ASal_tf=new JTextField(15);
		        Font ftf=new Font("Serif",Font.PLAIN,20);
		        ASal_tf.setFont(ftf);
		        
		        AVal_lab=new JLabel("Limit Of Covering : ");
		        AVal_lab.setPreferredSize(new Dimension(300,50));
		        AVal_lab.setFont(f);
		        String[]valid=new String[4];
		        valid[0]="5000 $";valid[1]="7500 $";valid[2]="10000 $";valid[3]="20000 $";
		        AValid_cmb=new JComboBox(valid);
		        AValid_cmb.setPreferredSize(new Dimension(100,30));
		        back1=new JButton("<== Back");
		        
		        save=new JButton("Save");
		        save.setBackground(java.awt.Color.decode("#dda0dd"));
		        save.setPreferredSize(new Dimension(250,50));
		        back1.setPreferredSize(new Dimension(250,50));
		        back1.setBackground(java.awt.Color.decode("#dda0dd"));
                pAdd.setLayout(new GridLayout(4,0));
                p1Add.setLayout(new FlowLayout());
                p2Add.setLayout(new FlowLayout());
                p3Add.setLayout(new FlowLayout());
                p4Add.setLayout(new FlowLayout());
		        p1Add.add(Apass_lab);p1Add.add(Apass_cmb);
		        p2Add.add(Agend_lab);p2Add.add(AGend_cmb);
		        p2Add.add(ASal_lab);p2Add.add(ASal_tf);
		        p3Add.add(AVal_lab);p3Add.add(AValid_cmb);
		        p4Add.add(back1);
		        p4Add.add(save);
                pAdd.setBackground(java.awt.Color.decode("#d3d3d3"));
                p1Add.setBackground(java.awt.Color.decode("#d3d3d3"));
                p2Add.setBackground(java.awt.Color.decode("#d3d3d3"));
                p3Add.setBackground(java.awt.Color.decode("#d3d3d3"));
                p4Add.setBackground(java.awt.Color.decode("#d3d3d3"));
                
                pAdd.add(p1Add);pAdd.add(p2Add);pAdd.add(p3Add);pAdd.add(p4Add);
                
                //////  el maken el ahbal 
                
   	    	 
   	    	 
   	    	
                ///////////////////////////////////// pModify Menu 
                p1Modify=new JPanel();p2Modify=new JPanel();p3Modify=new JPanel();p4Modify=new JPanel();
               
		        Mpass_lab=new JLabel("Enter Client's password : ");Mpass_lab.setFont(f);
		        selectIdFromHosInsurance();
		        Mpass_cmb=new JComboBox(pass.toArray());
	   	    	 Mpass_cmb.setPreferredSize(new Dimension(100,30));
		       
		        MGend_lab=new JLabel("Gender :");
		        MGend_lab.setFont(f);
		        MGend_lab.setEnabled(false);
		        MGend_cmb=new JComboBox(gender);
		        MGend_cmb.setEnabled(false);
		        MGend_cmb.setPreferredSize(new Dimension(100,40));
		        MSal_lab=new JLabel("Salary : ");
		        MSal_lab.setFont(f);
		        MSal_lab.setEnabled(false);
		        MSal_tf=new JTextField(15);
		        MSal_tf.setFont(ftf);
		        MSal_tf.setEnabled(false);
		        MVal_lab=new JLabel("Limit Of Covering : ");
		        MVal_lab.setPreferredSize(new Dimension(300,50));
		        MVal_lab.setFont(f);
		        MVal_lab.setEnabled(false);
		 
		        MValid_cmbs=new JComboBox(valid);
		        MValid_cmbs.setPreferredSize(new Dimension(100,30));
		        MValid_cmbs.setEnabled(false);
		        back2=new JButton("<== Back");
		        back2.setBackground(java.awt.Color.decode("#dda0dd"));
		        edit=new JButton("Edit ");
		        edit.setPreferredSize(new Dimension(250,50));
		        edit.setBackground(java.awt.Color.decode("#dda0dd"));
		        back2.setPreferredSize(new Dimension(250,50));
                pModify.setLayout(new GridLayout(4,0));
                p1Modify.setLayout(new FlowLayout());
                p2Modify.setLayout(new FlowLayout());
                p3Modify.setLayout(new FlowLayout());
                p4Modify.setLayout(new FlowLayout());
		        p1Modify.add(Mpass_lab);p1Modify.add(Mpass_cmb);
		        p2Modify.add(MGend_lab);p2Modify.add(MGend_cmb);
		        p2Modify.add(MSal_lab);p2Modify.add(MSal_tf);
		        p3Modify.add(MVal_lab);p3Modify.add(MValid_cmbs);
		        p4Modify.add(back2);
		        p4Modify.add(edit);
                pModify.setBackground(java.awt.Color.decode("#d3d3d3"));
                p1Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
                p2Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
                p3Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
                p4Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
                
                back3=new JButton("<== Back");
                back3.setBackground(java.awt.Color.decode("#dda0dd"));
                
                /// 3am zidon ta7t 3al pModify 
                pModify.add(p1Modify);pModify.add(p2Modify);pModify.add(p3Modify);pModify.add(p4Modify);
                
                //pDisplay ///////////////////////////////////
                pDisplay=new JPanel(); p1Display=new JPanel(); p2Display=new JPanel(); p3Display=new JPanel(); p4Display=new JPanel();
                Dpass_lab=new JLabel("Choose Client's password :");
                Dpass_lab.setFont(f);
              //  Dpass_comb=new JComboBox(pass.toArray());
               // selectIdFromHosInsurance();
                Dpass_comb=new JComboBox(pass.toArray());
                
                Dpass_comb.setPreferredSize(new Dimension(100,30));
   	    	
                //
                pDisplay.setLayout(new GridLayout(4,1));
         	   p1Display.setLayout(new FlowLayout());
         	   p2Display.setLayout(new GridLayout(7,4));
         	   p3Display.setLayout(new FlowLayout());
         	   p4Display.setLayout(new FlowLayout());
         	   ////////////////////////////////////bade zid 3a pDisplay
         	  
         	   Dapp_lab=new JLabel("",SwingConstants.RIGHT);
         	   Dapp_lab.setFont(f);
         	   Dapp_lab.setEnabled(false);
         	   Dapp_tf=new JLabel();
         	   Dapp_tf.setEnabled(false);
         	   Dapp_tf.setFont(f);
         	   
         	   Ddate_lab=new JLabel("",SwingConstants.RIGHT);
         	   Ddate_lab.setFont(f);
         	   Ddate_lab.setEnabled(false);
         	   Ddate_tf=new JLabel();
         	   Ddate_tf.setFont(f);
         	   Ddate_tf.setEnabled(false);
         	   //client name
         	   Dname_lab=new JLabel("",SwingConstants.RIGHT);
         	   Dname_lab.setFont(f);
         	   Dname_lab.setEnabled(false);
         	   Dname_tf=new JLabel();
         	   Dname_tf.setFont(f);
         	   Dname_tf.setEnabled(false);
         	   //job 
         	   Djob_lab=new JLabel("",SwingConstants.RIGHT);
         	   Djob_lab.setFont(f);
         	   Djob_lab.setEnabled(false);
         	   Djob_tf=new JLabel();
         	   Djob_tf.setFont(f);
         	   Djob_tf.setEnabled(false);
         	   //fath
         	   DFather_lab=new JLabel("",SwingConstants.RIGHT);
         	   DFather_lab.setFont(f);
         	   DFather_lab.setEnabled(false);
         	   DFather_tf=new JLabel();
         	   DFather_tf.setFont(f);
         	   DFather_tf.setEnabled(false);
         	   //moth
         	   DMother_lab=new JLabel("",SwingConstants.RIGHT);
         	   DMother_lab.setFont(f);
         	   DMother_lab.setEnabled(false);
         	   DMother_tf=new JLabel();
         	   DMother_tf.setFont(f);
         	   DMother_tf.setEnabled(false);
         	   //birthdate
         	   birthDate_lab=new JLabel("",SwingConstants.RIGHT);
         	   birthDate_lab.setFont(f);
         	   birthDate_lab.setEnabled(false);
         	   birthDate_tf=new JLabel();
         	   birthDate_tf.setFont(f);
         	   birthDate_tf.setEnabled(false);
         	   //birthplace
         	   birthPlace_lab=new JLabel("",SwingConstants.RIGHT);
         	   birthPlace_lab.setFont(f);
         	   birthPlace_lab.setEnabled(false);
         	   birthPlace_tf=new JLabel();
         	   birthPlace_tf.setFont(f);
         	   birthPlace_tf.setEnabled(false);
         	   //adr
         	   DAdr_lab=new JLabel("",SwingConstants.RIGHT);
         	   DAdr_lab.setFont(f);
         	   DAdr_lab.setEnabled(false);
         	   DAdr_tf=new JLabel();
         	   DAdr_tf.setFont(f);
         	   DAdr_tf.setEnabled(false);
         	   //tel
         	   DTel_lab=new JLabel("",SwingConstants.RIGHT);
         	   DTel_lab.setFont(f);
         	   DTel_lab.setEnabled(false);
         	   DTel_tf=new JLabel();
         	   DTel_tf.setFont(f);
         	   DTel_tf.setEnabled(false);
         	   //FB
         	   DGender_lab=new JLabel("",SwingConstants.RIGHT);
         	   DGender_lab.setFont(f);
         	   DGender_lab.setEnabled(false);
         	   DGender_tf=new JLabel();
         	   DGender_tf.setFont(f);
         	   DGender_tf.setEnabled(false);
         	   //SB
         	   DSal_lab=new JLabel("",SwingConstants.RIGHT);
         	   DSal_lab.setFont(f);
         	   DSal_lab.setEnabled(false);
         	   DSal_tf=new JLabel();
         	   DSal_tf.setFont(f);
         	   DSal_tf.setEnabled(false);
         	   //State
         	   DState_lab=new JLabel("",SwingConstants.RIGHT);
         	   DState_lab.setFont(f);
         	   DState_lab.setEnabled(false);
         	   DState_tf=new JLabel();
         	   DState_tf.setFont(f);
         	   DState_tf.setEnabled(false);
         	   //nbChilds
         	   DnbChild_lab=new JLabel("",SwingConstants.RIGHT);
         	   DnbChild_lab.setFont(f);
         	   DnbChild_lab.setEnabled(false);
         	   DnbChild_Tf=new JLabel();
         	   DnbChild_Tf.setFont(f);
         	   DnbChild_Tf.setEnabled(false);
         	   //limit 
         	   Dlimit_lab=new JLabel("",SwingConstants.RIGHT);
         	   Dlimit_lab.setFont(f);
         	   Dlimit_lab.setEnabled(false);
         	   Dlimit_tf=new JLabel();
         	   Dlimit_tf.setFont(f);
         	   Dlimit_tf.setEnabled(false);
         	   pDisplay.setBackground(java.awt.Color.decode("#d3d3d3"));
         	   p1Display.setBackground(java.awt.Color.decode("#d3d3d3"));
         	   p2Display.setBackground(java.awt.Color.decode("#d3d3d3"));
         		  
         	   p3Display.setBackground(java.awt.Color.decode("#d3d3d3"));
         	   //bzid el elements 3ala el panels 
         	   p1Display.add(Dpass_lab);p1Display.add(Dpass_comb);
         	   p2Display.add(Dapp_lab);p2Display.add(Dapp_tf);
         	   p2Display.add(Ddate_lab);p2Display.add(Ddate_tf);
         	   p2Display.add(Dname_lab);p2Display.add(Dname_tf);
         	   p2Display.add(Djob_lab);p2Display.add(Djob_tf);
         	   p2Display.add(DFather_lab);p2Display.add(DFather_tf);
         	   p2Display.add(DMother_lab);p2Display.add(DMother_tf);
         	   p2Display.add(birthDate_lab);p2Display.add(birthDate_tf);
         	   p2Display.add(birthPlace_lab);p2Display.add(birthPlace_tf);
         	   p2Display.add(DAdr_lab);p2Display.add(DAdr_tf);
         	   p2Display.add(DTel_lab);p2Display.add(DTel_tf);
         	   p2Display.add(DGender_lab);p2Display.add(DGender_tf);
         	   p2Display.add(DSal_lab);p2Display.add(DSal_tf);
         	   p2Display.add(DState_lab);p2Display.add(DState_tf);
         	   p2Display.add(DnbChild_lab);p2Display.add(DnbChild_Tf);
         	  
         	   p3Display.add(Dlimit_lab);p3Display.add(Dlimit_tf);
         	  p4Display.setBackground(java.awt.Color.decode("#d3d3d3"));
         	    p4Display.add(back3);
         	   ///////////////////////////////////////////hon bzidon 3al pDisplay
         	     pDisplay.add(p1Display);
         	     pDisplay.add(p2Display);
         	     pDisplay.add(p3Display);
         	    pDisplay.add(p4Display);
                //
                back3.setPreferredSize(new Dimension(250,50));
                back3.setBackground(java.awt.Color.decode("#dda0dd"));
                
               
                //bzidon lal menus 3l menu bar 
		        bar.add(AddIns);
		 	   bar.add(ModifyIns);
		 	   bar.add(DisplayIns);
		 	   this.setJMenuBar(bar);
		 	   
		 	  
		 	   // kl panel bzdla wleda w buttons taba3a ..
		 	  c1=new CardLayout();
			   cards.setLayout(c1); 
			   cards.add(pAdd,"1"); //hayde el panel taba3 el add
			   cards.add(pModify,"2");//hhayde el panel taba3 el modify
			   cards.add(pDisplay,"3");// hhayde panel taba3 el display
			   Mpass_cmb.addActionListener(new CombListener());
			   save.addActionListener(new ButtonHandler());
			   edit.addActionListener(new ButtonHandler());
			   Dpass_comb.addActionListener(new CombListener());
			   back1.addActionListener(new ButtonHandler());
			   back2.addActionListener(new ButtonHandler());
			   back3.addActionListener(new ButtonHandler());
			
			   //listeners hon
			   AddIns.addMenuListener(new MenuListener() {
				   
					@Override
					public void menuSelected(MenuEvent e) {
						
						c1.show(cards,"1");
						
					}
					
					
					public void menuDeselected(MenuEvent e) {
						
						
					}
					
					@Override
					public void menuCanceled(MenuEvent e) {
						
						
					}
				   });
				   ModifyIns.addMenuListener(new MenuListener() {
					   
						@Override
						public void menuSelected(MenuEvent e) {
							
							c1.show(cards,"2");
							 
							 
							
						}
						
						
						public void menuDeselected(MenuEvent e) {
							
							
						}
						
						@Override
						public void menuCanceled(MenuEvent e) {
							
							
						}
					   });
				   DisplayIns.addMenuListener(new MenuListener() {
					   
						@Override
						public void menuSelected(MenuEvent e) {
							
							c1.show(cards,"3");
							
							
						}
						
						
						public void menuDeselected(MenuEvent e) {
							
							
						}
						
						@Override
						public void menuCanceled(MenuEvent e) {
							
							
						}
					   });
			       
				   this.add(cards,BorderLayout.CENTER);
		}
		
		
		public void FillExecuteCon(String query){
			   try
			    {
			    
			      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
			      
			      stmt = dbCon.createStatement();
			      rs = stmt.executeQuery(query);
			      while (rs.next())
			      {
			        String gend=rs.getString("Gender");
			        String sal=rs.getString("Salary");
			        String lim=rs.getString("LimitHos");
			        MGend_cmb.setSelectedItem(gend);
			        MSal_tf.setText(sal);
			        MValid_cmbs.setSelectedItem(lim);
			        
			      } 
			      
			      MGend_lab.setEnabled(true);
			      MGend_cmb.setEnabled(true);
			      MSal_lab.setEnabled(true);
			      MSal_tf.setEnabled(true);
			      MVal_lab.setEnabled(true);
			      MValid_cmbs.setEnabled(true);
			      dbCon.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
			  
		   	
		   }
		public class CombListener implements ActionListener{

			
			public void actionPerformed(ActionEvent ev) {
				
				if(ev.getSource()==Mpass_cmb){
					Long Id=(Long)Mpass_cmb.getSelectedItem();
					String query="select * from hospinsurance where ClientIdH='"+ Id + "'";
					FillExecuteCon(query);
					}
				else if(ev.getSource()==Dpass_comb){
					//bade a3ml enable la kl el labels ma3 values bi albon min el database 
					Long pass=(Long)Dpass_comb.getSelectedItem();
					String query="select * " +
		             "from hospinsurance, clients " +
		             "where hospinsurance.ClientIdH  = clients.idClient  and " +
		             "clients.idClient= '" + pass + "' ";
					ExecuteJoinCon(query);
				}
			}
			
		}
		
		public void selectId(){
			String query="select idClient from clients";
	    	ExecuteCon(query);
		}
		
		public void selectIdFromHosInsurance(){
	    	String query="select ClientIdH from hospinsurance";
	    	ExecuteHosCon(query);
	    	
	    }
		
		public void ExecuteHosCon(String query){
	    	//pass bade 3abyon min database
		//	pass=new ArrayList();
	    	try
		    {
		    
		      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
		      stmt = dbCon.createStatement();
		      rs = stmt.executeQuery(query);
	      while (rs.next())
		      {
		        
		        long p = rs.getLong("ClientIdH");
		        System.out.println("Id : "+p);
		        pass.add(p);
		       
		      } 
		      dbCon.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  
      
	    	
	    	
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
		       // System.out.println(id);
		        ids.add(id);
		       
		      } 
		      dbCon.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  
	    	Apass_cmb=new JComboBox(ids.toArray());
	    	
	    
	    }
		
		
		 public void InsertCon(String query){
			   
			   try
			    {
			    
			      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany","root", "");
			      
			      stmt = dbCon.createStatement();
			       stmt.executeUpdate(query);
			      
			      dbCon.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
			  
		   	
		   }
		 
		 public void ExecuteJoinCon(String query){
		    	try
			    {
			    
			      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
			      
			      stmt = dbCon.createStatement();
			      rs = stmt.executeQuery(query);
			      while (rs.next())
			      {
			        
			       // long id = rs.getLong("idClient");
			       long appNum=rs.getLong("Idhos");
			       String dateIns=rs.getString("DateHos");
			       String gender=rs.getString("Gender");
			       String sal=rs.getString("Salary");
			       String lim=rs.getString("LimitHos");
			       String Name=rs.getString("ClientName");
			       String fath=rs.getString("FatherName");
			       String moth=rs.getString("MotherName");
			       String birthDate=rs.getString("BirthDate");
			       String birthPlace=rs.getString("BirthPlace");
			       String state=rs.getString("State");
			       int nbChild=rs.getInt("nbChild");
			       String job=rs.getString("Job");
			       String adr=rs.getString("Adr");
			       long tel=rs.getLong("Tel");
			       //casting 
			       
			       String app=String.valueOf(appNum);
			       String nbChi=String.valueOf(nbChild);
			       String tele=String.valueOf(tel);
			       //set Text lal labels li hine fiyon description 
			     //b3abe el textfields min database 
			       //enable la kl shi true lal labels wel textfields 
			       Dapp_lab.setText("Application Number : ");
			       Dapp_lab.setEnabled(true);
			       Dapp_tf.setEnabled(true);
			       Dapp_tf.setText(app);
			       
			       Ddate_lab.setText("Date of insurance : ");
			       Ddate_lab.setEnabled(true);
			       Ddate_tf.setEnabled(true);
			       Ddate_tf.setText(dateIns);
			       
			       Dname_lab.setText("Client's Name : ");
			       Dname_lab.setEnabled(true);
			       Dname_tf.setEnabled(true);
			       Dname_tf.setText(Name);
			       
			       Djob_lab.setText("Job  : ");
			       Djob_lab.setEnabled(true);
			       Djob_tf.setEnabled(true);
			       Djob_tf.setText(job);
			       
			       DFather_lab.setText("Father's name : ");
			       DFather_lab.setEnabled(true);
			       DFather_tf.setEnabled(true);
			       DFather_tf.setText(fath);
			       
			       DMother_lab.setText("Mother's name : ");
			       DMother_lab.setEnabled(true);
			       DMother_tf.setEnabled(true);
			       DMother_tf.setText(moth);
			       
			       birthDate_lab.setText("Birth Date : ");
			       birthDate_lab.setEnabled(true);
			       birthDate_tf.setEnabled(true);
			       birthDate_tf.setText(birthDate);
			       
			       birthPlace_lab.setText("Birth Place : ");
			       birthPlace_lab.setEnabled(true);
			       birthPlace_tf.setEnabled(true);
			       birthPlace_tf.setText(birthPlace);
			       

			       DAdr_lab.setText("Adress : ");
			       DAdr_lab.setEnabled(true);
			       DAdr_tf.setEnabled(true);
			       DAdr_tf.setText(adr);
			       

			       DTel_lab.setText("Tel  : ");
			       DTel_lab.setEnabled(true);
			       DTel_tf.setEnabled(true);
			       DTel_tf.setText(tele);
			       

			       DGender_lab.setText("Gender   : ");   
			       DGender_lab.setEnabled(true);
			       DGender_tf.setEnabled(true);
			       DGender_tf.setText(gender);
			       
			       DSal_lab.setText("Second Benificiary   : ");
			       DSal_lab.setEnabled(true);
			       DSal_tf.setEnabled(true);
			       DSal_tf.setText(sal);
			       

			       DState_lab.setText("Marital state : ");
			       DState_lab.setEnabled(true);
			       DState_tf.setEnabled(true);
			       DState_tf.setText(state);
			       

			       DnbChild_lab.setText("Number of Childs   : ");
			       DnbChild_lab.setEnabled(true);
			       DnbChild_Tf.setEnabled(true);
			       DnbChild_Tf.setText(nbChi);
			       
			      Dlimit_lab.setText("Limit Of Covering : ");
			      Dlimit_lab.setEnabled(true);
			      Dlimit_tf.setEnabled(true);
			      Dlimit_tf.setText(lim);
			      } 
			      dbCon.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
			  
		    	
		    	
		    }
		 public void UpdateCon(String query){
			   
			   try
			    {
			    
			      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany","root", "");
			      stmt = dbCon.createStatement();
			      int affectedRows=stmt.executeUpdate(query);
			      
			    if(affectedRows==1)
			    	System.out.println("bravo zobet el edit");
			      dbCon.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			    }
			  
		   	
		   }
		 
		 
		 
		public class ButtonHandler implements ActionListener{

			
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource()==save){
					String gend=(String)AGend_cmb.getSelectedItem();
					String sal=ASal_tf.getText();
					String limitt=(String)AValid_cmb.getSelectedItem();
					Long Id=(Long)Apass_cmb.getSelectedItem();
					if(Validate(sal)){
						//kilon m3abeyin sa7 b2oul Joption pane eno sayavna el insurance w bsayvon bl database
						
						JOptionPane.showMessageDialog(null,"Filled Successfully ");
					     //save
						
						cal = Calendar.getInstance();
					       SimpleDateFormat format2 = new SimpleDateFormat("YYYY-MM-dd");
					       String formated = format2.format(cal.getTime());
						String requete="INSERT INTO `hospinsurance` (DateHos,ClientIdH,Gender,Salary,LimitHos) VALUE ('"+ formated +"','"+ Id +"','"+ gend + "','"+ sal +"','"+ limitt +"')";
						InsertCon(requete);
						
						
					}
				
			}
				else if(ev.getSource()==edit){
					String gend=(String)MGend_cmb.getSelectedItem();
					String sal=MSal_tf.getText();
					String limitt=(String)MValid_cmbs.getSelectedItem();
					if(Validate(sal)){
						//kilon m3abeyin sa7 b2oul Joption pane eno sayavna el insurance w bsayvon bl database
						
						JOptionPane.showMessageDialog(null,"Edit acceptable ");
					     //save
						Long Id=(Long)Mpass_cmb.getSelectedItem();
						System.out.println(Id+"This is the id ");
						cal = Calendar.getInstance();
					       SimpleDateFormat format3 = new SimpleDateFormat("YYYY-MM-dd");
					       String formated = format3.format(cal.getTime());
						
						//String q="UPDATE lifeinsurance set FBen='"+ Fb +"'where IDapp ='"+ 1 + "'";
						String q="UPDATE hospinsurance set Gender='"+ gend + "', Salary='" + sal + "' , LimitHos='"+ limitt + "' where ClientIdH='"+ Id + "'";
						UpdateCon(q);
				        
						
					}

					
				}
				else if(ev.getSource()==back1 || ev.getSource()==back2 || ev.getSource()==back3){
					
					EmployePage g=new EmployePage(nom);
					dispose();
					setVisible(false);
					g.setVisible(true);
					
				}
				
			
		}
      } // fin class button handlerr
		public boolean Validate(String sal){
			
			
			if(!sal.equals("")){
				
					return true;
				}
				else{
					JOptionPane.showMessageDialog(null,"Please enter his salary !");
					ASal_tf.requestFocus();
					return false;
			
				
		  }
		}
		
}
