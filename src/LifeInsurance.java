import java.awt.BorderLayout;
import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement; import java.util.logging.Level; import java.util.logging.Logger; 


import java.awt.CardLayout;
import java.awt.Color;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
public class LifeInsurance extends JFrame{
	public JMenuBar bar;
	public JMenu AddIns;
	public JMenu ModifyIns;
	public JMenu DisplayIns;
	public JLabel AppNb_lab,Date_lab,nom_lab,Job_lab,Father_lab,Mother_lab,Adr_lab,Tel_lab,FBen_lab,SBen_lab,State_lab,nbChild_lab,Limit_lab;
	public JLabel nom_lb,Job_lb,Father_lb,Mother_lb,Adr_lb,Tel_lb,FBen_lb,SBen_lb,State_lb,nbChild_lb,Limit_lb,Select_lb;
	public JTextField AppNb_tf,Date_tf,nom_tf,Job_tf,Father_tf,Mother_tf,Adr_tf,Tel_tf,FBen_tf,SBen_tf;
	public JTextField nom_t,Job_t,Father_t,Mother_t,Adr_t,Tel_t,FBen_t,SBen_t;
	public JComboBox state_comb,nbChild_comb,limit_comb;
	public JComboBox state_cmb,nbChild_cmb,limit_cmb,Pass_cmb;
	public JComboBox name_sel,id_sel;
	public JPanel cards,p,p0,p1,p2,p3,p4,pModify,p0Modify,p1Modify,p2Modify,p3Modify;
	public JPanel pDisplay,p1Display,p2Display,p3Display,p4Display;
	public JButton save,edit;
	public Calendar cal;
	public CardLayout c1;
	public JLabel sel_name_lb,sel_id_lab;
	private int numApp;
	public JPanel l,r,n,s;
	public ArrayList ids,pass;
	public JLabel Did_lab,DApp_lab,Ddate_lab,DName_lab,DJob_lab,DFather_lab,DMother_lab,DAdr_lab,DTel_lab,DFB_lab,DSB_lab,DState_lab,DnbChild_lab,Dlimit_lab;
	public JComboBox Did_comb;
	public JLabel DApp_tf,Ddate_tf,DName_tf,DJob_tf,DFather_tf,DMother_tf,DAdr_tf,DTel_tf,DFB_tf,DSB_tf,DState_tf,DnbChild_Tf,Dlimit_tf;
	public JLabel birthDate_lab,birthPlace_lab,birthDate_tf,birthPlace_tf;
	public JButton back1,back2,back3;
	Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	String formatted;
	String name;
    LifeInsurance(String name){
    	
    	setTitle("Life Insurance");
	   setVisible(true);
	   setSize(1600,900);
	   this.name=name;
	   setDefaultCloseOperation(3);
	  ids=new ArrayList();pass=new ArrayList();
	  back1=new JButton(" <=== Back ");back2=new JButton(" <=== Back ");back3=new JButton(" <=== Back ");
	   p=new JPanel();p0=new JPanel();p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();pModify=new JPanel();p0Modify=new JPanel();p1Modify=new JPanel();p2Modify=new JPanel();p3Modify=new JPanel();
	   pDisplay=new JPanel();p1Display=new JPanel();p2Display=new JPanel();p3Display=new JPanel();p4Display=new JPanel();
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
	  /* String[]state=new String[3];
	   state[0]="Single";state[1]="Married";state[2]="Divorced";
	   String[]nbchild=new String[20];
	   int j;
	   for(int i=0;i<nbchild.length;i++){
		   j=i+1;
		   nbchild[i]=""+j;
	   }
	   */
	   String[]limit=new String[4];
	   limit[0]="50000 $";limit[1]="75000 $";limit[2]="100000 $";limit[3]="200000 $";
	  // state_comb=new JComboBox(state);
	  // nbChild_comb=new JComboBox(nbchild);
	   limit_comb=new JComboBox(limit);
	  
	  save=new JButton("Save Insurance");
	   AppNb_lab=new JLabel("Application number :");
	   AppNb_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   AppNb_tf=new JTextField(20);
	   AppNb_tf.setEditable(false);
	   Date_lab=new JLabel("Date :");
	   Date_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Date_tf=new JTextField(20);
	   Date_tf.setEditable(false);
	   Date_tf.setFont(new Font("Calibri",Font.ITALIC,20));
	   cal = Calendar.getInstance();
       SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
        formatted = format1.format(cal.getTime());
       Date_tf.setText(formatted);
	   Date_tf.setEditable(false);
	   nom_lab=new JLabel("Client name :");
	   nom_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   nom_tf=new JTextField(20);
	   Job_lab=new JLabel("Job :");
	   Job_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Job_tf=new JTextField(20);
	   Father_lab=new JLabel("Father name :");
	   Father_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Father_tf=new JTextField(20);
	   Mother_lab=new JLabel("Mother name :");
	   Mother_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Mother_tf=new JTextField(20);
	   Adr_lab=new JLabel("Adress :");
	   Adr_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Adr_tf=new JTextField(20);
	   Tel_lab=new JLabel("Tel :");
	   Tel_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Tel_tf=new JTextField(20);;
	   FBen_lab=new JLabel("First benificiary :");
	   FBen_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   FBen_tf=new JTextField(20);
	   FBen_tf.addMouseListener(ml);
	   
	   FBen_tf.setTransferHandler(new TransferHandler("text"));
	   SBen_lab=new JLabel("Second benificiary :");
	   SBen_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   SBen_tf=new JTextField(20);
	   State_lab=new JLabel("Marital state :");
	   State_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   nbChild_lab=new JLabel("number of Childrens :");
	   nbChild_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   Limit_lab=new JLabel("Limit Of Covering :");
	   Limit_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   sel_name_lb=new JLabel("Choose the Client name : ");
	   // array bjib fi aseme el clients 3nde min el database 
	   //ra7 a3ml arra hala2 bs msh houwe el sa7i7
	   back1.setBackground(java.awt.Color.decode("#dda0dd"));
	   back1.setPreferredSize(new Dimension(250,50));
	   back2.setPreferredSize(new Dimension(250,50));
	   back2.setBackground(java.awt.Color.decode("#dda0dd"));
	   back3.setPreferredSize(new Dimension(250,50));
	   back3.setBackground(java.awt.Color.decode("#dda0dd"));
	   save.setBackground(java.awt.Color.decode("#dda0dd"));
	   sel_id_lab=new JLabel("Enter Client's password : ",SwingConstants.LEFT);
	  
	  
	   //haydol el id ba3ml listener 3al select name combo bs tnkabas bishouf eza msh Default bifatsh bl clients 3a lli esmo hek w bi7otole possibilte el id w bna2e 
	   
	   sel_id_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   
	   selectId();
	   
	   //hayde bas lal select 
	   
	   id_sel.setPreferredSize(new Dimension(100,30));
	   id_sel.setEnabled(true);
	   FBen_tf.setFont(new Font("Serif",Font.PLAIN,20));
	   SBen_tf.setFont(new Font("Serif",Font.PLAIN,20));
	 p.setLayout(new GridLayout(4,0));
	   
	   limit_comb.setPreferredSize(new Dimension(100,30));
	 //  name_sel.addActionListener(new SelectListener());
	   p1.setLayout(new FlowLayout());
	   p2.setLayout(new FlowLayout());
	   p3.setLayout(new FlowLayout());
	   p4.setLayout(new FlowLayout());
	   p1.add(sel_id_lab);p1.add(id_sel);
	   p2.add(FBen_lab);p2.add(FBen_tf);p2.add(SBen_lab);p2.add(SBen_tf);
	   save.setPreferredSize(new Dimension(250,50));
	   p3.add(Limit_lab);
	   p3.add(limit_comb);
	   p4.add(back1);
	   p4.add(save);
	   p.setBackground(java.awt.Color.decode("#d3d3d3"));
	   p1.setBackground(java.awt.Color.decode("#d3d3d3"));
	   p2.setBackground(java.awt.Color.decode("#d3d3d3"));
		  
	   p3.setBackground(java.awt.Color.decode("#d3d3d3"));
	   p4.setBackground(java.awt.Color.decode("#d3d3d3"));
	   
	   p.add(p1);
	   p.add(p2);p.add(p3);
	   p.add(p4);
	   //tab3oul modify
     pModify.setLayout(new GridLayout(4,0));
     limit_cmb=new JComboBox(limit);
     Select_lb=new JLabel("Select Client's password : ",SwingConstants.LEFT);
     Select_lb.setFont(new Font("Serif",Font.PLAIN,30));
     selectIdFromLifeInsurance();
     
     // hayda bade 3abi min ar2am el app li jebton min database min life insurance 
     Pass_cmb.setPreferredSize(new Dimension(100,30));
  Limit_lb=new JLabel("Limit of Covering :");
  Limit_lb.setFont(new Font("Serif",Font.PLAIN,30));
  Limit_lb.setEnabled(false);
     edit=new JButton("Edit Insurance");
     FBen_lb=new JLabel("First benificiary :");
     FBen_lb.setFont(new Font("Serif",Font.PLAIN,30));
     FBen_lb.setEnabled(false);
     FBen_t=new JTextField(15);SBen_t=new JTextField(15);
     FBen_t.setFont(new Font("Serif",Font.PLAIN,20));
     FBen_t.setEnabled(false);
	   SBen_t.setFont(new Font("Serif",Font.PLAIN,20));
	   SBen_t.setEnabled(false);
     SBen_lb=new JLabel("Second benificiary");
     SBen_lb.setFont(new Font("Serif",Font.PLAIN,30));
     SBen_lb.setEnabled(false);
	   limit_cmb.setPreferredSize(new Dimension(100,30));
	  limit_cmb.setEnabled(false);
	 edit.setBackground(java.awt.Color.decode("#dda0dd"));
	 //  name_sel.addActionListener(new SelectListener());
	   p1Modify.setLayout(new FlowLayout());
	   p2Modify.setLayout(new FlowLayout());
	   p3Modify.setLayout(new FlowLayout());
	   p0Modify.setLayout(new FlowLayout());
	   
	   p0Modify.add(Select_lb);p0Modify.add(Pass_cmb);
	   p1Modify.add(FBen_lb);p1Modify.add(FBen_t);p1Modify.add(SBen_lb);p1Modify.add(SBen_t);
	   edit.setPreferredSize(new Dimension(250,50));
	   p2Modify.add(Limit_lb);
	   p2Modify.add(limit_cmb);
	   p3Modify.add(back2);
	   p3Modify.add(edit);
	
	   pModify.setBackground(java.awt.Color.decode("#d3d3d3"));
	   p0Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
	   p1Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
		  
	   p2Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
	   p3Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
	   
	   
	   
	   
	   bar.add(AddIns);
	   bar.add(ModifyIns);
	   bar.add(DisplayIns);
	   this.setJMenuBar(bar);
	   
	  
	   cards=new JPanel();
	 
	   
	   //pModify 3m zedla el panels bi alba
	   
	   pModify.add(p0Modify);
	   pModify.add(p1Modify);
	   pModify.add(p2Modify);
	   pModify.add(p3Modify);
	   
	   // hala2 pDisplay 
	   pDisplay.setLayout(new GridLayout(4,1));
	   p1Display.setLayout(new FlowLayout());
	   p2Display.setLayout(new GridLayout(7,4));
	   p3Display.setLayout(new FlowLayout());
	   p4Display.setLayout(new FlowLayout());
	   ////////////////////////////////////bade zid 3a pDisplay
	   Font f=new Font("Serif",Font.PLAIN,30);
	   Did_lab=new JLabel("Select Client's Password  : ");
	   Did_lab.setFont(f);
	   Did_comb=new JComboBox(pass.toArray());
	   Did_comb.setPreferredSize(new Dimension(100,30));
	   DApp_lab=new JLabel("",SwingConstants.RIGHT);
	   DApp_lab.setFont(f);
	   DApp_lab.setEnabled(false);
	   DApp_tf=new JLabel();
	   DApp_tf.setEnabled(false);
	   DApp_tf.setFont(f);
	   Ddate_lab=new JLabel("",SwingConstants.RIGHT);
	   Ddate_lab.setFont(f);
	   Ddate_lab.setEnabled(false);
	   Ddate_tf=new JLabel();
	   Ddate_tf.setFont(f);
	   Ddate_tf.setEnabled(false);
	   //client name
	   DName_lab=new JLabel("",SwingConstants.RIGHT);
	   DName_lab.setFont(f);
	   DName_lab.setEnabled(false);
	   DName_tf=new JLabel();
	   DName_tf.setFont(f);
	   DName_tf.setEnabled(false);
	   //job 
	   DJob_lab=new JLabel("",SwingConstants.RIGHT);
	   DJob_lab.setFont(f);
	   DJob_lab.setEnabled(false);
	   DJob_tf=new JLabel();
	   DJob_tf.setFont(f);
	   DJob_tf.setEnabled(false);
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
	   DFB_lab=new JLabel("",SwingConstants.RIGHT);
	   DFB_lab.setFont(f);
	   DFB_lab.setEnabled(false);
	   DFB_tf=new JLabel();
	   DFB_tf.setFont(f);
	   DFB_tf.setEnabled(false);
	   //SB
	   DSB_lab=new JLabel("",SwingConstants.RIGHT);
	   DSB_lab.setFont(f);
	   DSB_lab.setEnabled(false);
	   DSB_tf=new JLabel();
	   DSB_tf.setFont(f);
	   DSB_tf.setEnabled(false);
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
	   p4Display.setBackground(java.awt.Color.decode("#d3d3d3"));
	   //bzid el elements 3ala el panels 
	   p1Display.add(Did_lab);p1Display.add(Did_comb);
	   p2Display.add(DApp_lab);p2Display.add(DApp_tf);
	   p2Display.add(Ddate_lab);p2Display.add(Ddate_tf);
	   p2Display.add(DName_lab);p2Display.add(DName_tf);
	   p2Display.add(DJob_lab);p2Display.add(DJob_tf);
	   p2Display.add(DFather_lab);p2Display.add(DFather_tf);
	   p2Display.add(DMother_lab);p2Display.add(DMother_tf);
	   p2Display.add(birthDate_lab);p2Display.add(birthDate_tf);
	   p2Display.add(birthPlace_lab);p2Display.add(birthPlace_tf);
	   p2Display.add(DAdr_lab);p2Display.add(DAdr_tf);
	   p2Display.add(DTel_lab);p2Display.add(DTel_tf);
	   p2Display.add(DFB_lab);p2Display.add(DFB_tf);
	   p2Display.add(DSB_lab);p2Display.add(DSB_tf);
	   p2Display.add(DState_lab);p2Display.add(DState_tf);
	   p2Display.add(DnbChild_lab);p2Display.add(DnbChild_Tf);
	   back3.setPreferredSize(new Dimension(250,50));
	   p3Display.add(Dlimit_lab);p3Display.add(Dlimit_tf);
	   p4Display.add(back3);
	   ///////////////////////////////////////////hon bzidon 3al pDisplay
	     pDisplay.add(p1Display);
	     pDisplay.add(p2Display);
	     pDisplay.add(p3Display);
	     pDisplay.add(p4Display);
	   //
	   c1=new CardLayout();
	   cards.setLayout(c1); 
	   cards.add(p,"1"); //hayde el panel taba3 el add
	   cards.add(pModify,"2");//hhayde el panel taba3 el modify
	   cards.add(pDisplay,"3");// hhayde panel taba3 el display
	   Did_comb.addActionListener(new CombListener());
	  /* FBen_tf.addMouseListener(ml);

	   FBen_tf.setTransferHandler(new TransferHandler("text"));*/
	   save.addActionListener(new ButtonHandler());
	   back1.addActionListener(new ButtonHandler());
	   back2.addActionListener(new ButtonHandler());
	   back3.addActionListener(new ButtonHandler());
	   edit.addActionListener(new ButtonHandler());
	   back1.addActionListener(new ButtonHandler());
	   back2.addActionListener(new ButtonHandler());
	   back3.addActionListener(new ButtonHandler());
	   Pass_cmb.addActionListener(new CombListener());
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
    
    

    public void selectId(){
    	String query="select idClient from clients";
    	ExecuteCon(query);
    }
    
    public void selectIdFromLifeInsurance(){
    	String query="select ClientId from lifeinsurance";
    	ExecuteLifeCon(query);
    	
    }
    
    public void ExecuteLifeCon(String query){
    	//pass bade 3abyon min database
    	try
	    {
	    
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
	      
	      stmt = dbCon.createStatement();
	      rs = stmt.executeQuery(query);
	      while (rs.next())
	      {
	        
	        long p = rs.getLong("ClientId");
	        
	        pass.add(p);
	       
	      } 
	      dbCon.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  

    	Pass_cmb=new JComboBox(pass.toArray());
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
	       long appNum=rs.getLong("IDapp");
	       String dateIns=rs.getString("DateIns");
	       String FBen=rs.getString("FBen");
	       String SBen=rs.getString("SBen");
	       String lim=rs.getString("LimitCov");
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
	       DApp_lab.setText("Application Number : ");
	       DApp_lab.setEnabled(true);
	       DApp_tf.setEnabled(true);
	       DApp_tf.setText(app);
	       
	       Ddate_lab.setText("Date of insurance : ");
	       Ddate_lab.setEnabled(true);
	       Ddate_tf.setEnabled(true);
	       Ddate_tf.setText(dateIns);
	       
	       DName_lab.setText("Client's Name : ");
	       DName_lab.setEnabled(true);
	       DName_tf.setEnabled(true);
	       DName_tf.setText(Name);
	       
	       DJob_lab.setText("Job  : ");
	       DJob_lab.setEnabled(true);
	       DJob_tf.setEnabled(true);
	       DJob_tf.setText(job);
	       
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
	       

	       DFB_lab.setText("First Benificiary name  : ");
	       DFB_lab.setEnabled(true);
	       DFB_tf.setEnabled(true);
	       DFB_tf.setText(FBen);
	       
	       DSB_lab.setText("Second Benificiary   : ");
	       DSB_lab.setEnabled(true);
	       DSB_tf.setEnabled(true);
	       DSB_tf.setText(SBen);
	       

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
	  
    	id_sel=new JComboBox(ids.toArray());
    	
    
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
   
   
   
   public void FillExecuteCon(String query){
	   try
	    {
	    
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
	      
	      stmt = dbCon.createStatement();
	      rs = stmt.executeQuery(query);
	      while (rs.next())
	      {
	        String fb=rs.getString("FBen");
	        String sb=rs.getString("SBen");
	        String lim=rs.getString("LimitCov");
	        FBen_t.setText(fb);
	        SBen_t.setText(sb);
	        limit_cmb.setSelectedItem(lim);
	      } 
	      FBen_lb.setEnabled(true);
	      SBen_lb.setEnabled(true);
	      SBen_t.setEnabled(true);
	      FBen_t.setEnabled(true);
	      Limit_lb.setEnabled(true);
	      limit_cmb.setEnabled(true);
	      dbCon.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  
   	id_sel=new JComboBox(ids.toArray());
   	
   }
   
public void UpdateCon(String query){
	   
	   try
	    {
	    
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany","root", "");
	      stmt = dbCon.createStatement();
	      int affectedRows=stmt.executeUpdate(query);
	      
	   // if(affectedRows==1)
	    //	JOptionPane.showMessageDialog(null,"Update is done successfully !");
	      dbCon.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  
   	
   }

 

   public class CombListener implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Pass_cmb){
		Long Id=(Long)Pass_cmb.getSelectedItem();
		String query="select * from lifeinsurance where ClientId='"+ Id + "'";
		FillExecuteCon(query);
		}
		else if(e.getSource()==Did_comb){
			//bade a3ml enable la kl el labels ma3 values bi albon min el database 
			Long pass=(Long)Did_comb.getSelectedItem();
			String query="select * " +
             "from lifeinsurance, clients " +
             "where lifeinsurance.ClientId  = clients.idClient  and " +
             "clients.idClient= '" + pass + "' ";
			ExecuteJoinCon(query);
		}
		
	}
	   
   }

    public class ButtonHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent ev) {
			//lama ekbos save
			if(ev.getSource()==save){
			String Fb=FBen_tf.getText();String SecB=SBen_tf.getText();
			
			Long Id=(Long)id_sel.getSelectedItem();
			
			String limitt=(String)limit_comb.getSelectedItem();
			if(Validate(Fb,SecB)){
				//kilon m3abeyin sa7 b2oul Joption pane eno sayavna el insurance w bsayvon bl database
				
				JOptionPane.showMessageDialog(null,"Filled Successfully ");
			     //save
				
				cal = Calendar.getInstance();
			       SimpleDateFormat format2 = new SimpleDateFormat("YYYY-MM-dd");
			       String formated = format2.format(cal.getTime());
				String requete="INSERT INTO `lifeinsurance` (DateIns,ClientId,FBen,Sben,LimitCov) VALUE ('"+ formated +"','"+ Id +"','"+ Fb+ "','"+ SecB +"','"+ limitt +"')";
				pass.add(Id);
				InsertCon(requete);
				
				
			}
			}
			else if(ev.getSource()==edit){
				String Fb=FBen_t.getText();String SecB=SBen_t.getText();
				String limitt=(String)limit_cmb.getSelectedItem();
				if(Validate(Fb,SecB)){
					//kilon m3abeyin sa7 b2oul Joption pane eno sayavna el insurance w bsayvon bl database
					
					JOptionPane.showMessageDialog(null,"Edit acceptable ");
				     //save
					Long Id=(Long)Pass_cmb.getSelectedItem();
					//System.out.println(Id+"This is the id ");
					cal = Calendar.getInstance();
				       SimpleDateFormat format3 = new SimpleDateFormat("YYYY-MM-dd");
				       String formated = format3.format(cal.getTime());
					
					//String q="UPDATE lifeinsurance set FBen='"+ Fb +"'where IDapp ='"+ 1 + "'";
					String q="UPDATE lifeinsurance set FBen='"+ Fb + "', SBen='" + SecB + "' , LimitCov='"+ limitt + "' where ClientId='"+ Id + "'";
					UpdateCon(q);
			        
					
				}

				
			}
			else if(ev.getSource()==back1 || ev.getSource()==back2 || ev.getSource()==back3){
				EmployePage p=new EmployePage(name);
				
				setVisible(false);
				p.setVisible(true);
				
			}
				
			
		}
		public boolean Validate(String Fb,String SecB){
			
			
				if(!Fb.equals("")){
					if(!SecB.equals("")){
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null,"Please choose the name of SB !");
						SBen_tf.requestFocus();
						return false;
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please choose the name of FB !");
					FBen_tf.requestFocus();
					return false;
				}
					
			}
			
		}
   
    
    //
    MouseListener ml=new MouseListener() {


    	@Override

    	public void mouseReleased(MouseEvent e) {

    	// TODO Auto-generated method stub


    	}


    	@Override

    	public void mousePressed(MouseEvent e) {

    	// TODO Auto-generated method stub

    	JComponent jc=( JComponent)e.getSource();

    	TransferHandler th=jc.getTransferHandler();

    	th.exportAsDrag(jc, e, TransferHandler.COPY);


    	}


    	@Override

    	public void mouseExited(MouseEvent e) {

    	// TODO Auto-generated method stub


    	}


    	@Override

    	public void mouseEntered(MouseEvent e) {

    	// TODO Auto-generated method stub


    	}


    	@Override

    	public void mouseClicked(MouseEvent e) {

    	// TODO Auto-generated method stub


    	}

    	};
    //
    
    }


	


    
     
			
			
				
				
		
    
    

