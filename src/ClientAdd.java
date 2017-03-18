import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger; 


import java.awt.CardLayout;
import java.awt.Component;
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
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
/*
import UndoManagerHelper.RedoAction;
import UndoManagerHelper.UndoAction;
import UndoManagerHelper.UndoRedoAction;*/

public class ClientAdd extends JFrame{
	
	public JMenuBar bar;
	public JMenu Add,Modify;
	public JLabel Aname,Atel,Afath,Amoth,AbirthDate,AbirthPlace,Astate,AnbChild,AJob,Aadr,
	Mname,Mtel,Mfath,Mmoth,MbirthDate,MbirthPlace,Mstate,MnbChild,MJob,Madr,Mselect;
	
	public JTextField Aname_tf,Atel_tf,Afath_tf,Amoth_tf,AbirthDate_tf,ABirthPlace_tf,Ajob_tf,Aadr_tf,
	Mname_tf,Mtel_tf,Mfath_tf,Mmoth_tf,MbirthDate_tf,MBirthPlace_tf,Mjob_tf,Madr_tf;
	public JComboBox Astate_cmb,AnbChild_cmb,
					Mstate_cmb,MnbChild_cmb,ids;
	public ArrayList idDatabase;
	public JButton add,undo,redo;
	public JButton modify;
	public JButton back1,back2,back3;
	public JTextArea details;
	public JPanel cards,p,p1,p2,p3,p4,pModify,p0Modify,p1Modify,p2Modify,p3Modify,p4Modify;
	CardLayout c1;
	Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
String name;
      ClientAdd(String name){
    	  setTitle("Client Add and Modify ");
    	   setVisible(true);
    	   setSize(1600,900);
    	   this.name=name;
    	   setDefaultCloseOperation(3);
    	  bar=new JMenuBar();
		   Add=new JMenu("Add Client");
		   Modify=new JMenu("Modify Client");
		  idDatabase=new ArrayList();
		  back1=new JButton(" <=== Back ");back2=new JButton(" <=== Back ");
		   Add.setPreferredSize(new Dimension(200,50));
		   Add.setFont(new Font("Calibri",Font.BOLD,20));
		   Modify.setPreferredSize(new Dimension(200,50));
		   Modify.setFont(new Font("Calibri",Font.BOLD,20));
		   cards=new JPanel();p=new JPanel();pModify=new JPanel();
		   p1=new JPanel(); p2=new JPanel(); p3=new JPanel(); p4=new JPanel(); 
		   p.setBackground(java.awt.Color.decode("#d3d3d3"));
		   p1.setBackground(java.awt.Color.decode("#d3d3d3"));
		   p2.setBackground(java.awt.Color.decode("#d3d3d3"));  
		   p3.setBackground(java.awt.Color.decode("#d3d3d3"));
		   
		   p1Modify=new JPanel(); p2Modify=new JPanel(); p3Modify=new JPanel(); p4Modify=new JPanel(); p0Modify=new JPanel(); 
		   Font f=new Font("Serif",Font.PLAIN,25);
		   Aname=new JLabel("Enter Client's name : ");
		   Aname.setFont(f);
		   Aname_tf=new JTextField(10);
		   Aname_tf.setFont(f);
		   Atel=new JLabel("Tel :");
		   Atel.setFont(f);
		   Atel_tf=new JTextField(10);
		   Atel_tf.setFont(f);
		   Afath=new JLabel("Father's name :");
		   Afath.setFont(f);
		   Afath_tf=new JTextField(10);
		   Afath_tf.setFont(f);
		   Amoth=new JLabel("Mother's name :");
		   Amoth.setFont(f);
		   Amoth_tf=new JTextField(10);
		   Amoth_tf.setFont(f);
		   AbirthDate=new JLabel("Birth Date :");
		   AbirthDate.setFont(f);
		   AbirthDate_tf=new JTextField(10);
		   AbirthDate_tf.setFont(f);
		   AbirthPlace=new JLabel("Birth Place :");
		   AbirthPlace.setFont(f);
		   ABirthPlace_tf=new JTextField(10);
		   ABirthPlace_tf.setFont(f);
		   Astate=new JLabel("State :");
		   Astate.setFont(f);
		   String[]states={"Married","Divorced","Single"};
		   Astate_cmb=new JComboBox(states);
		   Astate_cmb.setFont(f);
		  ArrayList nb=new ArrayList();
		   for(int i=0;i<=20;i++)
			  nb.add(i);
		   Mselect=new JLabel("Enter student's identifier : ");
		   AnbChild=new JLabel("nb of Childs : ");
		   AnbChild.setFont(f);
		   AnbChild_cmb=new JComboBox(nb.toArray());
		   AnbChild_cmb.setFont(f);
		   AJob=new JLabel("Job :");
		   AJob.setFont(f);
		   Ajob_tf=new JTextField(10);
		   Ajob_tf.setFont(f);
		   Aadr=new JLabel("Adress :");
		   Aadr.setFont(f);
		   Aadr_tf=new JTextField(10);
		   Aadr_tf.setFont(f);
		   Mname=new JLabel("Enter Client's name : ");
		   Mname.setFont(f);
		   Mname_tf=new JTextField(10);
		   Mname_tf.setFont(f);
		   Mtel=new JLabel("Tel :");
		   Mtel.setFont(f);
		   Mtel_tf=new JTextField(10);
		   Mtel_tf.setFont(f);
		   Mfath=new JLabel("Father's name :");
		   Mfath.setFont(f);
		   Mfath_tf=new JTextField(10);
		   Mfath_tf.setFont(f);
		   Mmoth=new JLabel("Mother's name :");
		   Mmoth.setFont(f);
		   Mmoth_tf=new JTextField(10);
		   Mmoth_tf.setFont(f);
		   MbirthDate=new JLabel("Birth Date :");
		   MbirthDate.setFont(f);
		   MbirthDate_tf=new JTextField(10);
		   MbirthDate_tf.setFont(f);
		   MbirthPlace=new JLabel("Birth Place :");
		   MbirthPlace.setFont(f);
		   MBirthPlace_tf=new JTextField(10);
		   MBirthPlace_tf.setFont(f);
		   Mstate=new JLabel("State :");
		   Mstate.setFont(f);
		   Mstate.setFont(f);
		   Mstate_cmb=new JComboBox();
		   Mstate_cmb.setFont(f);
		   MnbChild=new JLabel("nb of Childs : ");
		   MnbChild.setFont(f);
		   MnbChild_cmb=new JComboBox();
		   MnbChild_cmb.setFont(f);
		   MJob=new JLabel("Job :");
		   MJob.setFont(f);
		   Mjob_tf=new JTextField(10);
		   Mjob_tf.setFont(f);
		   Madr=new JLabel("Adress :");
		   Madr.setFont(f);
		   Madr_tf=new JTextField(10);
		   Madr_tf.setFont(f);
		   Mname_tf.setEnabled(true);
		   Mtel_tf.setEnabled(true);
		   Mfath_tf.setEnabled(true);
		   Mmoth_tf.setEnabled(true);
		   MbirthDate_tf.setEnabled(true);
		   MBirthPlace_tf.setEnabled(true);
		   Mjob_tf.setEnabled(true);
		   Madr_tf.setEnabled(true);
		   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-m-yyyy");
			Date date2 = null;
		   p1.setLayout(new GridLayout(2,0));
		   p2.setLayout(new GridLayout(5,4));
		   p2.add(Aname);p2.add(Aname_tf);
		   p2.add(Atel);p2.add(Atel_tf);
		   p2.add(Afath);p2.add(Afath_tf);
		   p2.add(Amoth);p2.add(Amoth_tf);
		   p2.add(AbirthDate);p2.add(AbirthDate_tf);
		   p2.add(AbirthPlace);p2.add(ABirthPlace_tf);
		   p2.add(Astate);p2.add(Astate_cmb);
		   p2.add(AnbChild);p2.add(AnbChild_cmb);
		   p2.add(AJob);p2.add(Ajob_tf);
		   p2.add(Aadr);p2.add(Aadr_tf);
		   add=new JButton("Add");
		   add.setBackground(java.awt.Color.decode("#dda0dd"));
	        add.setPreferredSize(new Dimension(250,50));
	        selectId();
	        back2.setBackground(java.awt.Color.decode("#dda0dd"));
	        back2.setPreferredSize(new Dimension(250,50));
	        p.setLayout(new GridLayout(2,1));
	        p3.add(add);
	        p1.add(p2);
	        p1.add(p3);
			  
			   modify=new JButton("Modify");
			   modify.setBackground(java.awt.Color.decode("#dda0dd"));
		       modify.setPreferredSize(new Dimension(250,50));
		       Mselect.setFont(f);
		       
		       p1Modify.setLayout(new GridLayout(5,4,20,5));
			   p2Modify.setLayout(new FlowLayout());
			   p3Modify.setLayout(new FlowLayout());
			   pModify.setLayout(new GridLayout(4,0));
			  
			   Mstate_cmb=new JComboBox(states);
			   MnbChild_cmb=new JComboBox(nb.toArray());
			   p0Modify.add(Mselect);p0Modify.add(ids);
			   p1Modify.add(Mname);p1Modify.add(Mname_tf);
			   p1Modify.add(Mtel);p1Modify.add(Mtel_tf);
			   p1Modify.add(Mfath);p1Modify.add(Mfath_tf);
			   p1Modify.add(Mmoth);p1Modify.add(Mmoth_tf);
			   p1Modify.add(MbirthDate);p1Modify.add(MbirthDate_tf);
			   p1Modify.add(MbirthPlace);p1Modify.add(MBirthPlace_tf);
			   p1Modify.add(Mstate);p1Modify.add(Mstate_cmb);
			   p1Modify.add(MnbChild);p1Modify.add(MnbChild_cmb);
			   p1Modify.add(MJob);p1Modify.add(Mjob_tf);
			   p1Modify.add(Madr);p1Modify.add(Madr_tf);
			//   edit.setPreferredSize(new Dimension(250,50));
			  p3Modify.add(modify);
			   p3Modify.add(back2);
			   ids.setPreferredSize(new Dimension(100,30));
			  
			   pModify.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p0Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p1Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
				  
			  
			   p3Modify.setBackground(java.awt.Color.decode("#d3d3d3"));
			   
			   pModify.add(p0Modify);
			   pModify.add(p1Modify);
			  
			   pModify.add(p3Modify);
			   
		       //
		       
		        
	        p4.setLayout(new GridLayout(1,2));
	        
	        JTextArea textArea = new JTextArea();
	 	   textArea.setText("Enter Details");
	 	   textArea.setSize(getPreferredSize());
	 	    JScrollPane scrollPane = new JScrollPane(textArea);

	 	    UndoManager manager = new UndoManager();
	 	    textArea.getDocument().addUndoableEditListener(manager);

	 	    JToolBar toolbar = new JToolBar();
	 	    //toolbar.setBackground(java.awt.Color.decode("#FAF0E6"));
	 	    toolbar.add(UndoManagerHelper.getUndoAction(manager));
	 	    toolbar.add(UndoManagerHelper.getRedoAction(manager));
	 	   
	       
	 	    p4.add(scrollPane);
	       // p4.add(textArea);
	        p4.add(toolbar);
	        
	       
	        ids.addActionListener(new CombListener());
	        bar.add(Add);
		    bar.add(Modify);
		 	 p.add(p1);
		 	 p.add(p4);
		 	  //this.add(p);
		 	// p.add(scrollPane);
		 	 // p.add(toolbar);
		 	   this.setJMenuBar(bar);
	        c1=new CardLayout();
			cards.setLayout(c1); 
			cards.add(p,"1");
			//hayde el panel taba3 el add
			cards.add(pModify,"2");
		   back2.addActionListener(new ButtonHandler());
			add.addActionListener(new ButtonHandler());
			modify.addActionListener(new ButtonHandler());
	        Add.addMenuListener(new MenuListener() {
				   
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
	        Modify.addMenuListener(new MenuListener() {
				   
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
	        this.add(cards,BorderLayout.CENTER);

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
  	       
  	        idDatabase.add(id);
  	       
  	      } 
  	      dbCon.close();
  	    }
  	    catch (Exception e)
  	    {
  	      System.err.println("Got an exception! ");
  	      System.err.println(e.getMessage());
  	    }
  	  
      	ids=new JComboBox(idDatabase.toArray());
      	
      
      }
      public class ButtonHandler implements ActionListener{

			
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource()==add){
					String name=Aname_tf.getText();
					String tel=Atel_tf.getText();
					String fath=Afath_tf.getText();
					String moth=Amoth_tf.getText();
					String bdat=AbirthDate_tf.getText();
					String bpl=ABirthPlace_tf.getText();
					String state=(String)Astate_cmb.getSelectedItem();
					
					//String nbCh=(String)AnbChild_cmb.getSelectedItem();
					
					int nb=(Integer)AnbChild_cmb.getSelectedItem();
					String job=Ajob_tf.getText();
					String adr=Aadr_tf.getText();
					if(Validate(name,tel,fath,moth,bdat,bpl,state,nb,job,adr)){
						String query="INSERT INTO `clients` (ClientName,FatherName,MotherName,BirthDate,BirthPlace,State,nbChild,Job,Adr,Tel) VALUE ('"+ name +"','"+ fath +"','"+ moth + "','"+ bdat +"','"+ bpl +"','"+ state +"','"+ nb +"','"+ job +"','"+ adr +"','"+ tel +"')";
						InsertCon(query);
					}
				}
				else if(ev.getSource()==modify){
					String name=Mname_tf.getText();
					String tel=Mtel_tf.getText();
					String fath=Mfath_tf.getText();
					String moth=Mmoth_tf.getText();
					String bdat=MbirthDate_tf.getText();
					String bpl=MBirthPlace_tf.getText();
					String state=(String)Mstate_cmb.getSelectedItem();
					int nb=(Integer)MnbChild_cmb.getSelectedItem();
					String job=Mjob_tf.getText();
					String adr=Madr_tf.getText();
					Long Id=(Long)ids.getSelectedItem();
					if(Validate(name,tel,fath,moth,bdat,bpl,state,nb,job,adr)){
						String query="UPDATE clients set ClientName='"+ name + "', FatherName='" + fath + "' , MotherName='"+ moth + "',BirthDate='" + bdat + "' ,BirthPlace='" + bpl + "' , State='"+ state + "',nbChild='" + nb + "',Job='"+ job + "',Adr='" + adr + "',Tel='" + tel + "'  where idClient='"+ Id + "'";
						UpdateCon(query);
					}
				}
				else if(ev.getSource()==back1 || ev.getSource()==back2 || ev.getSource()==back3){
					EmployePage p=new EmployePage(name);
					dispose();
					setVisible(false);
					p.setVisible(true);
					
				}
		}
			
  } // fin class button handlerr
      public void UpdateCon(String query){
   	   
   	   try
   	    {
   	    
   	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany","root", "");
   	      stmt = dbCon.createStatement();
   	      int affectedRows=stmt.executeUpdate(query);
   	      
   	    if(affectedRows==1)
   	   	JOptionPane.showMessageDialog(null,"Update is done successfully !");
   	      dbCon.close();
   	    }
   	    catch (Exception e)
   	    {
   	      System.err.println("Got an exception! ");
   	      System.err.println(e.getMessage());
   	    }
   	  
      	
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
	 
    public boolean Validate(String name,String tel,String fath,String mot,String bdat,String bpla,String state,int nbChilds,String job,String adr){
			
			
			if(!name.equals("")){
				
				if(tel.startsWith("03")||tel.startsWith("71")||tel.startsWith("76")||tel.startsWith("78")||tel.startsWith("07")||tel.startsWith("70")){
					//kmelet el shrut 
					
					return true;
					}
					
					
				
				else{
					JOptionPane.showMessageDialog(null,"Please enter his tel !");
					Atel_tf.requestFocus();
					return false;
			
				
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Please enter his name !");
					Aname_tf.requestFocus();
					return false;
			
				
		  }
		}
    public class CombListener implements ActionListener{

  		
  		public void actionPerformed(ActionEvent e) {
  		
  			
  		}
  		   
  	   }
}


	
class UndoManagerHelper {

	  public static Action getUndoAction(UndoManager manager, String label) {
	    return new UndoAction(manager, label);
	  }

	  public static Action getUndoAction(UndoManager manager) {
	    return new UndoAction(manager, "Undo");
	  }

	  public static Action getRedoAction(UndoManager manager, String label) {
	    return new RedoAction(manager, label);
	  }

	  public static Action getRedoAction(UndoManager manager) {
	    return new RedoAction(manager, "Redo");
	  }

	  private abstract static class UndoRedoAction extends AbstractAction {
	    UndoManager undoManager = new UndoManager();

	    String errorMessage = "Cannot undo";

	    String errorTitle = "Undo Problem";

	    protected UndoRedoAction(UndoManager manager, String name) {
	      super(name);
	      undoManager = manager;
	    }

	    public void setErrorMessage(String newValue) {
	      errorMessage = newValue;
	    }

	    public void setErrorTitle(String newValue) {
	      errorTitle = newValue;
	    }

	    protected void showMessage(Object source) {
	      if (source instanceof Component) {
	        JOptionPane.showMessageDialog((Component) source, errorMessage,
	            errorTitle, JOptionPane.WARNING_MESSAGE);
	      } else {
	        System.err.println(errorMessage);
	      }
	    }
	  }

	  public static class UndoAction extends UndoRedoAction {
	    public UndoAction(UndoManager manager, String name) {
	      super(manager, name);
	      setErrorMessage("Cannot undo");
	      setErrorTitle("Undo Problem");
	    }

	    public void actionPerformed(ActionEvent actionEvent) {
	      try {
	        undoManager.undo();
	      } catch (CannotUndoException cannotUndoException) {
	        showMessage(actionEvent.getSource());
	      }
	    }
	  }

	  public static class RedoAction extends UndoRedoAction {
	    String errorMessage = "Cannot redo";

	    String errorTitle = "Redo Problem";

	    public RedoAction(UndoManager manager, String name) {
	      super(manager, name);
	      setErrorMessage("Cannot redo");
	      setErrorTitle("Redo Problem");
	    }

	    public void actionPerformed(ActionEvent actionEvent) {
	      try {
	        undoManager.redo();
	      } catch (CannotRedoException cannotRedoException) {
	        showMessage(actionEvent.getSource());
	      }
	    }
	  }
	 

	}


	  
     

