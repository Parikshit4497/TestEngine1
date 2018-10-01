package com.brainmentors.testengine.util.constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDao {//we made it an interface because we do not want to create an object
public static Connection getConnection() throws ClassNotFoundException, SQLException {
	 Class.forName("org.postgresql.Driver");
	 ResourceBundle rb= ResourceBundle.getBundle("config");
	 String url=rb.getString("url");
	 String userid=rb.getString("userid");
	 String password=rb.getString("password");
	 
	 Connection con= DriverManager.getConnection(url, userid,password);
	 con.setAutoCommit(false);
	 
	 return con;
	 
}
}
