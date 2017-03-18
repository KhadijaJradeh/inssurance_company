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
public class CarInsurance extends JFrame{
	public JMenuBar bar;
	public JMenu AddIns;
	public JMenu ModifyIns;
	public JMenu DisplayIns;
	public JLabel AppNb_lab,Date_lab,nom_lab,Job_lab,Father_lab,Mother_lab,Adr_lab,Tel_lab,plate_lab,mark_lab,State_lab,nbChild_lab,Limit_lab;
	public JLabel nom_lb,Job_lb,Father_lb,Mother_lb,Adr_lb,Tel_lb,plate_lb,SBen_lb,State_lb,nbChild_lb,Limit_lb,Select_lb;
	public JTextField AppNb_tf,Date_tf,nom_tf,Job_tf,Father_tf,Mother_tf,Adr_tf,Tel_tf,mark_tf,plate_tf;
	public JTextField nom_t,Job_t,Father_t,Mother_t,Adr_t,Tel_t,plate_t,SBen_t;
	public JComboBox state_comb,nbChild_comb,limit_comb;
	public JComboBox state_cmb,nbChild_cmb,limit_cmb,Pass_cmb;
	public JComboBox name_sel,id_sel;
	public JPanel cards,p,p0,p1,p2,p3,p4,pModify,p0Modify,p1Modify,p2Modify,p3Modify;
	public JPanel pDisplay,p1Display,p2Display,p3Display,p4Display;
	public JButton save,edit;
	public JButton back1,back2,back3;
	public Calendar cal;
	public CardLayout c1;
	public JLabel sel_name_lb,sel_id_lab;
	private int numApp;
	public JPanel l,r,n,s;
	public ArrayList ids,pass;
	public JLabel Did_lab,DApp_lab,Ddate_lab,DName_lab,DJob_lab,
	DFather_lab,DMother_lab,DAdr_lab,DTel_lab,DFB_lab,DSB_lab,DState_lab,DnbChild_lab,Dlimit_lab;
	public JComboBox Did_comb,carmark_comb,carmodel_comb;
	public JLabel DApp_tf,Ddate_tf,DName_tf,DJob_tf,DFather_tf,DMother_tf,DAdr_tf,DTel_tf,DFB_tf,DSB_tf,DState_tf,DnbChild_Tf,Dlimit_tf;
	public JLabel birthDate_lab,birthPlace_lab,birthDate_tf,birthPlace_tf;
	Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	public JLabel year_lab,model_lab,markModify_lab;
	public JTextField year_tf,State_tf,model_tf,markModify_tf;
	public String[] types;
public String name;
	String formatted;
    @SuppressWarnings("unchecked")
	public CarInsurance(String name){
    	/*carmark_comb=new JComboBox(types);
    	carmodel_comb=new JComboBox();
    	types= new String[]{"BMW","Merceds","Toyota","Honda","Peugoet"};*/
    	setTitle("Car Insurance");
    	this.name=name;
	   setVisible(true);
	   setSize(1600,900);
	   setDefaultCloseOperation(3);
	  ids=new ArrayList();pass=new ArrayList();
	   p=new JPanel();
	   p0=new JPanel();
	   p1=new JPanel();
	   p2=new JPanel();
	   p3=new JPanel();
	   p4=new JPanel();
	   pModify=new JPanel();
	   p0Modify=new JPanel();
	   p1Modify=new JPanel();
	   p2Modify=new JPanel();
	   p3Modify=new JPanel();
	   pDisplay=new JPanel();
	   p1Display=new JPanel();
	   p2Display=new JPanel();
	   p3Display=new JPanel();
	   p4Display=new JPanel();
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
	  
	   int j;
	   
	   String[]limit=new String[4];
	   limit[0]="50000 $";limit[1]="75000 $";limit[2]="100000 $";limit[3]="200000 $";
	  
	   limit_comb=new JComboBox(limit);
	  back1=new JButton(" <=== Back");
	  back2=new JButton(" <=== Back");
	  back3=new JButton(" <=== Back");
	  save=new JButton("Save Insurance");
	  save.setBackground(java.awt.Color.decode("#ffffff"));
	  back1.setBackground(java.awt.Color.decode("#dda0dd"));
	   back1.setPreferredSize(new Dimension(250,50));
	   back2.setPreferredSize(new Dimension(250,50));
	   back2.setBackground(java.awt.Color.decode("#dda0dd"));
	   back3.setPreferredSize(new Dimension(250,50));
	   back3.setBackground(java.awt.Color.decode("#dda0dd"));
	  plate_lab=new JLabel("Plate Number :");
	   plate_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   plate_tf=new JTextField(10);
	   mark_lab=new JLabel("Mark :");
	  mark_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   mark_tf=new JTextField(10);
	   model_lab=new JLabel("Model :");
		  model_lab.setFont(new Font("Serif",Font.PLAIN,30));
		   model_tf=new JTextField(10);
	   State_lab=new JLabel("Model :");
	   State_tf=new JTextField(10);
	   State_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   year_lab=new JLabel("Year : ");
	    year_tf=new JTextField(10);
	    year_lab.setFont(new Font("Serif",Font.PLAIN,30));
	  
	   Limit_lab=new JLabel("Limit Of Covering :");
	   Limit_lab.setFont(new Font("Serif",Font.PLAIN,30));
	  
	   
	   

	   sel_id_lab=new JLabel("Enter Client's password : ",SwingConstants.LEFT);
	  
	  
	   //haydol el id ba3ml listener 3al select name combo bs tnkabas bishouf eza msh Default bifatsh bl clients 3a lli esmo hek w bi7otole possibilte el id w bna2e 
	   
	   sel_id_lab.setFont(new Font("Serif",Font.PLAIN,30));
	   
	   selectId();
	   
	   //hayde bas lal select 
	   
	   id_sel.setPreferredSize(new Dimension(100,30));
	   id_sel.setEnabled(true);
	   plate_tf.setFont(new Font("Serif",Font.PLAIN,20));
	   mark_tf.setFont(new Font("Serif",Font.PLAIN,20));
	   year_tf.setFont(new Font("Serif",Font.PLAIN,20));
	   State_tf.setFont(new Font("Serif",Font.PLAIN,20));
	 p.setLayout(new GridLayout(4,0));
	   
	   limit_comb.setPreferredSize(new Dimension(100,30));
	 
	   p1.setLayout(new FlowLayout());
	   p2.setLayout(new FlowLayout());
	   p3.setLayout(new FlowLayout());
	   p4.setLayout(new FlowLayout());
	   p1.add(sel_id_lab);p1.add(id_sel);
	   p2.add(plate_lab);p2.add(plate_tf);
	   p2.add(mark_lab);p2.add(mark_tf);
	   p2.add(year_lab);p2.add(year_tf);
	   p2.add(model_lab);p2.add(model_tf);
	   back3.setPreferredSize(new Dimension(250,50));
	   back3.setBackground(java.awt.Color.decode("#dda0dd"));
	   save.setBackground(java.awt.Color.decode("#dda0dd"));
	  //SState_lab.setFont(new Font("Serif",Font.PLAIN,30));
	  
	//  JTextField SState_tf=new JTextField(10);
	  //SState_tf.addMouseListener(ml);
	 
	   save.setPreferredSize(new Dimension(250,50));
	   p3.add(Limit_lab);
	   p3.add(limit_comb);
	   p4.add(back1);
	   p4.add(save);
	
	   p.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p1.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p2.setBackground(java.awt.Color.decode("#D3D3D3"));
		  
	   p3.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p4.setBackground(java.awt.Color.decode("#D3D3D3"));
	   
	   p.add(p1);
	   p.add(p2);p.add(p3);
	   p.add(p4);
	   //tab3oul modify
     pModify.setLayout(new GridLayout(4,0));
     limit_cmb=new JComboBox(limit);
     Select_lb=new JLabel("Select Client's password : ");
     Select_lb.setFont(new Font("Serif",Font.PLAIN,30));
     
     selectIdFromCarInsurance();
     // hayda bade 3abi min ar2am el app li jebton min database min life insurance 
     Pass_cmb.setPreferredSize(new Dimension(100,30));
  Limit_lb=new JLabel("Limit of Covering :");
  Limit_lb.setFont(new Font("Serif",Font.PLAIN,30));
  Limit_lb.setEnabled(false);
     edit=new JButton("Edit Insurance");
     plate_lb=new JLabel("Plate Number :");
     plate_lb.setFont(new Font("Serif",Font.PLAIN,30));
     plate_lb.setEnabled(false);
     plate_t=new JTextField(15);
     plate_t.setEnabled(false);
    // plate_t.addMouseListener(ml);
    // plate_t.setTransferHandler(new TransferHandler("text"));
     SBen_t=new JTextField(15);
     SBen_t.setEnabled(false);
    // SBen_t.setDragEnabled(true);
     markModify_lab=new JLabel("Mark : ");
     markModify_lab.setEnabled(false);
     markModify_lab.setFont(new Font("Serif",Font.PLAIN,30));
     markModify_tf=new JTextField(15);
     markModify_tf.setEnabled(false);
     plate_t.setFont(new Font("Serif",Font.PLAIN,20));
	 SBen_t.setFont(new Font("Serif",Font.PLAIN,20));
     SBen_lb=new JLabel("Year:");
     SBen_lb.setEnabled(false);
     State_lab.setEnabled(false);
     State_tf.setEnabled(false);
   //  SBen_t.addMouseListener(ml);
     SBen_lb.setFont(new Font("Serif",Font.PLAIN,30));
	   limit_cmb.setPreferredSize(new Dimension(100,30));
	  limit_cmb.setEnabled(false);
	  
	 //  name_sel.addActionListener(new SelectListener());
	   p1Modify.setLayout(new FlowLayout());
	   p2Modify.setLayout(new FlowLayout());
	   p3Modify.setLayout(new FlowLayout());
	   p0Modify.setLayout(new FlowLayout());
	   
	   p0Modify.add(Select_lb);p0Modify.add(Pass_cmb);
	  p1Modify.add(plate_lb);
	   p1Modify.add(plate_t);
	   
	  p1Modify.add(markModify_lab);
	  p1Modify.add(markModify_tf);
	  p1Modify.add(SBen_lb);
	  p1Modify.add(SBen_t);
	  p1Modify.add(State_lab);//model
	  p1Modify.add(State_tf);
	 
	   edit.setPreferredSize(new Dimension(250,50));
	   p2Modify.add(Limit_lb);
	   p2Modify.add(limit_cmb);
	   p3Modify.add(back2);
	   p3Modify.add(edit);
	   edit.setBackground(java.awt.Color.decode("#dda0dd"));
	   pModify.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p0Modify.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p1Modify.setBackground(java.awt.Color.decode("#D3D3D3"));
		  
	   p2Modify.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p3Modify.setBackground(java.awt.Color.decode("#D3D3D3"));
	   
	   
	   
	   
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
	   pDisplay.setLayout(new GridLayout(3,1));
	   p1Display.setLayout(new FlowLayout());
	   p2Display.setLayout(new GridLayout(7,4));
	   p3Display.setLayout(new FlowLayout());
	   
	   ////////////////////////////////////bade zid 3a pDisplay
	   Font f=new Font("Serif",Font.PLAIN,30);
	   Did_lab=new JLabel("Select Client's Password  : ",SwingConstants.CENTER);
	   Did_lab.setFont(f);
	   Did_comb=new JComboBox(ids.toArray());
	   Did_comb.setPreferredSize(new Dimension(100,30));
	   DApp_lab=new JLabel("",SwingConstants.RIGHT);
	   DApp_lab.setFont(f);
	   DApp_lab.setEnabled(false);
	   DApp_tf=new JLabel("");
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
	   pDisplay.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p1Display.setBackground(java.awt.Color.decode("#D3D3D3"));
	   p2Display.setBackground(java.awt.Color.decode("#D3D3D3"));
		  
	   p3Display.setBackground(java.awt.Color.decode("#D3D3D3"));
	   //bzid el elements 3ala el panels 
	   p1Display.add(Did_lab);
	   p1Display.add(Did_comb);
	   p2Display.add(DApp_lab);
	   p2Display.add(DApp_tf);
	   p2Display.add(Ddate_lab);
	   p2Display.add(Ddate_tf);
	   p2Display.add(DName_lab);
	   p2Display.add(DName_tf);
	   p2Display.add(DJob_lab);
	   p2Display.add(DJob_tf);
	   p2Display.add(DFather_lab);
	   p2Display.add(DFather_tf);
	   p2Display.add(DMother_lab);
	   p2Display.add(DMother_tf);
	   p2Display.add(birthDate_lab);
	   p2Display.add(birthDate_tf);
	   p2Display.add(birthPlace_lab);
	   p2Display.add(birthPlace_tf);
	   p2Display.add(DAdr_lab);
	   p2Display.add(DAdr_tf);
	   p2Display.add(DTel_lab);
	   p2Display.add(DTel_tf);
	   p2Display.add(DFB_lab);
	   p2Display.add(DFB_tf);
	   p2Display.add(DSB_lab);
	   p2Display.add(DSB_tf);
	   p2Display.add(DState_lab);
	   p2Display.add(DState_tf);
	   p2Display.add(DnbChild_lab);
	   p2Display.add(DnbChild_Tf);
	   p4Display.setBackground(java.awt.Color.decode("#d3d3d3"));
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
	   save.addActionListener(new ButtonHandler());
	   back1.addActionListener(new ButtonHandler());
	   back2.addActionListener(new ButtonHandler());
	   back3.addActionListener(new ButtonHandler());
	   edit.addActionListener(new ButtonHandler());
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
    
    
    public void ExecuteJoinCon(String query){
    	try
	    {
    		//Class.forName("com.mysql.jdbc.Driver");
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
    		//Class.forName("com.mysql.jdbc.Driver");
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
    
   public void selectIdFromCarInsurance(){
	   String query="select ClientIdC from carinsurance";
   	ExecuteCarCon(query);
   }
   
   public void ExecuteCarCon(String query){
	   try
	    {
	    
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
	      
	      stmt = dbCon.createStatement();
	      rs = stmt.executeQuery(query);
	      while (rs.next())
	      {
	        
	        long p = rs.getLong("ClientIdC");
	        
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
   public void InsertCon(String query){
	   
	   try
	    {
		  // Class.forName("com.mysql.jdbc.Driver");
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
	      
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
		  // Class.forName("com.mysql.jdbc.Driver");
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
	      
	      stmt = dbCon.createStatement();
	      rs = stmt.executeQuery(query);
	      while (rs.next())
	      {
	        String plate=rs.getString("PlateNb");
	        String year=rs.getString("Year");
	        String model=rs.getString("Model");
	        String mark=rs.getString("Mark");
	        String lim=rs.getString("LimitCar");
	        JOptionPane.showMessageDialog(null,"Entered to fill ");
	        plate_t.setText(plate);
	        SBen_t.setText(year);
	        State_tf.setText(model);
	        markModify_tf.setText(mark);    
	        limit_cmb.setSelectedItem(lim);
	       plate_lb.setEnabled(true);
	       plate_t.setEnabled(true);
	       SBen_lb.setEnabled(true);
	      SBen_t.setEnabled(true);
	       plate_t.setEnabled(true);
	       SBen_lb.setEnabled(true);
	       markModify_lab.setEnabled(true);
	       markModify_tf.setEnabled(true);
	       Select_lb.setEnabled(true);
	       State_lab.setEnabled(true);
	       State_tf.setEnabled(true);
	       Limit_lb.setEnabled(true);
	       limit_cmb.setEnabled(true);
	       
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
   
public void UpdateCon(String query){
	   
	   try
	    {
		   //Class.forName("com.mysql.jdbc.Driver");
	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
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


   public class CombListener implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Pass_cmb){
		Long Id=(Long)Pass_cmb.getSelectedItem();
		String query="select * from carinsurance where ClientIdC='"+ Id + "'";
		FillExecuteCon(query);
		}
		else if(e.getSource()==Did_comb){
			//bade a3ml enable la kl el labels ma3 values bi albon min el database 
			Long pass=(Long)Did_comb.getSelectedItem();
			String query="select * " +
             "from carinsurance, clients " +
             "where carinsurance.ClientIdC  = clients.idClient  and " +
             "clients.idClient= '" + pass + "' ";
			ExecuteJoinCon(query);
		}
		
	}
	   
   }

    public class ButtonHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent ev) {
			//lama ekbos save
			if(ev.getSource()==save){
			String pl=plate_tf.getText();String mark=mark_tf.getText();
			String year=year_tf.getText();String mod=model_tf.getText();
			
			
			String limitt=(String)limit_comb.getSelectedItem();
			if(Validate(pl,mark,year,mod)){
				//kilon m3abeyin sa7 b2oul Joption pane eno sayavna el insurance w bsayvon bl database
				
				JOptionPane.showMessageDialog(null,"Filled Successfully ");
			     //save
				Long Id=(Long)id_sel.getSelectedItem();
				cal = Calendar.getInstance();
			       SimpleDateFormat format2 = new SimpleDateFormat("YYYY-MM-dd");
			       String formated = format2.format(cal.getTime());
				String requete="INSERT INTO `carinsurance` (DateCar,ClientIdC,PlateNb,Mark,Year,Model,LimitCar) VALUE ('"+ formated +"','"+ Id +"','"+ pl+ "','"+ mark +"','"+ year +"','"+ mod +"','"+ limitt +"')";
				InsertCon(requete);
		        
				
			}
			else
				JOptionPane.showMessageDialog(null,"Not Filled Successfully ");
			}
			else if(ev.getSource()==edit){
				String pl=plate_t.getText();String mark=markModify_tf.getText();
				String year=SBen_t.getText();String mod=State_tf.getText();
				String limitt=(String)limit_cmb.getSelectedItem();
				if(Validate(pl,mark,year,mod)){
					//kilon m3abeyin sa7 b2oul Joption pane eno sayavna el insurance w bsayvon bl database
					
					JOptionPane.showMessageDialog(null,"Edit acceptable ");
				     //save
					Long Id=(Long)Pass_cmb.getSelectedItem();
					
					cal = Calendar.getInstance();
				       SimpleDateFormat format3 = new SimpleDateFormat("YYYY-MM-dd");
				       String formated = format3.format(cal.getTime());
					
					//String q="UPDATE lifeinsurance set FBen='"+ Fb +"'where IDapp ='"+ 1 + "'";
					String q="UPDATE carinsurance set PlateNb='"+ pl + "', Year='" + year + "' ,Mark='" + mark + "',Model ='" + mod + "',LimitCar='"+ limitt + "' where ClientIdC='"+ Id + "'";
					UpdateCon(q);
			        
					
				}

				
			}
			else if(ev.getSource()==back1 || ev.getSource()==back2 || ev.getSource()==back3){
				EmployePage p=new EmployePage(name);
				dispose();
				setVisible(false);
				p.setVisible(true);
				
			}
				
		
				
			
		}
		public boolean Validate(String pl,String mark,String year,String model){
			
			
				if(!pl.equals("")){
					if(!mark.equals("")){
						 if(!year.equals("")){
							 if(!model.equals("")){
								 return true;
							 }
							 else {
								 JOptionPane.showMessageDialog(null,"Please choose the model !");
									model_tf.requestFocus();
									return false;
							 }
							 
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Please choose the year !");
								year_tf.requestFocus();
								return false;
						 }
				         		
					}
					else{
						JOptionPane.showMessageDialog(null,"Please choose the name of the mark !");
						mark_tf.requestFocus();
						return false;
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please choose the number of the plate !");
					plate_tf.requestFocus();
					return false;
				}
					
			}
			
		}
   
    
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
    
    
    }
