package com.crm.data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrmDbData {
	
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet rs = null;
	
	public static List<String> getDbData(String queryPath, int columnIndex) {
		List<String> crmdata = new ArrayList<String>();
		try {
			String query = new Scanner(new File(queryPath)).useDelimiter("\\A").next();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/root","root","");
			st = con.createStatement();
			System.out.println(query);
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				String data = rs.getString(columnIndex);
				crmdata.add(data);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return crmdata;
		
	}
	
	public static List<String> getMultipleDataAgainstDb(String queryPath , int columnIndex1, int columnIndex2, int columnIndex3, int columnIndex4, int columnIndex5) {
		   List<String> crmdata = new ArrayList<String>();
		   
		   try{
			   String query = new Scanner(new File(queryPath)).useDelimiter("\\A").next();
			   Class.forName("com.mysql.cj.jdbc.Drive");
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/root","root","");
			   st = con.createStatement();
			   System.out.println(query);
			   rs = st.executeQuery(query);
			   
			   while(rs.next()) {
				   String data  = rs.getString(columnIndex1);
				   String data1 = rs.getString(columnIndex2);
				   String data2 = rs.getString(columnIndex3);
				   String data3 = rs.getString(columnIndex4);
				   String data4 = rs.getString(columnIndex5);
				   
				   crmdata.add(data);
				   crmdata.add(data1);
				   crmdata.add(data2);
				   crmdata.add(data3);
				   crmdata.add(data4);
			   }
			   
		  }
		catch(Exception e){
			e.printStackTrace();
		}
		   
		   return crmdata;
	}

	public static List<String> getDbDataListOfContacts(String qpath) {
		
		return null;
	}
	
	


}