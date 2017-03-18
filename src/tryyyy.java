import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;


public class tryyyy extends JFrame{
	 Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
	 public ArrayList tab;
	 public JComboBox tabs;
	 
      tryyyy(){
    	  setDefaultCloseOperation(3);
    	  setVisible(true);
    	  setSize(200, 300);
    	 tab=new ArrayList();
    	 tab.add("hhi");
    	 tabs=new JComboBox(tab.toArray());
    	  String query = "select name from clients";
    	  SelectConn(query);
    	  tab.add("hello");
    	  this.add(tabs);
    	       }
      public void SelectConn(String query){
    	  try
    	    {
    	    
    	      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
    	      
    	      stmt = dbCon.createStatement();
    	      rs = stmt.executeQuery(query);
    	      while (rs.next())
		      {
		        
		        String Name = rs.getString("ClientName");
		        System.out.println(Name);
		      } 
    	      dbCon.close();
    	    }
    	    catch (Exception e)
    	    {
    	      System.err.println("Got an exception! ");
    	      System.err.println(e.getMessage());
    	    }
    	  }
      
      
      }
/*
 *   Connection dbCon = null; Statement stmt = null; ResultSet rs = null;
				String query="select * from clients";
				String name=usrNameFeild.getText();
				String id=passFeild.getText();
				Long idd=Long.parseLong(id);
				

					//ids bade 3abyon min database
					try
				    {
				    
				      dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurancecompany", "root", "");
				      
				      stmt = dbCon.createStatement();
				      rs = stmt.executeQuery(query);
				      while (rs.next())
				      {
				        
				        long idDatabase = rs.getLong("idClient");
				        String namedatabase=rs.getString("ClientName");
				       if((idd==idDatabase) && (name.equals(namedatabase))){
				    	   ClientPage p=new ClientPage(namedatabase);
				    	   
				       }
				       
				      } 
				      dbCon.close();
				    }
				    catch (Exception ev)
				    {
				      System.err.println("Got an exception! ");
				      System.err.println(ev.getMessage());
				    }
				  
					
 */
 

