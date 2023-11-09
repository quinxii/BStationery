package org.btm.bstationeryafter.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.btm.bstationeryafter.utils.ConfigReader;


public class MySQLConnUtils {
	public static Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {
	     String hostName = ConfigReader.gethostName();
	     String dbName = ConfigReader.getname();
	     String userId = ConfigReader.getuserId();
	     String password = ConfigReader.getPassword();
	     return getMySQLConnection(hostName, dbName, userId, password);
	 }
	 
	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userId, String password) throws SQLException,
	         ClassNotFoundException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	 
	     Connection conn = DriverManager.getConnection(connectionURL, userId,
	             password);
	     return conn;
	 }
}
