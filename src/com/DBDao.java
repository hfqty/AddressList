package com;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class DBDao {
	private static String driver = "";
	private static String url="";
	private static String username="";
	private static String password="";
	
	//静态块
	static{
		InputStream ptis=null;
		Properties dbpt = new Properties();
		try {
			 ptis = new FileInputStream("db.properties");
			dbpt.load(ptis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		driver = dbpt.getProperty("driver");
		url = dbpt.getProperty("url");
		username = dbpt.getProperty("user");
		password = dbpt.getProperty("password");
		
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private DBDao(){}
	
	public static Connection getConnection() throws Exception{
		return (Connection) DriverManager.getConnection(url,username,password);
		
	}
	
	public static void myClose(java.sql.ResultSet rSet,PreparedStatement pstm,java.sql.Connection connection){
		if (rSet != null) {
			try {
				rSet.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			rSet=null;
		}
		if (pstm !=null) {
			try{
				pstm.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			pstm =null;
		}
		if (connection !=null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			connection =null;
		}
	}

}
