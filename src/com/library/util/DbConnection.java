package com.library.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection
{

	private static Connection con = null;
	private static String DB_NAME = null;
	private static String DB_URL = null;
	private static String DB_USERNAME = null;
	private static String DB_USERPASSWORD = null;
	private static String DB_DRIVER = null;
    static {
	    	File file=new File("D:\\ServletFiles\\LibraryCatalogSystem\\application.properties");
	    	try 
	    	{
				FileInputStream fi=new FileInputStream(file);
				Properties p=new Properties();
				p.load(fi);
				DB_DRIVER=p.getProperty("DB_DRIVER");
				DB_NAME=p.getProperty("DB_NAME");
				DB_URL=p.getProperty("DB_URL");
				DB_USERNAME=p.getProperty("DB_USERNAME");
				DB_USERPASSWORD=p.getProperty("DB_USERPASSWORD");
			}
	         catch (IOException e)
	    	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	}
	
	
	
    public static Connection getConnection()
    {
    	if(con==null)	
    	   return getConnection(DB_URL+DB_NAME, DB_USERNAME, DB_USERPASSWORD, DB_DRIVER);
    	return con;
    }
	public static Connection getConnection(String db_URL, String db_USERNAME, String db_USERPASSWORD,
			String db_DRIVER) 
	{
		try 
		{
			Class.forName(db_DRIVER);
			con = DriverManager.getConnection(db_URL, db_USERNAME, db_USERPASSWORD);
		} 
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
