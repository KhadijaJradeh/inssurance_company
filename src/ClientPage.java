

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.undo.UndoManager;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ClientPage extends JFrame{
	public CardLayout c1;
	JPanel cards=new JPanel();
	JPanel p1=new JPanel(),p11=new JPanel();
	JPanel p2=new JPanel(),p22=new JPanel();
	JPanel p3=new JPanel(),p33=new JPanel();
	JPanel p=new JPanel(),pp=new JPanel();
	JPanel panel1=new JPanel();
	JLabel firstLB,lastLB,bDateLB,bPlaceLB,addLB,telLB,firstLB2,lastLB2,bDateLB2,bPlaceLB2,addLB2,telLB2;
	JTextField appTF,dateTF,firstTF,lastTF,bDateTF,bPlaceTF,addTF,telTF,appTF2,dateTF2,firstTF2,lastTF2,
	bDateTF2,bPlaceTF2,addTF2,telTF2;
	public JMenu Modify;
	public JMenu Add;
	JMenuBar bar;
	JButton btn1,btn2;
	JComboBox idsClient;
	public JPanel header,footer,center;
	public JLabel text1,text2;
	public ArrayList ids;
	public JLabel text;
	String name;
	Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	ClientPage(String name){
		
		setTitle("Client Page");
		setDefaultCloseOperation(3);
		setVisible(true);
		setSize(1600,900);
		this.name=name;
		ids=new ArrayList();
		selectId();
	   p.setLayout(new GridLayout(2,8));
		pp.setLayout(new GridLayout(2,10));
				p1=new JPanel();
				bar=new JMenuBar();
				Modify=new JMenu("Modify Existing");
				Add=new JMenu("Add More");
			text=new JLabel("Choose student's password : ");
			text.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,20));
			   Modify.setPreferredSize(new Dimension(200,50));
			   Modify.setFont(new Font("Calibri",Font.BOLD,20));
			   Add.setPreferredSize(new Dimension(200,50));
			   Add.setFont(new Font("Calibri",Font.BOLD,20));

			   p2.setLayout(new GridLayout(8,8));
			   p2.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p3.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p1.setLayout(new FlowLayout());
			   p22.setLayout(new GridLayout(8,8));
			   p22.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p33.setBackground(java.awt.Color.decode("#d3d3d3"));
			   
			 
			   lastLB=new JLabel("Enter name : ");
			   lastLB.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   bDateLB=new JLabel("Birth Date :");
			   bDateLB.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   bPlaceLB=new JLabel("Birth Place:");
			   bPlaceLB.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   addLB=new JLabel("Address:");
			   addLB.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   telLB=new JLabel("Telephone:");
			   telLB.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   firstTF= new JTextField();
			   lastTF= new JTextField();
			   bDateTF= new JTextField();
			   bPlaceTF= new JTextField();
			   addTF= new JTextField();
			   telTF= new JTextField();
			 btn1=new JButton("Modify");
			 btn1.setPreferredSize(new Dimension(150, 50));
			 btn1.requestFocusInWindow();
			 bar.add(Modify);
			 bar.add(Add);
			 p1.add(text);
			 p1.add(idsClient);
			 p1.setBackground(java.awt.Color.decode("#d3d3d3"));
			  
			   p2.add(lastLB);
			   p2.add(lastTF);
			   p2.add(bDateLB);
			   p2.add(bDateTF);
			   p2.add(bPlaceLB);
			   p2.add(bPlaceTF);
			   p2.add(addLB);
			   p2.add(addTF);
			   p2.add(telLB);
			   p2.add(telTF);
			   p3.add(btn1);
			   p.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p.add(p1);
			   p.add(p2);
			   p.add(p3);
			   //add(p);
			  // JLabel area = new JLabel("Details if any");
			   JTextArea textArea = new JTextArea();
			   textArea.setText("Enter Details");
			   textArea.setSize(getPreferredSize());
			    JScrollPane scrollPane = new JScrollPane(textArea);

			    UndoManager manager = new UndoManager();
			    textArea.getDocument().addUndoableEditListener(manager);

			    JToolBar toolbar = new JToolBar();
			    toolbar.setBackground(java.awt.Color.decode("#d3d3d3"));
			    toolbar.add(UndoManagerHelper.getUndoAction(manager));
			    toolbar.add(UndoManagerHelper.getRedoAction(manager));
			  //  p.add(area);
			    p.add(scrollPane);
			    p.add(toolbar);
			  
			   //add another client
			   
			   lastLB2=new JLabel("Name:");
			   lastLB2.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   bDateLB2=new JLabel("Birth Date(d-m-y):");
			   bDateLB2.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   bPlaceLB2=new JLabel("Birth Place:");
			   bPlaceLB2.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   addLB2=new JLabel("Address:");
			   addLB2.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   telLB2=new JLabel("Telephone:");
			   telLB2.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,30));
			   
			   lastTF2= new JTextField();
			   bDateTF2= new JTextField();
			   bPlaceTF2= new JTextField();
			   addTF2= new JTextField();
			   telTF2= new JTextField();

				 btn2=new JButton("Add");
				 btn2.setPreferredSize(new Dimension(150, 50));
				 btn2.requestFocusInWindow();

			  /* bar.add(Modify);
			   bar.add(Add);*/
			   this.setJMenuBar(bar);
			   
			    p22.setBackground(java.awt.Color.decode("#d3d3d3"));
			   
			   p22.add(lastLB2);
			   p22.add(lastTF2);
			   p22.add(bDateLB2);
			   p22.add(bDateTF2);
			   p22.add(bPlaceLB2);
			   p22.add(bPlaceTF2);
			   p22.add(addLB2);
			   p22.add(addTF2);
			   p22.add(telLB2);
			   p22.add(telTF2);
			   
			   p33.setBackground(java.awt.Color.decode("#d3d3d3"));
			   p33.add(btn2);
			   pp.add(p22);
			   pp.setBackground(java.awt.Color.decode("#d3d3d3"));
			   pp.add(p33);
			   btn1.addActionListener(new ButtonHandler());
			  
			   c1=new CardLayout();
			   cards.setLayout(c1);

			   cards.add(p,"1"); //hayde el panel taba3 el add
			   cards.add(pp,"2");
			   

			    
			   
			   Modify.addMenuListener(new MenuListener() {
				   
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
				Add.addMenuListener(new MenuListener() {
					   
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
				//this.setBackground(java.awt.Color.decode("#d3d3d3"));
				

			}
public class ButtonHandler implements ActionListener{

		
		public void actionPerformed(ActionEvent ev) {
			//lama ekbos save
			 if(ev.getSource()==btn1){
				String name=lastTF.getText();String bdate=bDateTF.getText();
				String bPlace=bPlaceTF.getText();
				String address=addTF.getText();
				String tel=telTF.getText();
				
					
					Long Id=(Long)idsClient.getSelectedItem();
					//System.out.println(Id+"This is the id ");
					
					//String q="UPDATE lifeinsurance set FBen='"+ Fb +"'where IDapp ='"+ 1 + "'";
					String q="UPDATE clients set ClientName='"+ name + "', BirthDate='" + bdate+ "' , BirthPlace='"+ bPlace + "',Adr='" + address+ "', Tel='"+ tel + "' where ClientId='"+ Id + "'";
					
					UpdateCon(q);
			        
					
				

				
			}
			
			
		}
}
public void selectId() {
	
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
  
	idsClient=new JComboBox(ids.toArray());
	

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

			
		
		}}
